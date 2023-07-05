import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class Main_Project {
	
	private Logger log = (Logger) LoggerFactory.getLogger( Main_Project.class);

	public static void main(String[] args) {
		
		Eserci prova1 = new Eserci("*");
		Eserci prova2 = new Eserci("@");
		Thread pro1 = new Thread(prova1);
		Thread pro2 = new Thread(prova2);
		
		
		pro1.start();
		pro2.start();
		
	}

}
