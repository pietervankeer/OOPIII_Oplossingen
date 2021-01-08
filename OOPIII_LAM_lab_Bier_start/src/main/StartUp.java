package main;

import domein.DomeinController;
import ui.BierApplicatie;
import ui.BierApplicatie2;

public class StartUp
{
    public static void main(String[] args)
    {
        DomeinController dc=new DomeinController();
        new BierApplicatie(dc);
        
        //new BierApplicatie2(dc);
    }
}
