package passatempo.labirinto;

import java.util.Random;

public class Oggetto implements Evento {

	@Override
	public void indaga(Giocatore g, Stanza s) {
		Random rnd=new Random();
		Integer rndOgg=rnd.nextInt(2);
		
		if (rndOgg==0) { 
			g.setVita(g.getVita()+1);
			System.out.println("hai trovato una pozione! La tua vita aumenta di 1! (vite"+g.getVita()+")");
			s.setEventoAttivato(true);
			
		}
		if (rndOgg==1) {
			System.out.println("hai trovato un tesoro! Quando uscirai da qui sarai ricco!");
			g.setTesori(g.getTesori()+1);
			s.setEventoAttivato(true);
		}
//		if (rndOgg==2) { 
//			System.out.println("hai trovato una spada!");
//			if (g.getHaSpada()==true) {
//				System.out.println("ma ne hai gia' una, quindi la lasci lì");
//				s.setEventoAttivato(false);
//			}
//			g.setHaSpada(true);
//			s.setEventoAttivato(true);
//			
//		}
		

	}

}
