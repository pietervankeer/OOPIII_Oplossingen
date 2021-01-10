package domein;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerzoekAfhandeling implements Runnable {

	private final Socket socket;
	private final Zoo zoo;
	private final VerzoekLogger verzoekLogger;

	VerzoekAfhandeling(Socket connection, Zoo zoo, VerzoekLogger verzoekLogger) {
		socket = connection;
		this.zoo = zoo;
		this.verzoekLogger = verzoekLogger;
	}

	@Override
	public void run() {

		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			
			Verzoek verzoek = (Verzoek) objectInputStream.readObject();
			verwerkVerzoek(verzoek);
			objectOutputStream.writeObject(verzoek);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void verwerkVerzoek(Verzoek verzoek) {
		String logBericht = String.format("%s %s", socket.getInetAddress().getHostName(), verzoek.getQuery());
		verzoekLogger.log(logBericht);
		switch (verzoek.getQuery()) {
		case "query1": {
			List<Dier> li = zoo.geefDierenVanSoortMetNaam(verzoek.getParameter());
			verzoek.setResultaat(li);
			break;
		}
		case "query2": {
			Double gemiddelde = zoo.geefGemiddeldeGewichtVanDierenInGebouwMetNaam(verzoek.getParameter());
			List<Double> li = new ArrayList<>(Arrays.asList(gemiddelde));
			verzoek.setResultaat(li);
			break;
		}
		case "query3": {
			List<String> li;
			try {
				li = zoo.geefNamenVanDierenVanVerzorgerMetNummer(Integer.parseInt(verzoek.getParameter()));
			} catch (NumberFormatException ex) {
				System.out.println("Geen numerieke waarde");
				li = new ArrayList<>();
			}
			verzoek.setResultaat(li);
			break;
		}
		case "query4": {
			List<Verzorger> li = zoo.verzorgersInGebouwMetNaam(verzoek.getParameter());
			verzoek.setResultaat(li);
			break;
		}
		default:
			verzoek.setResultaat(new ArrayList<>());
		}
		verzoekLogger.log(String.format("%s afgehandeld", logBericht));
	}

}
