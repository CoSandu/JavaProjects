package javabase;

public class AziendaMotorini {

	// Voglio tener traccia del numero di motorini prodotti
	// Vorrei evitare di usare qualcosa di simile alle var. globali del C
	// int numeroMotorini = 0; 
	
	public static void main(String[] args) {

		Motorino m1 = new Motorino(50,"TR567HY","Rosso");

		// Potrei spostare la variabile nella classe Motorino, come attributo
		
		m1.numeroMotorini ++;
		
		System.out.println("Numero motorini: "+m1.numeroMotorini);

		Motorino m2 = new Motorino(50,"YT43W32","Giallo");
		
		// Pero', cosiì ogni oggetto ha la sua copia di quella variabile
		// (stato dell'oggetto, attributi e valore degli stessi)
		
		// Ogni volta parte da zero (inizializzazione per singolo oggetto)
		// A meno che non faccia altro, dichiarandola come static
	
		// Cosi' facendo, ogni accesso in lettura e scrittura avverra' 
		// su un'unica copia per l'intera applicazione
		
		m2.numeroMotorini ++; 
		
		System.out.println("Numero motorini: "+m2.numeroMotorini);
		
	}

}
