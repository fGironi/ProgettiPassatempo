package passatempo.labirinto;

public class Chiave implements Evento {

	@Override
	public void indaga(Giocatore g, Stanza s) {
		System.out.println("hai trovato la chiave!");
		g.setHaChiave(true);
		s.setEventoAttivato(true);

	}

}
