package passatempo.magia;

public abstract class Magia {


	private String nome;
	private String descrizione;
	private int CostoMana;
	private String durata;	
	
		
	public Magia(String nome) {
		super();
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getCostoMana() {
		return CostoMana;
	}
	public void setCostoMana(int costoMana) {
		CostoMana = costoMana;
	}
	public String getDurata() {
		return durata;
	}
	public void setDurata(String durata) {
		this.durata = durata;
	}
	public String effettoMagia(Object o) {
		return this.getDescrizione();
	}
	
		
	public abstract int consumoMana();		

}
