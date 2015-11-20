package vectors;

// Obiettivo: creare un contenitore di informazioni cosi' generico da 
// poter "ospitare" qualunque tipo di dato/oggetto che metta a 
// disposizione le operazioni di base per lavorare sui dati stessi

//public abstract class Collezione {

public interface Collezione {

	public abstract void aggiungi( Object daInserire);
	
	public abstract int dimensione();
	
	public abstract String toString();
	
	public abstract boolean contiene( Object daCercare );
}
