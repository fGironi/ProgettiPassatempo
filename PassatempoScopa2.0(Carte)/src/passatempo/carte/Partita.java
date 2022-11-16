package passatempo.carte;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Partita {

	private HashMap<String, Giocatore> listaGiocatori=new HashMap<String, Giocatore>();
	private Gioco giocoScelto;
	private ArrayList<Carta> mazzo=new ArrayList<Carta>();
	private Tavolo tavolo;
	
	public Partita() {
		super();
	}
	
	
	
	public Partita(Gioco giocoScelto) {
		super();
		this.giocoScelto = giocoScelto;
		this.listaGiocatori= new HashMap<String, Giocatore>();
		this.tavolo=new Tavolo();
	}



	public HashMap<String, Giocatore> getListaGiocatori() {
		return listaGiocatori;
	}
	public void setListaGiocatori(HashMap<String, Giocatore> listaGiocatori) {
		this.listaGiocatori = listaGiocatori;
	}
	public Gioco getGiocoScelto() {
		return giocoScelto;
	}
	public void setGiocoScelto(Gioco giocoScelto) {
		this.giocoScelto = giocoScelto;
	}
	public ArrayList<Carta> getMazzo() {
		return mazzo;
	}
	public void setMazzo(ArrayList<Carta> mazzo) {
		this.mazzo = mazzo;
	}
	public Tavolo getTavolo() {
		return tavolo;
	}
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	
	public ArrayList<Carta> creaMazzo() {
		this.mazzo=new ArrayList<Carta>();
		for (int i=0; i<10; i++) {
			for (int col=0; col<4; col++) {
				Carta carta =new Carta();
				carta.setValore(i+1);
				if (col==0) { carta.setSeme(SemeCarte.denara); this.mazzo.add(carta);}
				else if (col==1) { carta.setSeme(SemeCarte.spade); this.mazzo.add(carta);}
				else if (col==2) { carta.setSeme(SemeCarte.bastoni); this.mazzo.add(carta);}
				else { carta.setSeme(SemeCarte.coppe); this.mazzo.add(carta);}
			}
		}
		return this.mazzo;
	}
	
	
	public void mischiaMazzo(ArrayList<Carta> mazzo) {
		Collections.shuffle(this.mazzo);
	}
	
	
}
