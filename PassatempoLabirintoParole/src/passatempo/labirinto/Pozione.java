package passatempo.labirinto;

public class Pozione extends Oggetto {

	private String nome="pozione";
	
	@Override
	public void effetto(Giocatore g, Stanza s) {
		if (g.getVita()==g.getMaxVita()) System.out.println("Sei al massimo della vita, bere la pozione non ti aiuterebbe");
		else{
			g.setVita(g.getVita()+1);
			System.out.println("Bevi la pozione. La tua vita aumenta di 1! (vite"+g.getVita()+")");
			g.getZaino().remove(this.nome);
			super.effetto(g, s);
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	
}
