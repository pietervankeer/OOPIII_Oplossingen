package domein;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

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
		return null;
					  
	}


	public List<Vliegmaatschappij> geefAirlinesAlfabetischGesorteerd() {
		return null;
	}


	public List<Vliegmaatschappij> geefAirlinesGesorteerdVolgensAantalPartners() {
		return null;
	}


	public Map<Vliegmaatschappij,Integer> geefAirlinesAantalKeerPartner() 
	{
		return null;
		
	}
	
	public String geefEersteAirlineStartendMet(String woord)
	{
		return "";
	}
	
	public Vliegmaatschappij geefEenAirlineMetPartner(String partner)
	{
		return null;
	}
    
}
