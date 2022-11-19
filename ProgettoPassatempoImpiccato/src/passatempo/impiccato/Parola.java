package passatempo.impiccato;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

//import com.github.javafaker.Country;
import com.github.javafaker.Faker;

public class Parola {

	private String parolaScelta;
	private ArrayList <String> parolePossibili;
	private ArrayList <Boolean> lettereIndovinate;
	private Integer giuste;
	private ArrayList <String> lettereTentate;
//	private ArrayList <String> paesiPossibili;



	public ArrayList <String> getLettereTentate() {
		return lettereTentate;
	}

	public void setLettereTentate(ArrayList <String> lettereTentate) {
		this.lettereTentate = lettereTentate;
	}

	
	public Integer getGiuste() {
		return giuste;
	}

	public void setGiuste(Integer giuste) {
		this.giuste = giuste;
	}
	
	public String getParolaScelta() {
		return parolaScelta;
	}
	public void setParolaScelta(String parolaScelta) {
		this.parolaScelta = parolaScelta;
	}
	public ArrayList<String> getParolePossibili() {
		return parolePossibili;
	}
	public void setParolePossibili(ArrayList<String> parolePossibili) {
		this.parolePossibili = parolePossibili;
	}
	public ArrayList <Boolean> getLettereIndovinate() {
		return lettereIndovinate;
	}

	public void setLettereIndovinate(ArrayList <Boolean> lettereIndovinate) {
		this.lettereIndovinate = lettereIndovinate;
	}
		
	
	public void creaCapitale() {
	this.lettereTentate=new ArrayList<String>();
	this.giuste=0;
	this.parolePossibili=new ArrayList<String>();
	Faker faker=new Faker();
	for (int i=0; i<20; i++) {
		String capitale=faker.country().capital().toLowerCase();
		if (this.parolePossibili.contains(capitale)==false) this.parolePossibili.add(capitale);
		else i--;
			
		}
		
	}

	
	public void creaHarryPotter() {
		this.lettereTentate=new ArrayList<String>();
		this.giuste=0;
		this.parolePossibili=new ArrayList<String>();
		Faker faker=new Faker();
		for (int i=0; i<20; i++) {
			String personaggio=faker.harryPotter().character().toLowerCase();
			if (this.parolePossibili.contains(personaggio)==false) this.parolePossibili.add(personaggio);
			else i--;
		}
	}
	
	public void creaParola() throws IOException {
		
		this.lettereTentate=new ArrayList<String>();
		this.giuste=0;
		this.parolePossibili=new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader("/home/neotech/Desktop/gitclones/Passatempo/ProgettoPassatempoImpiccato/src/passatempo/impiccato/Parole.txt"));
		String parola;

		while((parola=br.readLine()) !=null) {
			//check per potenziali duplicati nella lista fornita
			if (this.parolePossibili.contains(parola)==false) this.parolePossibili.add(parola);
		}
		br.close();
	}
	
	
	public void scegliParola() {
		Random rnd=new Random();
		int i=rnd.nextInt(this.parolePossibili.size());
		this.parolaScelta=this.parolePossibili.get(i);
		
		this.parolePossibili.remove(i);
		this.lettereIndovinate=new ArrayList<Boolean>();
		for (int let = 0; let<this.parolaScelta.length(); let++) {
			Boolean letInd=false;
			if (this.parolaScelta.charAt(let)==' ') { 
				letInd=true;
				this.giuste++;
			}
			this.lettereIndovinate.add(letInd);
		}	

	}
	
	public void vinci(Utente u) {
		System.out.println("hai indovinato! La parola era '"+this.getParolaScelta()+"'!");
		u.setGioca(false);
	}
	
	public void perdi(Utente u) {
		System.out.println("fine vite, fine gioco! La parola era '"+this.getParolaScelta()+"'!");
		u.setGioca(false);
	}
	
	public void indovina(Scanner userInput, Utente u) {
		
		String input=userInput.nextLine().toLowerCase();
		Boolean indov=false;
		if (input=="") {input=" "; indov=true;}
		Character guess=input.charAt(0);
		Character fullguess='+' ;
		if (guess==fullguess) {
			if (input.substring(1).equals(this.parolaScelta)) {this.vinci(u); indov=true;}	
		}
		
		String strguess=guess.toString();
		this.lettereTentate.add(strguess);
		if (indov==false) {
			for (int l = 0; l<this.parolaScelta.length(); l++) {
				if (parolaScelta.charAt(l)==guess) {
					System.out.println("c'e' una "+guess+"!");
					if (this.lettereIndovinate.get(l)==false) {
						this.lettereIndovinate.set(l, true);
						this.giuste++;
						}
					indov=true;
				}
			}
		}
		if (indov==false) {
			u.setVite(u.getVite()-1);
			System.out.println("nessuna "+guess+"! Perdi una vita! ("+u.getVite()+" rimaste)");
			if (u.getVite()==0) {
				this.perdi(u);
			}
		}
		if (this.giuste==this.parolaScelta.length()) {
			this.vinci(u);
		}
		u.setTentativi(u.getTentativi()+1);
	}
	
	
	public void mostraParola(Utente u) {
		System.out.print("tentativo "+u.getTentativi()+" | vite:");
		for (int i=0; i<u.getVite(); i++) System.out.print(" @");
		System.out.print(System.lineSeparator());
		System.out.println("lettere tentate: "+this.lettereTentate);
		System.out.println("lettere indovinate: "+this.giuste+"/"+this.parolaScelta.length());
		for (int let = 0; let<this.parolaScelta.length(); let++) {
			
			if (this.lettereIndovinate.get(let)==true) {
				System.out.print(this.parolaScelta.charAt(let)+" ");
			}
			else System.out.print("? ");
		}
		System.out.println();
	}



}
