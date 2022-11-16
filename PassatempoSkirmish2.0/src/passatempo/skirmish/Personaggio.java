package passatempo.skirmish;

import java.util.Random;

public class Personaggio {

	private String nome;
	private Integer puntiVita;
	private Integer armatura;
	private Integer agilità;
	private Integer forza;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPuntiVita() {
		return puntiVita;
	}
	public void setPuntiVita(Integer puntiVita) {
		this.puntiVita = puntiVita;
	}
	public Integer getArmatura() {
		return armatura;
	}
	public void setArmatura(Integer armatura) {
		this.armatura = armatura;
	}
	public Integer getAgilità() {
		return agilità;
	}
	public void setAgilità(Integer agilità) {
		this.agilità = agilità;
	}
	public Integer getForza() {
		return forza;
	}
	public void setForza(Integer forza) {
		this.forza = forza;
	}
	
	public void attacca(Personaggio p) {
		Random rnd=new Random();
		if (rnd.nextInt(0, 100)<p.getAgilità()) {
			System.out.println("l'attacco di "+this.getNome()+" su "+p.getNome()+" fallisce");
			p.schivaPara(this);
		}
		else this.colpisci(p);
		
	}
	
	public void colpisci(Personaggio p) {
		
	}
	
	public void schivaPara(Personaggio p) {
		
	}
	
}
