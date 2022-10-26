package passatempo.magia;

import java.util.ArrayList;

public class CreaMagie {

	private ArrayList<Magia> listaMagie=new ArrayList<Magia>();
	
	public ArrayList<Magia> getListaMagie() {
		return listaMagie;
	}

	public void setListaMagie(ArrayList<Magia> listaMagie) {
		this.listaMagie = listaMagie;
	}

	public Magia creaMagia (String nomeMagia, String tipoMagia, String descrizione) {
		switch (tipoMagia) {
		case "Incantesimo":
			Magia mI=new Incantesimo(nomeMagia);
			mI.setDescrizione(descrizione);
			System.out.println("creato l'incantesimo "+mI.getNome());
			return mI;
		case "Stregoneria":
			Magia mS=new Stregoneria(nomeMagia);
			mS.setDescrizione(descrizione);
			System.out.println("creato l'incantesimo "+mS.getNome());
			return mS;
		case "Evocazione":
			Magia mE=new Evocazione(nomeMagia);
			mE.setDescrizione(descrizione);
			System.out.println("creato l'incantesimo "+mE.getNome());
			return mE;
		default:
			System.out.println("tipo non riconosciuto");
			return null;
		}
	}
	
	public void CreaListaMagie() {
		Magia luce=this.creaMagia("Luce", "Incantesimo", "Illumina la stanza");
			luce.setDurata("un'ora");
			this.getListaMagie().add(luce);
	}
		
		
	
	
	
}
