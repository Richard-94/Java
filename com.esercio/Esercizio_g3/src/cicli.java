
public class cicli {

	public static void main(String[] args) {
		System.out.println(evenOdd("201"));
		System.out.println(leapYear(1200));

	}
	
	
	
	public static boolean evenOdd(String number) {
		int i = Integer.parseInt(number);
		if(i%2==0) {
			return true;
		}else {
			return false;
		}	
	}
	
	
	public static boolean leapYear(int year) {
		if(year >= 1200) {
		if(year%4==0) {
				if(year%100==0) {
					if(year%400==0) {
						return true;
					}
				}else {
					return true;
				}
			}
		} else {
			
			System.out.println ("Year must be greater than 1200");
		}
	
		return false;
		
	}

}
