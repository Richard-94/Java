
public  class Produzione extends Worker implements IStampa {

	public Produzione(String matricola, Department dipartimento,Livello livello) {
		super(matricola, dipartimento,livello);
		
	}


	@Override
	public void stampaDatiDipendente() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
        return "Produzione [matricola=" + getMatricola() + ", stipendio=" + getStipendio() + ", livello=" + getLivello()
                + ", dipartimento=" + getDipartimento() + "]";
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
