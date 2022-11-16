package passatempo.labirinto;

import java.awt.Point;
import java.util.HashMap;

public class Stanza {

	private Integer idstz;
	private String descrizione;
	private HashMap <String, Stanza> stanzeVicine;
	private Evento evento;
	private Point posizione;
	private Integer nPorte;
	private Boolean haMostro;
	private Boolean eventoAttivato=false;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public HashMap<String, Stanza> getStanzeVicine() {
		return stanzeVicine;
	}
	public void setStanzeVicine(HashMap<String, Stanza> stanzeVicine) {
		this.stanzeVicine = stanzeVicine;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public Point getPosizione() {
		return posizione;
	}
	public void setPosizione(Point posizione) {
		this.posizione = posizione;
	}
	@Override
	public String toString() {
		return "Stanza "+this.idstz+" ["+posizione.x+", "+posizione.y+"] indagata="+this.getEventoAttivato();
		
	}
	public Integer getnPorte() {
		return nPorte;
	}
	public void setnPorte(Integer nPorte) {
		this.nPorte = nPorte;
	}
	public Integer getIdstz() {
		return idstz;
	}
	public void setIdstz(Integer idstz) {
		this.idstz = idstz;
	}
	public Boolean getHaMostro() {
		return haMostro;
	}
	public void setHaMostro(Boolean haMostro) {
		this.haMostro = haMostro;
	}
	public Boolean getEventoAttivato() {
		return eventoAttivato;
	}
	public void setEventoAttivato(Boolean eventoAttivato) {
		this.eventoAttivato = eventoAttivato;
	}

	
	
}
