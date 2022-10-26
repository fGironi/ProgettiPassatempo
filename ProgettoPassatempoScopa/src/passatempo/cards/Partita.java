package passatempo.cards;
import java.util.*;

public class Partita {

	private Giocatore giocatore;
	private String ultimaPresa=null;
	
	
	private ArrayList<Carta> mazzo =new ArrayList<Carta>(); {
		
		for (int i=0; i<10; i++) {
			for (int col=0; col<4; col++) {
				Carta carta =new Carta();
				carta.setValore(i+1);
				if (col==0) { carta.setSeme("denara"); mazzo.add(carta);}
				else if (col==1) { carta.setSeme("spade"); mazzo.add(carta);}
				else if (col==2) { carta.setSeme("bastoni"); mazzo.add(carta);}
				else { carta.setSeme("coppe"); mazzo.add(carta);}
			}
		}
	}	
			
	public String getUltimaPresa() {
		return ultimaPresa;
	}

	public void setUltimaPresa(String ultimaPresa) {
		this.ultimaPresa = ultimaPresa;
	}

	public Giocatore getGiocatore() {
		return giocatore;
	}

	public void setGiocatore(Giocatore giocatore) {
		this.giocatore = giocatore;
	}

	public ArrayList<Carta> getMazzo() {
		return mazzo;
	}

	public void setMazzo(ArrayList<Carta> mazzo) {
		this.mazzo = mazzo;
	}


	
	public void situazione(Giocatore g1, Giocatore g2, Tavolo t) {
		System.out.println("Mano di "+g1.getNome()+"("+g1.getMano().size()+" carte):");
			for (int i=0; i<g1.getMano().size(); i++) {
		System.out.print(g1.getMano().get(i).getValore()+" di "+g1.getMano().get(i).getSeme()+", ");
		}
		System.out.println(); System.out.println();

		System.out.println("Mano di "+g2.getNome()+"("+g2.getMano().size()+" carte):");
		for (int i=0; i<g2.getMano().size(); i++) {
			System.out.print(g2.getMano().get(i).getValore()+" di "+g2.getMano().get(i).getSeme()+", ");
		}
		System.out.println(); System.out.println();
	
		System.out.println("Per terra ci sono "+t.getCartePerTerra().size()+" carte:");
		for (int i=0; i<t.getCartePerTerra().size(); i++) {
			System.out.print(t.getCartePerTerra().get(i).getValore()+" di "+t.getCartePerTerra().get(i).getSeme()+", ");
		}
		System.out.println();
		System.out.println("prese di "+g1.getNome()+": "+g1.getPrese().size());
		System.out.println("prese di "+g2.getNome()+": "+g2.getPrese().size());
		System.out.println("-----------------------------------------");
	}
	
	public int primiera (Giocatore g1, String seme) {
		int puntiPrim=0;
		for (Carta c:g1.getPrese()) {
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
	
	
	
	
	public void calcoloPunti(Giocatore g1, Giocatore g2) {
		System.out.println("-------------------");
		System.out.println("CALCOLO PUNTI:");
		System.out.println();
		
		System.out.println("Scope fatte: "+g1.getNome()+" "+g1.getPunti()+", "+g2.getNome()+" "+g2.getScopeFatte());
		System.out.println();
		
		
	//Carte
		System.out.println("Carte: "+g1.getNome()+" "+g1.getPrese().size()+", "+g2.getNome()+" "+g2.getPrese().size());
		if	(g1.getPrese().size()>g2.getPrese().size()) {
			System.out.println("Punto a "+g1.getNome());
			g1.setPunti(g1.getPunti()+1);
		}
		else if (g2.getPrese().size()>g1.getPrese().size()) {
			System.out.println("Punto a "+g2.getNome());
			g2.setPunti(g2.getPunti()+1);
		}
		else {
			System.out.println("Le carte sono pari, un punto ciascuno");
			g1.setPunti(g1.getPunti()+1); g2.setPunti(g2.getPunti()+1);
		}
		System.out.println();
			//Denara+Settebello
		int denG1=0;
		int denG2=0;
		for (Carta c:g1.getPrese()) {
			if (c.getSeme()=="denara") {
				denG1++;
				if (c.getValore()==7) {g1.setPunti(g1.getPunti()+1); System.out.println(g1.getNome()+" ha il settebello!"); System.out.println();}
				}
			}
		for (Carta c:g2.getPrese()) {
			if (c.getSeme()=="denara") {
				denG2++;
				if (c.getValore()==7) {g2.setPunti(g2.getPunti()+1); System.out.println(g2.getNome()+" ha il settebello!"); System.out.println();}
			}
		}
		
		System.out.println("Denara: "+g1.getNome()+" "+denG1+", "+g2.getNome()+" "+denG2);
		
		if	(denG1>denG2) {
			System.out.println("Punto a "+g1.getNome()+"");
			g1.setPunti(g1.getPunti()+1);
		}
		else if (denG2>denG1) {
			System.out.println("Punto a "+g2.getNome());
			g2.setPunti(g2.getPunti()+1);
		}
		else { 
			System.out.println("Pari, un punto ciascuno");
			g1.setPunti(g1.getPunti()+1); g2.setPunti(g2.getPunti()+1);
		}
		System.out.println();
		
		//Primiera
		int primG1=0;
		primG1=(this.primiera(g1, "denara")+this.primiera(g1, "coppe")+this.primiera(g1, "spade")+this.primiera(g1, "bastoni"));
		System.out.println("Primiera di "+g1.getNome()+": "+primG1);
		System.out.println();
		int primG2=0;
		primG2=(this.primiera(g2, "denara")+this.primiera(g2, "coppe")+this.primiera(g2, "spade")+this.primiera(g2, "bastoni"));
		System.out.println("Primiera di "+g2.getNome()+": "+primG2);
		System.out.println();
		if	(primG1>primG2) {
			System.out.println("Punto a "+g1.getNome()+"");
			g1.setPunti(g1.getPunti()+1);
		}
		else if (primG2>primG1) {
			System.out.println("Punto a "+g2.getNome());
			g2.setPunti(g2.getPunti()+1);
		}
		else { 
			System.out.println("Pari, un punto ciascuno");
			g1.setPunti(g1.getPunti()+1); g2.setPunti(g2.getPunti()+1);
		}
		System.out.println();
		
			
			
			
		System.out.println(g1.getNome()+": "+g1.getPunti());
		System.out.println(g2.getNome()+": "+g2.getPunti());
	}
		

		
	


}
