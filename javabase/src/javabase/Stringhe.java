package javabase;

public class Stringhe {

	public static void main(String[] args) {

		String s; // java.lang.String s;
		
		s = "abcde";
		s = new String("defgh"); // Equivalente

		// La stringa non e' modificabile (non e' uno StringBuffer), quindi quando si
		// scrive qualcosa di simile a quanto scritto qui sotto, in realta' viene creato 
		// un nuovo oggetto con il contenuto indicato e si fa in modo che la variabile
		// s vi faccia riferimento (oggetto precedente perde il riferimento, memoria prima o
		// poi liberata dalla Garbage Collection)
		
		s = new String("defghijklmnopqrst\n"); 
		//s += "uijkl...";

		// Lunghezza della stringa, senza '\0'
		
		System.out.println("Dimensione: "+s.length());
		
		double d = 5.0;
		
		// Concatenazione mediante +
		
		System.out.println("Il valore della variabile e': "+d);
		
		String ss = "" + 5.0 + "testo";
		
		// Si possono inserire caratteri speciali, es. per andare a capo, virgolette, ecc.
		
		System.out.println("\"Ciao mondo\"");
		
		// Confrontare stringhe
		
		String s1 = "ABCDE";
		String s2 = "FGHIJ";
		
		/*if(s1 == s2)
			System.out.println("Uguali");
		else
			System.out.println("Diverse");*/
		
		// Confronto tra stringhe
		
		if(s1 == s2)
			System.out.println("Riferimenti uguali");
		else
			System.out.println("Riferimenti diversi");
		
		// MAI CONFRONTARE TRA LORO GLI OGGETTI UTILIZZANDO ==, 
		// CIO' CHE SI CONFRONTA IN QUEL MODO SONO SOLO LE VARIABILI RIFERIMENTO
		
		// SE VOGLIO CONFRONTARE DUE OGGETTI DEVO UTILIZZARE METODI DIVERSI... QUALI?
		
		if(s1.compareTo(s2)==0) // In C avrei usato strcmp()
			System.out.println("Contenuti uguali");
		else
			System.out.println("Contenuti diversi");
		
		// Con valori di ritorno analoghi a quelli di strcmp(), quindi ==0 per stringhe identiche

		// Altri metodi della classe String
		
		String minuscolo = "casa";
		String maiuscolo = minuscolo.toUpperCase(); // Converto tutto in maiuscolo, oppure minuscolo toLowerCase()
		System.out.println(maiuscolo);
		
		String str = "La mia stringa e' questa qua!";
		
		boolean presente = str.contains("mia"); // Verifica contenimento 
		
		System.out.println("Presente: "+presente);
		
		int indice = str.indexOf("mia"); // Indice della prima occorrenza di "mia" nella stringa
		
		System.out.println("Indice prima occorrenza: "+indice);
		
		// str.lastIndexOf per cercare dal fondo, l'ultima occorrenza
		
		// str.startsWith("") per verificare se la stringa comincia con ...
		
		// str.isEmpty(); per verificare se la stringa e' vuota, ""
		
		// Carattere in posizione i-esima, in C stringa come arraym quindi str[i]

		// In Java, no aritmetica dei puntatori, no accesso con []
		
		//str.charAt(i)
		
		// Metodi di utilita' della classe StringBuffer
		
		StringBuffer sb = new StringBuffer("abcdefghi");
		
		sb.reverse(); // Per ribaltare il contenuto
		
	}

}
