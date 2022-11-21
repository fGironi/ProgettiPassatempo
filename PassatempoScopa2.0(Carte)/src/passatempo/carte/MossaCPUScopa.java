package passatempo.carte;

import java.util.ArrayList;

public class MossaCPUScopa {

	private Carta cartaGiocata;
	private ArrayList <Carta> cartePrese;
	private Integer valoreMossa;
	private Boolean prende;
	
	
	
	public MossaCPUScopa(Integer valoreMossa) {
		super();
		this.cartaGiocata = new Carta();
		this.cartePrese = new ArrayList<Carta>();
		this.valoreMossa = valoreMossa;
	}
	public Carta getCartaGiocata() {
		return cartaGiocata;
	}
	public void setCartaGiocata(Carta cartaGiocata) {
		this.cartaGiocata = cartaGiocata;
	}
	public ArrayList<Carta> getCartePrese() {
		return cartePrese;
	}
	public void setCartePrese(ArrayList<Carta> cartePrese) {
		this.cartePrese = cartePrese;
	}
	public Integer getValoreMossa() {
		return valoreMossa;
	}
	public void setValoreMossa(Integer valoreMossa) {
		this.valoreMossa = valoreMossa;
	}
	public Boolean getPrende() {
		return prende;
	}
	public void setPrende(Boolean prende) {
		this.prende = prende;
	}
	
	
}
