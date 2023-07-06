package Esercizio_2;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Creation implements Runnable {
	
	
	private int[] numbers;
    private int sum1;
    private int sum2;
    private int sum3;
    private int[] randomNumbersArray;

	
	private static Logger log;


	public Creation(int[] numbers) {
		 this.log = LoggerFactory.getLogger(Creation.class);
	    this.numbers = numbers;
	    this.randomNumbersArray = randomNumber();
	}
	

    public int getSum1() {
        return sum1;
    }

    public int getSum2() {
        return sum2;
    }

    public int getSum3() {
        return sum3;
    }

	
	public static int[] randomNumber() {

		Logger log = LoggerFactory.getLogger( Creation.class);

			Random random = new Random();
			int[] randomNumber = new int[10];

				try {
					for(int i = 0;i<randomNumber.length;i++) {
							 randomNumber[i] = random.nextInt(10)+1;	
					}

					log.info("Random numbers: {}",  randomNumber);

					
					
				} catch(ArrayIndexOutOfBoundsException e) {
					log.error(e.getMessage());
					
				}catch(NumberFormatException e) {
					log.error("Caratteri non consentiti!!!");
					
				}
				return randomNumber;

		}

	public static int randomArray1(int[] randomNumbersArray) {
			int[] array1 = Arrays.copyOfRange(randomNumbersArray, 0, 2);
			 log.info("length: {}", array1.length);
			
			//log.info("Random numbers: {}", Arrays.toString(array1));
			int sum = 0;
			int i;
			for (i=0;i<array1.length;i++) {
				sum += array1[i];
			}
			
			return sum;
		
		}
	
	public static int randomArray2(int[] randomNumbersArray) {
		int[] array2 = Arrays.copyOfRange(randomNumbersArray, 2, 5);
		log.info("length: {}", array2.length);
		int sum = 0;
		int i;
		for (i=0;i<array2.length;i++) {
			sum += array2[i];
		}
		 log.info("Random numbers2 sum: {}", sum);
		return sum;
	
	}
	 
	public static int randomArray3(int[] randomNumbersArray) {
		int[] array3 = Arrays.copyOfRange(randomNumbersArray, 5, 10);
		log.info("length: {}", array3.length);
		int sum = 0;
		int i;
		for (i=0;i<array3.length;i++) {
			sum += array3[i];
		}
		 log.info("Random numbers3 sum: {}", sum);
		return sum;
	
	}
	

    public int getTotalSum() {
        return sum1 + sum2 + sum3;
    }

	 
		 
	@Override
	public void run() {
		 	 sum1 = randomArray1(randomNumbersArray);
		     sum2 = randomArray2(randomNumbersArray);
		     sum3 = randomArray3(randomNumbersArray);
		   
	}

}
