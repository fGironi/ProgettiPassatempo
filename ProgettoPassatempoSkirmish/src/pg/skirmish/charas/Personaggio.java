package pg.skirmish.charas;

public abstract class Personaggio {

	private String nome;
	private int forza;
	private int vita;
	private int velocita;
	private int imprecisione;
	
	public abstract int danno();
	public abstract String attacco(Personaggio bersaglio);
	public abstract void abilita();
	public abstract void abilCombat(Personaggio bersaglio);
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getForza() {
		return forza;
	}
	public void setForza(int forza) {
		this.forza = forza;
	}
	public int getVita() {
		return vita;
	}
	public void setVita(int vita) {
		this.vita = vita;
	}
	public int getVelocita() {
		return velocita;
	}
	public void setVelocita(int velocita) {
		this.velocita = velocita;
	}
	public int getImprecisione() {
		return imprecisione;
	}
	public void setImprecisione(int imprecisione) {
		this.imprecisione = imprecisione;
	}

	
}
