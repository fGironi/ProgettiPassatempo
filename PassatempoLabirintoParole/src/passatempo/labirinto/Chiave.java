package passatempo.labirinto;

public class Chiave extends Oggetto {

	private String nome="chiave";

	
	
	
	@Override
	public void effetto(Giocatore g, Stanza s) {
		if (s.getEvento() instanceof Uscita) {
			System.out.println("prepari la chiave");
			g.setHaChiave(true);
			g.getZaino().remove(this.nome);
		}
		else System.out.println("prepari la chiave, ma non c'e' nessuna serratura da aprire");
		super.effetto(g, s);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	
}
