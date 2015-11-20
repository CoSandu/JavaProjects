package javabase;

public class Motorino {

	private int cilindrata;
	private String targa;
	private String colore;
	
	// Se voglio creare in Java qualcosa di simile ad una variabile 
	// globale del C, per la quale esista una sola istanza/copia nell'intera
	// applicazione posso usare la parola chiave static
	
	static int numeroMotorini = 0;
	
	public Motorino(int cilindrata, String targa, String colore){
		this.cilindrata=cilindrata;
		this.targa = targa;
		this.colore = colore;
	}
	
}
