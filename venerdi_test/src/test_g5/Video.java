package test_g5;

public class Video extends Multimedia implements Metodi {
	
	String result = "";

	int durata;
	int luminosita;
	int volume;
	int numero;

	


	public Video(String titolo, int numero) {
		super(titolo);
		this.numero = 1;
	}
	
	
	
	public String play(int numero, int durata, int volume) {
	    this.durata = durata;
	    this.volume = volume;
	    if (durata > 0 && durata <= 5) {
	        for (int i = 0; i < this.durata; i++) {
	            System.out.print(this.getTitolo());
	            for (int j = 0; j < this.volume; j++) {
	                System.out.print("!");
	            }
	           System.out.println();
	        }
	    } else {
	        return "la durata deve essere compresa tra 1 e 5";
	    }
		
		return result;
	   
	}
	
	
	public String play(int numero, int volume, int durata, int luminosita) {
		this.durata = durata;
	    this.volume = volume;
	    this.luminosita = luminosita;
	    if (this.durata > 0 && this.durata <= 5) {
	        for (int i = 0; i < this.durata; i++) {
	            System.out.print(this.getTitolo());
	            for (int j = 0; j < this.volume; j++) {
	                System.out.print("!"); 
	            }
	            
	            for(int k = 0; k<this.luminosita; k++) {
                 	 System.out.print("*");
                 }
	          
	            System.out.println();
	        }
	    }
		return result;
	}
	
	
	@Override
	public String toString() {
		return "Video [durata=" + durata + ", luminosita=" + luminosita + ", volume=" + volume + ", numero=" + numero
				+ "]";
	}

	@Override
	public int abbassaVolume(int volume) {
		return VolumeClass.abbassaVolume(volume);
	}

	@Override
	public int alzaVolume(int volume) {
		return VolumeClass.alzaVolume(volume);
	}
	
	
	public int alzaLuminosita(int luminosita) {
		return VolumeClass.alzaLuminosita(luminosita);
	    
	}
	
	public int abbassaLuminosita(int luminosita) {
		return VolumeClass.abbassaLuminosita(luminosita);

	}

}
