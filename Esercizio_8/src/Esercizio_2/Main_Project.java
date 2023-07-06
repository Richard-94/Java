package Esercizio_2;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

public class Main_Project {
	
	private Logger log = (Logger) LoggerFactory.getLogger( Main_Project.class);

	public static void main(String[] args) {
		  int[] randomNumber = Creation.randomNumber();

		  Creation prova1 = new Creation(randomNumber);
		  Creation prova2 = new Creation(randomNumber);
		  Creation prova3 = new Creation(randomNumber);

		    Thread pro1 = new Thread(prova1);
		    Thread pro2 = new Thread(prova2);
		    Thread pro3 = new Thread(prova3);
		   

		    pro1.start();
		    pro2.start();
		    pro3.start();
		    
		    try {
				pro1.join();
				pro2.join();
			    pro3.join();
				    
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    int sum1 = prova1.getSum1();
		    int sum2 = prova2.getSum2();
		    int sum3 = prova3.getSum3();
		    int totalSum = prova1.getTotalSum();

		    System.out.println("Sum of randomArray1: " + sum1);
		    System.out.println("Sum of randomArray2: " + sum2);
		    System.out.println("Sum of randomArray3: " + sum3);
		    System.out.println("Total Sum: " + totalSum);
	       
	}

}
