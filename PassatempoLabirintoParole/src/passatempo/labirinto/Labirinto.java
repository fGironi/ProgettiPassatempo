package passatempo.labirinto;

import java.awt.Point;
import java.util.HashMap;

public class Labirinto {

	private HashMap<Point, Stanza> mappaLab;

	
	
	public HashMap<Point, Stanza> getMappaLab() {
		return mappaLab;
	}

	public void setMappaLab(HashMap<Point, Stanza> mappaLab) {
		this.mappaLab = mappaLab;
	}
}
