//TODO 	trasformare arraylist famiglie e spese in hashmap
//TODO	creare un sistema di ricerca che dal nome della famiglia o dal numero 
//		dell'appartamento restituisca le informazioni relative

package passatempo.condominio;

import java.util.*;

public class Condominio {

	private Integer numAppartamenti;
	
	private HashMap<String, Famiglia> listaFamiglie;
	private HashMap<String, Spesa> listaSpese;
	private ArrayList<Appartamento> listaAppartamenti;
	
	
	public Condominio(Integer numAppartamenti) {
		super();
		this.numAppartamenti = numAppartamenti;
		this.listaAppartamenti=new ArrayList<Appartamento>();
		for (int i=1; i<=this.numAppartamenti; i++) {
			//System.out.println("test crea appartamento");
			Appartamento appart=new Appartamento();
			appart.setInterno(i);
			listaAppartamenti.add(appart);
		}
		this.listaFamiglie=new HashMap<String, Famiglia>();
		this.listaSpese=new HashMap<String, Spesa>();
		//this.listaFamiglie.keySet();
		
	}

	
	public HashMap<String, Famiglia> getListaFamiglie() {
		return listaFamiglie;
	}

	public void setListaFamiglie(HashMap<String, Famiglia> listaFamiglie) {
		this.listaFamiglie = listaFamiglie;
	}

	public HashMap<String, Spesa> getListaSpese() {
		return listaSpese;
	}
	public void setListaSpese(HashMap<String, Spesa> listaSpese) {
		this.listaSpese = listaSpese;
	}
	public ArrayList<Appartamento> getListaAppartamenti() {
		return listaAppartamenti;
	}
	public void setListaAppartamenti(ArrayList<Appartamento> listaAppartamenti) {
		this.listaAppartamenti = listaAppartamenti;
	}
	public Integer getNumAppartamenti() {
		return numAppartamenti;
	}
	public void setNumAppartamenti(Integer numAppartamenti) {
		this.numAppartamenti = numAppartamenti;
	}
	
	public void abitaIniziale(Scanner userInput) {
		for(Appartamento appart:this.listaAppartamenti) {
			while (appart.getOccupato()==null) {
				String occ;
				System.out.println("l'appartamento "+appart.getInterno()+" e' occupato? "
					+ "(scrivi 'y'/'yes'/'s'/'si' per dire sì, 'n'/'no' per dire no");
				occ=userInput.nextLine().toLowerCase();			
				if (occ.equals("no")||occ.equals("n")) { 
					appart.setOccupato(false);
					System.out.println("l'appartamento e' stato segnato come libero");
				}
				else if (occ.equals("si") || occ.equals("s") || occ.equals("yes") || occ.equals("y")) {
					appart.setOccupato(true);
					System.out.println("l'appartamento e' stato segnato come occupato");
					System.out.println("Inserire il cognome della famiglia che abita questo appartamento:");
					String f=userInput.nextLine();
					Famiglia fam=new Famiglia();
					fam.setNomeFamiglia(f);
					fam.setAppartementoAbitato(appart);
					appart.setFamigliaAbitante(fam);
					this.listaFamiglie.put(f, fam);
				}
				else {System.out.println("comando non riconosciuto");}
			}
					
		}
		
		//testing area:
		System.out.println();
		for (Appartamento appart:this.listaAppartamenti) {
		System.out.println("interno "+appart.getInterno());
		System.out.println(" occupato: "+appart.getOccupato());
		if (appart.getOccupato()) {System.out.println(" famiglia: "+appart.getFamigliaAbitante().getNomeFamiglia());}
		}	

	}
	
	public void getInfo(Scanner userInput) {
		System.out.println("Inserisci il nome di una famiglia");
		String fam=userInput.nextLine();
		if (this.listaFamiglie.containsKey(fam)) {
			System.out.println(this.listaFamiglie.get(fam).getNomeFamiglia());
			System.out.println("Appartamento:"+this.listaFamiglie.get(fam).getAppartementoAbitato().getInterno());
			System.out.println("Pagamenti in regola: "+this.getListaFamiglie().get(fam).getPagamentiInRegola());
						
		}
		else System.out.println("famiglia non trovata");
	}
	
	public void getDatiPaga(Scanner userInput) {
		System.out.println("scrivi il codice della spesa condominiale per cui si effettua il pagamento");
		String selSpesa=userInput.nextLine();
		System.out.println("scrivi il nome della famiglia che sta effettuando il pagamento");
		String selFam=userInput.nextLine();
		this.listaFamiglie.get(selFam).paga(this.listaSpese.get(selSpesa).getQuoteFamiglie().get(selFam), userInput);
	}
}
	
