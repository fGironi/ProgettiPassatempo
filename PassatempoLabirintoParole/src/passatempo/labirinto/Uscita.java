package passatempo.labirinto;

public class Uscita implements Evento {

	@Override
	public void indaga(Giocatore g, Stanza s) {
		System.out.println("hai trovato una botola segreta! E' chiusa a chiave ma senti il rumore del vento oltre di essa. Potrebbe essere l'uscita da questo labirinto!");

		if (g.getHaChiave()==true) {
			System.out.println("apri la botola con la chiave che hai trovato e corri verso la liberta'! Sei fuori dal labirinto!");
			g.setVinto(true);
		}
		else System.out.println("purtroppo senza chiave non sembra possibile fare molto. Deve essere da qualche parte");
	}

}
