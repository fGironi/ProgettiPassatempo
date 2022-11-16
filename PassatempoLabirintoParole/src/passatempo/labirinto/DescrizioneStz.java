package passatempo.labirinto;

import java.util.ArrayList;

public class DescrizioneStz {

	private ArrayList<String> descrStart;
	private ArrayList<String> descrRandom;
	
	public ArrayList<String> getDescrStart() {
		return descrStart;
	}
	public void setDescrStart(ArrayList<String> descrStart) {
		this.descrStart = descrStart;
	}
	public ArrayList<String> getDescrRandom() {
		return descrRandom;
	}
	public void setDescrRandom(ArrayList<String> descrRandom) {
		this.descrRandom = descrRandom;
	}
	
	
	public void creaDesStart(){
		ArrayList<String> rndDesStart=new ArrayList<String>();
		String start1="Ti trovi improvisamente in una stanza scarsamente illuminata, grigi muri dall'aria antica sono tutto cio' che trovi ad accoglierti. Sembra esserci un'uscita";
		rndDesStart.add(start1);
		
		String start2="Apri gli occhi e ti ritrovi a fissare un soffito sconosciuto di marmo bianco. Sei in una stanza che sembra completamente vuota a parte una singola porta";
		rndDesStart.add(start2);
					
		this.descrStart=rndDesStart;
	}

	public void creaDesRnd() {
		ArrayList<String> rndDes=new ArrayList<String>();
		String stanza1="un improbabile ruscello scorre da un angolo all'altro della stanza, emettendo un bagliore soffuso che e' tutto cio' che illumina l'ambiente";
		rndDes.add(stanza1);
		String stanza2="un enorme crepaccio si apre al centro di quello che potrebbe essere stato un bellissimo salone. Il lampadario ancora acceso al centro del soffitto non riesce ad illuminare fino in fondo il baratro";
		rndDes.add(stanza2);
		String stanza3="un improbabile ruscello scorre da un angolo all'altro della stanza, emettendo un bagliore soffuso che e' tutto cio' che illumina l'ambiente";
		rndDes.add(stanza3);
		String stanza4="una stanza incredibilmente anonima. L'unica cosa che attira la tua attenzione sono le 4 torce agli angoli";
		rndDes.add(stanza4);
		String stanza5="Un lungo corridoio pieno di macerie, la maggior parte delle porte sono collassate e bloccate da massi e detriti";
		rndDes.add(stanza5);
		String stanza6="Un falo' che non sembra fare fumo domina la stanza, alcune scatole aperte e parzialmente distrutte sono l'unica altra cosa che vedi attorno a te";
		rndDes.add(stanza6);		
		String stanza7="Improvvisamente ti trovi in una stanza piena di altri individui che si guardano attorno confusi, per poi realizzare che la stanza e' piena di specchi che riflettono la tua immagine";
		rndDes.add(stanza7);		
		String stanza8="Se non fosse per il grigio del muro di pietra che intravedi tra le fronde, giureresti di trovarti in una foresta illuminata da centinaia di lucciole";
		rndDes.add(stanza8);
		this.descrRandom=rndDes;
	}
	
}
