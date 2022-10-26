package passatempo.cards;

import java.util.ArrayList;

public class Tavolo {
	
	private ArrayList<Carta> cartePerTerra;
	
	public ArrayList<Carta> getCartePerTerra() {
		return cartePerTerra;
	}

	public void setCartePerTerra(ArrayList<Carta> cartePerTerra) {
		this.cartePerTerra = cartePerTerra;
	}

	public ArrayList<Carta> TerraIniziale(ArrayList<Carta> mazzo) {
		this.cartePerTerra = new ArrayList<Carta>();
		for (int i=0; i<4; i++) {
			Carta c= new Carta();
			c= mazzo.get(0);
			this.cartePerTerra.add(c);
			//System.out.println("pescato"+c.getValore()+c.getSeme());
			mazzo.remove(0);
			}
		System.out.println("vengono messe 4 carte per terra");
		return mazzo;
	}
	
}