package passatempo.magia;

import java.util.ArrayList;

public abstract class Mago {
	
	private String nome;
	private int mana;
	private ArrayList<Magia> libroDiMagie;
	private String scuola;
	
	
	
	public Mago(String nome) {
		super();
		this.nome = nome;
		ArrayList<Magia> ldm=new ArrayList<Magia>();
		this.setLibroDiMagie(ldm);
		
	}

	public int getMana() {
		return mana;
	}

	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ArrayList<Magia> getLibroDiMagie() {
		return libroDiMagie;
	}

	public void setLibroDiMagie(ArrayList<Magia> libroDiMagie) {
		this.libroDiMagie = libroDiMagie;
	}
	public String getScuola() {
		return scuola;
	}
	public void setScuola(String scuola) {
		this.scuola = scuola;
	}
	


	public void imparaMagia(Magia m) {
	this.libroDiMagie.add(m);
	System.out.println("il mago "+this.getNome()+" ha scritto nel suo libro la magia "+m.getNome());
	}

	public void lanciaMagia(Magia magia, Object bersaglio) {
		if (this.getLibroDiMagie().contains(magia)) {
			System.out.println(this.getNome()+" lancia la magia "+magia.getNome());
			System.out.println(magia.getDescrizione());
			}
		else {System.out.println(this.getNome()+" non conosce questa magia");}
	}

}
