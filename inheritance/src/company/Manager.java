package company;

public class Manager extends Employee {

	// private String name;
	// private double wage;
	// Sono ereditati da Employee, non devono essere indicati
	
	// La classe Manager aggiunge, rispetto all'Employee, la managedUnit

	private String managedUnit; 
	
	public Manager(String n, double w, String mU){
		
		// 1) Creo ed inizializzo l'"anima" Employee del Manager
		
		      // ... = new Employee(...); non posso farlo così
		
			  // Si utilizza super(), invocando il costruttore della 
		      // classe padre, passando i parametri del caso
		
			  super( n, w ); 
		
		// 2) Creo ed inizializzo la parte specifica del Manager
		
			  this.managedUnit = mU;
	}

	// La classe derivata puo' aggiungere nuovi metodi
	public void setManagedUnit(String mU){
		this.managedUnit=mU;
	}
	
	// Oppure puo' cambiare quanto definito dal padre
	// OVERRIDE/ING, metodo con la stessa firma utilizzata nel padre, ma 
	// DIVERSA IMPLEMENTAZIONE (diverso da overloading, solo stesso nome)

	public String toString(){ 
		
		// Non occorre riscrivere tutto il codice di stampa, meglio DELEGARE
		// return " Name: "+name+"\n"+" Wage: "+wage+"\n...
		
		// Delego la stampa nella parte Employee del Manager all'Employee,
		// qui stampo solo la parte di competenza del Manager
		
		// Uso super., che significa oggetto padre, con questo 
		// posso invocare i metodi in esso definiti

		return super.toString()+"\n "+managedUnit;
	}
	
	// Fornisco anche in questo caso un'implementazione specifica del metodo 
	// per il Manager

	public void incrementWage(){
		
		//wage +=50000;
		
		// Alternativa, uso di un metodo setter setWage() di Employee		
		
		setWage(5500000);	// Equivalentemente con super.	
	}
}