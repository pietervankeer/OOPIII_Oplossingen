package domein;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import persistentie.VliegmaatschappijMapper;

public class DomeinController {
	private final VliegmaatschappijRepository vliegmijRepository;

	public DomeinController() {
		this.vliegmijRepository = new VliegmaatschappijRepository();
	}

	public String geefAirlines() {
		List<Vliegmaatschappij> lijst = vliegmijRepository.getMaatschappijen();
		return zetLijstOmNaarString(lijst);

	}

	private String zetLijstOmNaarString(List<Vliegmaatschappij> lijst) {
		return lijst.stream()
				.map(Vliegmaatschappij::toString)
				.collect(Collectors.joining("\n"));

	}

	public List<String> geefAlleAirlinesMetMinstensAantalPartners(int aantal) {
		List<Vliegmaatschappij> selectie = vliegmijRepository.geefAlleAirlinesMetMinstensAantalPartners(aantal);
		return selectie.stream()
				.map(Vliegmaatschappij::toString)
				.collect(Collectors.toList());
	}

	public String geefAirlinesAlfabetischGesorteerd() {
		List<Vliegmaatschappij> lijst = vliegmijRepository.geefAirlinesAlfabetischGesorteerd();
		return zetLijstOmNaarString(lijst);
	}

	public String geefAirlinesGesorteerdVolgensAantalPartners() {
		List<Vliegmaatschappij> lijst = vliegmijRepository.geefAirlinesGesorteerdVolgensAantalPartners();
		return zetLijstOmNaarString(lijst);
	}

	public String geefAirlinesAantalKeerPartner() {
		Map<Vliegmaatschappij, Integer> map = vliegmijRepository.geefAirlinesAantalKeerPartner();
		return map.entrySet().stream()
				.map(entry -> String.format("%s is %d keer partner", entry.getKey(), entry.getValue()))
				.collect(Collectors.joining("\n"));
	}
	
	public String geefEersteAirlineStartendMet(String woord) {
		return vliegmijRepository.geefEersteAirlineStartendMet(woord);
	}
	
	public Vliegmaatschappij geefEenAirlineMetPartner(String partner) {
		return vliegmijRepository.geefEenAirlineMetPartner(partner);
	}
}
