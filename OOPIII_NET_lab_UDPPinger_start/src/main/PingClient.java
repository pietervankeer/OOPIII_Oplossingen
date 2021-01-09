package main;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PingClient {
	private InetAddress host;
	private String hostName = "localhost"; // default
	private int portnr = 5555; // default
	private final int PINGAANTAL = 10;
	private final int TOKEN_TIMESTAMP = 2; // positie in packet
	private final int MAX_WAIT_TIME = 1000;
	private long min = 999999, max = 0, somRTT = 0;
	private int aangekomen = 0;
	private List<Long> rtts = new ArrayList();

	public static void main(String[] args) {
		new PingClient().run(args);
	}

	public void run(String args[]) {
		try {
			if (args.length > 0) {
				hostName = args[0];
			}
			if (args.length == 2) {
				portnr = Integer.parseInt(args[1]);
			}

			// maak netwerkconnectie
			// socket --> DatagramSocket
			host = InetAddress.getByName(hostName);
			DatagramSocket datagramSocket = new DatagramSocket();
			datagramSocket.setSoTimeout(MAX_WAIT_TIME); // wacht maximum MAX_WAIT_TIME when receiving a datagrampacket

//TODO
			// verstuur PINGAANTAL keer een bericht met huidig tijdstip

			for (int pingNr = 1; pingNr < PINGAANTAL; pingNr++) {

				// data voor bericht:
				SimpleDateFormat timeNow = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
				String timedStr = timeNow.format(new Date(System.currentTimeMillis()));
				String message = String.format("Ping #%d %s (%s)", pingNr, System.currentTimeMillis(), timedStr);
//TODO
				// verpak bericht, verstuur en wacht op antwoord print de ontvangenData
				// update de teller
				DatagramPacket ping_Verzoek = new DatagramPacket(message.getBytes(), message.getBytes().length, host,
						portnr);
				datagramSocket.send(ping_Verzoek); // versturen van packet

				DatagramPacket ping_Antwoord = new DatagramPacket(new byte[message.getBytes().length],
						message.getBytes().length);

				try {
					datagramSocket.receive(ping_Antwoord); // wait for reveive, with timeout
					printData(ping_Antwoord);
				} catch (SocketTimeoutException e) {
					System.out.printf("ping #%d : No Repsonse was received from the server\n", pingNr);
				}

			} // end for
				// System.out.printf("min: %d, max: %d, gem: %d, packets loss: %.0f%%%n", min,
				// max, somRTT/PINGAANTAL
				// ,(PINGAANTAL-aangekomen)/(double)PINGAANTAL*100);
		} // end-try
		catch (IOException e) {
			System.out.println("Probleem: ");
			e.printStackTrace();
		}

	}

	private void printData(DatagramPacket request) {
		// haal de info uit het ontvangen packet, toon op de console
		String response = new String(request.getData(), request.getOffset(), request.getLength());
		String[] tokens = response.split(" ");
		long verzonden_timestamp = Long.valueOf(tokens[2]); // tijd verzenden
		long ontvangen_timestamp = System.currentTimeMillis(); // tijd ontvangen

		long rtt = ontvangen_timestamp - verzonden_timestamp;

		System.out.printf("%s received from %s (RTT = %dms)%n", response, request.getAddress().getHostName(), rtt);

		// System.out.printf("%s Received from %s (RTT=%dms)%n", response,
		// request.getAddress().getHostAddress(), rtt);
		// updateRTTs(rtt);
	}

	private void updateRTTs(long rtt) {
//bereken  min, max, somRTT (voor gemiddelde
//TODO
		if (min >= rtt) {
			min = rtt;
		} else if (max <= rtt) {
			max = rtt;
		}
		

		rtts.add(rtt);
	}
}