package passatempo.carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Random;



public class Scopa implements Gioco {

	private String ultimaPresa;
	private HashMap<Giocatore, Carta> scopeFatte;
	
	
	
	public void pescata(ArrayList<Carta> mazzo, Giocatore giocatore) {
		for (int i=0; i<3; i++) {
			Carta c= mazzo.get(0);
			giocatore.getMano().add(c);
			mazzo.remove(0);
		}
		System.out.println(giocatore.getNome()+" pesca 3 carte");
	}
	
	@Override
	public void setupGioco(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo) throws ArithmeticException {
		if (giocatori.size()>4) throw new ArithmeticException("Non si possono avere più di 4 giocatori per una partita a scopa!");
		if (giocatori.size()<2) throw new ArithmeticException("Non si possono avere meno di 2 giocatori per una partita a scopa!");
		this.scopeFatte=new HashMap<Giocatore, Carta>();
		for (Giocatore g:giocatori.values()) {
			this.pescata(mazzo, g);
		}
		ArrayList<Carta> cterra=new ArrayList<Carta>();
		tavolo.setCartePerTerra(cterra);
		for (int i=0; i<4; i++) {
			Carta c= mazzo.get(0);
			tavolo.getCartePerTerra().add(c);
			mazzo.remove(0);
		}
		System.out.println("vengono messe 4 carte per terra");
	}

	
	@Override
	public void giocaTurno(Giocatore giocatore, Tavolo tavolo) {
		Random rnd=new Random();
		Carta cartaGiocata = giocatore.getMano().get(rnd.nextInt(giocatore.getMano().size()));
		System.out.println(giocatore.getNome()+" gioca "+cartaGiocata);
		boolean presaFatta=false;
		for (Carta cartaTerra:tavolo.getCartePerTerra()) {
			if (cartaGiocata.getValore()==cartaTerra.getValore()) {
				System.out.println(giocatore.getNome()+" prende "+cartaTerra+" da terra");
				giocatore.getPrese().add(cartaTerra);
				giocatore.getPrese().add(cartaGiocata);
				giocatore.getMano().remove(cartaGiocata);
				tavolo.getCartePerTerra().remove(cartaTerra);
				presaFatta=true;
				this.ultimaPresa=giocatore.getNome();
				if(tavolo.getCartePerTerra().size()==0) {
					System.out.println("Scopa per "+giocatore.getNome()+"!");
					this.scopeFatte.put(giocatore, cartaGiocata);
					}
				break;
			}
		}
		//presa con la somma di due carte:
		if (presaFatta==false) {
			for (int i=0; i<tavolo.getCartePerTerra().size()-1; i++) {
				Carta cartaT1=tavolo.getCartePerTerra().get(i);
				for (int j=i+1; j<tavolo.getCartePerTerra().size(); j++) {
					Carta cartaT2=tavolo.getCartePerTerra().get(j);
					if (cartaGiocata.getValore()==((cartaT1.getValore())+cartaT2.getValore())) {
						System.out.println(giocatore.getNome()+" prende "+cartaT1+" e "+cartaT2+" da terra");
						giocatore.getPrese().add(cartaT1);
						giocatore.getPrese().add(cartaT2);
						giocatore.getPrese().add(cartaGiocata);
						giocatore.getMano().remove(cartaGiocata);
						tavolo.getCartePerTerra().remove(cartaT1);
						tavolo.getCartePerTerra().remove(cartaT2);
						presaFatta=true;
						this.ultimaPresa=giocatore.getNome();
						if(tavolo.getCartePerTerra().size()==0) {
							System.out.println("Scopa per "+giocatore.getNome()+"!"); 
							this.scopeFatte.put(giocatore, cartaGiocata);
							}
						break;
					}
				}
				if (presaFatta==true) {break;}
			}
				
		}
		
		if (presaFatta==false) {
			System.out.println(giocatore.getNome()+" non prende nulla");
			tavolo.getCartePerTerra().add(cartaGiocata);
			giocatore.getMano().remove(cartaGiocata);
		}
		System.out.println();
		
	}
	
