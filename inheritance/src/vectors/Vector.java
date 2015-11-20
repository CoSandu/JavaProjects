package vectors;

public class Vector {

	protected static final int MAX_DIM = 100;

	// Attributi della classe

	protected int array[]; // = new int[MAX_DIM];
	protected int num;     // = 0;

	// Definizione di una variabile i qui sopra sarebbe corretto sintatticamente, 
	// ma errato dal punto di vista concettuale (non sarebbe un attributo di Vector,
	// astrazione/incapsulamento, ma una variabile, es. utilizzata come contatore)
	
	
	public Vector(){
		array = new int[MAX_DIM]; // Allocazioni, inizializz., meglio nel costruttore
		num = 0;
	}
	
	public void add(int value){
		
		if(num>=MAX_DIM) // Con un metodo add() per aggiungere il valore 
			return;      // 1) evito l'accesso diretto (delega, limit. dipendenze, no spaghetti code)
		                 // 2) posso aggiungere istruzioni, es. per controllo errori
		array[num] = value;
		
		num++;
	}
	
	public void print(){
		int i;
		for(i=0; i<num;i++ )
			System.out.print(array[i]+" ");
	}
}
