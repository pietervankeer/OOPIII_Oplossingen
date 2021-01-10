package domein;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import persistentie.PersistentieController;

public class Zoo {//DUMMY

	public final String PERSISTENCE_UNIT_NAME = "JPA_details";
    private List<Verzorger> verzorgers;
    private List<Dier> dieren;
    private List<Gebouw> gebouwen;

    public Zoo() {
        this.dieren = new PersistentieController().geefDieren();
        this.verzorgers = new PersistentieController().geefVerzorgers();
        this.gebouwen = new PersistentieController().geefGebouwen();
    }

    /*
     * Geeft alle dieren terug die behoren tot de diersoort met de opgegeven naam. De lijst van
     * dieren moet gesorteerd zijn op gewicht (laag naar hoog).
     */
    public List<Dier> geefDierenVanSoortMetNaam(String soortNaam) {
        Comparator<Dier> opGewicht = Comparator.comparing(Dier::getGewicht);
        
        return dieren.stream()
        		.filter(d -> d.getSoort().getNaam().equals(soortNaam))
        		.sorted(opGewicht)
        		.collect(Collectors.toList());
        }

    /*
     * Geeft het gemiddelde gewicht terug van alle dieren die verblijven in het gebouw met de
     * opgegeven naam. Geeft 0 terug indien er geen gebouw is met deze naam.
     */
    public double geefGemiddeldeGewichtVanDierenInGebouwMetNaam(String gebouwNaam) {
       Gebouw gebouw = gebouwen.stream()
    		   .filter(g -> g.getNaam().equals(gebouwNaam))
    		   .findFirst()
    		   .orElse(null);
       if(gebouw == null) {
    	   return 0;
       }
       
       return gebouw.getDieren().stream()
    		   .mapToDouble(Dier::getGewicht)
    		   .average()
    		   .getAsDouble();
       
    }

    /*
     * Geeft de namen van de dieren terug die verzorgd worden door de verzorger met het opgegeven
     * nummer. Geeft een lege lijst terug indien er geen verzorger is met dit nummer.
     */
    //--
    public List<String> geefNamenVanDierenVanVerzorgerMetNummer(int verzorgerNummer) {
    	Verzorger optVerzorger = verzorgers.stream()
        		.filter(v -> v.getNummer() == verzorgerNummer)
        		.findFirst()
        		.orElse(null);
    	
    	if(optVerzorger != null) {
    		 return optVerzorger.getDieren().stream()
    				 .map(Dier::getNaam)
    				 .collect(Collectors.toList());
    	}
    	
    	return new ArrayList<String>();
    	
    }

//    /*
//     * Geeft een lijst terug van verzorgers die een of meerdere dieren verzorgen die verblijven in
//     * het gebouw met de opgegeven naam. Geeft een lege lijst terug indien er geen gebouw is met
//     * deze naam.
    //    * NU DUMMY UITWERKING voor test gebruik in deze toepassing 
//  *  NIET VERDER UITWERKEN
//     */
    public List<Verzorger> verzorgersInGebouwMetNaam(String gebouwNaam) {
        if (gebouwNaam.equalsIgnoreCase("Reptielen")) {
            return verzorgers;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * De methode maakOverzichtVolgensSoort geeft een overzicht (Map) terug van
     * alle dieren per Soort.
     */
    //TODO
    // TODO METHODE ....maakOverzichtVolgensSoort() ... hier uitschrijven
    //
    public Map<Soort, List<Dier>> maakOverzichtVolgensSoort(){
    	return dieren.stream()
    			.collect(Collectors.groupingBy(Dier::getSoort));
    }
}
