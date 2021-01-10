/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistentie;

import domein.Dier;
import domein.Gebouw;
import domein.Soort;
import java.util.Arrays;
import java.util.List;

public class GebouwMapper {

    /*
     * Geeft dummy data terug die je kan gebruiken ter vervanging van een databank.
     */
    public List<Gebouw> getGebouwen() {
        Gebouw reptielen = new Gebouw("Reptielen", 40);
        Soort krokodil = new Soort("Krokodil");
        Dier kroky = new Dier(1, "Kroky", 102, krokodil);
        Dier happy = new Dier(2, "Happy", 97, krokodil);
        reptielen.getDieren().add(kroky);
        reptielen.getDieren().add(happy);
        return Arrays.asList(reptielen);
    }

}
