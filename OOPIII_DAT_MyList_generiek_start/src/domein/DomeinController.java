package domein;

import java.io.File;
import java.util.List;

import persistentie.PersistentieController;

public class DomeinController {
    
    private PersistentieController pc = new PersistentieController();
    
    public void persisteerBierGegevensAlsObject(String tekstFileNaam, String objectFileNaam){    
    	//TODO zie stap3
        List<Bier> listBier = pc.leesBieren(new File(tekstFileNaam));
        
        // lijst aanmaken
        MyListIterable<Bier> myListIterable = new MyListIterable<>("bieren");
        
        // lijst opvullen
        listBier.forEach(bier -> myListIterable.insertAtFront(bier));
        
        // lijst persisteren
        pc.persisteerObject(myListIterable, new File(objectFileNaam));
    }
    
}
