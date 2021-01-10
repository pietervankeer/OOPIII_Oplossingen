package persistentie;

import domein.Dier;
import domein.Soort;
import java.util.Arrays;
import java.util.List;

public class DierMapper {

    /*
     * Geeft dummy data terug die je kan gebruiken ter vervanging van een databank.
     */
    public List<Dier> getDieren() {
        Soort krokodil = new Soort("Krokodil");
        Dier kroky = new Dier(1, "Kroky", 102, krokodil);
        Dier happy = new Dier(2, "Happy", 97, krokodil);

        Soort vogel = new Soort("Vogel");
        Dier beo = new Dier(3, "Beo", 0.102, vogel);
        Dier koko = new Dier(4, "Koko", 0.97, vogel);
        return Arrays.asList(kroky, happy, beo, koko);
    }

}
