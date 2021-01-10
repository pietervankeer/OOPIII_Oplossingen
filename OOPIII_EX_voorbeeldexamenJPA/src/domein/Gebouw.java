package domein;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/*
 *  1. @Entity
 *  2. @Id
 *  3. getters en setters?
 *  4. protected standard ctor
 *  5. Serializable
 *  6. generate hashcode and equals
 */

@Entity
public class Gebouw implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
	private String naam;
    private int capaciteit;
    @OneToMany
    private final List<Dier> dieren = new ArrayList<>();

    
    protected Gebouw() {
	}
    
    public Gebouw(String naam, int capaciteit) {
        this.naam = naam;
        this.capaciteit = capaciteit;
    }

    public String getNaam() {
        return naam;
    }

    public int getCapaciteit() {
        return capaciteit;
    }

    public void setCapaciteit(int capaciteit) {
        this.capaciteit = capaciteit;
    }

    public List<Dier> getDieren() {
        return dieren;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.naam);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Gebouw other = (Gebouw) obj;
        if (!Objects.equals(this.naam, other.naam)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naam;
    }
}
