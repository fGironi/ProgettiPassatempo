package passatempo.labirinto;

public class Trappola implements Evento {

	private String nomeEvento="una trappola";
	
	@Override
	public void indaga(Giocatore g, Stanza s) {
		g.setVita(g.getVita()-1);
		System.out.println("C'era una trappola! perdi una vita! (vite:"+g.getVita()+")");
		s.setEventoAttivato(true);
	}
	@Override
	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}

}
