package persistentie;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domein.Bier;

public class BierMapper {

	public List<Bier> inlezenBieren(String naamBestand) {

		List<Bier> bieren = new ArrayList<>();

		try (Scanner input = new Scanner(Files.newInputStream(Paths.get("bieren.txt")))) {

			while (input.hasNext()) {
				Bier bier = new Bier(input.next(), input.next(), input.nextDouble(), input.nextDouble(),
						input.nextLine());
				bieren.add(bier);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return bieren;
	}

}
