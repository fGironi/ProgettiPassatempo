package passatempo.labirinto;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class Generatore {

	private ArrayList<Point> posizioni;

	public ArrayList<Point> getPosizioni() {
		return posizioni;
	}

	public void setPosizioni(ArrayList<Point> posizioni) {
		this.posizioni = posizioni;
	}


	public ArrayList<Point> impostaPosizioni (Integer dimensione) {
		ArrayList<Point> impPos=new ArrayList<Point>();
		for (int i=0; i<dimensione; i++) {
			for (int j=1; j<dimensione; j++) {
				Point p=new Point(i,j);
				impPos.add(p);
			}
		}
	return impPos;
	}
		
	
	
	
	public void creaStanze(Labirinto l, Integer numeroStz) {
		Random rnd=new Random();
		DescrizioneStz ds=new DescrizioneStz();
		ds.creaDesStart();
		ds.creaDesRnd();
		HashMap<Point,Stanza> mappa=new HashMap<Point,Stanza>();
		l.setMappaLab(mappa);
		//Creo la lista di eventi
		ArrayList<Evento> eventi=new ArrayList<Evento>();
		for (int i=0; i<numeroStz; i++) {
			if (i==0) {
				Evento u=new Uscita();	eventi.add(u);
			}
			else if (i==1) {
				Evento c=new TrovaChiave(); eventi.add(c);
			}
			else if (i==2) {
				Evento m=new Mostro(); eventi.add(m);
			}
			else if (i>2&i<6) {
				Evento o=new TrovaOggetto(); eventi.add(o);	
			}
			
			else {
				Evento t=new Trappola(); eventi.add(t);
			}
			Collections.shuffle(eventi);
		}
		
		
		//Creo la stanza di partenza:
		Stanza start=new Stanza();
		start.setIdstz(0);
		Point startP=new Point(0, 0);
		start.setPosizione(startP);
		start.setDescrizione(null);
		start.setStanzeVicine(new HashMap<String, Stanza>());
		Integer rds=rnd.nextInt(ds.getDescrStart().size());
		start.setDescrizione(ds.getDescrStart().get(rds));
		start.setEvento(new TrovaOggetto());
		//Creo le varie stanze
		l.getMappaLab().put(startP, start);
		for (int i=0; i<numeroStz; i++) {
			Stanza s=new Stanza();
			s.setEvento(eventi.get(0));
			eventi.remove(0);
			
			Integer rd=rnd.nextInt(ds.getDescrRandom().size());
			String des=ds.getDescrRandom().get(rd);
			s.setDescrizione(des);
			ds.getDescrRandom().remove(des);
			s.setIdstz(i+1);
			s.setStanzeVicine(new HashMap<String, Stanza>());
			while (s.getPosizione()==null) {
				int rndp=rnd.nextInt(posizioni.size());
				Point p=this.posizioni.get(rndp);
				for (Point p2:l.getMappaLab().keySet()) {
					if (p.distance(p2)==1) {
						s.setPosizione(p);
						this.posizioni.remove(rndp);
					}
				}
			}
			l.getMappaLab().put(s.getPosizione(), s);
		}
		//Segno le stanze vicine alle varie stanze
		for (int i=0; i<10; i++) {
			for (Stanza s:l.getMappaLab().values()) {
				for (Stanza s1:l.getMappaLab().values()) {
					if (s.getPosizione().getX()==(s1.getPosizione().getX()+1)&& s.getPosizione().getY()==s1.getPosizione().getY()) {
						s.getStanzeVicine().put(Direzione.est.toString(), s1);
					}
					else if (s.getPosizione().getX()==(s1.getPosizione().getX()-1)&& s.getPosizione().getY()==s1.getPosizione().getY()) {
						s.getStanzeVicine().put(Direzione.ovest.toString(), s1);
					}
					else if (s.getPosizione().getY()==(s1.getPosizione().getY()+1)&& s.getPosizione().getX()==s1.getPosizione().getX()) {
						s.getStanzeVicine().put(Direzione.sud.toString(), s1);
					}
					else if (s.getPosizione().getY()==(s1.getPosizione().getY()-1)&& s.getPosizione().getX()==s1.getPosizione().getX()) {
						s.getStanzeVicine().put(Direzione.nord.toString(), s1);
					}
					else continue;
				}
				s.setnPorte(s.getStanzeVicine().size());
				
			}
		}
		
		
	}
}
