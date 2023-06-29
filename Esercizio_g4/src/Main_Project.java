
public class Main_Project {

	public static void main(String[] args) {
		 Worker operaio1 = new Produzione("2566", Department.PRODUZIONE, Livello.OPERAIO);
		 Worker operaio2 = new Produzione("9666", Department.PRODUZIONE, Livello.OPERAIO);
		 Worker operaio3 = new Impiegato("26562",0,10,Livello.IMPIEGATO, Department.AMMINISTRAZIONE);
		 Worker operaio4 = new Dirigente("26562",0,10,Livello.DIRIGENTE, Department.VENDITE);
		 
		 
			System.out.println(operaio1);
			System.out.println(operaio2);
			System.out.println(operaio3);
			System.out.println(operaio4);
			System.out.println(operaio4);
		
		 Worker[] lista =new Worker[4];
		 lista[0]= operaio1;
		 lista[1]= operaio2;
		 lista[2]= operaio3;
		 lista[3]= operaio3;
		 
		 for (int i = 0; i < lista.length; i++) {
			    if (lista[i] instanceof Produzione) {
			        Produzione nuovoOperaio = (Produzione) lista[i];
			        
			        Livello livello = nuovoOperaio.getLivello();

			        if (livello.equals(Livello.OPERAIO)) {
			            nuovoOperaio.setLivello(Livello.IMPIEGATO);
			        }
			        System.out.println(nuovoOperaio.toString());
			    }
			        else if(lista[i] instanceof Impiegato) {
			        	Impiegato nuovoImpiegato = (Impiegato) lista[i];
			        	Livello livello1 = nuovoImpiegato.getLivello();
			        	if(livello1.equals(Livello.IMPIEGATO)) {
			        		nuovoImpiegato.setLivello(livello1.QUADRO);
			        	}
			        	System.out.println(nuovoImpiegato.toString());
					      
			        
			        }
			        
			        
			        
			        
			   	 
			       
			      
			    }
			    
			    
		


	}		


}
