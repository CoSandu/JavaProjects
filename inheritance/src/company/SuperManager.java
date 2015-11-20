package company;

public class SuperManager extends Manager {

	private String secretary;

	public SuperManager(String n, double w, String mU, String s) {
	
		// La prima istruzione del costruttore di una classe
		// derivata deve sempre essere la chiamata al costruttore
		// della classe di base (padre)
		super(n, w, mU);
		
		// Poi dovrei andare ad inizializzare tutti gli attributi
		// specifici della classe in esame
		
		this.secretary = s;
		
	}
	
	// Se non si fa altro, la classe eredita i metodi del padre, ovvero
	// del Manager (e quindi di Employee), come incrementWage()
	
	// Posso pero' fornirne una versione in overriding, ad esempio
	// per incrementare la paga di una quantita' maggiore

}
