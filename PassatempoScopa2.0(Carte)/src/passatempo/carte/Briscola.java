package passatempo.carte;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Briscola implements Gioco {
	
	private Carta cartaRegnante;
	private SemeCarte semeBriscola;
	private String ultimaPresa;
	
	@Override
	public void setupGioco(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo)
			throws ArithmeticException {
		if (giocatori.size()!=2) throw new ArithmeticException("Una partita a briscola può essere fatta solo con 2 giocatori (per ora)");
		
		
		for (Giocatore g:giocatori.values()) {
			for (int i=0; i<3; i++) {
				Carta c= mazzo.get(0);
				g.getMano().add(c);
				mazzo.remove(0);
			}
			System.out.println(g.getNome()+" pesca 3 carte");
		}
		this.semeBriscola=mazzo.get(mazzo.size()-1).getSeme();
		System.out.println("L'ultima carta e' il "+mazzo.get(mazzo.size()-1)+". La briscola e' "+this.semeBriscola);
		System.out.println();
	}

	@Override
	public void pescata(ArrayList<Carta> mazzo, Giocatore giocatore) {
		Carta c= mazzo.get(0);
		giocatore.getMano().add(c);
		mazzo.remove(0);
		System.out.println(giocatore.getNome()+" pesca una carta");

	}

	public Integer valorePresa(Carta c) {
		if (c.getValore()==1) return 12;
		else if (c.getValore()==3) return 11;
		else return c.getValore();
	}
	
	
	@Override
	public void giocaTurno(Giocatore giocatore, Tavolo tavolo) {
		Random rnd=new Random();
		Carta cartaGiocata=null;
		if (tavolo.getCartePerTerra().size()==0) {
			cartaGiocata=giocatore.getMano().get(rnd.nextInt(giocatore.getMano().size()));
			tavolo.getCartePerTerra().add(cartaGiocata);
			giocatore.getMano().remove(cartaGiocata);
			this.cartaRegnante=cartaGiocata;
			this.ultimaPresa=giocatore.getNome();
			System.out.println(giocatore.getNome()+" apre con il "+cartaGiocata);
		}
		else {
			Carta cartaGiocabile=null;
			for (Carta c:giocatore.getMano()) {
				if (c.getSeme()==this.cartaRegnante.getSeme() && this.valorePresa(c)>this.valorePresa(this.cartaRegnante)) {
					if (cartaGiocabile==null) cartaGiocabile=c;
					else if (this.valorePresa(c)<this.valorePresa(cartaGiocabile)) cartaGiocabile=c; 
				}
			}
			if (cartaGiocabile==null) {
				if (this.valorePresa(this.cartaRegnante)>7 && this.cartaRegnante.getSeme()!=this.semeBriscola) {
					for (Carta c:giocatore.getMano()) {
						if (cartaGiocabile==null && c.getSeme()==this.semeBriscola) cartaGiocabile=c;
						else if (cartaGiocabile!=null && this.valorePresa(c)<this.valorePresa(cartaGiocabile) && c.getSeme()==this.semeBriscola) cartaGiocabile=c;
					}
				}
			}
			if (cartaGiocabile!=null) {
				this.cartaRegnante=cartaGiocabile;
				this.ultimaPresa=giocatore.getNome();
			}
			if (cartaGiocabile==null) {
				for (Carta c:giocatore.getMano()) {
					if (cartaGiocabile==null &&c.getSeme()!=this.semeBriscola) cartaGiocabile=c;
					else if (cartaGiocabile!=null && this.valorePresa(c)<this.valorePresa(cartaGiocabile)&&c.getSeme()!=this.semeBriscola) cartaGiocabile=c;
					
				}
			}
			if (cartaGiocabile==null){ 
				cartaGiocabile=giocatore.getMano().get(0);
				if (cartaGiocabile.getSeme()==this.semeBriscola && this.valorePresa(cartaGiocabile)>this.valorePresa(cartaRegnante)) {
					this.cartaRegnante=cartaGiocabile;
				}
			}
			
	/*		if (cartaGiocabile==null) {
				for (Carta c:giocatore.getMano()) {
				if (cartaGiocabile!=null && this.valorePresa(c)<this.valorePresa(cartaGiocabile)) cartaGiocabile=c;
				else cartaGiocabile=c;
				this.cartaRegnante=cartaGiocabile;
				}
			}*/
			cartaGiocata=cartaGiocabile;
			tavolo.getCartePerTerra().add(cartaGiocata);
			giocatore.getMano().remove(cartaGiocata);
			System.out.println(giocatore.getNome()+" risponde con il "+cartaGiocata);
			System.out.println();
		}
		

	}

	
	@Override
	public void situazione(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		for (Giocatore g:giocatori.values()) {
			System.out.println(g);
		}
		System.out.println(mazzo.size()+" carte rimaste");
	}
	
	@Override
	public void svolgiPartita(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		for (Giocatore g:giocatori.values()) {
			this.giocaTurno(g, tavolo);
			
		}
		while (mazzo.size()>0) {
			Giocatore primo=null;
			Giocatore secondo=null;
			for (Giocatore g:giocatori.values()) {
				if (this.ultimaPresa==g.getNome()) {
					for (Carta c:tavolo.getCartePerTerra()) {
						g.getPrese().add(c);
						System.out.println(g.getNome()+" prende il "+c);
					}
					primo=g;
					tavolo.getCartePerTerra().clear();
					
				}
				else secondo=g;
			}
			if (mazzo.size()>0) {
				this.pescata(mazzo, primo);
				this.pescata(mazzo, secondo); 
				System.out.println();
			}
			this.situazione(mazzo, giocatori, tavolo); System.out.println();
			this.giocaTurno(primo, tavolo);
			this.giocaTurno(secondo, tavolo); System.out.println();
			if (mazzo.size()==0) {
				for (int i=0; i<2; i++) {
					for (Giocatore g:giocatori.values()) {
						if (this.ultimaPresa==g.getNome()) {
							for (Carta c:tavolo.getCartePerTerra()) {
								g.getPrese().add(c);
								System.out.println(g.getNome()+" prende il "+c);
							}
							primo=g;
							tavolo.getCartePerTerra().clear();
							
						}
						else secondo=g;
					}
					this.situazione(mazzo, giocatori, tavolo); System.out.println();
					if (mazzo.size()>0) {
						this.pescata(mazzo, primo);
						this.pescata(mazzo, secondo); 
						System.out.println();
					}
					this.giocaTurno(primo, tavolo);
					this.giocaTurno(secondo, tavolo); System.out.println();
				}
				for (Giocatore g:giocatori.values()) {
					if (this.ultimaPresa==g.getNome()) {
						for (Carta c:tavolo.getCartePerTerra()) {
							g.getPrese().add(c);
							System.out.println(g.getNome()+" prende il "+c);
						}
						tavolo.getCartePerTerra().clear();
				
					}
				}
				this.situazione(mazzo, giocatori, tavolo); System.out.println();
				
			}
				
		}
		
		
		

	}

	@Override
	public void calcoloPunti(HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		System.out.println("CALCOLO PUNTI:");
		Integer puntiTemp=null;
		String vincitore=null;
		for (Giocatore g: giocatori.values()) {
			g.setPunti(0);
			System.out.println("prese di "+g.getNome()+":");
			for (Carta c:g.getPrese()) {
				if (this.valorePresa(c)>7) System.out.print(c+", ");
				if (c.getValore()==1) g.setPunti(g.getPunti()+11);
				else if (c.getValore()==3) g.setPunti(g.getPunti()+10); 
				else if (c.getValore()==10) g.setPunti(g.getPunti()+4); 
				else if (c.getValore()==9) g.setPunti(g.getPunti()+3);
				else if (c.getValore()==8) g.setPunti(g.getPunti()+2);
			}
			System.out.println();
			System.out.println("Totale: "+g.getPunti()+" punti");
			
			if (vincitore==null) {
				vincitore=g.getNome();
				puntiTemp=g.getPunti();
			}
			
			if (g.getPunti()>puntiTemp) vincitore=g.getNome();
			
			else if (g.getPunti()==puntiTemp) vincitore="lo sport";
			System.out.println();
		}
		
		System.out.println("Il vincitore e' "+vincitore);

	}


		
	

}
