package MainClasses;



public abstract class Catalogo {
	private String isbn;
	private String titolo;
	private int anno_pubblicazione;
	private int pagine;
	private Libri libro;
	
	
	public Catalogo(String isbn, String titolo, int anno_pubblicazione2, int pagine) {
		super();
		this.isbn= isbn;
		this.titolo = titolo;
		this.anno_pubblicazione = anno_pubblicazione2;
		this.pagine = pagine;
		this.libro = libro;
		
	}



	public String getISBN() {
		return isbn;
	}


	

	

	public Libri getLibro() {
		return libro;
	}


	public void setLibro(Libri libro) {
		this.libro = libro;
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
