package pg.skirmish;
//import java.util.*;

import pg.skirmish.charas.Personaggio;
import pg.skirmish.charas.Rokra;
import pg.skirmish.charas.Shagga;

public class Main {

	public static void main(String[] args) {
		
		
		Personaggio g1=new Shagga();
		Personaggio g2=new Rokra();
			
		System.out.println(g1.getNome()+" ha un bonus di +"+g1.getForza()+" alla forza, "+g1.getVita()+" punti ferita e "+g1.getVelocita()+" velocità");
		System.out.println(g2.getNome()+" ha un bonus di +"+g2.getForza()+" alla forza, "+g2.getVita()+" punti ferita e "+g2.getVelocita()+" velocità");
		System.out.println();
		System.out.println();
			
		
		if (g2.getVelocita()>g1.getVelocita()){
			System.out.println(g2.attacco(g1));
			System.out.println(g1.getNome()+" e' a "+g1.getVita()+" punti vita");
			System.out.println();
			if (g1.getVita()<=0) {System.out.println(g1.getNome()+" cade! "+g2.getNome()+" vince!");}
			
			System.out.println(g1.getNome()+" e' a "+g1.getVita()+" punti vita");
			System.out.println();
		}
		
		
		while(true) {
			
	//		pg1 attacca
			System.out.println(g1.attacco(g2));
			System.out.println(g2.getNome()+" e' a "+g2.getVita()+" punti vita");
			System.out.println();
			if (g2.getVita()<=0) {System.out.println(g2.getNome()+" cade! "+g1.getNome()+" vince!"); break;}
			
			
			//		pg2 attacca
			System.out.println(g2.attacco(g1));
			System.out.println(g1.getNome()+" e' a "+g1.getVita()+" punti vita");
			System.out.println();
			if (g1.getVita()<=0) {System.out.println(g1.getNome()+" cade! "+g2.getNome()+" vince!"); break;}
			
		}
		
	}

}
