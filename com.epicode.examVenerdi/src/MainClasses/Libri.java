package MainClasses;



public class Libri extends Catalogo {
	
	private String autore;
	private String genere;
	


	public Libri(String isbn, String titolo, int anno_pubblicazione2, int pagine, String autore, String genere) {
		super(isbn, titolo, anno_pubblicazione2, pagine);
		this.autore = autore;
		this.genere = genere;
	}


	public String getAutore() {
		return autore;
	}


	public void setAutore(String autore) {
		this.autore = autore;
	}


	public String getGenere() {
		return genere;
	}


	public void setGenere(String genere) {
		this.genere = genere;
	}


	@Override
	public String toString() {
		 return "Libri [ISBN=" + getISBN() + ", titolo=" + getTitolo() + ", autore=" + getAutore() + ", genere=" + getGenere() + ", anno_pubblicazione=" + getAnno_pubblicazione() + ", pagine=" + getPagine() + "]";
	}
	

	

}
