package javabase;

import javax.swing.JOptionPane;

public class WrapperApplication {

	public static void main(String[] args) {

		// int i = 5;
		
		// In alternativa al tipo primitivo int uso la classe 
		// Intero che mi sono creato, una scatola che contiene un valore
		// int ed i metodi per gestirlo (costruttore, getter, setter, ecc.)
		
		Intero i = new Intero(5); // Gli assegno un valore, inizializzandolo o con metodo setter

		i.setValore(5);
		
		// Oppure, piu' semplicemente, uso i tipi wrapper di Java, Integer, Double, ecc.
		
		Integer intero = new Integer(5);
		Double reale = new Double(6.5);

		// Vediamo un esempio di impiego dei dipi wrapper (per funz. di conversione)
		
		String stringa = JOptionPane.showInputDialog("Inserisci la tua eta'");
		
		// Dobbiamo convertire la stringa restituita in un int(ero)

		// Non posso farlo con un cast, in C avrei usato la funzione atoi()
		
		// int eta = (int)stringa;
		
		// Uso il metodo statico parseInt() della classe Interegr
		
		int eta = Integer.parseInt(stringa);
		
		// Come faccio a convertire un int in una String? So gia' farlo, con il +
		
		String s = ""+5;

		// Esiste anche un metodo del tipo wrapper, toString(), gia' visto
		
		Integer cinque = new Integer(5);
		s = cinque.toString();
		
		// Lavorando con i tipi wrapper puo' capitare di usarli assieme ai tipi primitivi
		
		Double d1 = new Double(6.3);
		double d2 = 3.7;
		
		// AUTO-BOXING / AUTO-UNBOXING, Java inserisce/estrae automaticamente dalla scatola
		
		              // new Double(d2)
		Double d3 = d1 + d2; 
		double d4 = d1 + d2;
		
	}

}