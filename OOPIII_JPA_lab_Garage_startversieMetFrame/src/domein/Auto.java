package domein;

public class Auto extends Vervoermiddel {

    public Auto(String nummerplaat) {
        super(nummerplaat);
    }

    @Override
    public double geefVerkeersbelasting() {
        return 77.75;
        //volgens cilinderinhoud
    }
}
