package palestre;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GestionePalestre {
	
	Map<String,Clienti> clienti = new HashMap<String,Clienti>();
	
	public Persona aggiungiPersona(String nome, String cognome, String cf) {
		Clienti p = new Clienti (nome, cognome, cf);
		clienti.put(cf, p);
		return p;
	}

	public Persona getPersona(String cf) throws ErrPersonaInesistente {
		return null;
	}

	public PersonalTrainer aggiungiPersonalTrainer(String matricola, String nome, String cognome, String cf) {
		return null;
	}

	public PersonalTrainer getPersonalTrainer(String matricola) throws ErrPersonalTrainerInesistente {
		return null;
	}

	public void assegnaPersonalTrainer(String matricola, String cf) throws ErrPersonaInesistente, ErrPersonalTrainerInesistente {
	}

	public String caricaDati(String nomeFile) throws IOException {
		// modificare sostituendo a X, Y, Z i valori corretti
		return "Numero di righe correttamente elaborate: X - numero di righe scartate: Y - numero di righe totali: Z";
	}
  
}
