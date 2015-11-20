package javabase;

public class Corso {

	private String codice;
	private String titolo;
	
    private Studente studenti[];      // Anche questo e' un attributo, private
                                      // Per accedervi, metodo getter/setter o, piu' probabilmente
                                      // in questo caso, metodo per iscrivere/disiscrivere uno Studente
    	
	private int numeroStudentiIscritti = 0;
	
	public Corso(String codice, String titolo){
		this.codice=codice;
		this.titolo=titolo;

		studenti = new Studente[100]; // Per motivi concettuali e di efficienza (memoria)
									  // mglio creare l'array nel costruttore
	}
	
	// Alcuni metodi getter/setter

	public Studente[] getStudenti() {
		return studenti;
	}

	public void setStudenti(Studente studenti[]) {
		this.studenti = studenti;
	}
	
    // Metodo che si occupa di iscrivere (aggiungere all'array) uno Studente
	// Riceve nome, cognome e matricola oppure uno Studente?
	// Dipende, in questo caso possiamo scegliere noi, dipende da dove lo 
	// Studente viene creato, qui oppure la dove il metodo iscrivi() viene invocato

	public void iscrivi(Studente s){
		
		// Tengo traccia di dove inserire con un indice
		
		studenti[numeroStudentiIscritti] = s;
		numeroStudentiIscritti++;
		
		// Alternativa: scandisco l'array alla ricerca della prima cella a null
	}
	
	public int getNumeroStudentiIscritti(){
		return numeroStudentiIscritti;
	}
	
}
