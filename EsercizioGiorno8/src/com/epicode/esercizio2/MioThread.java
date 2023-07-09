package com.epicode.esercizio2;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MioThread implements Runnable {
	
	private Logger log = LoggerFactory.getLogger(MioThread.class);
	private int[] arr;
	private int indiceInziale;
	private int indiceFinale;
	private List<Integer> listaParziali;

	public MioThread(int[] arr, int indiceInziale, int indiceFinale, List<Integer> listaParziali) {
		this.arr = arr;
		this.indiceInziale = indiceInziale;
		this.indiceFinale = indiceFinale;
		this.listaParziali = listaParziali;
	}

	@Override
	public void run() {
		int sommaParziale = 0;
		for (int i = indiceInziale; i < indiceFinale; i++) {
			sommaParziale += arr[i];
		}
		this.listaParziali.add(sommaParziale);
		log.info("Somma Parziale ("+indiceInziale+" - "+indiceFinale+"): " + sommaParziale);
	}

}
