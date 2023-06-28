import java.util.Scanner;

public class esercizio_4 {

	public static void main(String[] args) {
		
		 countDown();
	}
	
	public static void countDown() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Insert number: ");
		int number = Integer.parseInt(sc.nextLine());
		
		for(int i=number;i>=0;i--) {
			
			System.out.println(i);
		}
		
	}

}
