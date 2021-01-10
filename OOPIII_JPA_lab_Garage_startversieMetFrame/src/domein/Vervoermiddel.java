package domein;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* 
 *  Stappenplan voor JPA te implementeren:
 *  
 *  	Stap 1: @Entity toevoegen boven de klasse
 *  	Stap 2: Is er een ID? ofwel een bestaande propertie kiezen ofwel property toevoegen. @Id en @GeneratedValue(strategy = GenerationType.AUTO) toevoegen
 *  	Stap 3: interface Serializable implementeren + versie nummer laten genereren
 *  	Stap 4: Zijn getters en setters in orde?
 *  	Stap 5: is de toString(), hashcode en equals geimplementeerd?
 */ 




// Van de klasse een entiteit maken
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Vervoermiddel implements TebetalenTaks, Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private String nummerplaat;
    
    @OneToMany(mappedBy = "vervoermiddel", cascade = CascadeType.ALL)
    private List<Onderhoudsbeurt> onderhoudsbeurten = new ArrayList<>();

    
    // Constructors
    // default constructor voor JPA
    protected Vervoermiddel() {
    	
	}
    public Vervoermiddel(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    
    // getters en setters
    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }
    
    public List<Onderhoudsbeurt> getOnderhoudsbeurten() {
        return Collections.unmodifiableList(onderhoudsbeurten);
    }
    
    
    // Methods
    public void addOnderhoudsbeurt(Onderhoudsbeurt ob){
        onderhoudsbeurten.add(ob);
    }
    
    public Onderhoudsbeurt geefOnderhoudsbeurtOpDatum(LocalDate dat) {
    	return onderhoudsbeurten.stream()
    			.filter(o -> o.bevatDatum(dat))
    			.findAny()
    			.orElse(null);    }

    @Override
    public String toString() {
        return String.format("Vervoermiddel{nummerplaat=%s}%n", nummerplaat);
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nummerplaat == null) ? 0 : nummerplaat.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vervoermiddel other = (Vervoermiddel) obj;
		if (nummerplaat == null) {
			if (other.nummerplaat != null)
				return false;
		} else if (!nummerplaat.equals(other.nummerplaat))
			return false;
		return true;
	}
    
    

}
