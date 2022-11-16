package passatempo.carte;

import java.util.ArrayList;

public class Tavolo {

	private ArrayList<Carta> cartePerTerra;

	
	public Tavolo() {
		super();
		this.cartePerTerra = new ArrayList<Carta>();
	}

	public ArrayList<Carta> getCartePerTerra() {
		return cartePerTerra;
	}

	public void setCartePerTerra(ArrayList<Carta> cartePerTerra) {
		this.cartePerTerra = cartePerTerra;
	}

	@Override
	public String toString() {
		return "Tavolo " + cartePerTerra ;
	}
	
	
}
