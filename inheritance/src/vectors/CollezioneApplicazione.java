package vectors;

import java.util.List;

import company.Employee;

public class CollezioneApplicazione {

	public static void main(String[] args) {

		Collezione c ; 
		 
		           // c= new Collezione(); 
		
		           // c = new CollezioneArray();
		           
		           c = new CollezioneLista();
		           
		// Si possono inserire oggetti di vario tipo, Integer, 
		// String, Employee, ecc.     
		           
		//Employee e1 = new Employee("M. Rossi", 10000);           
		           
		c.aggiungi(new Employee("M. Rossi", 10000)); // "abcd",  new Integer(3);
		c.aggiungi(new Employee("G.Verdi", 15000));
		c.aggiungi(new Employee("A. Bianchi", 30000));
		
		int dim = c.dimensione();
		
		System.out.println("Numero di elementi: "+dim);
		           
		System.out.println("Contenuto:\n"+c.toString());
		
		System.out.println("Cerco");
		if(c.contiene(new Employee("M. Rossi", 44000)))
			System.out.println(" Trovato");
		else
			System.out.println(" Non trovato");
		
		System.out.println("--------------------------");
		
		Collezione cc = new CollezioneArray();
		
		cc.aggiungi(new Studente(1234, "Gianni", "Rossi", 25.0));
		cc.aggiungi(new Studente(5678, "Anna", "Neri", 28.0));
		cc.aggiungi(new Studente(9012, "Francesca", "Blu", 22.0));
		cc.aggiungi(new Studente(3456, "Paola", "Verdi", 22.0));
		
		System.out.println("Num stud: "+ cc.dimensione());
		System.out.println("Dettagli stud; \n"+cc.toString());
		System.out.println("Cerco uno studente");
		if(cc.contiene(new Studente(1234, "Gianni", "Rossi", 25.0)))
			System.out.println(" Trovato :-)");
		else
			System.err.println(" Non trovato :-(((");
		
		
	}
}
