package passatempo.condominio;

import java.math.BigDecimal;

public class Pagamento {

	private Condomino pagante;
	private String descrizione;
	private BigDecimal quota;
	private Boolean isPagato;
	
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public BigDecimal getQuota() {
		return quota;
	}
	public void setQuota(BigDecimal quota) {
		this.quota = quota;
	}
	public Condomino getPagante() {
		return pagante;
	}
	public void setPagante(Condomino pagante) {
		this.pagante = pagante;
	}
	public Boolean getIsPagato() {
		return isPagato;
	}
	public void setIsPagato(Boolean isPagato) {
		this.isPagato = isPagato;
	}

	
	
}