	public void prendiCarteRimaste(HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		for (Giocatore g:giocatori.values())	
			if (this.ultimaPresa==g.getNome()) {
				System.out.println(g.getNome()+" ha fatto l'ultima presa, quindi prende le carte rimaste");
				for (Carta c:tavolo.getCartePerTerra()) {
					g.getPrese().add(c);
					System.out.println(g.getNome()+" prende "+c);
				}
				System.out.println();
		}
	}
	
	public void situazione(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		for (Giocatore g:giocatori.values()) {
			System.out.println(g);
		}
		System.out.println(tavolo);
		System.out.println(mazzo.size()+" carte rimaste");
	}
	
	public void svolgiPartita(ArrayList<Carta> mazzo, HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		while (mazzo.size()>0) {
			for (int i=0; i<3; i++) {
				for (Giocatore g:giocatori.values()) {
					System.out.println();
					this.giocaTurno(g, tavolo);
					this.situazione(mazzo, giocatori, tavolo);
				}
			}
			for (Giocatore g:giocatori.values()) this.pescata(mazzo, g);
			this.situazione(mazzo, giocatori, tavolo);
		}
		for (int i=0; i<3; i++) {
			for (Giocatore g:giocatori.values()) {
				System.out.println();
				this.giocaTurno(g, tavolo);
				this.situazione(mazzo, giocatori, tavolo);
			}
		}
	}
	
	public void puntiScopa(HashMap<Giocatore, Carta> scopeFatte) {
		System.out.println("Conta delle scope fatte:");
		if (scopeFatte.size()==0) System.out.println("nessuna scopa!");
		for (Entry<Giocatore, Carta> entry :scopeFatte.entrySet()) {
			System.out.println("punto a "+entry.getKey().getNome()+" per la scopa con il "+entry.getValue());
			entry.getKey().setPunti(entry.getKey().getPunti()+1);
		}
	}
	
	
	public void puntoCarte(HashMap<String, Giocatore> listaGiocatori) {
		System.out.println("Conta delle carte prese:");
		HashMap<String, Integer> mappaPuntoCarte=new HashMap<String, Integer>();
		for (Giocatore g:listaGiocatori.values()) {
			mappaPuntoCarte.put(g.getNome(), g.getPrese().size()); 
			System.out.println(g.getNome()+" "+g.getPrese().size()+" carte");
		}
		Integer maxCarte=Collections.max(mappaPuntoCarte.values());
		for (Entry<String, Integer> entry :mappaPuntoCarte.entrySet()) {
			if (entry.getValue()==maxCarte) {
				System.out.println("Punto a "+entry.getKey()+ " con "+entry.getValue()+" carte!");
				listaGiocatori.get(entry.getKey()).setPunti(listaGiocatori.get(entry.getKey()).getPunti()+1);
			}
		
		}
	}
	public void puntoDenara(HashMap<String, Giocatore> listaGiocatori) {
		System.out.println("Conta delle denara prese:");
		HashMap<String, Integer> mappaPuntoDenara=new HashMap<String, Integer>();
		
		for (Giocatore g:listaGiocatori.values()) {
				Integer denaraGiocatore=0;
				for(Carta c:g.getPrese()) {
					if (c.getSeme()==SemeCarte.denara) {
						denaraGiocatore++;
						if (c.getValore()==7) {
							System.out.println(g.getNome()+" ha il 7 bello! punto extra!"); 
							g.setPunti(g.getPunti()+1);
						}
					}
				}
			mappaPuntoDenara.put(g.getNome(), denaraGiocatore); 
			System.out.println(g.getNome()+" "+denaraGiocatore+" denara");
		}
		
		Integer maxDenara=Collections.max(mappaPuntoDenara.values());
		for (Entry<String, Integer> entry :mappaPuntoDenara.entrySet()) {
			if (entry.getValue()==maxDenara) {
				System.out.println("Punto a "+entry.getKey()+ " con "+entry.getValue()+" denara!");
				listaGiocatori.get(entry.getKey()).setPunti(listaGiocatori.get(entry.getKey()).getPunti()+1);
			}
		}			
	}
	
	
	public Integer primieraSeme (Giocatore g, SemeCarte seme) {
		int puntiPrim=0;
		for (Carta c:g.getPrese()) {
			if (c.getSeme()==seme) {
				if (c.getValore()==7) {puntiPrim=21; break;}
				else if (c.getValore()==6) {if (puntiPrim<18) {puntiPrim=18;}}
				else if (c.getValore()==1) {if (puntiPrim<18) {puntiPrim=16;}}
				else if (c.getValore()==5) {if (puntiPrim<18) {puntiPrim=15;}}
				else if (c.getValore()==4) {if (puntiPrim<18) {puntiPrim=14;}}
				else if (c.getValore()==3) {if (puntiPrim<18) {puntiPrim=13;}}
				else if (c.getValore()==2) {if (puntiPrim<18) {puntiPrim=12;}}
				else if (c.getValore()==10||c.getValore()==9||c.getValore()==8) {
					if (puntiPrim<18) {	puntiPrim=10;}
					}
				else puntiPrim=0;
			}
		}
		System.out.println(seme+": "+puntiPrim+" punti");
		return puntiPrim;
	}
	
