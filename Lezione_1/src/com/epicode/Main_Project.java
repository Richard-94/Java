package com.epicode;

public class Main_Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 		COMMENTI MULTILINEA
		 */
		boolean b = true;
		char c = 'c';// si usa '' quando ho un solo carattere quando ho yna stringa metto ""
		int i =25;  // valore numerico senza virgola
		double d = 25.5;  // valore numerico decimale
		String s = "ciao";
		
		
		int va1 = 10;
		int va2; // Dichiarato un variabilr
		va2=5;   // Inizializzato una variabile
		final int VA3 = 15; // Definisco e inizzializzo una costante
		
		int[] arrNum = new int [5]; //creo un array di valori di numeri con lunghezza fissa di 5, cioe da 0-4
		arrNum[0] = 25; // inizializzo un valore nell'indice 0 del mio array
		arrNum[1]= 10;
		System.out.println(arrNum[1]);// stampo il valore in console con indice 1 
		
		String[] arrString = new String[3]; //creo un array di valori di stringhe con 3 elementi
		
		char[] arrChar = {'a','b','c'};// creo un array e lo popolo con dei valori
		
		
		for (int j=0; j<arrChar.length;j++) {
			System.out.println(arrChar[j]);
		}
		
		//concerto del casting nel senso che sicomme il num3 ha una lunghezza piu grande cioe long 
		// non lo si puo mettere dentro int num4 perche la scatola è piu piccola quindi faccio il casting esplicito
		// e lo taglio per poterlo metterelo dentro 
		int num1 = 25;// casting implicito
		int num2 = num1;//implicito
		long num3 = num1;//implicito
		int num4 = (int) num3;//esplicito
		
		num1 = num1+5;//operatori di assegnamento
		
		num1 += 5;//operatore di assegnamento
		 
//boolean cond3 =!!(5 >10);
		
	}

}
