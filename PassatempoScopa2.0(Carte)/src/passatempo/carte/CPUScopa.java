package passatempo.carte;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class CPUScopa extends Giocatore {

	private ArrayList<MossaCPUScopa> mossePossibili;
	private MossaCPUScopa mossaScelta;




	public ArrayList<MossaCPUScopa> getMossePossibili() {
		return mossePossibili;
	}


	public void setMossePossibili(ArrayList<MossaCPUScopa> mossePossibili) {
		this.mossePossibili = mossePossibili;
	}


	public MossaCPUScopa getMossaScelta() {
		return mossaScelta;
	}


	public void setMossaScelta(MossaCPUScopa mossaScelta) {
		this.mossaScelta = mossaScelta;
	}



	public CPUScopa(String nome) {
		super(nome);
		this.mossePossibili=new ArrayList<MossaCPUScopa>();
	}


	public void sceltaScopaAI(Tavolo tavolo, HashMap<String, Giocatore> giocatori) {
		Integer totalePerTerra=0;
		for (Carta t:tavolo.getCartePerTerra()) {
			totalePerTerra=totalePerTerra+t.getValore();
		}
		for (Carta cartaGiocabile : this.getMano()) {
			Integer valoreMossa=0;
			//Valutazione se la carta prende 1*1
			for (Carta cartaTerra:tavolo.getCartePerTerra()) {
				if (cartaGiocabile.getValore()==cartaTerra.getValore()) {
					valoreMossa=valoreMossa+8;
					if (cartaGiocabile.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+3;
					if (cartaGiocabile.getValore()==7) valoreMossa=valoreMossa+5;
					if (cartaGiocabile.getValore()==7 && cartaGiocabile.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+5;
					if (cartaTerra.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+3;
					if (cartaTerra.getValore()==7 && cartaTerra.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+5;
					if (cartaTerra.getValore()==7) valoreMossa=valoreMossa+5;
					if (cartaTerra.getValore()==6) valoreMossa=valoreMossa+4;
					if (cartaTerra.getValore()==1) valoreMossa=valoreMossa+3;
					if (cartaTerra.getValore()==5) valoreMossa=valoreMossa+1;
					
					if (totalePerTerra-cartaTerra.getValore()<=10 && totalePerTerra-cartaTerra.getValore()>0) {
						valoreMossa=valoreMossa-4;
						for (Carta c:this.getMano()) {
							if (c.getValore()==totalePerTerra) valoreMossa=valoreMossa+2;
						}
						for (Giocatore g: giocatori.values()) {
							for (Carta c:g.getPrese()) {
								if (c.getValore()==totalePerTerra) valoreMossa=valoreMossa+1;
							}
						}
					}
					MossaCPUScopa mossa=new MossaCPUScopa(valoreMossa);
					mossa.setCartaGiocata(cartaGiocabile);
					mossa.getCartePrese().add(cartaTerra);
					mossa.setPrende(true);
					this.mossePossibili.add(mossa);
				}
			}
			if (valoreMossa==0) {
				for (int i=0; i<tavolo.getCartePerTerra().size()-1; i++) {
					Carta cartaT1=tavolo.getCartePerTerra().get(i);
					for (int j=i+1; j<tavolo.getCartePerTerra().size(); j++) {
						Carta cartaT2=tavolo.getCartePerTerra().get(j);
						if (cartaGiocabile.getValore()==((cartaT1.getValore())+cartaT2.getValore())) {
							valoreMossa=valoreMossa+10;
							if (cartaGiocabile.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+3;	
							if (cartaGiocabile.getValore()==7 && cartaGiocabile.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+5;
							if (cartaGiocabile.getValore()==7) valoreMossa=valoreMossa+5;
							if (cartaT1.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+3;
							if (cartaT1.getValore()==7 && cartaT1.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+5;
							if (cartaT1.getValore()==7) valoreMossa=valoreMossa+5;
							if (cartaT1.getValore()==6) valoreMossa=valoreMossa+4;
							if (cartaT1.getValore()==1) valoreMossa=valoreMossa+3;
							if (cartaT1.getValore()==5) valoreMossa=valoreMossa+1;
							if (cartaT2.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+3;
							if (cartaT2.getValore()==7 && cartaT2.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa+5;
							if (cartaT2.getValore()==7) valoreMossa=valoreMossa+5;
							if (cartaT2.getValore()==6) valoreMossa=valoreMossa+4;
							if (cartaT2.getValore()==1) valoreMossa=valoreMossa+3;
							if (cartaT2.getValore()==5) valoreMossa=valoreMossa+1;
							if (totalePerTerra-(cartaT1.getValore()+cartaT2.getValore())<=10 && totalePerTerra-(cartaT1.getValore()+cartaT2.getValore())>0) {
								valoreMossa=valoreMossa-4;
								for (Carta c:this.getMano()) {
									if (c.getValore()==totalePerTerra) valoreMossa=valoreMossa+2;
								}
								for (Giocatore g: giocatori.values()) {
									for (Carta c:g.getPrese()) {
										if (c.getValore()==totalePerTerra) valoreMossa=valoreMossa+1;
									}
								}
							}
							MossaCPUScopa mossa=new MossaCPUScopa(valoreMossa);
							mossa.setCartaGiocata(cartaGiocabile);
							mossa.getCartePrese().add(cartaT1);
							mossa.getCartePrese().add(cartaT2);
							mossa.setPrende(true);
							this.mossePossibili.add(mossa);
						}
					}
				}
			}
			if (valoreMossa==0) {
				if (cartaGiocabile.getSeme()==SemeCarte.denara) valoreMossa=valoreMossa-2;
				if (cartaGiocabile.getValore()==7) valoreMossa=valoreMossa-5;
				if (cartaGiocabile.getValore()==6) valoreMossa=valoreMossa-3;
				if (totalePerTerra+cartaGiocabile.getValore()<=10) {
					valoreMossa=valoreMossa-4;
					for (Carta c:this.getMano()) {
						if (c.getValore()==totalePerTerra) valoreMossa=valoreMossa+2;
					}
					for (Giocatore g: giocatori.values()) {
						for (Carta c:g.getPrese()) {
							if (c.getValore()==totalePerTerra) valoreMossa=valoreMossa+1;
						}
					}				
				}
				MossaCPUScopa mossa=new MossaCPUScopa(valoreMossa);
				mossa.setCartaGiocata(cartaGiocabile);
				mossa.setPrende(false);
				this.mossePossibili.add(mossa);
						
			}
		}
		this.mossaScelta= Collections.max(this.mossePossibili, Comparator.comparing(m -> m.getValoreMossa()));
		this.mossePossibili.clear();

	}
}


//		for (Carta cartaTerra:tavolo.getCartePerTerra()) {
//			if (cartaGiocata.getValore()==cartaTerra.getValore()) {
//				System.out.println(giocatore.getNome()+" prende "+cartaTerra+" da terra");
//				giocatore.getPrese().add(cartaTerra);
//				giocatore.getPrese().add(cartaGiocata);
//				giocatore.getMano().remove(cartaGiocata);
//				tavolo.getCartePerTerra().remove(cartaTerra);
//				presaFatta=true;
//				
//				if(tavolo.getCartePerTerra().size()==0) {
//					System.out.println("Scopa per "+giocatore.getNome()+"!");
//					this.scopeFatte.put(giocatore, cartaGiocata);
//					}
//				break;
//			}
//		}
//		//presa con la somma di due carte:
//		if (presaFatta==false) {
//			for (int i=0; i<tavolo.getCartePerTerra().size()-1; i++) {
//				Carta cartaT1=tavolo.getCartePerTerra().get(i);
//				for (int j=i+1; j<tavolo.getCartePerTerra().size(); j++) {
//					Carta cartaT2=tavolo.getCartePerTerra().get(j);
//					if (cartaGiocata.getValore()==((cartaT1.getValore())+cartaT2.getValore())) {
//						System.out.println(giocatore.getNome()+" prende "+cartaT1+" e "+cartaT2+" da terra");
//						giocatore.getPrese().add(cartaT1);
//						giocatore.getPrese().add(cartaT2);
//						giocatore.getPrese().add(cartaGiocata);
//						giocatore.getMano().remove(cartaGiocata);
//						tavolo.getCartePerTerra().remove(cartaT1);
//						tavolo.getCartePerTerra().remove(cartaT2);
//						presaFatta=true;
//						this.ultimaPresa=giocatore.getNome();
//						if(tavolo.getCartePerTerra().size()==0) {
//							System.out.println("Scopa per "+giocatore.getNome()+"!"); 
//							this.scopeFatte.put(giocatore, cartaGiocata);
//							}
//						break;
//					}
//				}
//				if (presaFatta==true) {break;}
//			}
//				
//		}
//		
//		if (presaFatta==false) {
//			System.out.println(giocatore.getNome()+" non prende nulla");
//			tavolo.getCartePerTerra().add(cartaGiocata);
//			giocatore.getMano().remove(cartaGiocata);
//		}
//		System.out.println();
//	}

