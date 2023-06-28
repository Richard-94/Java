import java.util.Scanner;

public class esercizio_while {
	

	public static void main(String[] args) {
		accept();
		
		
	}
	
	
	

	public static void accept() {
		String username = ":q";
		
		Scanner sc = new Scanner(System.in);
		 String nome;
	do {
		System.out.print("Insert name: ");
		nome = sc.nextLine();
		char [] nome1=nome.toCharArray();
		
		
		for(int i=0;i<nome1.length;i++) {
			System.out.println (nome1[i]+"," );
		}
	}
	 while(!nome.equals(username));
	
	
	}
	

}
