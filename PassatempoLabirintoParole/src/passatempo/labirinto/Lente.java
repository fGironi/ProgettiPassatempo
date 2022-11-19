package passatempo.labirinto;

public class Lente extends Oggetto {

	private String nome="lente";

	@Override
	public void effetto(Giocatore g, Stanza s) {
		System.out.println("la lente magica si dissolve e rivela che qui c'e' "+s.getEvento().getNomeEvento());
		g.getZaino().remove(this.nome);
		super.effetto(g, s);
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
