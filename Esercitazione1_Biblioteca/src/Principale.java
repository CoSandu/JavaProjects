import biblioteca.Biblioteca;

/**
 * Classe con un main di esempio.
 */
public class Principale {

    /**
     * Esempio di uso della classe Biblioteca
     * Puo' essere utilizzato come semplice "test"
     * 
     */
	public static void main(String[] args) {
		
		// Viene creata una nuova biblioteca, e se ne imposta il nome, con il metodo setNome()
		Biblioteca b = new Biblioteca();
		b.setNome("Biblioteca civica Torino Centro");
		
		// il nome della biblioteca e' accessibile con il metodo
		// getNome()
		String nomeBiblioteca = b.getNome();
		System.out.println("Creata la biblioteca " + nomeBiblioteca);
		System.out.println();
		
		// L'aggiunta di un nuovo libro avviene 
		// tramite il metodo aggiungiLibro() che riceve tre parametri
		// titolo, autore, editore
		b.aggiungiLibro("Programmare in Java","Antonio Agliata","Edizioni Futura");
		b.aggiungiLibro("Chimica Organica","John Mcmurry", "Piccin");
		b.aggiungiLibro("Principi di marketing","Philip Kotler", "Pearson");
		b.aggiungiLibro("Marketing","Giancarlo Ferrero", "Giappichelli");
		
		// Per accedere al primo libro si utilizza 
		// il metodo primo(), che restituisce una stringa nel formato
		// titolo-autore-editore
		String primoLibro = b.primo();
		System.out.println("primo() --> " + primoLibro);
		System.out.println();

		// Per accedere a un libro qualsiasi della biblioteca 
		// si utilizza il metodo libro() che riceve come parametro 
		// il numero d'ordine del libro (a partire da 1, 
		// percio' primo() == libro(1)), nello stesso formato del metodo primo()
		primoLibro = b.libro(1); 
		System.out.println("libro(1) --> " + primoLibro);
		System.out.println("libro(2) --> " + b.libro(2));
		System.out.println("libro(3) --> " + b.libro(3));
		System.out.println("libro(4) --> " + b.libro(4));
		System.out.println();
		
		// Il metodo elenco() restituisce una stringa con 
		// l'elenco dei libri della biblioteca, uno per riga 
		// (ogni riga termina con ';\n', l'ultima con '.')
		System.out.println("Elenco:\n" + b.elenco());
		System.out.println();
	}
}









