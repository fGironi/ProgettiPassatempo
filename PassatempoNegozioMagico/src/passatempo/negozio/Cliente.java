package passatempo.negozio;

import java.util.Random;

import com.github.javafaker.Faker;

public class Cliente {

	private Integer id;
	private String nome;
	private Richiesta richiesta;
	private Integer pazienza;
	private Boolean soddisfatto;
	
	
	

	public Cliente(Integer id) {
		super();
		this.id = id;
		Faker f=new Faker();
		Random rnd=new Random();
		this.nome=f.name().firstName();
		this.richiesta=new Richiesta();
		this.pazienza=rnd.nextInt(4, 7);
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Richiesta getRichiesta() {
		return richiesta;
	}
	public void setRichiesta(Richiesta richiesta) {
		this.richiesta = richiesta;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getPazienza() {
		return pazienza;
	}
	public void setPazienza(Integer pazienza) {
		this.pazienza = pazienza;
	}
	public Boolean getSoddisfatto() {
		return soddisfatto;
	}
	public void setSoddisfatto(Boolean soddisfatto) {
		this.soddisfatto = soddisfatto;
	}
	
	
}
