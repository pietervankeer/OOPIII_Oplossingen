package domein;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class DomeinController {
	private BierWinkel bierWinkel;

	public DomeinController() {
		bierWinkel = new BierWinkel();
	}

	public long geefAantalBierenMetMinAlcoholPercentage(double percentage) {
		return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
	}

	public List<String> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage) {
		List<Bier> bieren = bierWinkel.geefAlleBierenMetMinAlcoholPercentage(percentage);
		return bieren.stream().map(Bier::toString).collect(Collectors.toList());
	}

	public List<String> geefAlleBieren() {
		return bierWinkel.getBieren().stream().map(Bier::toString).collect(Collectors.toList());
	}

	public String geefNamenBieren() {
		return bierWinkel.geefNamenBieren().stream().collect(Collectors.joining("\n"));
	}

	public String geefBierMetHoogsteAlcoholPercentage() {
		return bierWinkel.geefBierMetHoogsteAlcoholPercentage().toString();
	}

	public String geefBierMetLaagsteAlcoholPercentage() {
		return bierWinkel.geefBierMetLaagsteAlcoholPercentage().toString();
	}

	public List<String> geefGeordendOpAlcoholGehalteEnNaam() {
		List<Bier> bieren = bierWinkel.getBieren();
		Comparator<Bier> opAlcoholPercentage = Comparator.comparing(Bier::getAlcoholgehalte).reversed();
		Comparator<Bier> opNaam = Comparator.comparing(Bier::getNaam);

		return bieren.stream().sorted(opAlcoholPercentage.thenComparing(opNaam)).map(Bier::toString)
				.collect(Collectors.toList());
	}

	public String geefAlleNamenBrouwerijen() {
		return bierWinkel.geefAlleNamenBrouwerijen().stream().collect(Collectors.joining("\n"));
	}

	public String geefAlleNamenBrouwerijenMetWoord(String woord) {
		return bierWinkel.geefAlleNamenBrouwerijenMetWoord(woord).stream().collect(Collectors.joining("\n"));
	}

	public String opzettenAantalBierenPerSoort() {
		// naar BierWinkel --> map<String, Long>
		Comparator<Bier> OpSoort = Comparator.comparing(Bier::getSoort);
		
		Map<String, Long> bierMap = bierWinkel.getBieren().stream()
				.sorted(OpSoort)
				.collect(Collectors.groupingBy(Bier::getSoort, TreeMap::new, Collectors.counting()));

		return bierMap.entrySet().stream()
				.map(entry -> String.format("%s = %d", entry.getKey(), entry.getValue()))
				.collect(Collectors.joining("\n"));
	}

	public String opzettenOverzichtBierenPerSoort() {
		// naar BierWinkel --> map<String, List<Bier>>		
		Map<String, List<Bier>> bierMap = bierWinkel.getBieren().stream()
				.collect(Collectors.groupingBy(Bier::getSoort, TreeMap::new, Collectors.toList()));
		return overzichtToString(bierMap);
	}


	private String overzichtToString(Map<String, List<Bier>> map) { 
		// hulp voor map --> String
		return 	map.entrySet().stream()
				.map(entry -> String.format("%s = %s", entry.getKey(), entry.getValue()))
				.collect(Collectors.joining("\n"));
	}

}
