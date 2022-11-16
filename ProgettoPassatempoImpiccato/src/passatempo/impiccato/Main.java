package passatempo.impiccato;
import java.io.IOException;
import java.util.Scanner;
//TODO longterm: trasformare le lettere in oggetti, evitare che la ripetizione di un errore tolga vite 
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner userInput=new Scanner(System.in);
		

		
		System.out.println("Semplice partita ad impiccato, indovina la parola segreta una lettera per volta!");
		System.out.println("il giocatore ha 7 vite e ne perde una ogni volta che tenta una lettera che non e' nella parola");
		System.out.println("(Se vuoi provare ad indovinare la parola segreta per intero puoi scriverla preceduta da un '+'");
		System.out.println("ad esempio scrivendo '+parola')");
		System.out.println();
		Integer record=0;
		
		
		boolean partita=true;	
		while (partita==true) {
			Utente user=new Utente(7);
			Parola parola=new Parola();
			System.out.println("scegli la modalità a cui giocare! scrivi \"harry\" per indovinare un personaggio di HP o \"parola\" per indovinare una parola casuale");
			String modalita=userInput.nextLine();
			if (modalita.equals("harry")){
				parola.creaHarryPotter();
			}
			if (modalita.equals("capitale")){
				parola.creaCapitale();
			}
			
			if (modalita.equals("parola")) {
				parola.creaParola();	
				
			}
			parola.scegliParola();
			System.out.println("la parola segreta e' di "+parola.getParolaScelta().length()+" lettere");
			System.out.println();
						
			while(user.isGioca()) {
				parola.mostraParola(user);
				parola.indovina(userInput, user);
				System.out.println();
				
			}
		
			System.out.println();
			if (user.getVite()>record) {
				System.out.println("nuovo record!"); 
				record=user.getVite();
			}
			System.out.println("record attuale: "+record+" vite rimaste");
			System.out.println("Vuoi giocare ancora? scrivi qualsiasi cosa per un'altra partita, "
					+ "altrimenti scrivi 'quit' per uscire");
			String quit=userInput.nextLine().toLowerCase();
			if (quit.equals("quit")) {
				partita=false;
				System.out.println("Ciao! A presto!");
				userInput.close();
			}
			else { 
				user.setGioca(true);
				parola.getLettereTentate().clear();
				System.out.println("-----------------------");
			}
						
		}
	}

}
