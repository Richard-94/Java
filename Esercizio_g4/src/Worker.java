import java.lang.System.Logger.Level;



abstract public class Worker {
	private String matricola;
	private double stipendio;
	private double importoOrarioStraordinario;
	private Livello livello;
	private Department dipartimento;
	 
	 public static final double STIPENDIO_BASE = 1000;
	
	public String getMatricola() {
		return matricola;
	}
	
	public double getStipendio() {
		return stipendio;
	}
	
	public double getImportoOrarioStraordinario() {
		return importoOrarioStraordinario;
	}
	public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
		this.importoOrarioStraordinario = importoOrarioStraordinario;
	}
	public Livello getLivello() {
		return livello;
	}
	
	public void setLivello(Livello grado) {
	    this.livello = grado;
	}


	
	public Department getDipartimento() {
		return dipartimento;
	}
	public void setDipartimento(Department dipartimento) {
		this.dipartimento = dipartimento;
	}
	
	

	@Override
	public String toString() {
		return "Worker [matricola=" + matricola + ", stipendio=" + stipendio + ", importoOrarioStraordinario="
				+ importoOrarioStraordinario + ", livello=" + livello + ", dipartimento=" + dipartimento + "]";
	}

	public Worker(String matricola, Department dipartimento, Livello livello) {
		
		this.matricola = matricola;
		this.stipendio = STIPENDIO_BASE;
		this.importoOrarioStraordinario = 30;
		this.livello = Livello.OPERAIO;
		this.dipartimento = dipartimento;
	}
	
	

	public Worker(String matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Department dipartimento) {
		super();
		this.matricola = matricola;
		this.stipendio = STIPENDIO_BASE;
		this.importoOrarioStraordinario = importoOrarioStraordinario;
		this.livello = livello;
		this.dipartimento = dipartimento;
	}

	
	


	
	
	
}
