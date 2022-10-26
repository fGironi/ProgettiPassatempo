package passatempo.magia;

public class Incantesimo extends Magia {

	public Incantesimo(String nome) {
		super(nome);
		this.setDurata("eterno");
	}

	@Override
	public String effettoMagia(Object bersaglio) {
		return this.getDescrizione();
	}

	@Override
	public int consumoMana() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
