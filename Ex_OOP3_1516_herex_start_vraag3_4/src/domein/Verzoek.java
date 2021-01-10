package domein;

import java.io.Serializable;
import java.util.List;

public class Verzoek<T> implements Serializable {
	private final String parameter;
	private final String query;
	private List<T> resultaat;

	public Verzoek(String query, String text) {
		this.query = query;
		parameter = text;
	}

	public String getParameter() {
		return parameter;
	}

	public String getQuery() {
		return query;
	}

	public void setResultaat(List<T> lijst) {
		resultaat = lijst;
	}
	public List<T> getResultaat(){
		return resultaat;
	}

}
