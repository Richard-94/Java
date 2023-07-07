package MainClasses;



public abstract class Catalogo {
	private String ISBN;
	private String titolo;
	private int anno_pubblicazione;
	private int pagine;
	
	
	public Catalogo(String iSBN, String titolo, int anno_pubblicazione2, int pagine) {
		super();
		ISBN = iSBN;
		this.titolo = titolo;
		this.anno_pubblicazione = anno_pubblicazione2;
		this.pagine = pagine;
	}


	public String getISBN() {
		return ISBN;
	}


	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}


	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}


	public int getPagine() {
		return pagine;
	}


	public void setPagine(int pagine) {
		this.pagine = pagine;
	}



	

}
