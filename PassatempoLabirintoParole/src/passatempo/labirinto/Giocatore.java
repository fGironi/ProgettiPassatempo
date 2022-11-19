package passatempo.labirinto;

import java.awt.Point;
import java.util.HashMap;

public class Giocatore {

	private Point posizione;
	private Integer vita;
	private Integer maxVita=3;
	public Integer getMaxVita() {
		return maxVita;
	}

	public void setMaxVita(Integer maxVita) {
		this.maxVita = maxVita;
	}

	private Boolean haSpada;
	private Boolean haChiave;
	private Integer tesori;
	private Boolean vinto;
	private HashMap<String, Oggetto> zaino;
	
	public Giocatore(Point posizione) {
		super();
		this.posizione = posizione;
		this.haSpada=false;
		this.haChiave=false;
		this.vita=maxVita;
		this.tesori=0;
		this.vinto=false;
		this.zaino=new HashMap<String, Oggetto>();
	}
	
	public void prendiOggetto(Oggetto ogg) {
		while (this.zaino.containsKey(ogg.getNome())) {
			int i=1;
			ogg.setNome(ogg.getNome()+i);
			i++;
		}
		this.zaino.put(ogg.getNome(), ogg);
	}
	
	public void usaOggetto(String nOgg, Stanza s) {
		if (this.zaino.containsKey(nOgg)==false) {
			System.out.println("non hai questo oggetto");
		}
		else {
			zaino.get(nOgg).effetto(this, s);
		}
	}
	
	
	public Point getPosizione() {
		return posizione;
	}

	public void setPosizione(Point posizione) {
		this.posizione = posizione;
	}
	
	public void muovi(Point dest) {
		this.posizione.setLocation(dest);
	}
	public Integer getVita() {
		return vita;
	}
	public void setVita(Integer vita) {
		this.vita = vita;
	}
	public Boolean getHaSpada() {
		return haSpada;
	}
	public void setHaSpada(Boolean haSpada) {
		this.haSpada = haSpada;
	}
	public Boolean getHaChiave() {
		return haChiave;
	}
	public void setHaChiave(Boolean haChiave) {
		this.haChiave = haChiave;
	}
	public Integer getTesori() {
		return tesori;
	}
	public void setTesori(Integer tesori) {
		this.tesori = tesori;
	}
	public Boolean getVinto() {
		return vinto;
	}
	public void setVinto(Boolean vinto) {
		this.vinto = vinto;
	}

	public HashMap<String, Oggetto> getZaino() {
		return zaino;
	}

	public void setZaino(HashMap<String, Oggetto> zaino) {
		this.zaino = zaino;
	}
	
	
}
