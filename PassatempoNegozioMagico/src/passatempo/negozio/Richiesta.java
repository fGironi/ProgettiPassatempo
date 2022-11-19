package passatempo.negozio;

import java.util.Random;

public class Richiesta {

	private Integer id;
	private String descrizione;
	private Boolean risolto;
	private String soggetto;
	private Integer temperatura;
	private Integer veleno;
	private Integer solidita;
	
	
	
	public Richiesta() {
		super();
		Random rnd=new Random();
		this.risolto = false;
		Integer rndsog=rnd.nextInt(5);
		if (rndsog==0) this.soggetto = "il piede";
		if (rndsog==1) this.soggetto = "il gatto";
		if (rndsog==2) this.soggetto = "il braccio";
		if (rndsog==3) this.soggetto = "il cappello";
		if (rndsog==4) this.soggetto = "l'albero del vicino";
		Boolean problema=false;
		while (problema==false) {
			this.temperatura = rnd.nextInt(-2, 3);
			this.veleno = rnd.nextInt(-2, 3);
			this.solidita = rnd.nextInt(-2, 3);
			
			if (this.temperatura==0 && this.veleno>0 && this.solidita==0) problema=false;
			else problema=true;
		}
		this.creaDescrizione();

		
	}
	
	public void creaDescrizione() {
		String statoTemp;
		if (this.temperatura<-2) statoTemp=" incredibilmente congelato,";
		else if (this.temperatura==-2) statoTemp=" congelato,";
		else if (this.temperatura==-1) statoTemp=" freddo,";
		else if (this.temperatura==1) statoTemp=" caldo,";
		else if (this.temperatura==2) statoTemp=" infuocato,";
		else if (this.temperatura>2) statoTemp=" incredibilmente infuocato,";
		else statoTemp="";
		String statoSalute;
		if (this.veleno<-2) statoSalute=" incredibilmente avvelenato,";
		else if (this.veleno==-2) statoSalute=" gravemente avvelenato,";
		else if (this.veleno==-1) statoSalute=" avvelenato,";
		else statoSalute="";
		String statoSolido;
		if (this.solidita<-2) statoSolido=" liquefatto,";
		else if (this.solidita==-2) statoSolido=" liquefatto,";
		else if (this.solidita==-1) statoSolido=" mollo,";
		else if (this.solidita==1) statoSolido=" rigido,";
		else if (this.solidita==2) statoSolido=" pietrificato,";
		else if (this.solidita>2) statoSolido=" incrediblmente pietrificato,";
		else statoSolido="";
		
		this.descrizione=this.soggetto+statoTemp+statoSalute+statoSolido;
	}
	public String getSoggetto() {
		return soggetto;
	}
	public void setSoggetto(String soggetto) {
		this.soggetto = soggetto;
	}
	public Integer getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(Integer temperatura) {
		this.temperatura = temperatura;
	}
	public Integer getVeleno() {
		return veleno;
	}
	public void setVeleno(Integer veleno) {
		this.veleno = veleno;
	}
	public Integer getSolidita() {
		return solidita;
	}
	public void setSolidita(Integer solidita) {
		this.solidita = solidita;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Boolean getRisolto() {
		return risolto;
	}
	public void setRisolto(Boolean risolto) {
		this.risolto = risolto;
	}

	
	
}
