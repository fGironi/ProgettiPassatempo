package passatempo.negozio;

public class Magia {

	private String nome;
	private Integer calore;
	private Integer salute;
	private Integer solido;
	
	
	
	
	public Magia(String nome, Integer calore, Integer salute, Integer solido) {
		super();
		this.nome = nome;
		this.calore = calore;
		this.salute = salute;
		this.solido = solido;
	}


	public void effetto (Richiesta r) {
		r.setSolidita(r.getSolidita()+this.solido);
		r.setTemperatura(r.getTemperatura()+this.calore);
		r.setVeleno(r.getVeleno()+this.salute);
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Integer getCalore() {
		return calore;
	}


	public void setCalore(Integer calore) {
		this.calore = calore;
	}


	public Integer getSalute() {
		return salute;
	}


	public void setSalute(Integer salute) {
		this.salute = salute;
	}


	public Integer getSolido() {
		return solido;
	}


	public void setSolido(Integer solido) {
		this.solido = solido;
	}
	
	

}
