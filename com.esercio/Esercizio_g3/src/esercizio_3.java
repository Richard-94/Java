
public class esercizio_3 {

	public static void main(String[] args) {
		System.out.println(switchNumber (1));

	}
	
	public static String switchNumber (int number) {
		String result = "";
		
		switch(number) {
		case 0:
			result = "zero";
			break;
			
		case 1:
			result = "One";
			break;
			
		case 2:
			result = "two";
			break;
			
		case 3:
			result = "three";
			break;
			
			
			default:
				result = "invalid number";
				break;
		
		}
		
		return result;
	}


	

}
