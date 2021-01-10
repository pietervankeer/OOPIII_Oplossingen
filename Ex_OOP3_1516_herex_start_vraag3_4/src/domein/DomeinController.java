package domein;

import java.util.List;

public class DomeinController {

    private final Zoo zoo;

    public DomeinController() {
        zoo = new Zoo();
    }

    /*
     * Geeft alle dieren terug die behoren tot de diersoort met de opgegeven naam. De lijst van
     * dieren moet gesorteerd zijn op gewicht (laag naar hoog).
     */
//    public List<String> geefDierenVanSoortMetNaam(String soortNaam) {
//        return zetOmNaarLijstVanStrings(zoo.geefDierenVanSoortMetNaam(soortNaam));
//    }

    /*
     * Geeft het gemiddelde gewicht terug van alle dieren die verblijven in het gebouw met de
     * opgegeven naam. Geeft 0 terug indien er geen gebouw is met deze naam.
     */
    public double geefGemiddeldeGewichtVanDierenInGebouwMetNaam(String gebouwNaam) {
        return zoo.geefGemiddeldeGewichtVanDierenInGebouwMetNaam(gebouwNaam);
    }

    /*
     * Geeft de namen van de dieren terug die verzorgd worden door de verzorger met het opgegeven
     * nummer. Geeft een lege lijst terug indien er geen verzorger is met dit nummer.
     */
    public List<String> geefNamenVanDierenVanVerzorgerMetNummer(int verzorgerNummer) {
        return zoo.geefNamenVanDierenVanVerzorgerMetNummer(verzorgerNummer);
    }

    /*
     * Geeft een lijst terug van verzorgers die een of meerdere dieren verzorgen die verblijven in
     * het gebouw met de opgegeven naam. Geeft een lege lijst terug indien er geen gebouw is met
     * deze naam.
     */
//    public List<String> geefVerzorgersInGebouwMetNaam(String gebouwNaam) {
//        return zetOmNaarLijstVanStrings(zoo.verzorgersInGebouwMetNaam(gebouwNaam));
//    }

    /**
     * Deze methode geeft de informatie uit de map terug volgens volgende
     * manier:
     *
     *
     */
    public String maakOverzichtVolgensSoort() {
  //TODO
        return null;
    }

    //private List<String> zetOmNaarLijstVanStrings(//Lijst...) {
//TODO

//    }

}
