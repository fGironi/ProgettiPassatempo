package passatempo.labirinto;
//																GIOCO LABIRINTO
import java.awt.Point;
import java.util.Scanner;


//TODO: piccola cattiveria extra, impostare che se la stanza ha un mostro entrarci vuol dire combatterci
//TODO: stanzachiusa, una meccanica per cui il giocatore deve fare per forza x prima di uscire dalla stanza
//TODO: le descrizioni devono aver senso per la stanza e devono essere uniche

public class Main {

	public static void main(String[] args) {
		
		Generatore g=new Generatore();
		Scanner scan=new Scanner(System.in);
		
		
		System.out.println("Ti trovi in un labirinto, puoi scrivere una direzione indicata dalla lista per andare nella stanza successiva o scrivere \"indaga\" per esplorare quella attuale");
		System.out.println("Scrivi \"usa\" per usare gli oggetti nel tuo zaino. Inizi con 3 vite, le trappole ti levano vita, le pozioni la aumentano");
		System.out.println("premi invio per cominciare a giocare");
		scan.nextLine();	
		
		Boolean gioca=true;
		while (gioca==true) {
			Labirinto lab=new Labirinto();
			Integer difficolta=0;
			Point start=new Point(0,0);
			Giocatore player=new Giocatore(start);
			g.setPosizioni(g.impostaPosizioni(8+difficolta));
			g.creaStanze(lab, 10+difficolta);
			player.setPosizione(start);
			Boolean partita=true;
			while (partita==true) {
			
				for (Point p: lab.getMappaLab().keySet()) {
					if (player.getPosizione().distance(p)==0) {
						System.out.println(lab.getMappaLab().get(p));
						System.out.println(lab.getMappaLab().get(p).getDescrizione());
						System.out.println("Ci sono "+lab.getMappaLab().get(p).getnPorte()+" uscite");
						for (String dir:lab.getMappaLab().get(p).getStanzeVicine().keySet()) {
							System.out.println(dir);
						}
						String input=scan.nextLine().toLowerCase();
						Boolean scelta=false;
						while (scelta==false) {
							
							if (input.equals("quit")) {
								System.out.println("Esclami \"NON NE POSSO PIU'\" e abbandoni questo mondo");
								scelta=true; gioca=false; partita =false; break; 
							}
							else if (input.equals("usa")){
								if (player.getZaino().size()==0) System.out.println("Guardi dentro al tuo zaino. E' vuoto.");
								else {	System.out.println("Guardi dentro al tuo zaino (scrivi cosa vuoi usare o \"nulla\" per smettere di guardare)");
										for (String s:player.getZaino().keySet()) {
											System.out.println(s);
										}
										Boolean guardaZaino=true;
										while (guardaZaino==true) {
											input=scan.nextLine().toLowerCase();
											if (input.equals("nulla")) guardaZaino=false;
											else if (player.getZaino().containsKey(input)) {
												player.getZaino().get(input).effetto(player, lab.getMappaLab().get(p));
												guardaZaino=false;
											}
											else System.out.println("non hai questo oggetto");
										}
								}
								input=scan.nextLine().toLowerCase();
								
							}
							
							else if (input.equals("indaga")){
								System.out.println("indaghi nella stanza");
								if (lab.getMappaLab().get(p).getEventoAttivato()==false) lab.getMappaLab().get(p).getEvento().indaga(player, lab.getMappaLab().get(p));
								else System.out.println("hai gia' indagato in questa stanza, non c'e' nulla di nuovo");
								System.out.println();
								input=scan.nextLine().toLowerCase();
							}
							else if (lab.getMappaLab().get(p).getStanzeVicine().containsKey(input)) {
								scelta=true;
								player.muovi(lab.getMappaLab().get(p).getStanzeVicine().get(input).getPosizione());
							}
							else if (player.getVita()==0) {
								System.out.println("l'oscurita cala su di te");
								scelta=true;
							}
							else if (player.getVinto()==true) {
								System.out.println("e ti ritrovi in un altro, piu' grande, labirinto");
								scelta=true;
							}
							else {
									System.out.println("non e' chiaro cosa tu voglia fare");
									input=scan.nextLine().toLowerCase();
								}
												
							}
					
					}
					
				}
				if (player.getVinto()==true) {
					System.out.println("complimenti! hai recuperato "+player.getTesori()+" tesori!" );
					difficolta=+1;
					lab=new Labirinto();
					start=new Point(0,0);
					player.setHaChiave(false);
					player.setVinto(false);
					g.setPosizioni(g.impostaPosizioni(8+difficolta));
					g.creaStanze(lab, 10+difficolta);
					player.setPosizione(start);
					
					
				}
				if (player.getVita()==0) {
					System.out.println("fine vite, game over");
					partita=false;
					System.out.println("vuoi riprovare?(y/n)");
					String ng=scan.nextLine();
					if (ng.equals("n")) gioca=false;
					if (ng.equals("y")) System.out.println("si ricomincia");
				}
			}
		}
		scan.close();
	}
}
