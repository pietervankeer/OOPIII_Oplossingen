package domein;

import java.time.LocalDate;

public class Onderhoudsbeurt {

    private LocalDate begindatum;
   
    private LocalDate einddatum;

    private Vervoermiddel vervoermiddel;

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

}
