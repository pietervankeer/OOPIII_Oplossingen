package domein;

import java.io.File;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

public class FileServer {
    //attributen voor netwerkconnectie en streams
   //TODO

    public void run() {
        //initialiseer server
        //TODO
        try (    ) {
            System.out.println("Fileserver up");
            //wacht tot een client verbindig maakt
            //verwerk al de verzoeken van een client tot deze afsluit
            //          delegeer naar hulpmethode processClient
            //wacht opnieuw op een client, blijft dit doen
            //TODO
            while (                            ) {
                try {
                    System.out.println("Fileserver waiting...");

                    
                    
                    

                } catch (IOException ex) {
                    System.out.println("Problemen : " + ex.getMessage());
                } 
            }
        } catch (IOException ex) {
            System.out.println("Problemen met server connectie : " + 
                                                ex.getMessage());
        } 
    }

    private void processClient() {
        //verwerk al de verzoeken van een client volgens het afgesproken protocol 
        //tot deze afsluit
        //sluit dan ook de connectie met deze client
        //maak gebruik van de 3 onderstaande hulpmethoden
        try {
 
            
            
        } catch (IOException ex) {
            System.out.println("Problemen met client connectie : " + 
                    ex.getMessage());
        }
    }

    private void sendFile(File file) throws IOException {
        //TODO
            
    }

    private void sendNoFile() {
        //TODO
    
    }
    
    private void readAndSaveUpdateFile(File file) throws IOException {
        //TODO
        
    }

}
