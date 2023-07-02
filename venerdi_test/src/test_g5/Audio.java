package test_g5;

public class Audio extends  Multimedia implements Metodi {
	
	String result = "";
	int durata;
	int alzaLuminosita;
	int volume;
	int numero;

	public Audio(String titolo,int numero) {
		super(titolo);
		this.numero = 0;
	}
	
	public String play(int numero, int durata, int volume) {
	    this.durata = durata;
	    this.volume = volume;
	    if (this.durata > 0 && this.durata <= 5) {
	        for (int i = 0; i < this.durata; i++) {
	            System.out.print(this.getTitolo());
	            for (int j = 0; j < this.volume; j++) {
	                System.out.print("!");
	            }
	           System.out.println();
	        }
	    } 
	    return result;
		
	}

	
	@Override
	public String toString() {
		return "Audio [durata=" + durata + ", alzaLuminosita=" + alzaLuminosita + ", volume=" + volume + ", numero="
				+ numero + "]";
	}

	public int abbassaVolume(int volume) {
		return VolumeClass.abbassaVolume(volume);
	}


	@Override
	public int alzaVolume(int volume) {
		return VolumeClass.alzaVolume(volume);
	}

}
