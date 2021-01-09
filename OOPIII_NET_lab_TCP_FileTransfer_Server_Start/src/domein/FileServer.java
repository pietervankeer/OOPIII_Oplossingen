package domein;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.Scanner;

public class FileServer {
	// attributen voor netwerkconnectie en streams
	private Socket socket;
	private Scanner sockInput;
	private Formatter sockOutput;

	public void run() {
		// initialiseer server
		// TODO
		// je kan zelf een poort meegeven, maar niet een getal tussen 0 en 1024 want die
		// zijn voorbehouden
		try (ServerSocket serverSocket = new ServerSocket(44444, 10)) {
			System.out.println("Fileserver up");
			// wacht tot een client verbindig maakt
			// verwerk al de verzoeken van een client tot deze afsluit
			// delegeer naar hulpmethode processClient
			// wacht opnieuw op een client, blijft dit doen
			// TODO

			// oneindig wachten op connecties
			while (true) {
				try {
					System.out.println("Fileserver waiting...");
					socket = serverSocket.accept(); // wachten tot een socket connectie maakt
					// vanaf er connectie gemaakt is kan je de client (socket) beginnen verwerken
					processClient();
				} catch (IOException ex) {
					System.out.println("Problemen : " + ex.getMessage());
				}
				// zeker zijn dat de socket wordt afgesloten als het programma stopt.
				finally {
					if (socket != null)
						socket.close();
				}
			}
		} catch (IOException ex) {
			System.out.println("Problemen met server connectie : " + ex.getMessage());
		}
	}

	private void processClient() {
		// verwerk al de verzoeken van een client volgens het afgesproken protocol
		// tot deze afsluit
		// sluit dan ook de connectie met deze client
		// maak gebruik van de 3 onderstaande hulpmethoden
		try {
			sockInput = new Scanner(socket.getInputStream());
			sockOutput = new Formatter(socket.getOutputStream());

			while (sockInput.hasNextLine()) {
				String actie = sockInput.nextLine();

				File file;

				switch (actie.toUpperCase()) {
				case "READ" -> {
					file = new File(sockInput.nextLine());
					System.out.println("READ " + file.getName());

					if (file.exists()) {
						sendFile(file);
					} else {
						sendNoFile();
					}
				}
				case "REWRITE" -> {
					file = new File(sockInput.nextLine());
					System.out.println("REWRITE " + file.getName());

					if (file.exists()) {
						System.out.println("REWRITE: file found --> " + file.getName());
						readAndSaveUpdateFile(file);
					} else {
						System.out.println("REWRITE: File not found --> " + file.getName());	
						}

				}
				}
			}

		} catch (IOException ex) {
			System.out.println("Problemen met client connectie : " + ex.getMessage());
		}
	}

	private void sendFile(File file) throws IOException {

		sockOutput.format("FOUND\n");
		sockOutput.flush();

		try (Scanner fileScanner = new Scanner(file)) {
			while (fileScanner.hasNextLine()) {
				sockOutput.format("%s%n", fileScanner.nextLine());
				sockOutput.flush();
			}
		}

		sockOutput.format("*E*O*F\n");
		// zorgen dat alles verstuurd wordt.
		// buffer leegmaken
		sockOutput.flush();

	}

	private void sendNoFile() {
		// geen client laten weten dat er geen file gevonden is.
		sockOutput.format("NOTFOUND%n");
		sockOutput.flush();

	}

	private void readAndSaveUpdateFile(File file) throws IOException {
		// tekst inlezen tot eof
		StringBuilder builder = new StringBuilder();
		String line;
		
		

		while (!(line = sockInput.nextLine()).equals("*E*O*F")) {
			builder.append(line).append(System.lineSeparator());
		}

		// file overschrijven
		try (Formatter fileFormatter = new Formatter(new FileWriter(file, false))) {
			fileFormatter.format(builder.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
