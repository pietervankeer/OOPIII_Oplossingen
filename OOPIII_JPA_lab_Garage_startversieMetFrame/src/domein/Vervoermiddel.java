package domein;

import java.util.ArrayList;
import java.util.List;

public abstract class Vervoermiddel implements TebetalenTaks {
    
    private String nummerplaat;
    private List<Onderhoudsbeurt> onderhoudsbeurten = new ArrayList<>();

    public Vervoermiddel(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }
    
    public List<Onderhoudsbeurt> getOnderhoudsbeurten() {
        //TODO
        return null;
    }
    
    public void addOnderhoudsbeurt(Onderhoudsbeurt ob){
        onderhoudsbeurten.add(ob);
    }

    @Override
    public String toString() {
        return String.format("Vervoermiddel{nummerplaat=%s}%n", nummerplaat);
    }

}
