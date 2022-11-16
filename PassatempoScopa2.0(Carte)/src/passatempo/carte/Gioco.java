package passatempo.carte;

import java.util.ArrayList;
import java.util.HashMap;

public interface Gioco {

	public void setupGioco(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo) throws ArithmeticException;
	public void pescata(ArrayList<Carta> mazzo, Giocatore giocatore);
	public void giocaTurno(Giocatore giocatore, Tavolo tavolo);
	public void svolgiPartita(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo);
	public void calcoloPunti(HashMap<String, Giocatore> giocatori, Tavolo tavolo);
	public void situazione(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo);
}
