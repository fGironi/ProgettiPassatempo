package passatempo.magia;

public class Main {

	public static void main(String[] args) {

		
		CreaMagie nm= new CreaMagie();
		nm.CreaListaMagie();
		Mago saruman=new Necromante("Saruman");
		Magia ibernazione=new Incantesimo("Ibernazione");
		Magia miracolo=new Incantesimo("Miracolo");
		
		System.out.println("la scuola di magia di "+saruman.getNome()+" e' "+saruman.getScuola());		
		
		Magia pallaDiFuoco=nm.creaMagia("Palla di Fuoco", "Stregoneria", "una sfera infuocata");
		
		saruman.imparaMagia(pallaDiFuoco);
		saruman.imparaMagia(ibernazione);
		ibernazione.setDescrizione("cristalli di ghiaccio vibrano nell'aria prima di condensarsi in un unico blocco");
		
		saruman.lanciaMagia(ibernazione, saruman);
		saruman.lanciaMagia(miracolo, saruman);
		saruman.lanciaMagia(pallaDiFuoco, null);

		for(Magia m:saruman.getLibroDiMagie()) {
			System.out.println(m.getNome());
		}
		

		
		System.out.println(nm.getListaMagie().get(0).getNome());
		
	//	System.out.println(nm.getPallaDiFuoco().getDescrizione());
		
		

	}

}
