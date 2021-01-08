package ui;

import domein.DomeinController;

public class BierApplicatie2 {

    private DomeinController domeinController;

    public BierApplicatie2(DomeinController dc) {
        this.domeinController = dc;
        run();
    }

    public void run() {
        System.out.println(domeinController.opzettenAantalBierenPerSoort());
        System.out.println(domeinController.opzettenOverzichtBierenPerSoort());
    }
}
