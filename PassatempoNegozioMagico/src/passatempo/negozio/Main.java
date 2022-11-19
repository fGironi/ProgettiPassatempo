package passatempo.negozio;

//import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Giocatore player=new Giocatore();
		LibroMagie libro=new LibroMagie();
		Negozio neg=new Negozio();
		Scanner scan=new Scanner(System.in);
		Integer difficolta=0;
		System.out.println("Sei un mago che ha aperto un negozio di servizi arcani in un piccolo paese, riuscirai a tenere a bada tutti i clienti?");
		System.out.println("scrivi \"impara\" per dedicarti allo studio e imparare una nuova magia dal tuo librone");
		System.out.println("scrivi \"magia\" per usare una magia per uno dei tuoi clienti, ma attenzione, ogni azione ti porterà via un'ora e alle 20 si chiude");
		System.out.println();
		scan.nextLine();
		Boolean staGiocando=true;
				
		while (staGiocando==true) {
			Integer tempo=0;
			neg.setGiorniAttivita(neg.getGiorniAttivita()+1);
			System.out.println("Giorno "+neg.getGiorniAttivita()+":");		
			System.out.println();
			while(tempo<12) {
				Boolean scelta=false;
				while (scelta==false) {
					System.out.println("Sono le "+(8+tempo));
					if (tempo==(neg.getClienti().size()*(4-difficolta))) {
						Cliente c=new Cliente(neg.getClienti().size()+1);
						neg.getClienti().put(c.getId().toString(), c);
						System.out.println("un cliente entra in negozio ed esclama: \"ho "+c.getRichiesta().getDescrizione()+" aiutami!\"");
						System.out.println();
					}
					for (Cliente c:neg.getClienti().values()) {
					if (c.getSoddisfatto()==null) System.out.println(c.getNome()+" ha "+c.getRichiesta().getDescrizione()+" cosa vuoi fare?");
					}
					String input=scan.nextLine();
					if (input.equals("impara")) {
						player.imparaMagia(libro);
						scelta=true;
					}
					else if (input.equals("magia")) {
						System.out.println("queste sono le magie che conosci:");
						for (String s:player.getMagieConosciute().keySet()) {
							System.out.println(s);
						}
						System.out.println("quale magia vuoi usare?");
						Boolean magiaScelta=false;
						while (magiaScelta==false) {
							input=scan.nextLine();
							if (player.getMagieConosciute().containsKey(input)) {
								Magia mUsata=player.getMagieConosciute().get(input);
								System.out.println("quale cliente vuoi aiutare?");
								for (Cliente c:neg.getClienti().values()) {
									if (c.getSoddisfatto()==null) System.out.println(c.getId()+" per aiutare "+c.getNome());
								}
								Boolean aiutaC=false;
								input=scan.nextLine();
								while (aiutaC==false) {
									if (neg.getClienti().containsKey(input)) {
										Cliente clienteAiutato=neg.getClienti().get(input);	
										mUsata.effetto(clienteAiutato.getRichiesta());
										clienteAiutato.getRichiesta().creaDescrizione();
										scelta=true;
										magiaScelta=true;
										aiutaC=true;
									}
									else System.out.println("non so che cliente vuoi aiutare");
								}
							}
							else System.out.println("non conosci questa magia");
						}
					}
					else System.out.println("non e' chiaro cosa tu voglia fare");
					System.out.println();
					
					
					for (Cliente c:neg.getClienti().values()) {
						if (c.getPazienza()>(12-tempo)) c.setPazienza((12-tempo));
						if (c.getRichiesta().getTemperatura()==0 && c.getRichiesta().getVeleno()>=0 && c.getRichiesta().getSolidita()==0) {
							c.getRichiesta().setRisolto(true);
							if (c.getSoddisfatto()==null) System.out.println(c.getNome()+" è contento e ti ringrazia");
							c.setSoddisfatto(true);
							if (player.getStress()>0) player.setStress(player.getStress()-1);
						}
						else c.setPazienza(c.getPazienza()-1);
						
						if (c.getSoddisfatto()==null && c.getPazienza()==0) {
							c.setSoddisfatto(false);
							System.out.println(c.getNome()+" se ne va scocciato");
							player.setStress(player.getStress()+1);
						}
						
					}
					if (player.getStress()==3) {
						System.out.print(" e neanche te ne puoi piu'");
						System.out.println("molli tutto e chiudi per sempre");
						staGiocando=false;
					}
					tempo++;
				}
			}
			neg.getClienti().clear();
			if (neg.getGiorniAttivita()%3==0 &&difficolta<4) difficolta++;
	
			
		}
		System.out.println("GAME OVER");
		scan.close();
	}
}
