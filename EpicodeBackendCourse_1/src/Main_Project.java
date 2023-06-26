import java.util.Arrays;

public class Main_Project {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int results = multiply(5,6);
		System.out.println(results);
		
		String concat =add("ciao ",10);
		System.out.println(concat);
		
		
		 String[] a = { "ciao", "si", "yes", "boh","fr"};
		    String b = "new element";
		    
		    putInArray(a, b);
	
	}

	
	public static int multiply(int a, int b) {
		int results = a *b;
		return results;
	}
	
	public static String add(String a,int b) {
		String concat = a +Integer.toString(b)  ;
		return concat;
	}
	
	public static String[] putInArray(String a[], String b) {
				
				if(a.length==5) {
					
					for(int j=0; j<a.length;j++) {
						a[2]=b;
					}
				}else {
			        System.out.println("Array 'a' must have exactly 5 elements.");
				}
				
				System.out.println(Arrays.toString(a));
				
				return a;
		
	}

}
