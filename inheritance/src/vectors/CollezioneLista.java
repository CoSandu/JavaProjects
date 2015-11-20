package vectors;

public class CollezioneLista implements Collezione {

	// Altra implementazione, basata su una struttura dati di tipo lista (linkata)

	ElementoLista head = null; // Fa riferimento al primo elemento 
	                           // della lista, null se lista ancora vuota
	
	int numeroElementi = 0;
	
	// Inserimento in testa
	public void aggiungi(Object daInserire){
		
		// 1) Creazione del nuovo ElementoLista 
		ElementoLista tempe = new ElementoLista(daInserire);
		
		// 2) Memorizzo nella "pancia" dell'ElementoLista il valore daInserire
		// tempe.value = daInserire;
        
		// 3) Successore del nuovo elemento posto uguale a quanto attualmente
		//    "puntato" da head
		tempe.setNext(head);

		// 4) Head punta al nuovo elemento 
		head = tempe;
		
		// Incremento il numero di elementi
		this.numeroElementi++;
	}
	
	public int dimensione(){
		return numeroElementi;
	}
	
	public String toString(){

		// Scandisco tutti gli elementi a partire da head, concatenando in ret

		String ret="";
		ElementoLista curre = head; // Elemento corrente
		                            // Il primo curre e' la testa della lista
		
		while(curre != null){
			ret+=curre.getValue().toString()+"\n"; // Stampo "la pancia" dell'elemento corrente
		    curre = curre.getNext();               // Mi sposto sull'elemento seguente
		}
		
		return ret;
	}

	// Potrei anche andare a ridefinire il metodo contiene() se mi serve
	
	// Fino a quando non lo faccio verra' utilizzata la versione definita nel padre
	
	// Indispensabile farlo se Collezione e' definita come interfaccia, le classi che
	// la implementano devono fornire una implementazione di tutti i suoi metodi

	public boolean contiene(Object daCercare) {
		return false; // Da completare
	}
}
