package vectors;

public class ElementoLista {

	// Ogni elemento della lista possiede due attributi
	//  value: che "contiene", "ospita" il valore da memorizzare, generico
	//  next: "puntatore" (riferimento) all'elemento successivo della lista
	
	private Object value; // Sufficientemente generico
	private ElementoLista next; // Sempre di tipo ElementoLista
	
	public ElementoLista(Object v){
		value = v;
	}
	
	public void setNext(ElementoLista n){
		next = n;
	}
	
	public ElementoLista getNext(){
		return next;
	}
	
	public Object getValue(){
		return value;
	}
}
