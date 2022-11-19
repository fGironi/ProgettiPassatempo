package passatempo.negozio;

import java.util.HashMap;

public class Negozio {

	private HashMap<String, Cliente> clienti;
	private Integer giorniAttivita;
	
	
	public Negozio() {
		super();
		this.clienti = new HashMap<String, Cliente>();
		this.giorniAttivita = 0;
	}

	public HashMap<String, Cliente> getClienti() {
		return clienti;
	}

	public void setClienti(HashMap<String, Cliente> clienti) {
		this.clienti = clienti;
	}

	public Integer getGiorniAttivita() {
		return giorniAttivita;
	}

	public void setGiorniAttivita(Integer giorniAttivita) {
		this.giorniAttivita = giorniAttivita;
	}
	
	
	
}
