package vectors;

import company.Employee;

public class VectorApplication {

	public static void main(String[] args) {

		System.out.println("Vettore:");

		Vector v = new Vector();
		v.add(100);
		v.add(200);
		v.add(300);
		v.add(225);
		
		v.print();

		OrderedVector ov = new OrderedVector();
		
		System.out.println("\nVettore ordinato:");
		
		Vector vv = new OrderedVector(); // Variabile riferimento di tipo piu' generale
		                                 // per memorizz. oggetto piu' specifico
			
		vv.add(1000);                    // A run time Java capira' che l'oggetto e' di tipo
		vv.add(2000);                    // OrderedVector e chiamera' l'implementazione piu'
		vv.add(3000);                    // specifica di add() (che in questo caso esiste)
		                                 // effettuando un inserimento in ordine
		vv.add(2500);
		
		vv.print();

		// OBJECT
		
		// Riferimento piu' generale possibile, la variabile o puo' fare riferimento
		// a qualunque oggetto (tutte le classi "sono anche un po' Object")
	
		Object o;
		
		       o = new String ("abcde");
		       
		       o = new Integer(5);
		       
		       o = new Double (4.7);
		       
		       o = new Employee("Name", 10000);
		
	}

}
