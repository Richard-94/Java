
public class Main_Project {

	public static void main(String[] args) {
		Dipendente dipendente1= new Dipendente("252658",Department.PRODUZIONE);
		dipendente1.promuovi();
		
		Dipendente dipendente2= new Dipendente("252658",Department.PRODUZIONE);
		
		Dipendente dipendente3= new Dipendente ("25662", 0, 10,Livello.QUADRO,Department.VENDITE);
		dipendente3.promuovi();
		
	
		
		
		
		
		
		
		
		
		
		System.out.println(dipendente1);
		System.out.println(dipendente2);
		System.out.println(dipendente3);
		System.out.println(dipendente1.calcolaPaga(dipendente1,20));
		System.out.println(dipendente2.calcolaPaga(dipendente2));
		System.out.println(dipendente3.calcolaPaga(dipendente3));
		System.out.println(dipendente1.calcolaPaga(dipendente3,10));
		
		
	}
	
	

}
