package passatempo.labirinto;

import java.util.ArrayList;
import java.util.Random;

public class Mostro implements Evento {

	private String nomeEvento="un mostro";
	private Boolean spawnMostro=false;
	private ArrayList<Oggetto> lootPossibile;
	
	public ArrayList<Oggetto> getLootPossibile() {
		return lootPossibile;
	}
	public void setLootPossibile(ArrayList<Oggetto> lootPossibile) {
		this.lootPossibile = lootPossibile;
	}

	public Boolean getSpawnMostro() {
		return spawnMostro;
	}
	public void setSpawnMostro(Boolean spawnMostro) {
		this.spawnMostro = spawnMostro;
	}	
	
	
	@Override
	public void indaga(Giocatore g, Stanza s) {
		Random rnd=new Random();
		if (spawnMostro==false){
			System.out.println("improvvisamente un mostro ti attacca!");
			s.setHaMostro(true);
			Boolean sorpreso=rnd.nextBoolean();
			if (sorpreso==true) {
				g.setVita(g.getVita()-1);
				System.out.println("ti coglie alla sprovvista, ti colpisce e perdi una vita (vite:"+g.getVita()+")");
			}
			this.lootPossibile=new ArrayList<Oggetto>();
			this.lootPossibile.add(new Pozione());
			this.lootPossibile.add(new Spada());
			this.lootPossibile.add(new Lente());
			this.lootPossibile.add(new Chiave());

		}
		else {
			System.out.println("il mostro è ancora nella stanza");
		}
		if (g.getHaSpada().equals(true)) {
			System.out.print("Con la tua spada sconfiggi il mostro ");
			Boolean rotta=rnd.nextBoolean();
			if (rotta==false) System.out.println("e rinfoderi la spada");
			else { 
				System.out.println("ma la tua spada si rompe");
				g.setHaSpada(false);
			}
			this.daiLoot(g);
			s.setEventoAttivato(true);
			s.setHaMostro(false);
			
		}
		else {
			g.setVita(g.getVita()-1);
			System.out.println("Senza nulla con cui difenderti, il mostro ti attacca e perdi una vita (vite:"+g.getVita()+")");
		}
	}

	public void daiLoot(Giocatore g) {
		Random rnd=new Random();
		Integer loot=rnd.nextInt(this.lootPossibile.size());
		g.prendiOggetto(this.lootPossibile.get(loot));
	}
	@Override
	public String getNomeEvento() {
		return nomeEvento;
	}
	public void setNomeEvento(String nomeEvento) {
		this.nomeEvento = nomeEvento;
	}
	
}
