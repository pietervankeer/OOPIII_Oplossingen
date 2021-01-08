package domein;

import java.io.File;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import persistentie.ObjectStreamManipulaties;
import persistentie.PersistentieController;

public class Garage {

	private final File auto;
	private final File onderhoud;
	private Map<String, Auto> autoMap;
	private Map<String, List<Onderhoud>> autoOnderhoudMap;
	private List<Set<Auto>> overzichtLijstVanAutos;

	private final int AANTAL_OVERZICHTEN = 3;
	private int overzichtteller;

	public Garage(String bestandAuto, String bestandOnderhoud) {
		auto = new File(bestandAuto);
		onderhoud = new File(bestandOnderhoud);
		initGarage();
	}

	private void initGarage() {
		PersistentieController persistentieController = new PersistentieController(auto, onderhoud);

		// Set<Auto> inlezen - stap1
		Set<Auto> autoSet = persistentieController.geefAutos().stream().collect(Collectors.toSet());
		System.out.println("STAP 1");
		autoSet.forEach(System.out::println);

		// Maak map van auto's: volgens nummerplaat - stap2
		autoMap = omzettenNaarAutoMap(autoSet);
		System.out.println("STAP 2");
		autoMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value));

		// Onderhoud inlezen - stap3
		List<Onderhoud> onderhoudLijst = persistentieController.geefOnderhoudVanAutos();
		System.out.println("STAP 3 : " + onderhoudLijst);

		// lijst sorteren - stap4
		sorteren(onderhoudLijst);
		System.out.println("STAP 4");
		onderhoudLijst.forEach(System.out::println);

		// lijst samenvoegen - stap5
		aangrenzendePeriodenSamenvoegen(onderhoudLijst);
		System.out.println("STAP 5");
		onderhoudLijst.forEach(System.out::println);

		// Maak map van onderhoud: volgens nummerplaat - stap6
		autoOnderhoudMap = omzettenNaarOnderhoudMap(onderhoudLijst);
		System.out.println("STAP 6");
		autoOnderhoudMap.forEach((key, value) -> System.out.printf("%s %s%n", key, value));

		// Maak overzicht: set van auto's - stap7
		overzichtLijstVanAutos = maakOverzicht(autoOnderhoudMap);
		System.out.println("STAP 7");
		overzichtLijstVanAutos.forEach(System.out::println);
	}

	// Maak map van auto's: volgens nummerplaat - stap2
	private Map<String, Auto> omzettenNaarAutoMap(Set<Auto> autoSet) {
		// set omvormen naar een map en als key: nummerplaat, value: auto object
		return autoSet.stream().collect(Collectors.toMap(Auto::getNummerplaat, Function.identity()));
	}

	// lijst sorteren - stap4
	private void sorteren(List<Onderhoud> lijstOnderhoud) {
		// sorteren: Eerst op nummerplaat daarna op begindatum
		lijstOnderhoud.sort(Comparator.comparing(Onderhoud::getNummerplaat).thenComparing(Onderhoud::getBegindatum));
	}

	// lijst samenvoegen - stap5
	private void aangrenzendePeriodenSamenvoegen(List<Onderhoud> lijstOnderhoud) {
		Iterator<Onderhoud> it = lijstOnderhoud.iterator();

		Onderhoud onderhoud = null;
		Onderhoud onderhoudNext = null;

		while (it.hasNext()) {
			onderhoud = onderhoudNext;
			onderhoudNext = it.next();

			// bepalen of het om het onderhoud gaat van dezelfde auto
			if (onderhoud != null && onderhoud.getNummerplaat().equals(onderhoudNext.getNummerplaat())) {
				if (onderhoud.getEinddatum().plusDays(1).equals(onderhoudNext.getBegindatum())) {
					// als het aangrenzende datums zijn --> onderhoud aanpassen!
					onderhoud.setEinddatum(onderhoudNext.getEinddatum());
					// onderhoudNext verwijderen uit de lijst
					it.remove();
					onderhoudNext = onderhoud;
				}
			}
		}

	}

	// Maak map van onderhoud: volgens nummerplaat - stap6
	private Map<String, List<Onderhoud>> omzettenNaarOnderhoudMap(List<Onderhoud> onderhoudLijst) {
		return onderhoudLijst.stream().collect(Collectors.groupingBy(Onderhoud::getNummerplaat));
	}

	// Hulpmethode - nodig voor stap 7
	private int sizeToCategorie(int size) {
		return switch (size) {
		case 0, 1 -> 0;
		case 2, 3 -> 1;
		default -> 2;
		};
	}

	// Maak overzicht: set van auto's - stap7
	private List<Set<Auto>> maakOverzicht(Map<String, List<Onderhoud>> autoOnderhoudMap) {
		// Hint:
		// van Map<String, List<Onderhoud>>
		// naar Map<Integer, Set<Auto>> (hulpmethode gebruiken) groupingBy
		// naar List<Set<Auto>>
		return autoOnderhoudMap.entrySet().stream()
				.collect(Collectors.groupingBy(entry -> sizeToCategorie(entry.getValue().size()), // Integer
						TreeMap::new, Collectors.mapping(entry -> autoMap.get(entry.getKey()), Collectors.toSet())))
				.values().stream().collect(Collectors.toList());
	}

//Oefening DomeinController:
	public String autoMap_ToString() {
		String res = String.format("automap %n");

		res += autoMap.values().stream().sorted(Comparator.comparing(Auto::getNummerplaat)) // stream van auto
				.map(Auto::toString) // stream van string
				.collect(Collectors.joining("\n"));
		return res;
	}

	public String autoOnderhoudMap_ToString() {
		String res = String.format("autoOnderhoudmap %n");
		res += autoOnderhoudMap.entrySet().stream()
				.sorted(Comparator.comparing(Map.Entry::getKey)) 	// stream van Map.Entry
				.map(entry -> String.format("%s:%n%s",
						entry.getKey(),
						entry.getValue().stream() 					// stream van Onderhoud (tussentijds)
						.map(Onderhoud::toString) 					// map elk onderhoud op zijn beschrijving
						.collect(Collectors.joining("\n")))) 		// stream van String 
				.collect(Collectors.joining("\n")); 				// breng alle strings samen in 1 samengestelde string
		return res;
	}

	public String overzicht_ToString() {
		overzichtteller = 1;
		String res = String.format("overzicht %n");
		
		res += overzichtLijstVanAutos.stream()
				.map(setAuto -> String.format("%d%n%s",
						overzichtteller++,
						setAuto.stream() // stream van Auto
						.map(Auto::toString)
						.collect(Collectors.joining("\n")))) // stream van String
				.collect(Collectors.joining("\n"));
		return res;
	}

}
