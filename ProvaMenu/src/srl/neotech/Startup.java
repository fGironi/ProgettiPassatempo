package srl.neotech;

import java.util.*;

public class Startup {

	public static ArrayList<Piatto> menu=new ArrayList<Piatto>(); 
	public static int opzionimenu=5;
	
	public static void main(String[] args) {
		for (int i=0; i<opzionimenu; i++) {
			Piatto piatto=new Piatto();
			if (i==0) {
				piatto.nome="Carbonara";
				piatto.tipo="Primo";
				piatto.prezzo=8;
				piatto.numIngr=3;
				for (int k=0; k<piatto.numIngr; k++) {
					Ingrediente ingr=new Ingrediente();
					if (k==0) { 
						ingr.nomeIngr="spaghetti";}
					else if (k==1) {
						ingr.nomeIngr="uova";}
					else {
						ingr.nomeIngr="pancetta";}
				piatto.ingredienti.add(ingr);
				}
			}
			else if (i==1) {
				piatto.nome="Bistecca al pepe";
				piatto.tipo="secondo";
				piatto.prezzo=15;
				piatto.numIngr=2;
				for (int k=0; k<piatto.numIngr; k++) {
					Ingrediente ingr=new Ingrediente();
					if (k==0) { 
						ingr.nomeIngr="manzo";}
					else if (k==1) {
						ingr.nomeIngr="pepe";}
					piatto.ingredienti.add(ingr);
				}
			}
			menu.add(piatto);
			
		}
		
			
		for(Piatto piatto:menu) {
			System.out.println(piatto.nome+", ingredienti: ");
			for (Ingrediente ingr:piatto.ingredienti) {
				System.out.print(ingr.nomeIngr+" ");
			}
			System.out.println();
		}
			
	}
	
}