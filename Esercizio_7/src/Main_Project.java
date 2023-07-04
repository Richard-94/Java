import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main_Project {

    private static final Logger log = LoggerFactory.getLogger(Main_Project.class);

    public static void main(String[] args) {
    	 //Esercizio_1.test();
    	//int[] randomNumbers = Esercizio_1.Random();
    	//Esercizio_1.Invert(randomNumbers);
    	
    	int[] numb = Esercizio_1.Random();
    	Esercizio_1.bool(numb,false);
    	
    	
    	Esercizio_3.insert("Mario Rossi", "123456789");
    	Esercizio_3.insert("Luigi Verdi", "987654321");
    	Esercizio_3.insert("Francesca Neri", "456321789");
		//aggiungiContatto("Mario Rossi", "123456789"); // Errore Chiave Duplicata
		
    	Esercizio_3.stampaContatti();
		
		String nomeContatto = Esercizio_3.searchTelefono("456321789");
		System.out.println("Nome contatto: " + nomeContatto);
		
		String numeroContatto = Esercizio_3.searchByNome("Mario Rossi");
		System.out.println("Numero contatto: " + numeroContatto);
	
		Esercizio_3.del("Luigi Verdi");
		// rimuoviContatto("Antonio Bianchi"); // Errore Chiave non presente in rubrica
	
		Esercizio_3.stampaContatti();
		
		System.out.println(Esercizio_3.person.toString());
    	
    }


  
}
