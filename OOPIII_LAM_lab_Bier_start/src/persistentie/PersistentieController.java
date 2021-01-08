package persistentie;

import domein.Bier;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class PersistentieController {

    private BierMapper bierMapper;

    public List<Bier> inlezenBieren(String naamBestand) {
        if (bierMapper == null) {
            bierMapper = new BierMapper();
        }
        return bierMapper.inlezenBieren(naamBestand);
    }

}
