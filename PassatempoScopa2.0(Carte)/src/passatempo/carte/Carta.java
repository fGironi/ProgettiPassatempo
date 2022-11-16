package passatempo.carte;

public class Carta {

	private Integer valore;
	private SemeCarte seme;
	
	public Integer getValore() {
		return valore;
	}
	public void setValore(Integer valore) {
		this.valore = valore;
	}
	public SemeCarte getSeme() {
		return seme;
	}
	public void setSeme(SemeCarte seme) {
		this.seme = seme;
	}
	@Override
	public String toString() {
		return valore+" di "+seme;
	}

	
	
}
