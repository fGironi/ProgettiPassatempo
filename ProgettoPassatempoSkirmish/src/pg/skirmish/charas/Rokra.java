package pg.skirmish.charas;
import java.util.*;

public class Rokra extends Personaggio {
		
	int exec=0;
	
	public Rokra () {
		this.setNome("Rokra");
		Random rndVR= new Random();
		this.setVita(rndVR.nextInt(80-55)+55);
		Random rndFR= new Random();
		this.setForza(rndFR.nextInt(5-1)+1);
		this.setVelocita(rndFR.nextInt(3-1)+1);
		this.setImprecisione(4);
		this.abilita();
		}
	
	
	@Override
	public int danno() {
		Random rnd= new Random();
		int a= rnd.nextInt((8+this.getForza())-(1+this.getForza()))+(1+this.getForza());
		return a;
	}

	@Override
	public void abilita() {
		
	}


	@Override
	public void abilCombat(Personaggio bersaglio) {

		if (bersaglio.getVita()<20 && exec==0) {
			exec=2;
			this.setForza(getForza()+2);
			System.out.println(this.getNome()+" si carica di energia divina per finire lo scontro exec:"+exec);
		}
		else if (bersaglio.getVita()<20 && exec>=1) {exec--; System.out.println("exec:"+exec);}
		else {System.out.println("exec:"+exec);}
		
	}

	
	@Override
	public String attacco(Personaggio bersaglio) {
		int dmg=this.danno();
		this.abilCombat(bersaglio);
		Random rnd2= new Random();
		switch (rnd2.nextInt(this.getImprecisione())) {
			case 0: 
				bersaglio.setVita(bersaglio.getVita()-dmg);
				return this.getNome()+" attacca "+bersaglio.getNome()+" con il martello ed infligge "+dmg+" danni!";
				
			case 1: 
				this.setVita(this.getVita()+dmg);
				return this.getNome()+" usa una magia curativa e recupera "+dmg+" punti vita! Ora e' a "+this.getVita()+" punti vita";
			case 2: 
				this.setForza(getForza()+1);
				bersaglio.setVita(bersaglio.getVita()-(dmg/2));
				return this.getNome()+" lancia un urlo verso "+bersaglio.getNome()+" infliggendo "+(dmg/2)+" danni e aumentando la sua forza!";
			default:
				return this.getNome()+" manca "+bersaglio.getNome();
				
		}
		
	}


}
