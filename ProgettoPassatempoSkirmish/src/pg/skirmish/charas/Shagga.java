package pg.skirmish.charas;
import java.util.*;

public class Shagga extends Barbaro{
	
	
	
	public Shagga () {
	this.setNome("Shagga");
	Random rndVS= new Random();
	this.setVita(rndVS.nextInt(50-35)+35);
	Random rndFS= new Random();
	this.setForza(rndFS.nextInt(6-2)+2);
	this.setVelocita(rndFS.nextInt(5-2)+2);
	this.setImprecisione(6);
	this.abilita();
	}
	
	
	@Override
	public String attacco(Personaggio bersaglio) {
		this.abilCombat(bersaglio);
		int dmg=this.danno();
		Random rnd2= new Random();
		switch (rnd2.nextInt(this.getImprecisione())) {
			case 0: 
				bersaglio.setVita(bersaglio.getVita()-dmg);
				return this.getNome()+" attacca "+bersaglio.getNome()+" con l'ascia ed infligge "+dmg+" danni!";
			case 1: 
				bersaglio.setVita(bersaglio.getVita()-1);
				System.out.println(this.getNome()+" colpisce "+bersaglio.getNome()+" con una testata infliggendo 1 danno e la stordisce per poi attaccare di nuovo!"); this.attacco(bersaglio);
			case 2: 
				bersaglio.setVita(bersaglio.getVita()-(dmg/2));
				bersaglio.setForza(bersaglio.getForza()-1);
				return this.getNome()+" schianta "+bersaglio.getNome()+" al suolo con una presa ed infligge "+(dmg/2)+" danni, la forza di "+bersaglio.getNome()+" e' ridotta di 1!";
			default: 
				return this.getNome()+" attacca "+bersaglio.getNome()+" ma il colpo viene schivato!";
		}
	}


	@Override
	public int danno() {
		Random rnd= new Random();
		int a= rnd.nextInt((12+this.getForza())-(1+this.getForza()))+(1+this.getForza());
		return a;
	}

}
