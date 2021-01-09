package domein;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import persistentie.PersistentieController;

public class BierWinkel {

	private final List<Bier> bieren;
	private PersistentieController pc = new PersistentieController();

	public BierWinkel() {
		bieren = pc.inlezenBieren("bieren.txt");
	}

	public List<Bier> getBieren() {
		return bieren;
	}

	public long geefAantalBierenMetMinAlcoholPercentage(double percentage) {
		return bieren.stream().filter(b -> b.getAlcoholgehalte() >= percentage).count();
	}

	public List<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage) {
		return bieren.stream().filter(b -> b.getAlcoholgehalte() >= percentage).collect(Collectors.toList());
	}

	public List<String> geefNamenBieren() {
		return bieren.stream().map(Bier::getNaam).collect(Collectors.toList());
	}

	// Bier met hoogst aantal graden
	public Bier geefBierMetHoogsteAlcoholPercentage() {
		return bieren.stream().sorted(Comparator.comparing(Bier::getAlcoholgehalte).reversed()).findFirst().get();
	}

	// Bier met laagst aantal graden
	public Bier geefBierMetLaagsteAlcoholPercentage() {
		return bieren.stream().sorted(Comparator.comparing(Bier::getAlcoholgehalte)).findFirst().get();
	}

	/*
	 * Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog
	 * naar laag, en bij gelijk aantal graden op naam (alfabetisch).
	 */
	public List<Bier> geefGeordendOpAlcoholGehalteEnNaam() {
		return null;

	}

	// Alle brouwerijen
	public List<String> geefAlleNamenBrouwerijen() {
		return bieren.stream()
				.map(Bier::getBrouwerij)
				.collect(Collectors.toList());
	}

	// Alle brouwerijen die het woord "van" bevatten
	public List<String> geefAlleNamenBrouwerijenMetWoord(String woord) {
		return bieren.stream()
				.map(Bier::getBrouwerij)
				.filter(brouwerij -> brouwerij.contains(woord))
				.collect(Collectors.toList());
	}

	public Map<String, List<Bier>> opzettenOverzichtBierenPerSoort() {
		return bieren.stream().collect(Collectors.groupingBy(Bier::getSoort));
	}

	public Map<String, Long> opzettenAantalBierenPerSoort() {
		return bieren.stream().collect(
				Collectors.groupingBy(
						Bier::getSoort, 
						TreeMap::new,
						Collectors.counting()
						));
	}

}
