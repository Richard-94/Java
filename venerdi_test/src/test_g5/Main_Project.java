package test_g5;

import java.util.Scanner;

public class Main_Project {
	  
   

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		
		
		int regolaVolume = 0;
		int regolaLuminosita = 0;
		String titolo = null;
		int durata3 = 0;
		int durata1 =0;
		Multimedia[] contenuto = new Multimedia[5];
		
	//ALL'INIZIO FACCIO CREARE 2 AUDIO DALL'UTENTE
		
		
		 System.out.println("Crea 2 canzoni: ");
		    	for(int i = 0; i<2;i++) {
		    		 System.out.print("Inserisci il titolo: ");
				        titolo = sc.next();
				        System.out.print("Inserisci la durata: ");
				        durata3 = sc.nextInt();

				        System.out.println("Premi 0 se vuoi abbassare il volume");
				        System.out.println("Premi 1 se vuoi aumentare il volume");
				        System.out.print("Inserisci il volume: ");
				        int volume = sc.nextInt();

				        Audio canzone = new Audio(titolo, 0);

				        switch (volume) {
				            case 0:
				                System.out.print("Inserisci il valore di abbassamento: ");
				                int abbassamento = sc.nextInt();
				                regolaVolume = canzone.abbassaVolume(abbassamento);
				                break;
				            case 1:
				                System.out.print("Inserisci il valore di aumento: ");
				                int aumento = sc.nextInt();
				                regolaVolume = canzone.alzaVolume(aumento);
				                break;
				            default:
				                regolaVolume = volume;
				                break;
		    	}
				       
				        contenuto[i] = canzone;
				        System.out.println(canzone.play(0, durata1, regolaVolume));

		        }

		    	 System.out.println("***************************");
		    	 
		    	 
		    	 //L'UTENTE CREA 2 VIDEO
		    	 
		    	 System.out.println("Crea 2 video: ");
		   
		    	 String titolo1 = null;
		    	 for(int i=0;i<2;i++) {
		    		 System.out.print("Inserisci il titolo: ");
				        titolo1 = sc.next();
				        System.out.print("Inserisci la durata: ");
				        durata1 = sc.nextInt();

				        System.out.println("Premi 0 se vuoi abbassare il volume");
				        System.out.println("Premi 1 se vuoi aumentare il volume");
				        System.out.print("Inserisci il volume: ");
				        int volume1 = sc.nextInt();

				        Video video = new Video(titolo1, 1);

				        switch (volume1) {
				            case 0:
				                System.out.print("Inserisci il valore di abbassamento: ");
				                int abbassamento2 = sc.nextInt();
				                regolaVolume = video.abbassaVolume(abbassamento2);
				                break;
				            case 1:
				                System.out.print("Inserisci il valore di aumento: ");
				                int aumento2 = sc.nextInt();
				                regolaVolume = video.alzaVolume(aumento2);
				                break;
				            default:
				                break;
				        }

				        System.out.println("Premi 0 se vuoi abbassare la luminosità");
				        System.out.println("Premi 1 se vuoi aumentare la luminosità");
				        System.out.print("Inserisci la luminosità: ");
				        int luminosita = sc.nextInt();

				        switch (luminosita) {
				            case 0:
				                System.out.print("Inserisci il valore di abbassamento: ");
				                int abbassamento3 = sc.nextInt();
				                regolaLuminosita = video.abbassaLuminosita(abbassamento3);
				                break;
				            case 1:
				                System.out.print("Inserisci il valore di aumento: ");
				                int aumento3 = sc.nextInt();
				                regolaLuminosita = video.alzaLuminosita(aumento3);
				                break;
				            default:
				                break;
				        }

				        contenuto[i+2] = video;
				       // System.out.println(video.play(1, durata1, regolaVolume,regolaLuminosita));
		    	 }
		    	 
		    	 
		       //L'UTENTE CREA UN'IMMAGINE

		    	 System.out.println("***************************");
		        
		    	 System.out.println("Crea un'immagine: ");
		    	 String titolo3 = null;
		    	 
		    	 for(int i=0; i<1;i++) {
		    		 System.out.print("Inserisci il titolo: ");
				      	titolo3 = sc.next();
				        Immagine image = new Immagine(titolo3, 2);
		
				        System.out.println("Premi 0 se vuoi abbassare la luminosità");
				        System.out.println("Premi 1 se vuoi aumentare la luminosità");
				        System.out.print("Inserisci la luminosità: ");
				        int luminosita1 = sc.nextInt();

				        switch (luminosita1) {
				            case 0:
				                System.out.print("Inserisci il valore di abbassamento: ");
				                int abbassamento3 = sc.nextInt();
				                regolaLuminosita = image.abbassaLuminosita(abbassamento3);
				                break;
				            case 1:
				                System.out.print("Inserisci il valore di aumento: ");
				                int aumento3 = sc.nextInt();
				                regolaLuminosita = image.alzaLuminosita(aumento3);
				                break;
				            default:
				                break;
				        }
				        
				        contenuto[i+4] = image;
				        //System.out.println(Immagine.show(2,regolaLuminosita));
		    	 }
		    	 
		    	 
		    	 
		    	 // L'UTENTE SCEGLIE I CINQUE OGGETTI CHE HA CREATO PIU VOLTE FINCHE NON PREME 0 PER FINIRE
		    	 
		    	 int esci = 0;
		    	 int scelta;
		    	 
		    	 do {
		    		 System.out.println("Che cosa vuoi visualizzare?");
		    		  sc.nextLine(); 
		    		 scelta = sc.nextInt();
		    		
			    	// *************************************************

			    	 switch(scelta) {
			    		 case 1:
			    			 if(contenuto[0] instanceof Audio){
				    			 Audio a = (Audio) contenuto[0];
				    			 //System.out.println(a);
				    			 System.out.println(a.play(0, durata3, regolaVolume));
			    		 }	 
			    			 break;
			    		 case 2:
			    			 if(contenuto[1] instanceof Audio) {
				    			 Audio b = (Audio) contenuto[1];
				    			 //System.out.println(b);
				    			 System.out.println(b.play(0, durata3, regolaVolume));
			    			 }
			    			 break;
			    			 
			    		 case 3:
			    			 if(contenuto[2] instanceof Video) {
				    			 Video c = (Video) contenuto[2];
				    			 //System.out.println(c);
				    			 System.out.println(c.play(1,regolaLuminosita, durata1, regolaVolume));
				    		 }
			    			 break;
			    			 
			    		 case 4:
			    			 if(contenuto[3] instanceof Video) {
				    			 Video d = (Video) contenuto[3];
				    			 //System.out.println(d);
				    			 System.out.println(d.play(1, regolaLuminosita, durata1, regolaVolume));
				    		 }
			    			 break;
			    		 case 5:
				    			 if(contenuto[4] instanceof Immagine) {
				    				 Immagine e = (Immagine) contenuto[4];
				    				 //System.out.println(e);
				    				 System.out.println(e.show(2, regolaLuminosita)); 
					    		 }
				    			 break;
			    	 }

		    	 }while(!(scelta==(esci)));
		    	 System.out.println("Finito");
		    	 
		    	
}

}

