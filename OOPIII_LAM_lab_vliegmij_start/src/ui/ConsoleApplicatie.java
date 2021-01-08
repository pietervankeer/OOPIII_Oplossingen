package ui;

import domein.DomeinController;


public class ConsoleApplicatie 
{
    public ConsoleApplicatie(DomeinController dc) 
    {
    	System.out.println("Alle vliegmaatschappijen:");
        System.out.println(dc.geefAirlines());
        
        System.out.println("\nAlle vliegmaatschappijen met minstens 2 partners:");
        dc.geefAlleAirlinesMetMinstensAantalPartners(2).forEach(System.out::println);
        
        System.out.println("\nAlle vliegmaatschappijen alfabetisch gesorteerd:");
        System.out.println(dc.geefAirlinesAlfabetischGesorteerd());
        
        System.out.println("\nAlle vliegmaatschappijen gesorteerd volgens aantal partners:");
        System.out.println(dc.geefAirlinesGesorteerdVolgensAantalPartners());
        
        System.out.println("\nAlle vliegmaatschappijen met aantal keer zelf partner:");
        System.out.println(dc.geefAirlinesAantalKeerPartner());
        
        System.out.println("\nEerste vliegmaatschappij in de lijst beginnend met A:");
        System.out.println(dc.geefEersteAirlineStartendMet("A"));
        
        System.out.println("\nEerste vliegmaatschappij in de lijst beginnend met ABC:");
        System.out.println(dc.geefEersteAirlineStartendMet("ABC"));
        
        System.out.println("\nEen vliegmaatschappij met partner Areo Mexico:");
        System.out.println(dc.geefEenAirlineMetPartner("Areo Mexico"));
        
        System.out.println("\nEen vliegmaatschappij met partner Onbestaand:");
        System.out.println(dc.geefEenAirlineMetPartner("Onbestaand"));
        
    }
}
