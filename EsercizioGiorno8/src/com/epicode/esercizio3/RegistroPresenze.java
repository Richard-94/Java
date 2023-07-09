package com.epicode.esercizio3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RegistroPresenze {
	
	private static Logger log = LoggerFactory.getLogger(RegistroPresenze.class);
	private static File file = new File("documenti/presenze.txt");
	private static List<Presenze> listaPresenze = new ArrayList<Presenze>();
	
	public static void main(String[] args) {

		try {
			// Metodo che genera oggetti di tipo presenza
			//creaOggetti();
			// Metodo che salva gli oggetti nel file
			//salvaSuFile();
			// Metodo che legge dal file
			listaPresenze = caricaDaFile();
			
			for (Presenze p : listaPresenze) {
				log.info(p.toString());
			}
		} catch (IOException e) {
			log.error(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			log.error("File vuoto");
		}
		
	}
	
	public static void creaOggetti() {
		Presenze p1 = new Presenze("Mario Rossi",4);
		Presenze p2 = new Presenze("Giuseppe Verdi",7);
		Presenze p3 = new Presenze("Antonio Bianchi",2);
		
		listaPresenze.add(p1);
		listaPresenze.add(p2);
		listaPresenze.add(p3);
	}

	public static void salvaSuFile() throws IOException {
		// Mario Rossi@5#Giorgio Bianchi@7#Gianni Verdi@7
		
		// Preparo la stringa da salvare nel file
		String txt = "";
		for (Presenze p : listaPresenze) {
			txt += p.getNome() + "@" + p.getNumPresenze() + "#";
		}
		
		FileUtils.writeStringToFile(file, txt, "UTF-8", true); 
		log.info("Testo scritto su file " + file.getPath());
	}

	public static List<Presenze> caricaDaFile() throws IOException {
		listaPresenze.clear();
		
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		
		System.out.println(textFile);
		
		String[] p = textFile.split("#");

		for (String s : p) {
			//System.out.println(s);
			String[] par = s.split("@");
			Presenze person = new Presenze(par[0], Integer.parseInt(par[1]));
			listaPresenze.add(person);
		}
		
		return listaPresenze;
		
	}

}
