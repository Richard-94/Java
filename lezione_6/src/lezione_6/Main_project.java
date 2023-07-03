package lezione_6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main_project {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(Main_project.class);
		log.info("logInfo");
		log.debug("logDebug");
		log.error("logError");
		log.warn("logWarn");

	}

}
