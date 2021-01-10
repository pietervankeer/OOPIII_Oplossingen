package domein;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

import domein.Vervoermiddel;

@Entity
@NamedQuery(name = "Onderhoudsbeurt.opDatum", query = "SELECT o FROM Onderhoudsbeurt o WHERE :x BETWEEN o.begindatum AND o.einddatum")
public class Onderhoudsbeurt implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
    private LocalDate begindatum;
   
    private LocalDate einddatum;

    @ManyToOne
    private Vervoermiddel vervoermiddel;

    
    protected Onderhoudsbeurt() {
    }
    
    public Onderhoudsbeurt(LocalDate begindatum, LocalDate einddatum, Vervoermiddel vervoermiddel) {
        this.begindatum = begindatum;
        this.einddatum = einddatum;
        this.vervoermiddel = vervoermiddel;
    }

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(LocalDate einddatum) {
        this.einddatum = einddatum;
    }

    public Vervoermiddel getVervoermiddel() {
        return vervoermiddel;
    }

    public void setVervoermiddel(Vervoermiddel vervoermiddel) {
        this.vervoermiddel = vervoermiddel;
    }

    public boolean bevatDatum(LocalDate datum) {
    	return !((datum.isBefore(begindatum)) || (datum.isAfter(einddatum)));
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((begindatum == null) ? 0 : begindatum.hashCode());
		result = prime * result + ((einddatum == null) ? 0 : einddatum.hashCode());
		result = prime * result + ((vervoermiddel == null) ? 0 : vervoermiddel.hashCode());
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
		Onderhoudsbeurt other = (Onderhoudsbeurt) obj;
		if (begindatum == null) {
			if (other.begindatum != null)
				return false;
		} else if (!begindatum.equals(other.begindatum))
			return false;
		if (einddatum == null) {
			if (other.einddatum != null)
				return false;
		} else if (!einddatum.equals(other.einddatum))
			return false;
		if (vervoermiddel == null) {
			if (other.vervoermiddel != null)
				return false;
		} else if (!vervoermiddel.equals(other.vervoermiddel))
			return false;
		return true;
	}
    
    
    
    

}
