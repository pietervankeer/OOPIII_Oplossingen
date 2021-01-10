package domein;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GarageBeheerder {

    public final String PERSISTENCE_UNIT_NAME = "OOPIII_JPA_GaragePU";
    private EntityManager em;
    private EntityManagerFactory emf;
    private Map<String, Vervoermiddel> vervoerMap = new HashMap<>();

    public GarageBeheerder() {
        initializePersistentie();
    }

    private void initializePersistentie() {
        openPersistentie();
        GarageData od = new GarageData(this);
        od.populeerData();
    }

    private void openPersistentie() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
    }

    public void closePersistentie() {
        em.close();
        emf.close();
    }

    public List<Auto> geefAutosZonderOnderhoudsbeurt() {
        return null;
    }

    public List<Auto> geefAutosZonderOnderhoudsbeurtJPA() {
        return null;
    }

    public List<Auto> geefAutosMetOnderhoudsbeurt() {
        return null;
    }

    public List<Auto> geefAutosMetOnderhoudsbeurtJPA() {
        return null;
    }

    public List<Onderhoudsbeurt> geefOnderhoudsbeurtenOpDatum(LocalDate dat) {
        return null;
    }

    public List<Onderhoudsbeurt> geefOnderhoudsbeurtenOpDatumJPA(LocalDate dat) {
        return null;
    }

    public void addVervoermiddel(Vervoermiddel v) {
        vervoerMap.put(v.getNummerplaat(), v);
        //TODO
        
    }

    public void addOnderhoudsbeurt(String nrplaat, LocalDate begin, LocalDate einde) {
        Vervoermiddel v = vervoerMap.get(nrplaat);
        Onderhoudsbeurt o = new Onderhoudsbeurt(begin, einde, v);
        //TODO
        
    }
}
