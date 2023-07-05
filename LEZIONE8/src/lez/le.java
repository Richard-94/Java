package lez;


import java.io.File;
import java.io.IOException;
import java.lang.System.Logger;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;

public class le {
	static File file = new File("doc/test.txt");
	static org.slf4j.Logger log = LoggerFactory.getLogger(le.class);

	public static void main(String[] args) {
		try {
			scriviSuFile("ciaoo");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
	
	
	public static void scriviSuFile(String testo) throws IOException {
		FileUtils.writeStringToFile(file, testo, "UTF-8");
		log.info("Testo scritto su file" + file.getPath());
	}

}
