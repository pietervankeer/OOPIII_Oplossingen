package domein;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Gebouw {

    private String naam;
    private int capaciteit;
    private final List<Dier> dieren = new ArrayList<>();

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
