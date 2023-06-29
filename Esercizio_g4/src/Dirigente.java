
public class Dirigente extends Worker implements IStampa {

	public Dirigente(String matricola, double stipendio, double importoOrarioStraordinario, Livello livello,
			Department dipartimento) {
		super(matricola, stipendio, importoOrarioStraordinario, livello, dipartimento);
		
	}

	@Override
	public void stampaDatiDipendente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String promuovi(String grado) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calcolaPagaIstanza(String istanza) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calcolaPagaOvertime(String istanza, int ore) {
		// TODO Auto-generated method stub
		return 0;
	}

}
