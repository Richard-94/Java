import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Esercizio_3 {
	private static Logger log = LoggerFactory.getLogger(Esercizio_3 .class);
	static Map<String, String> person = new HashMap<String, String>();
	public static void insert() {
		
		person.put("Nome", "Telefono");
		
	}
	
	public static void del() {
		Set<String> keys = person.keySet();
		 for (String key : keys) {
	            person.remove(key);
	        }
	}
	
	public static void search() {
		Set<String> keys = person.keySet();
		 for (String value : keys) {
	            person.containsValue(value);
	        }
	}
	
}
