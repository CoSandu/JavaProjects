package vectors;

public class OrderedVector extends Vector{

	// Estendo la classe Vector, implementando una struttura dati che mantiene l'ordinamento
	
	/*
	public OrderedVector(){
		super();
	}
	*/
	
	// Non ho bisogno di aggiungere nulla di nuovo, ma devo ridefinire in override
	// il metodo add() per ordinare in fase di inserimento di un nuovo valore
	// (invece di ordinare dopo, quando serve)
	
	public void add(int value){ 
	
		// Eventualmente prima posso gestire gli errori come in Vector
		// if(num>=MAX_DIM) return;
		
		// 1) Scandisco l'array da sinistra e cerco la prima
		//    cella il cui contenuto e' maggiore di cio' che
		//    devo inserire 
		
		int i;
		for(i = 0; i<num; i++){
			if(array[i]>value)
				break;
		}
		
		// 2) All'uscita dal ciclo nella variabile i ho l'indice della 
		//    prima cella il cui contenuto e' maggiore di value,
		//    ora devo spostare a destra le celle dall'indice i compreso in poi
		
		for(int j=num; j > i; j--)
			array[j]=array[j-1];
		
		// 3) Inserisco il nuovo valore nella cella i-esima ed incremento num
		array[i] = value;
		num++;
		
	}
}