package domein;

import java.time.LocalDate;
import java.util.List;

public class GarageController {

    private GarageBeheerder gb = new GarageBeheerder();

    public List<String> geefAutosZonderOnderhoudsbeurt() {
        return null;
    }

    public List<String> geefAutosMetOnderhoudsbeurt() {
        return null;
    }

    public List<String> geefOnderhoudsbeurtenOpDatum(int jaar, int maand, int dag) {
        return null;
    }

    public void close() {
        gb.closePersistentie();
    }

}
