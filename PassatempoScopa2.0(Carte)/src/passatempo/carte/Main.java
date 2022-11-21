package passatempo.carte;
import java.util.HashMap;

 
public class Main {

	public static void main(String[] args) {
		Gioco gioco=new Scopa();
		Partita p=new Partita(gioco);
		p.setMazzo(p.creaMazzo());
		Tavolo tav=p.getTavolo();
		p.mischiaMazzo(p.getMazzo());
		HashMap<String, Giocatore> giocatori=p.getListaGiocatori();
		Giocatore g1=new CPUScopa ("Giovanni"); giocatori.put(g1.getNome(), g1);
		Giocatore g2=new CPUScopa ("Antonio"); giocatori.put(g2.getNome(), g2);
		Giocatore g3=new CPUScopa ("Marco"); giocatori.put(g3.getNome(), g3);
		Giocatore g4=new CPUScopa ("Piero"); giocatori.put(g4.getNome(), g4);
		
		p.getGiocoScelto().setupGioco(p.getMazzo(), giocatori, tav);
		System.out.println(g1); System.out.println(g2);
		p.getGiocoScelto().svolgiPartita(p.getMazzo(), giocatori, tav);
		p.getGiocoScelto().calcoloPunti(giocatori, tav);
		
	
	}

}
