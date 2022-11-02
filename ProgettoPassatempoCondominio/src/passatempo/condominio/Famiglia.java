package passatempo.condominio;

import java.math.BigDecimal;
import java.util.*;

public class Famiglia {

	private HashMap<String, Persona> membri;
	private String nomeFamiglia;
	private Appartamento appartementoAbitato;
	private HashMap<String, Pagamento> listaPagamenti;
	private BigDecimal quotaPagamento;
	private Boolean pagamentiInRegola;
	
	public HashMap<String, Persona>  getMembri() {
		return membri;
	}
	public void setMembri(HashMap<String, Persona>  membri) {
		this.membri = membri;
	}
	public HashMap<String, Pagamento> getListaPagamenti() {
		return listaPagamenti;
	}
	public void setListaPagamenti(HashMap<String, Pagamento> listaPagamenti) {
		this.listaPagamenti = listaPagamenti;
	}
	public BigDecimal getQuotaPagamento() {
		return quotaPagamento;
	}
	public void setQuotaPagamento(BigDecimal quotaPagamento) {
		this.quotaPagamento = quotaPagamento;
	}
	public String getNomeFamiglia() {
		return nomeFamiglia;
	}
	public void setNomeFamiglia(String nomeFamiglia) {
		this.nomeFamiglia = nomeFamiglia;
	}
		
	public Appartamento getAppartementoAbitato() {
		return appartementoAbitato;
	}
	public void setAppartementoAbitato(Appartamento appartementoAbitato) {
		this.appartementoAbitato = appartementoAbitato;
	}
	public Boolean getPagamentiInRegola() {
		return pagamentiInRegola;
	}
	public void setPagamentiInRegola(Boolean pagamentiInRegola) {
		this.pagamentiInRegola = pagamentiInRegola;
	}

	public void paga(Pagamento pag, Scanner userInput) {
		
		if (pag.getIsPagato()==true) { 
			System.out.println(pag.getPagante().getCognome()+" "+pag.getPagante().getNome()+" ha gia' effettuato il pagamento");
		}
		else {
			System.out.println("chi sta effettuando il pagamento?");
			//pag.setPagante(con);
			String pagante=userInput.nextLine();
			pag.setIsPagato(true);
			System.out.println("conferma pagamento da parte di "+pagante);
		}
	}


	
}
