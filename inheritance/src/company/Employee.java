package company;

public class Employee {

	private String name; // protected, questa classe e le classi da essa deriv.
	private double wage; // protected
	
	// Utilizzo dei commenti in formato JavaDoc

	/**
	 * Questo e' il costruttore della classe Employee
	 * @param n Questo e' il nome dell'impiegato
	 * @param w Questa invece e' la paga che voglio dargli
	 */
	public Employee(String n, double w){
		this.name = n;
		this.wage = w;
	}
	
	public void incrementWage(){
		this.wage += 2000;
	}
	
	public String toString(){
		return " "+name+" "+wage+"$";
	}
	
	public boolean equals(Object obj) { // Ridefinisco equals() di Object

	    // Se avessi scritto equals(Employee altroOggetto), non sarebbe stato override 
	    // (la firma deve essere la stessa del metodo nella classe padre, altrimenti
	    // si tratta semplicemente un altro metodo della classe, con lo stesso nome)

		Employee altro = (Employee) obj; // Downcast esplicito, per "vedere" gli attrib. di Employee
		
		// Occorre scrivere l'"algoritmo" (il criterio) di confronto che si vuole utilizzare
		// Si potrebbero confrontare solo i nomi, oppure nome e paga (come in questo caso), ecc.

		if(altro.name.compareTo(this.name)==0 &&
		   altro.wage == this.wage)
			return true; // Se uguali
		else
			return false; // Se diversi
	}
	
	public void setWage(double w){
		this.wage=w;
	}
	
}
