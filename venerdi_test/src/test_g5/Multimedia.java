package test_g5;

public abstract class Multimedia {
	
	protected String titolo;

	public Multimedia(String titolo) {
		this.titolo = titolo;
		
		
	}
	
	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Multimedia [titolo=" + titolo + "]";
	}

}
