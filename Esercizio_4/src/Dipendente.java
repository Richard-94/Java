
public class Dipendente {
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Department dipartimento;
	
	
	public Dipendente(String matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Department dipartimento) {
		
		this.matricola = matricola;
		this.stipendio = 1000;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}
	
	
	public Dipendente(String matricola,Department dipartimento) {
		this.matricola = matricola;
		this.stipendio = 1000;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.dipartimento = dipartimento;
	}


	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}


	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}


	public Department getDipartimento() {
		return dipartimento;
	}


	public void setDipartimento(Department dipartimento) {
		this.dipartimento = dipartimento;
	}


	
	
	@Override
	public String toString() {
		return "Dipendente [matricola=" + matricola + ", stipendio=" + stipendio + ", importoOrarioStraordinario="
				+ importoOrarioStraordinario + ", livello=" + livello + ", dipartimento=" + dipartimento + "]";
	}


	public Livello promuovi() {
		if(this.livello==Livello.OPERAIO) {
			this.livello = Livello.IMPIEGATO;
			this.stipendio = this.stipendio * 1.2;
			System.out.println("MATRICOLA NUMERO " +this.matricola +"  SEI STATO PROMOSSO A  " + this.livello  );
		}else if(this.livello==Livello.IMPIEGATO) {
			this.livello=Livello.QUADRO;
			this.stipendio=this.stipendio * 1.5;
			System.out.println("MATRICOLA NUMERO " +this.matricola +"  SEI STATO PROMOSSO A  " + this.livello  );
		}else if(this.livello==Livello.QUADRO) {
			this.livello=Livello.DIRIGENTE;
			this.stipendio=this.stipendio * 2;
			System.out.println("MATRICOLA NUMERO " +this.matricola +"  SEI STATO PROMOSSO A  " + this.livello  );
		}else {
			System.out.println("ERRORE il dipendente non può essere promosso!!!");
		}
		return this.livello;
		
	}
		
		public static double calcolaPaga(Dipendente d) {
			return d.stipendio;
		}
		
		public static double calcolaPaga(Dipendente d, int ore) {
			return d.stipendio+(d.importoOrarioStraordinario*ore);
		}
		

	}
	
	
	




