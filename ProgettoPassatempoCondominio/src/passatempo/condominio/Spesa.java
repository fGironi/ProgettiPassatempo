package passatempo.condominio;
import java.math.BigDecimal;
import java.util.*;

public class Spesa {

	private BigDecimal importo;
	private String tipologia;
	private String descrizione;
	private String incaricato;
	private String recapito;
	private HashMap<String, Pagamento> quoteFamiglie;
	
	public BigDecimal getImporto() {
		return importo;
	}
	public void setImporto(BigDecimal importo) {
		this.importo = importo;
	}
	public String getTipologia() {
		return tipologia;
	}
	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getIncaricato() {
		return incaricato;
	}
	public void setIncaricato(String incaricato) {
		this.incaricato = incaricato;
	}
	public String getRecapito() {
		return recapito;
	}
	public void setRecapito(String recapito) {
		this.recapito = recapito;
	}
	public HashMap<String, Pagamento> getQuoteFamiglie() {
		return quoteFamiglie;
	}
	public void setQuoteFamiglie(HashMap<String, Pagamento> quoteFamiglie) {
		this.quoteFamiglie = quoteFamiglie;
	}
	
	
}
