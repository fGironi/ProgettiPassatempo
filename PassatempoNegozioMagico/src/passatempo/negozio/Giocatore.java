package passatempo.negozio;

import java.util.HashMap;
import java.util.Random;

public class Giocatore {

	private Integer stress;
	private HashMap <String, Magia> magieConosciute;
	
	public Giocatore() {
		super();
		this.stress=0;
		this.magieConosciute=new HashMap<String, Magia>();
		Magia m1=new Magia("caldo", 1, 0, 0); magieConosciute.put(m1.getNome(), m1);
		Magia m2=new Magia("freddo", -1, 0, 0); magieConosciute.put(m2.getNome(), m2);
		Magia m3=new Magia("cura", 0, 1, 0); magieConosciute.put(m3.getNome(), m3);
		Magia m4=new Magia("solido", 0, 0, 1); magieConosciute.put(m4.getNome(), m4);
		Magia m5=new Magia("mollo", 0, 0, -1); magieConosciute.put(m5.getNome(), m5);
	}

	public void imparaMagia(LibroMagie lm) {
		Random rnd=new Random();
		Magia nm;
		String nomernd=lm.getMagieContenute().get(rnd.nextInt(lm.getMagieContenute().size()));
		System.out.println("Consulti il tuo librone e impari "+nomernd);
		nm=lm.getMagieEsistenti().get(nomernd);
		lm.getMagieContenute().remove(nomernd);
		this.magieConosciute.put(nm.getNome(), nm);
	}
	
	
	
	
	public HashMap<String, Magia> getMagieConosciute() {
		return magieConosciute;
	}

	public void setMagieConosciute(HashMap<String, Magia> magieConosciute) {
		this.magieConosciute = magieConosciute;
	}

	public Integer getStress() {
		return stress;
	}

	public void setStress(Integer stress) {
		this.stress = stress;
	}
	
	
}
