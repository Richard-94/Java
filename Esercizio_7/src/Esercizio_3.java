import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio_3 {
	private static Logger log = LoggerFactory.getLogger(Esercizio_3 .class);
	static Map<String, String> person = new HashMap<String, String>();
	public static void insert(String nome, String telefono) {
		
		person.put("Nome", "Telefono");
		
	}
	
	public static void del(String nome) {
		
		person.remove(nome);
	      
	}
	
	public static String searchTelefono(String telefono) {
		Set<String> key = person.keySet();
		
		for (String s : key) {
			if(telefono.equals(person.get(s))) {
				return s;
			}
		}
		return null;
		
	}
	
	public static String searchByNome(String nome) {
		
		return person.get(nome);
	      
	}
	
	public static void stampaContatti(){
		System.out.println("******* Contatti *********");
	    Set<String> key = person.keySet();
	    for (String k : key) {
			System.out.println("Nome: " + k + " Numero: " +person.get(k));
		}
	}
	
}
