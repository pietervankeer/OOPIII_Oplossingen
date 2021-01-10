package domein;

import javax.persistence.Entity;

@Entity
public class LichteVracht extends Vervoermiddel {
	private static final long serialVersionUID = 1L;
	
	private double massa;

    protected LichteVracht() {
	}
    
    public LichteVracht(double massa, String nummerplaat) {
        super(nummerplaat);
        this.massa = massa;
    }

    public double getMassa() {
        return massa;
    }

    public void setMassa(double massa) {
        this.massa = massa;
    }

    @Override
    public double geefVerkeersbelasting() {
        throw new UnsupportedOperationException("Not supported yet.");
        //volgens maximale massa
    }
}
