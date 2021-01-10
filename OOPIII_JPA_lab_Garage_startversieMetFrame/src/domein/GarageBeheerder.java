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

	public final String PERSISTENCE_UNIT_NAME = "JPA_details";
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
		return vervoerMap.values().stream().filter(v -> v instanceof Auto) // filter alle auto's
				.map(v -> (Auto) v).filter(a -> a.getOnderhoudsbeurten().isEmpty()) // filter auto's zonder
																					// onderhoudsbeurten
				.collect(Collectors.toList());
	}

	public List<Auto> geefAutosZonderOnderhoudsbeurtJPA() {
		return em.createNamedQuery("Auto.alleAutosZonderOnderhoud", Auto.class)
				.getResultList();
	}

	public List<Auto> geefAutosMetOnderhoudsbeurt() {
		return vervoerMap.values().stream().filter(v -> v instanceof Auto) // filter alle auto's
				.map(v -> (Auto) v).filter(a -> !a.getOnderhoudsbeurten().isEmpty()) // filter auto's met
																						// onderhoudsbeurten
				.collect(Collectors.toList());
	}

	public List<Auto> geefAutosMetOnderhoudsbeurtJPA() {
		return em.createNamedQuery("Auto.alleAutosMetOnderhoud", Auto.class)
				.getResultList();
		
	}

	public List<Onderhoudsbeurt> geefOnderhoudsbeurtenOpDatum(LocalDate dat) {
		return vervoerMap.values().stream()
				.map(v -> v.geefOnderhoudsbeurtOpDatum(dat))
				.filter(o -> o != null)
				.collect(Collectors.toList());
	}

	public List<Onderhoudsbeurt> geefOnderhoudsbeurtenOpDatumJPA(LocalDate dat) {
		return em.createNamedQuery("Onderhoudsbeurt.opDatum", Onderhoudsbeurt.class)
				.setParameter("x", dat)
				.getResultList();
	}

	public void addVervoermiddel(Vervoermiddel v) {
		vervoerMap.put(v.getNummerplaat(), v);

		// begin transactie
		em.getTransaction().begin();
		// vervoersmiddel persisteren
		em.persist(v);
		// einde transactie
		em.getTransaction().commit();

	}

	public void addOnderhoudsbeurt(String nrplaat, LocalDate begin, LocalDate einde) {
		Vervoermiddel v = vervoerMap.get(nrplaat);
		Onderhoudsbeurt o = new Onderhoudsbeurt(begin, einde, v);

		v.addOnderhoudsbeurt(o);

		// begin transactie
		em.getTransaction().begin();
		// vervoersmiddel persisteren
		em.persist(o);
		// einde transactie
		em.getTransaction().commit();

	}
}
