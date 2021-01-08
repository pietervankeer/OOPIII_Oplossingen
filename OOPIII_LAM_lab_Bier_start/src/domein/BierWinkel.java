package domein;

import java.util.List;
import java.util.Map;
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
        return 0;
    }

    public List<Bier> geefAlleBierenMetMinAlcoholPercentage(double percentage) {
        return null;
    }

    public List<String> geefNamenBieren() {
        return null;
    }

    //Bier met hoogst aantal graden
    public Bier geefBierMetHoogsteAlcoholPercentage() {
        return null;
    }

    //Bier met laagst aantal graden
    public Bier geefBierMetLaagsteAlcoholPercentage() {
        return null;
    }

    /*Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog naar laag, 
     en bij gelijk aantal graden op naam (alfabetisch).
     */
    public List<Bier> geefGeordendOpAlcoholGehalteEnNaam() {
        return null;

    }

    //Alle brouwerijen
    public List<String> geefAlleNamenBrouwerijen() {
        return null;
    }

    //Alle brouwerijen die het woord "van" bevatten
    public List<String> geefAlleNamenBrouwerijenMetWoord(String woord) {
        return null;
    }

    public Map<String, List<Bier>> opzettenOverzichtBierenPerSoort() {
        return null;
    }

    public Map<String, Long> opzettenAantalBierenPerSoort() {
        return null;
    }
    
    
}
