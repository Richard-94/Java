


public class Banca {
	public static void main(String args[]) {
		ContoCorrente conto1 = new ContoCorrente("Grossi Mario", 20000.0);
		conto1.stampaSaldo();

		System.out.println("Saldo conto: " + conto1.restituisciSaldo());

		try {
			conto1.preleva(1750.5);
			conto1.stampaSaldo();
			

			System.out.println("Saldo conto: " + conto1.restituisciSaldo());
			
		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			e.printStackTrace();
		}

		ContoOnLine conto2 = new ContoOnLine("Rossi Luigi", 50350.0, 1500);

		conto2.stampaSaldo();

		try {
			conto2.preleva(200);

			conto2.stampaSaldo();
			

			

		} catch (BancaException e) {
			System.out.println("Errore durante il prelievo: " + e);
			//e.printStackTrace();
		}
	}
}

