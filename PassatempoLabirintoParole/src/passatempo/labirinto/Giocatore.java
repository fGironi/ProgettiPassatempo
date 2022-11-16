package passatempo.labirinto;

import java.awt.Point;

public class Giocatore {

	private Point posizione;
	private Integer vita;
	private Boolean haSpada;
	private Boolean haChiave;
	private Integer tesori;
	private Boolean vinto;
	
	public Giocatore(Point posizione) {
		super();
		this.posizione = posizione;
		this.haSpada=false;
		this.haChiave=false;
		this.vita=3;
		this.tesori=0;
		this.vinto=false;
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
}
