package passatempo.condominio;
import java.util.*;

public class Menu {

	public void start(Scanner userInput) { 		
		String start="attesa start";
		while (start.equals("start")==false) {
			System.out.println("benvenuto in un programma incompleto e attualmente inutile.");
			System.out.println("Scrivi 'start' se vuoi iniziare a creare un condominio o scrivi qualsiasi altra cosa se vuoi leggere di nuovo questo messaggio");
			start=userInput.nextLine();
			if (start.equals("start")==false) System.out.println("davvero? ... ok");
			System.out.println();
		}
	}
	public Integer interniCondominio(Scanner userInput) {
		System.out.println("inizio la creazione del condominio. quanti appartamenti devo inizializzare?");	
		Integer userInterni=userInput.nextInt();
		System.out.println();
		while (userInterni==0) {
			System.out.println("un condominio non può avere zero appartamenti, per favore inserisci un altro numero");
			userInterni=userInput.nextInt();
		}
		System.out.println("creo "+userInterni+" interni");
		System.out.println();
		Integer interniCondominio=userInterni;
		return interniCondominio;
	}

	public String selezioneUtente(Scanner userInput) {
		System.out.println("------------");
		System.out.println("cosa ti serve? Scrivi:");
		System.out.println("'info': per avere informazioni sulle famiglie");
		System.out.println("'spesa': per aggiungere una spesa condominiale");
		System.out.println("'paga' per registrare il pagamento di una spesa");
		System.out.println("'statopagamenti' per la lista e lo stato delle spese condominiali");
		String input=userInput.nextLine();
		return input;
	}
}
