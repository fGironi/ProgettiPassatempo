package passatempo.impiccato;

public class Utente {

	private int vite;
	private boolean gioca;
	private Integer tentativi;
	
	public Utente(int vite) {
		super();
		this.vite = vite;
		this.setGioca(true);
		this.tentativi=0;
	}

	public int getVite() {
		return vite;
	}

	public void setVite(int vite) {
		this.vite = vite;
	}

	public boolean isGioca() {
		return gioca;
	}

	public void setGioca(boolean gioca) {
		this.gioca = gioca;
	}

	public Integer getTentativi() {
		return tentativi;
	}

	public void setTentativi(Integer tentativi) {
		this.tentativi = tentativi;
	}

}
