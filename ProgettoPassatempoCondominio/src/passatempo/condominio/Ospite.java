package passatempo.condominio;

public class Ospite{

	private String inizioOspitalita;
	private String idDocumento;
	private Condomino garante;
	public String getInizioOspitalita() {
		return inizioOspitalita;
	}
	public void setInizioOspitalita(String inizioOspitalita) {
		this.inizioOspitalita = inizioOspitalita;
	}
	public String getIdDocumento() {
		return idDocumento;
	}
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}
	public Condomino getGarante() {
		return garante;
	}
	public void setGarante(Condomino garante) {
		this.garante = garante;
	}
	
	
}
