package test_g5;

public class VolumeClass {
	public static int abbassaVolume(int volume) {
        int newVolume = 15;
        if (volume >= 15) {
            System.out.println("Valore deve essere minore di 15");
        } else {
            newVolume -= volume;
        }
        return newVolume;
    }
	
	  public static int alzaVolume(int volume) {
	        int newVolume = 5;
	        if (volume < 5 && volume >= 10) {
	            System.out.println("Valore deve essere tra 5 e 10");
	        } else {
	            newVolume += volume;
	        }
	        return newVolume;
	    }
	  
	  
		public static int alzaLuminosita(int luminosita) {
			   int newLuminosita = 3;
		        if (luminosita < 5 && luminosita >= 10) {
		            System.out.println("Valore deve essere tra 5 e 10");
		        } else {
		        	newLuminosita += luminosita;
		        }
		        return newLuminosita;
		    
		}
		
		public static int abbassaLuminosita(int luminosita) {
			int newLuminosita = 15;
	        if (luminosita >= 15) {
	            System.out.println("Valore deve essere minore di 15");
	        } else {
	        	newLuminosita -= luminosita;
	        }
	        return newLuminosita;
		}

		

}

