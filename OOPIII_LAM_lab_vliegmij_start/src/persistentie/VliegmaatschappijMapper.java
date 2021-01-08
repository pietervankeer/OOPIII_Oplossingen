package persistentie;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.Vliegmaatschappij;

public class VliegmaatschappijMapper {
	public List<Vliegmaatschappij> leesTekstBestand(String naamBestand) {
		List<Vliegmaatschappij> airlines = new ArrayList<>();

		try (Scanner input = new Scanner(Files.newInputStream(Paths.get(naamBestand)))) {
			while (input.hasNextLine()) {
				Vliegmaatschappij airline = new Vliegmaatschappij(input.nextLine().split(","));
				airlines.add(airline);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return airlines;
	}
}
