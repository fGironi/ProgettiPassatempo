package passatempo.negozio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class LibroMagie {

	private HashMap <String, Magia> magieEsistenti;
	private ArrayList <String> magieContenute;



	public HashMap<String, Magia> getMagieEsistenti() {
		return magieEsistenti;
	}



	public void setMagieEsistenti(HashMap<String, Magia> magieEsistenti) {
		this.magieEsistenti = magieEsistenti;
	}



	public ArrayList<String> getMagieContenute() {
		return magieContenute;
	}



	public void setMagieContenute(ArrayList<String> magieContenute) {
		this.magieContenute = magieContenute;
	}



	public LibroMagie() {
		super();
		this.magieEsistenti=new HashMap<String, Magia>(); 
		this.magieContenute=new ArrayList<String>();
		Random rnd=new Random();
				
		for (int i=0; i<100; i++) {
			Magia m=new Magia(null, rnd.nextInt(-2,3), rnd.nextInt(-2,3), rnd.nextInt(-2,3));
			
			String nomeGenerico=null;
				if ((m.getCalore()+m.getSalute()+m.getSolido())<-4) nomeGenerico="incanto";
				else if ((m.getCalore()+m.getSalute()+m.getSolido())<0) nomeGenerico="tocco";
				else if ((m.getCalore()+m.getSalute()+m.getSolido())==0) nomeGenerico="sussurro";
				else if ((m.getCalore()+m.getSalute()+m.getSolido())>0) nomeGenerico="soffio";
				else if ((m.getCalore()+m.getSalute()+m.getSolido())<4) nomeGenerico="portento";
				
			String nomeCalore;
				if (m.getCalore()==-2) nomeCalore=" gelido";
				else if (m.getCalore()==-1) nomeCalore=" freddo";
				else if (m.getCalore()==1) nomeCalore=" caldo";
				else if (m.getCalore()==2) nomeCalore=" infuocato";
				else nomeCalore="";
				
			String nomeCura;
				if (m.getSalute()==-2) nomeCura=" tossico";
				else if (m.getSalute()==-1) nomeCura=" velenoso";
				else if (m.getSalute()==1) nomeCura=" curativo";
				else if (m.getSalute()==2) nomeCura=" ristoratore";
				else nomeCura="";	
			String nomeSolido;
				if (m.getSolido()==-2) nomeSolido=" liquefante";
				else if (m.getSolido()==-1) nomeSolido=" sciogliente";
				else if (m.getSolido()==1) nomeSolido=" indurente";
				else if (m.getSolido()==2) nomeSolido=" pietrificante";
				else nomeSolido="";
				
			m.setNome(nomeGenerico+nomeCalore+nomeCura+nomeSolido);
			if (this.magieEsistenti.containsKey(m.getNome())) i--;
			else {
				this.magieEsistenti.put(m.getNome(), m);
				this.magieContenute.add(m.getNome());
			}
			
		}
		
		
	}

	
}
