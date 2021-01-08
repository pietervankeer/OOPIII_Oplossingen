package ui;

import domein.DomeinController;

public class BierApplicatie
{

    private final DomeinController domeinController;

    public BierApplicatie(DomeinController dc)
    {
        this.domeinController = dc;
        run();
    }

    //KLEINE OEFENINGEN OP JAVA 8
    //---------------------------------------
    public void run()
    {
        //Alles gebeurt avh tekstbestand bieren.txt
        //Bereken het aantal bieren die minstens 8 graden hebben
        System.out.println("======================================================");
        System.out.println("Bereken het aantal bieren die minstens 8 graden hebben");

        System.out.println("Aantal bieren van minstens 8 graden:" 
                + domeinController.geefAantalBierenMetMinAlcoholPercentage(8));

        //Maak een lijst met alle bieren van minstens 8 graden
        System.out.println("======================================================");
        System.out.println("Maak een lijst met alle bieren van minstens 8 graden");
        domeinController.geefLijstAlleBierenMetMinAlcoholPercentage(8).
                forEach(bier -> System.out.println(bier));

        //Enkel namen van bieren laten zien
        System.out.println("======================================================");
        System.out.println("Enkel namen van bieren laten zien");
        System.out.println(domeinController.geefNamenBieren());
       

        //Bier met hoogst aantal graden
        System.out.println("======================================================");
        System.out.println("Bier met hoogste aantal graden");
        System.out.println("Bier met hoogste aantal graden: "
                + domeinController.geefBierMetHoogsteAlcoholPercentage());

        //Bier met laagst aantal graden
        System.out.println("======================================================");
        System.out.println("Bier met laagst aantal graden");
        System.out.println("Bier met laagste aantal graden: " 
                + domeinController.geefBierMetLaagsteAlcoholPercentage());

        /*Zorg ervoor dat het resultaat gesorteerd wordt op alcoholgehalte van hoog naar laag, 
         en bij gelijk aantal graden op naam (alfabetisch).
         */
        System.out.println("======================================================");
        System.out.println("resultaat op alcoholgehalte van hoog naar laag, dan op naam");
        domeinController.geefGeordendOpAlcoholGehalteEnNaam().forEach(System.out::println);
        
        //Alle brouwerijen
        System.out.println("======================================================");
        System.out.println("Alle brouwerijen");
        System.out.println(domeinController.geefAlleNamenBrouwerijen());
        //Alle brouwerijen die het woord "van" bevatten
        System.out.println("======================================================");
        System.out.println("Alle brouwerijen die het woord \"van\" bevatten");
        System.out.println(domeinController.geefAlleNamenBrouwerijenMetWoord("van"));
    }

}
