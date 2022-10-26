package pg.skirmish.charas;

public abstract class Barbaro extends Personaggio {

	private int maxPF;
	private boolean RageAtt;
	
	public int getMaxPF() {
		return maxPF;
	}
	public void setMaxPF(int maxPF) {
		this.maxPF = maxPF;
	}
	public boolean isRageAtt() {
		return RageAtt;
	}
	public void setRageAtt(boolean rageAtt) {
		RageAtt = rageAtt;
	}
	
	public void setupRage() {
	this.setMaxPF(this.getVita());
	this.setRageAtt(false);
	System.out.println(this.getNome()+" MaxPF= "+this.getMaxPF()+", rage= "+this.isRageAtt());
	}
	
	public void rage() {
		if (this.isRageAtt()==false) {			
			if (this.getVita()<(this.getMaxPF()/2)) {
			this.setForza(getForza()+2);
			System.out.println("RAGE attiva, forza="+this.getForza());
			this.setRageAtt(true);
			}
		}
	}
	
	@Override
	public void abilita() {
		this.setupRage();
	}
	
	@Override
	public void abilCombat(Personaggio bersaglio) {
		this.rage();
	}
	
}

	

