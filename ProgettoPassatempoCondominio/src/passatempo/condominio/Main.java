package passatempo.condominio;
import java.util.*;


public class Main {

	public static void main(String[] args) {

		Scanner userInput=new Scanner(System.in);
		Menu m=new Menu();
		m.start(userInput);
		Condominio c=new Condominio(m.interniCondominio(userInput));
		userInput.nextLine();
		c.abitaIniziale(userInput);
		String strIn="";
		while ((strIn.equals("quit"))==false) {
			strIn=m.selezioneUtente(userInput);
			if (strIn.equals("info"))c.getInfo(userInput);
			if (strIn.equals("paga"))c.getDatiPaga(userInput);
			else System.out.println("comando non riconosciuto");
		}
		if(userInput!=null)    userInput.close();
	}
	

}
