package domein;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerzoekAfhandeling implements Runnable{

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
    //TODO
    
    
    }
        private void verwerkVerzoek(Verzoek verzoek) {
            //TODO
            //String logBericht = ..............
            verzoekLogger.log( logBericht);
            switch (verzoek.getQuery()) {
            case "query1": {
                List<Dier> li = zoo.geefDierenVanSoortMetNaam(verzoek.getParameter());
                verzoek.setResult(li);
                break;
            }
            case "query2": {
                Double gemiddelde = zoo.geefGemiddeldeGewichtVanDierenInGebouwMetNaam(verzoek.getParameter());
                List<Double> li = new ArrayList<>(Arrays.asList(gemiddelde));
                verzoek.setResult(li);
                break;
            }
            case "query3": {
                List<String> li;
                try {
                    li = zoo.geefNamenVanDierenVanVerzorgerMetNummer(Integer.parseInt(verzoek.getParameter()));
                } catch (NumberFormatException ex) {
                    System.out.println("Geen numerieke waarde");
                    li =new ArrayList<>();
                }
                verzoek.setResult(li);
                break;
            }
            case "query4": {
                List<Verzorger> li = zoo.verzorgersInGebouwMetNaam(verzoek.getParameter());
                verzoek.setResult(li);
                break;
            }
            default:
                verzoek.setResult(new ArrayList<>());
            }
            verzoekLogger.log(String.format("%s afgehandeld", logBericht) );
    }
    
}
