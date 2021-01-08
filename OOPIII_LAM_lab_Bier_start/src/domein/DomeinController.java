package domein;

import java.util.List;
import java.util.Map;

public class DomeinController
{
    private BierWinkel bierWinkel;

    public DomeinController()
    {
        bierWinkel = new BierWinkel();
    }
  
    public long geefAantalBierenMetMinAlcoholPercentage(double percentage)
    {
    	return bierWinkel.geefAantalBierenMetMinAlcoholPercentage(percentage);
    }
    
    public List<String> geefLijstAlleBierenMetMinAlcoholPercentage(double percentage)
    {
    	return null;
    }
    
    public List<String> geefAlleBieren()
    {
        return null;
    }
    
    public String geefNamenBieren()
    {
        return null;
    }
    
    public String geefBierMetHoogsteAlcoholPercentage()
    {
        return null;
    }
    
    public String geefBierMetLaagsteAlcoholPercentage()
    {
        return null;
    }
    
    public List<String> geefGeordendOpAlcoholGehalteEnNaam()
    {
       return null;
    }
    
    public String geefAlleNamenBrouwerijen()
    {
        return null;
    }
    
    public String geefAlleNamenBrouwerijenMetWoord(String woord)
    {
        return null;
    }

    public String opzettenAantalBierenPerSoort()
    {   //naar BierWinkel --> map<String, Long>
        return null;
    }

    public String opzettenOverzichtBierenPerSoort()
    {  // naar BierWinkel --> map<String, List<Bier>>
        return null;
    }

    /*
    private       String overzichtToString(Map<    > map)
    {  //hulp voor map --> String
         return null;
    }
    */

}
