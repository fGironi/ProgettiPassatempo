package passatempo.carte;

import java.util.ArrayList;


public class Giocatore {

	private String nome;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> prese;
	private Integer punti;
	
	public Giocatore(String nome) {
		super();
		this.nome = nome;
		this.mano= new ArrayList<Carta>();
		this.prese=new ArrayList<Carta>();
		this.punti=0;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Carta> getMano() {
		return mano;
	}
	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	public ArrayList<Carta> getPrese() {
		return prese;
	}
	public void setPrese(ArrayList<Carta> prese) {
		this.prese = prese;
	}
	public Integer getPunti() {
		return punti;
	}
	public void setPunti(Integer punti) {
		this.punti = punti;
	}

	@Override
	public String toString() {
		return nome +" "+ mano;
	}

}
