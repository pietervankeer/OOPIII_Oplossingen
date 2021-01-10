package persistentie;

import domein.Dier;
import domein.Verzorger;
import domein.Gebouw;
import java.util.List;

public class PersistentieController {

    private GebouwMapper gebouwMapper;
    private VerzorgerMapper dierenverzorgerMapper;
    private DierMapper dierenMapper;

    public List<Gebouw> geefGebouwen() {
        if (gebouwMapper == null) {
            gebouwMapper = new GebouwMapper();
        }
        return gebouwMapper.getGebouwen();
    }

    public List<Dier> geefDieren() {
        if (dierenMapper == null) {
            dierenMapper = new DierMapper();
        }
        return dierenMapper.getDieren();
    }

    public List<Verzorger> geefVerzorgers() {
        if (dierenverzorgerMapper == null) {
            dierenverzorgerMapper = new VerzorgerMapper();
        }
        return dierenverzorgerMapper.getVerzorgers();
    }

}
