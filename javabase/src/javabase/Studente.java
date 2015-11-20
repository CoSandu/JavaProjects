package javabase;

public class Studente {

	// Regola d'oro, attributi definiti come privati

	private String matricola;
	private String nome;
	private String cognome;

	private int eta; // Cambio la visibilita' da "non indicata" a private
	
	private boolean sesso;
	
	// Per creare il costruttore si puo' utilizzare il wizard di Eclipse 

	public Studente(String matricola, String nome, String cognome) {
		this.matricola = matricola;
		this.nome = nome;
		this.cognome = cognome;
		eta = 0;
		sesso = false;
	}
	
	// Accesso agli attributi garantito da metodi getter/setter, ev. creati con wizard Eclipse

	// Non e' necessario definire getter/setter per ogni attributo, solo per
	// quelli per cui si vuole avere un accesso pubblico
	
	public String getMatricola(){
		return matricola;
	}
	
	public void setMatricola(String matricola){
		this.matricola=matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getEta() {
		return eta;
	}

	// Vantaggio del'uso del metodo rispetto all'accesso diretto:
	// si puo' inserire codice, ad es. per il controllo degli errori, ma non solo
	
	public void setEta(int eta) {
		if(eta>-1)
			this.eta = eta;
		else
			System.err.println("Eta' non valida");
	}

	public boolean getSesso() {
		return sesso;
	}

	public void setSesso(boolean sesso) {
		this.sesso = sesso;
	}
	
	// Delega: chi meglio dello Studente sa come descriversi? 
	// Manutenibilita'/evoluzione del codice piu' semplice (ad esempio, 
	// per gestire un nuovo attributo o correggere un errore nella stampa 
	// sara' sufficiente modificare questo punto del codice)

	public String toString(){
		
		String risultato = "";
		
		risultato += "Matricola: "+matricola+"\n";
		risultato += "Nome: "+nome+"\n";
		risultato += "Cognome: "+cognome+"\n";
		risultato += "Eta: "+eta+"\n";

		if(sesso==true)
			risultato+="Sesso: F";
		else
			risultato+="Sesso: M";
		
		return risultato;
	}
	
	
	
	
	
	
	
}
