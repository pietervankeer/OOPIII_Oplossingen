package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Vliegmaatschappij {
	
	private final String naam;
	private final List<String> partners;

	public Vliegmaatschappij(String[] data) {
		if (data == null || data.length == 0) {
			throw new IllegalArgumentException("Data om een vliegmaatschappij te maken onvolledig!");
		}
		naam = data[0];
		if (naam == null || naam.isEmpty()) {
			throw new IllegalArgumentException("Geen geldige naam!");
		}
		partners = new ArrayList<>(Arrays.asList(data));
		partners.remove(0);
	}

	public List<String> getPartners() {
		return partners;
	}

	public boolean isPartner(String naam) {
		return partners.contains(naam);
	}

	public String getNaam() {
		return naam;
	}

	@Override
	public String toString() {
		return String.format("%s met partners %s", naam, partners);
	}
}
