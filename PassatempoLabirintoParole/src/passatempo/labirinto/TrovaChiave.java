package passatempo.labirinto;

public class TrovaChiave implements Evento {

	private String nomeEvento="la chiave!";
	
	@Override
	public void indaga(Giocatore g, Stanza s) {
		System.out.println("hai trovato la chiave!");
		g.setHaChiave(true);
		s.setEventoAttivato(true);

	}

	@Override
	public String getNomeEvento() {
		return this.nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

}
