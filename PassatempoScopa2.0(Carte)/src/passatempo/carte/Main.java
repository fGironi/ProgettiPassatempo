package passatempo.carte;
import java.util.HashMap;

 
public class Main {

	public static void main(String[] args) {
		Gioco gioco=new Briscola();
		Partita p=new Partita(gioco);
		p.setMazzo(p.creaMazzo());
		Tavolo tav=p.getTavolo();
		p.mischiaMazzo(p.getMazzo());
		HashMap<String, Giocatore> giocatori=p.getListaGiocatori();
		Giocatore g1=new Giocatore ("Giovanni"); giocatori.put(g1.getNome(), g1);
		Giocatore g2=new Giocatore ("Antonio"); giocatori.put(g2.getNome(), g2);
//		Giocatore g3=new Giocatore ("Marco"); giocatori.put(g3.getNome(), g3);
//		Giocatore g4=new Giocatore ("Piero"); giocatori.put(g4.getNome(), g4);
		
		p.getGiocoScelto().setupGioco(p.getMazzo(), giocatori, tav);
		System.out.println(g1); System.out.println(g2);
		p.getGiocoScelto().svolgiPartita(p.getMazzo(), giocatori, tav);
		p.getGiocoScelto().calcoloPunti(giocatori, tav);
		
	
	}

}
