package passatempo.cards;
import java.util.ArrayList;

public class Giocatore {
	
	private int id;
	private String nome;
	private Integer punti;
	private ArrayList<Carta> mano;
	private ArrayList<Carta> prese;
	private Integer scopeFatte;
	
	public Giocatore(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
		this.prese=new ArrayList<Carta>();
		this.setPunti(0);
		this.setScopeFatte(0);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public ArrayList<Carta> getMano() {
		return mano;
	}
	public void setMano(ArrayList<Carta> mano) {
		this.mano = mano;
	}
	
	public ArrayList<Carta> getPrese() {
		return prese;
	}
	public void setPrese(ArrayList<Carta> prese) {
		this.prese = prese;
	}
	public Integer getPunti() {
		return punti;
	}
	public void setPunti(Integer punti) {
		this.punti = punti;
	}
	public Integer getScopeFatte() {
		return scopeFatte;
	}
	public void setScopeFatte(Integer scopeFatte) {
		this.scopeFatte = scopeFatte;
	}
	
	
	public ArrayList<Carta> PescaIniziale(ArrayList<Carta> mazzo) {
		this.mano = new ArrayList<Carta>();
		for (int i=0; i<3; i++) {
			Carta c= new Carta();
			c= mazzo.get(0);
			this.mano.add(c);
			//System.out.println("pescato"+c.getValore()+c.getSeme());
			mazzo.remove(0);
			}
		System.out.println(this.getNome()+" pesca 3 carte");
		return mazzo;
		
	}
	
	public void Gioca(ArrayList<Carta> mano, ArrayList<Carta> cartePerTerra, Partita partita) {
		this.getMano().get(0);
		System.out.println(this.getNome()+" gioca "+this.getMano().get(0).getValore()+" di "+this.getMano().get(0).getSeme());
		boolean presaFatta=false;
		for (Carta c:cartePerTerra) {
			if (this.getMano().get(0).getValore()==c.getValore()) {
				System.out.println(this.getNome()+" prende "+c.getValore()+" di "+c.getSeme()+" da terra");
				this.getPrese().add(c);
				this.getPrese().add(this.getMano().get(0));
				this.getMano().remove(0);
				cartePerTerra.remove(c);
				presaFatta=true;
				partita.setUltimaPresa(this.getNome());
				if(cartePerTerra.size()==0) {System.out.println("Scopa! punto per "+this.getNome()); this.punti++; this.scopeFatte++;}
				break;
			}
		}
		//presa con la somma di due carte:
		if (presaFatta==false) {
			for (int i=0; i<cartePerTerra.size()-1; i++) {
				for (int j=i+1; j<cartePerTerra.size(); j++) {
					if (this.getMano().get(0).getValore()==(cartePerTerra.get(i).getValore()+cartePerTerra.get(j).getValore())) {
						System.out.println(this.getNome()+" prende "+cartePerTerra.get(i).getValore()+" di "+cartePerTerra.get(i).getSeme()+" e "
								+cartePerTerra.get(j).getValore()+" di "+cartePerTerra.get(j).getSeme()+" da terra");
						Carta c1=cartePerTerra.get(i);
						Carta c2=cartePerTerra.get(j);
						this.getPrese().add(c1);
						this.getPrese().add(c2);
						this.getPrese().add(this.getMano().get(0));
						this.getMano().remove(0);
						cartePerTerra.remove(c1);
						cartePerTerra.remove(c2);
						presaFatta=true;
						partita.setUltimaPresa(this.getNome());
						if(cartePerTerra.size()==0) {System.out.println("Scopa! punto per "+this.getNome()); this.punti++;}
						break;
					}
				}
				if (presaFatta==true) {break;}
			}
				
		}
		
		if (presaFatta==false) {
			System.out.println(this.getNome()+" non prende nulla");
			cartePerTerra.add(this.getMano().get(0));
			this.getMano().remove(0);
		}
		System.out.println();
		
	}
	
	
	public void prendiCarteRimaste(Partita p, ArrayList<Carta> cartePerTerra) {
			if (p.getUltimaPresa()==this.getNome()) {
				System.out.println(this.getNome()+" ha fatto l'ultima presa, quindi prende le carte rimaste");
				for (Carta c:cartePerTerra) {
					this.getPrese().add(c);
					System.out.println(this.getNome()+" prende "+c.getValore()+" di "+c.getSeme());
					}
				System.out.println();
		}	 
	}


	

}
