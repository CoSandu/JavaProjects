package javabase;

public class ControlStatements {

	public static void main(String[] args) {

		int i = 8;
		
		// Condizioni, in Java (espressioni, valutate come true/false)
		// Ad esempio, in C si poteva scrivere if(i)
		// In Java deve essere invece if (i!=0), usando uno o piu' operatori
		// Quali operatori?
		//  aritmetici
		//  relazionali
		//  bit a bit
		//  assegnamento, =, +=, ecc., diverso da ==
		//  incremento
		//  logici
		
		if(i>5){
			System.out.println("La variabile e' maggiore di 5");
		}
		else if(i<5)
			System.out.println("La variabile e' minore di 5");
		else
			System.out.println("La variabile e' uguale a 5");
		

		// Intervallo > 5 E < 10
		if( (i>5) && (i<10) ){ // Prima op. relazionali, poi logici, attenzione alla precedenza
			                   // tra gli operatori, nel dubbio usare altre ( )
			System.out.println("Variabile maggiore di 5 e minore di 10");
		}
		else
			System.out.println("Altrimenti");
		
		// Anche piu' di un if-else, annidati/in cascata 
		// Con o senza {}, in base al numero di istruzioni nel blocco (se una sola, anche senza {})
		
		// Tipi di dato primitivi
		
		byte ottetto;
		
		ottetto = 34;
		ottetto = 127;
		//ottetto = 128; // 8 bit in C2, da -128 a +127
		
		// Costanti, in Java definite mediante final, tipo e nome (oltre a valore)
		
		// Forte orientamento alla tipizzazione, diversamente dal C, solo nome (e valore)
		// come una variabile, ma il valore non potra' piu' essere modificato
		
		final float PI = 3.14f;
		
		// Impossibile assegnare un valore ad una costante (Eclise segnala errore)
		// PI = 6.28;
		
		// #define PI trevirgolaquattordici
		
		final String GIORNO = "Mercoledi";
		
		
		double reale = 6.92;
		
		int intero = 5;
		
		//reale = intero;
		
		System.out.println(reale);
		
		intero = (int)reale; // Operazione di CASTING, TYPE CASTING ()
		
        // La variabile reale viene temporaneamente considerata del tipo tra ()
        // per il tempo necessario ad eseguire l'operazione
        // (la parte frazionaria e' stata temporaneamente buttata via)		
		
		System.out.println(reale);
		
		System.out.println(intero);
		
		// Come si invoca il metodo stampa()?

		//stampa(c1);

		// Il parametro attuale viene COPIATO nel parametro formale
        // Si puo' passare un valore, una costante, una variabile, un'espressione, ecc.			
		
		Automobile c1 = new Automobile();
		c1.targa="CS567RR";
		c1.marca="FCA";
		c1.colore="Rosso";

		System.out.println("Automobile c1");
		
		       // Parametro attuale copiato nel par. formale
		stampa(c1);
		
		// Ma, allora, quando si passa un oggetto piu' sofisticato, es. un'Autombile, che succede, 
		// se non ci sono i puntatori? Il passaggio di parametri avviene sempre by value, ma
		// vengono copiati riferimenti ad aree di memoria (quindi qualcosa di simile ai puntatori del C)
		// l'uso dei puntatori viene semplicemente nascosto al programmatore
		
		
	}
	
	                         // Parametro formale
	static public void stampa(Automobile param){ 	// In Java, passaggio di parametri sempre per copia, by value
		//System.out.println("Il parametro vale: "+param);
		System.out.println("Targa: "+param.targa);
		System.out.println("Marca: "+param.marca);
		System.out.println("Colore: "+param.colore);
	}

}
