package passatempo.labirinto;

import java.awt.Point;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Labirinto lab=new Labirinto();
		Generatore g=new Generatore();
		Scanner scan=new Scanner(System.in);
				
		g.setPosizioni(g.impostaPosizioni(8));
		g.creaStanze(lab, 10);
		Point start=new Point(0,0);
		Giocatore player=new Giocatore(start);
		Boolean gioca=true;
		
		
		System.out.println("Ti trovi in un labirinto, puoi scrivere una direzione indicata dalla lista per andare nella stanza successiva o scrivere \"indaga\" per esplorare quella attuale");
		System.out.println("Inizi con 3 vite, le trappole ti levano vita, le pozioni la aumentano");
		System.out.println("premi invio per cominciare a giocare");
		scan.nextLine();	
		while (gioca==true) {
		
			for (Point p: lab.getMappaLab().keySet()) {
				if (player.getPosizione().distance(p)==0) {
					System.out.println(lab.getMappaLab().get(p));
					System.out.println(lab.getMappaLab().get(p).getDescrizione());
					System.out.println("Ci sono "+lab.getMappaLab().get(p).getnPorte()+" uscite");
					for (String dir:lab.getMappaLab().get(p).getStanzeVicine().keySet()) {
						System.out.println(dir);
					}
					String input=scan.nextLine();
					if (input.equals("indaga")){
						System.out.println("indaghi nella stanza");
						if (lab.getMappaLab().get(p).getEventoAttivato()==false) lab.getMappaLab().get(p).getEvento().indaga(player, lab.getMappaLab().get(p));
						else System.out.println("hai gia' indagato in questa stanza, non c'e' nulla di nuovo");
						System.out.println();
						
					}
					
					else if (lab.getMappaLab().get(p).getStanzeVicine().containsKey(input)) {
						player.muovi(lab.getMappaLab().get(p).getStanzeVicine().get(input).getPosizione());
					}
					else {
						System.out.println("non c'e' un'uscita in quella direzione");
					}
				}
			}
			if (player.getVinto()==true) {
				System.out.println("complimenti! hai recuperato "+player.getTesori()+" tesori!" );
				gioca=false;
				
			}
			if (player.getVita()==0) {
				System.out.println("fine vite, game over");
				gioca=false;
			}
		}
		scan.close();
		
		
		
	}

}
