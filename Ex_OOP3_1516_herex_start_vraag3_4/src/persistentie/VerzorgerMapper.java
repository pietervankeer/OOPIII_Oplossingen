package persistentie;

import domein.Dier;
import domein.Soort;
import domein.Verzorger;
import java.util.Arrays;
import java.util.List;

public class VerzorgerMapper {

    /*
     * Geeft dummy data terug die je kan gebruiken ter vervanging van een databank.
     */
    public List<Verzorger> getVerzorgers() {
        Verzorger jan = new Verzorger(1, "Jan");
        Verzorger piet = new Verzorger(2, "Piet");
        Soort krokodil = new Soort("Krokodil");
        Dier kroky = new Dier(1, "Kroky", 102, krokodil);
        Dier happy = new Dier(2, "Happy", 97, krokodil);
        jan.getDieren().add(kroky);
        jan.getDieren().add(happy);
        piet.getDieren().add(happy);
        return Arrays.asList(jan, piet);
    }

}
