import company.*;

public class CompanyApplicazione {

	public static void main(String[] args) {

		Employee e1 = new Employee("M. Rossi", 20000.0);
		
		// Stampa, andando ad accedere direttamente ai singoli attributi 
		// di Employee con . o getter

		System.out.println("Employee e1");
		//System.out.println(""+e1.getName());
		//System.out.println(""+e1.getWage());
		
		// DELEGA, faccio in modo che sia l'employee a stamparsi
		
		System.out.println(e1.toString());
		
		e1.incrementWage();
		
		System.out.println("\nEmployee e1 dopo l'aumento");
		System.out.println(e1.toString()); //toString()
		
		Employee e2 = new Employee("G. Verdi", 21000);
		
		// Mettiamo gli impiegati in un array

		Employee emps[] = new Employee[10];
		emps[0] = e1;
		emps[1] = e2;
		
		System.out.println("Stampo gli Employee nell'array");
		for (int i=0; i < emps.length; i++){
			Employee temp = emps[i];
			if(temp!=null)
				System.out.println(temp.toString()); // O, in maniera equivalente, 
			                                         // anche senza toString()
		}
			
		System.out.println("Stampo usando il costrutto for-each");

		// Un modo diverso di stampare l'array potrebbe essere
		// quello di utilizzare il costrutto FOR EACH
		// Il for each funziona solo con oggetti (al limite wrapper)

		//Integer arrayInteri[] = new Integer[10];

		for(Employee temp : emps){ 
			// Qui, in temp, ho un Employee
			if(temp!=null)
				System.out.println(temp.toString());
		}
		
		Manager m = new Manager("B.Boss",500000,"Contab.");
		
		System.out.println("\nManager");
		System.out.println(m.toString()); // Senza fare null'altro
		                                  // il Manager ha ereditato
		                                  // il metodo toString() da Empl.
		
		m.incrementWage();
		
		System.out.println("\nManager dopo il lauto aumento");
		System.out.println(m.toString());
		
		// POLIMORFISMO E DYNAMIC BINDING
		
		// Ora proviamo ad utilizzare le variabili riferimento dei vari tipi definiti
		
		Employee e;
		
		e = m; // Una variabile riferimento di tipo piu' generico, e
	           // (Employee) puo' fare riferimento ad un oggetto, m
	           // di tipo piu' specifico (Manager), a patto che
	           // vi sia una relazione di ereditarieta' tra le
	           // due classi (extends)		

		int i = (int)3.5;
		double d = 8;
		
		e.incrementWage(); // Corretto sintatticamente a compile time 
						   // perche' Employee ha un metodo incrementWage(),
                           // poi, a run time, Java capisce quale e'
                           // l'oggetto cui la avariabile e fa riferimento ed invoca
                           // la versione del metodo corretta (piu' specifica),
                           // se esiste, altrimenti quella piu' generica

		System.out.println(e.toString()); // 1) COMPILE-TIME
		                                  // Verifica se posso invocare quel met.
										  // 2) RUN-TIME
		                                  // Stabilisce quale sia la versione
		                                  // corretta del metodo da chiamare
		                                  // ovvero se di Empl. o di Manager
										  // guardando cosa c'e' effettivamente in 
		                                  // memoria (DYNAMIC BINDING, POLIMORFISMO)
		
		
		// Per memorizzare anche i manager, devo forse creare anche un array di Manager?
		
		// No, proviamo a definire un semplice array di Employee

		Employee empsAndMangs[] = new Employee[10]; 
		
		empsAndMangs[0] = e1;
		empsAndMangs[1] = e2;
		empsAndMangs[2] = m;
		
		// Cosi' come una variabile di tipo piu' generale puo' fare
		// riferimento ad un oggetto piu' specifico, allo stesso modo
		// le celle di un array di tipo piu' generale possono fare riferimento
		// ad oggetti piu' specifici
		
		System.out.println("Stampo l'array di Employee e Manager");
		
		for(Employee temp : empsAndMangs){
			if(temp!=null)
				System.out.println(temp.toString());
		}

		// Non solo Employee e Manager...

		SuperManager sm = new SuperManager("S. Uperman", 1000000, "Planet", "Secretary");

		System.out.println("Super manager sm: ");
		System.out.println(sm.toString());
		
		empsAndMangs[3] = sm; 
		
		// Sempre a proposito di variabili riferimento ... (e = m;)
		
		// Funziona anche ...
		
		//m = e; // Questa operazione, cosi', non e' possibile,
		         // manca una parte dell'informazione, non so 
		         // come valorizzare la parte specifica del Manager
		         // (l'Employee non ha la managedUnit)
		
	}

}
