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
		return null;

	}

	public List<String> geefAlleAirlinesMetMinstensAantalPartners(int aantal) {
		List<Vliegmaatschappij> selectie = vliegmijRepository.geefAlleAirlinesMetMinstensAantalPartners(aantal);
		return null;
	}

	public String geefAirlinesAlfabetischGesorteerd() {
		List<Vliegmaatschappij> lijst = vliegmijRepository.geefAirlinesAlfabetischGesorteerd();
		return null;
	}

	public String geefAirlinesGesorteerdVolgensAantalPartners() {
		List<Vliegmaatschappij> lijst = vliegmijRepository.geefAirlinesGesorteerdVolgensAantalPartners();
		return null;
	}

	public String geefAirlinesAantalKeerPartner() {
		Map<Vliegmaatschappij, Integer> map = vliegmijRepository.geefAirlinesAantalKeerPartner();
		return null;
	}
	
	public String geefEersteAirlineStartendMet(String woord) {
		return vliegmijRepository.geefEersteAirlineStartendMet(woord);
	}
	
	public Vliegmaatschappij geefEenAirlineMetPartner(String partner) {
		return vliegmijRepository.geefEenAirlineMetPartner(partner);
	}
}
