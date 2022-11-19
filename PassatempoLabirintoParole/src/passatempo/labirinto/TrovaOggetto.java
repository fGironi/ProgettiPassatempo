package passatempo.labirinto;

import java.util.Random;

public class TrovaOggetto implements Evento {

	private String nomeEvento="un oggetto nascosto";
	
	@Override
	public void indaga(Giocatore g, Stanza s) {
		Random rnd=new Random();
		
		Integer rndOgg=rnd.nextInt(5);
		Oggetto ogg=null;
		if (rndOgg<3) {
			if (rndOgg==0||rndOgg==1) { 
				ogg=new Pozione();
			}
	
			if (rndOgg==2) { 
				ogg=new Spada();
			}
			System.out.println("Hai trovato: "+ogg.getNome()+". Riponi l'oggetto nel tuo zaino.");
			g.prendiOggetto(ogg);
		}
		
		
		else {
			System.out.println("hai trovato un tesoro! Quando uscirai da qui sarai ricco!");
			g.setTesori(g.getTesori()+1);
		}
		
		s.setEventoAttivato(true);
	
	
	}

	public String getNomeEvento() {
		return nomeEvento;
	}

	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}



}
