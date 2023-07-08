package MainClasses;



public class Riviste extends Catalogo implements Comparable<Riviste> {
	private Period period;


	public Riviste(String isbn, String titolo, int anno_pubblicazione2, int pagine, Period period) {
		super(isbn, titolo, anno_pubblicazione2, pagine);
		this.period = period;
	}

	
	public Period getPeriod() {
		return period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}


	@Override
	public int compareTo(Riviste o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
	    return "Riviste [period=" + period + ", ISBN=" +  getISBN() + ", titolo=" + getTitolo() + ", anno_pubblicazione=" + getAnno_pubblicazione() + ", pagine=" + getPagine() + "]";
	}





	

}
