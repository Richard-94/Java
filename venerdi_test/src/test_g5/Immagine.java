package test_g5;

public class Immagine extends  Multimedia   {
	int luminosita;
	int numero;
	
	String result = "";
	public Immagine( String titolo, int numero) {
		super(titolo);
		this.numero = 2;
	}
	
	public String show(int k, int regolaLuminosita) {
	    this.luminosita=5;
	   
	    if (this.luminosita > 0 && this.luminosita <= 10) {
	        for (int i = 0; i < this.luminosita; i++) {
	            System.out.print(this.getTitolo());
	            for (int j = 0; j < this.luminosita; j++) {
	                System.out.print("*");
	            }
	            System.out.println();
	        }
	    } 
	    
	    return result;
	}

	
	@Override
	public String toString() {
		return "Immagine [luminosita=" + luminosita + ", numero=" + numero + "]";
	}

	public int alzaLuminosita(int luminosita) {
		return VolumeClass.alzaLuminosita(luminosita);
	    
	}
	
	public int abbassaLuminosita(int luminosita) {
		return VolumeClass.abbassaLuminosita(luminosita);

	}

}


