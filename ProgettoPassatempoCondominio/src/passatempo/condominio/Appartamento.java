package passatempo.condominio;

public class Appartamento {

	private Integer interno;
	private Famiglia famigliaAbitante;
	private Boolean occupato;
	private Integer metratura;
	
	public Integer getInterno() {
		return interno;
	}
	public void setInterno(Integer interno) {
		this.interno = interno;
	}
	public Famiglia getFamigliaAbitante() {
		return famigliaAbitante;
	}
	public void setFamigliaAbitante(Famiglia famigliaAbitante) {
		this.famigliaAbitante = famigliaAbitante;
	}
	public Boolean getOccupato() {
		return occupato;
	}
	public void setOccupato(Boolean occupato) {
		this.occupato = occupato;
	}
	public Integer getMetratura() {
		return metratura;
	}
	public void setMetratura(Integer metratura) {
		this.metratura = metratura;
	}
	
	
	
}
