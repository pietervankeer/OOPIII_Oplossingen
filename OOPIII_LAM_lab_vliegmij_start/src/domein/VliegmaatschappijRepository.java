package domein;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import persistentie.VliegmaatschappijMapper;

public class VliegmaatschappijRepository 
{
	private final List<Vliegmaatschappij> maatschappijen;
    private final VliegmaatschappijMapper vm;
	
    
    public VliegmaatschappijRepository() 
    {
		vm = new VliegmaatschappijMapper();
        maatschappijen = vm.leesTekstBestand("airlines.txt");
	}


	public List<Vliegmaatschappij> getMaatschappijen() {
		return maatschappijen;
	}


	public List<Vliegmaatschappij> geefAlleAirlinesMetMinstensAantalPartners(int aantal) {
		return maatschappijen.stream()
				.filter(a -> a.getPartners().size() >= aantal)
				.collect(Collectors.toList());
					  
	}


	public List<Vliegmaatschappij> geefAirlinesAlfabetischGesorteerd() {
		return maatschappijen.stream()
				.sorted(Comparator.comparing(Vliegmaatschappij::getNaam))
				.collect(Collectors.toList());
	}


	public List<Vliegmaatschappij> geefAirlinesGesorteerdVolgensAantalPartners() {
		return maatschappijen.stream()
				.sorted(Comparator.comparing(vm -> vm.getPartners().size()))
				.collect(Collectors.toList());
	}


	public Map<Vliegmaatschappij,Integer> geefAirlinesAantalKeerPartner() 
	{
		// loop over alle vm's
		// tel aantal keer dat airline partner is
		
		return maatschappijen.stream()
				.collect(Collectors.toMap(
						Function.identity(), // key, this --> vliegtuigmaatschappij
						vm -> (int) maatschappijen.stream()
							.filter(m -> m.getPartners().contains(vm.getNaam())) // lijst filteren: enkel de Vliegtuigmaatschappijen die oorspronkelijke Vliegtuigmaatschappij als partner hebben blijven over.
							.count() // gefilterde lijst optellen
						));
				
		
	}
	
	public String geefEersteAirlineStartendMet(String woord)
	{
		return maatschappijen.stream()
				.filter(vm -> vm.getNaam().contains(woord))
				.map(Vliegmaatschappij::getNaam)
				.findFirst()
				.orElse("Geen gevonden");
	}
	
	public Vliegmaatschappij geefEenAirlineMetPartner(String partner)
	{
		return maatschappijen.stream()
				.filter(vm -> vm.getPartners().contains(partner))
				.findAny()
				.orElse(null);
	}
    
}
