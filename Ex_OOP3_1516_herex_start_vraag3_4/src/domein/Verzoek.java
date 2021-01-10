package domein;

import java.io.Serializable;


public class Verzoek   implements Serializable {
    private final String parameter;
    private final String query;
//TODO data attribuut
    
    public Verzoek(String query, String text) {
        this.query=query;
        parameter=text;
    }

    public String getParameter() {
        return parameter;
    }
    public String getQuery() {
        return query;
    }
    //TODO
   // methoden getResultaat en setResult


}
