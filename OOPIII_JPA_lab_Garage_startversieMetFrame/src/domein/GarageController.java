package domein;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.mysql.cj.result.LocalDateTimeValueFactory;

public class GarageController {

    private GarageBeheerder gb = new GarageBeheerder();

    public List<String> geefAutosZonderOnderhoudsbeurt() {
    	//List<Auto> li = gb.geefAutosZonderOnderhoudsbeurt();
    	List<Auto> li = gb.geefAutosZonderOnderhoudsbeurtJPA();
    			
    	return li.stream()
        		.map(Auto::getNummerplaat)
        		.collect(Collectors.toList());
    }

    public List<String> geefAutosMetOnderhoudsbeurt() {
    	//List<Auto> li = gb.geefAutosMetOnderhoudsbeurt();
    	List<Auto> li = gb.geefAutosMetOnderhoudsbeurtJPA();
    	
    	
    	return li.stream()
        		.map(Auto::getNummerplaat)
        		.collect(Collectors.toList());
    	
    }

    public List<String> geefOnderhoudsbeurtenOpDatum(int jaar, int maand, int dag) {
    	LocalDate dat = LocalDate.of(jaar, maand, dag);    	
    	//List<Onderhoudsbeurt> li = gb.geefOnderhoudsbeurtenOpDatum(dat);
    	List<Onderhoudsbeurt> li = gb.geefOnderhoudsbeurtenOpDatumJPA(dat);
    	
    			
    	return li.stream()
        		.map(o -> o.getVervoermiddel().getNummerplaat())
        		.collect(Collectors.toList());

    }

    public void close() {
        gb.closePersistentie();
    }

}
