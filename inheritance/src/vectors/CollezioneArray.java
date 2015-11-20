package vectors;
                          // extends, se Collezione e' una classe
public class CollezioneArray implements Collezione {

	// Una possibile implementazione della collezione, con una
	// struttura dati di tipo array di Object (generico)
	
	// Rispetto a Collezione, la classe CollezioneArray
	//  aggiunge l'array
	//  eredita tutti i metodi di Collezione
	//  e li modifica (in override), fornendone una implementazione adatta per l'array
	
	// private                  MAX_DIM
	Object array[] = new Object[100];

	int numElementi = 0;
	
	// In override rispetto alla definizione piu' generale di aggiungi() 
	// fornita nella classe padre Collezione
	public void aggiungi(Object daInserire) {

		for(int i=0; i<array.length;i++ ){
			if(array[i]==null){
				array[i] = daInserire;
				numElementi++;
				break; // return;
			}
		}
	
	}

	// In override rispetto al metodo di Collezione
	public int dimensione() {
		return numElementi;
	}

	// In override rispetto al metodo di Object (e Collezione)
	public String toString() {
		
		String ret="";
		for( Object otemp : array ){  // for (Employee etemp : emps) { ... }
			if(otemp!=null)
				ret+=otemp.toString()+"\n"; 
		}
		return ret;
	}

	// In override rispetto al metodo di Collezione
	public boolean contiene(Object daCercare) {

		for(int i=0;i<numElementi;i++){
			if(array[i].equals(daCercare)   ) // Mai confrontare ogg. con ==
				return true;
			//else
			//	return false;
		}
		return false;
	}

}
