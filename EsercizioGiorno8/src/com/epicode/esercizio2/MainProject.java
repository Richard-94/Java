package com.epicode.esercizio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainProject {

	public static void main(String[] args) throws InterruptedException {
		
		Logger log = LoggerFactory.getLogger(MainProject.class);
		int[] arr = creaArray(3000);
		List<Integer> listaParziali = new ArrayList<Integer>();
		int tot = 0;
		
		// Test sul funzionamento della somma dei numeri nell'array
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		Thread t1 = new Thread(new MioThread(arr, 0, 1000, listaParziali));
		Thread t2 = new Thread(new MioThread(arr, 1000, 2000, listaParziali));
		Thread t3 = new Thread(new MioThread(arr, 2000, 3000, listaParziali));
		
		t1.start();
		t2.start();
		t3.start();
		
		t1.join();
		t2.join();
		t3.join();
		
		for (Integer val : listaParziali) {
			tot += val;
		}
		
		log.info("Totale: " + tot);
			
	}
	
	private static int[] creaArray(int size) {
		Random rand = new Random();
		int[] numArr = new int[size];
		for (int i = 0; i < size; i++) {
			numArr[i] = rand.nextInt(25);
		}
		return numArr;
	}

}
