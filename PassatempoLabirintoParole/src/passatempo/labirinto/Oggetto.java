package passatempo.labirinto;

public abstract class Oggetto {

	private String nome;
	
	public void effetto(Giocatore g, Stanza s) {
		//to Override
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}

