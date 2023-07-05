import java.lang.System.Logger;

import org.slf4j.LoggerFactory;

public class Eserci implements Runnable {
	
	private org.slf4j.Logger log = LoggerFactory.getLogger(Eserci.class);
	
	private String message;
	


	public Eserci(String message) {
		super();
		this.message = message;
	}
	
	


	@Override
	public void run() {
		for (int i=0;i<10;i++) {
			
			log.info("N." + i + " - " + message);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				log.error(e.getMessage());
			}
		}
		
		
	}


}
