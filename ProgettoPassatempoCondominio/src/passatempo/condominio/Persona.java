package passatempo.condominio;

public abstract class Persona {

	private String nome;
	private String cognome;
	private Famiglia famiglia;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public Famiglia getFamiglia() {
		return famiglia;
	}
	public void setFamiglia(Famiglia famiglia) {
		this.famiglia = famiglia;
	}
	
	
	
	
}
