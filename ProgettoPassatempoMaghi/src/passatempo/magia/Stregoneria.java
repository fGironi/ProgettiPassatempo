package passatempo.magia;

public class Stregoneria extends Magia {

	public Stregoneria(String nome) {
		super(nome);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String effettoMagia(Object o) {
		return this.getDescrizione();
	}

	@Override
	public int consumoMana() {
		// TODO Auto-generated method stub
		return 0;
	}

}
