package passatempo.cards;

import java.util.*;

public class Main {

	public static void main(String[] args) {

		Partita p=new Partita();
		Tavolo t=new Tavolo();
		
		Giocatore g1= new Giocatore(5818753, "Marco");
		Giocatore g2= new Giocatore(2154873, "Antonio");
		
		
		Collections.shuffle(p.getMazzo());
		
		System.out.println("inizializzo la partita tra "+g1.getNome()+" (id:"+g1.getId()+") e "+g2.getNome()+" (id:"+g2.getId()+")");
		System.out.println("elenco carte presenti nel mazzo attualmente: ("+p.getMazzo().size()+" carte)");
		for(Carta c:p.getMazzo()) {System.out.println(c.getValore()+" di "+c.getSeme());}
		
		System.out.println("---------------------------------");
		
		g1.PescaIniziale(p.getMazzo());
		g2.PescaIniziale(p.getMazzo());
		t.TerraIniziale(p.getMazzo());
		System.out.println();
		
		p.situazione(g1, g2, t);
		
		System.out.println();
		System.out.println("---------------------------------");
		
		while (p.getMazzo().size()>0) {
			while (g2.getMano().size()>0) {
				g1.Gioca(g1.getMano(), t.getCartePerTerra(), p);
				p.situazione(g1, g2, t);
				g2.Gioca(g2.getMano(), t.getCartePerTerra(), p);
				p.situazione(g1, g2, t);
			}
		g1.PescaIniziale(p.getMazzo());
		g2.PescaIniziale(p.getMazzo());
		System.out.println();
		p.situazione(g1, g2, t);
		}
		while (g2.getMano().size()>0) {
			g1.Gioca(g1.getMano(), t.getCartePerTerra(), p);
			p.situazione(g1, g2, t);
			g2.Gioca(g2.getMano(), t.getCartePerTerra(), p);
			p.situazione(g1, g2, t);
		}
		
		g1.prendiCarteRimaste(p, t.getCartePerTerra());
		g2.prendiCarteRimaste(p, t.getCartePerTerra());
		
		p.calcoloPunti(g1, g2);
	}
}
