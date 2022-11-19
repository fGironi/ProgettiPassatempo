package passatempo.labirinto;

public class Spada extends Oggetto {

	private String nome="spada";
	
	@Override
	public void effetto(Giocatore g, Stanza s) {
		if (g.getHaSpada()==true) System.out.println("hai gia' una spada in mano");
		else {
			System.out.println("Equipaggi la spada");
			g.setHaSpada(true);
			g.getZaino().remove(this.nome);
			super.effetto(g, s);
		}
	}


	public String getNome() {
		return this.nome;
	}


	public void setNome(String nome) {
		this.nome= nome;
	}

	
}