	public void puntoPrimiera (HashMap<String, Giocatore> listaGiocatori) {
		HashMap<String, Integer> mappaPuntoPrimiera=new HashMap<String, Integer>();
		System.out.println("Conta delle primiere:");
		for (Giocatore g: listaGiocatori.values()) {
			Integer primG=0;
			primG=(this.primieraSeme(g, SemeCarte.denara)+this.primieraSeme(g, SemeCarte.coppe)+this.primieraSeme(g, SemeCarte.spade)+this.primieraSeme(g, SemeCarte.bastoni));
			mappaPuntoPrimiera.put(g.getNome(), primG); 
			System.out.println("Primiera di "+g.getNome()+": "+primG); System.out.println();
		}
		
		Integer maxPrimiera=Collections.max(mappaPuntoPrimiera.values());
		for (Entry<String, Integer> entry :mappaPuntoPrimiera.entrySet()) {
			if (entry.getValue()==maxPrimiera) {
				System.out.println("Punto a "+entry.getKey()+ " con una primiera da "+entry.getValue());
				listaGiocatori.get(entry.getKey()).setPunti(listaGiocatori.get(entry.getKey()).getPunti()+1);
			}
			
		}
		
	}
	
	
	@Override
	public void calcoloPunti(HashMap<String, Giocatore> giocatori, Tavolo tavolo) {
		this.prendiCarteRimaste(giocatori, tavolo);
		System.out.println("FINE PARTITA! Inizio il calcolo dei punti:"); System.out.println();
		this.puntiScopa(scopeFatte); System.out.println();
		this.puntoCarte(giocatori); System.out.println();
		this.puntoDenara(giocatori); System.out.println();
		this.puntoPrimiera(giocatori); System.out.println();
		System.out.println("RISULTATO FINALE");
		for (Giocatore g:giocatori.values()) System.out.println(g.getNome()+" "+g.getPunti()+" punti");
		
			
	}





	public String getUltimaPresa() {
		return ultimaPresa;
	}
	public void setUltimaPresa(String ultimaPresa) {
		this.ultimaPresa = ultimaPresa;
	}

	public HashMap<Giocatore, Carta> getScopeFatte() {
		return scopeFatte;
	}

	public void setScopeFatte(HashMap<Giocatore, Carta> scopeFatte) {
		this.scopeFatte = scopeFatte;
	}








}
