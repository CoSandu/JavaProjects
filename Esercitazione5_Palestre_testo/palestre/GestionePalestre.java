package palestre;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class GestionePalestre {
	
	Map<String,Persona> clienti = new HashMap<String,Persona>();
	Map<String,PersonalTrainer> pTrainer = new HashMap<String,PersonalTrainer>();
	
	public boolean presente(Persona p){
		if (p.getCognome()==null || p.getCognome().length()==0
				|| p.getNome()==null ||p.getNome().length()==0
				|| p.getCodiceFiscale()==null ||p.getCodiceFiscale().length()==0
				|| clienti.containsKey(p.getCodiceFiscale())){
			return true;	
		}
		return false;
	}
	
	public Persona aggiungiPersona(String nome, String cognome, String cf) {
		Persona p = new Cliente (nome, cognome, cf);
		if (this.presente(p)==false){
			clienti.put(cf, p);
			return p;
		}
		return null;
	}

	public Persona getPersona(String cf) throws ErrPersonaInesistente {
		if (clienti.containsKey(cf)){
			return clienti.get(cf);
		}
			throw new ErrPersonaInesistente();
	}
	
	public boolean getCodTrain(Persona t){
		for (PersonalTrainer v : pTrainer.values()){
			if(v.getCodiceFiscale().equalsIgnoreCase(t.getCodiceFiscale())){
				return true;
			}
		}
		return false;
	}
	
	
	public boolean presenteTrainer(Persona t){
		if (t.getCognome()==null || t.getCognome().length()==0
				|| t.getNome()==null ||t.getNome().length()==0
				|| t.getCodiceFiscale()==null ||t.getCodiceFiscale().length()==0
				|| this.getCodTrain(t) == true
				|| pTrainer.containsKey(((Trainer) t).getMatricola())){
			return true;	
		}
		return false;
	}


	public PersonalTrainer aggiungiPersonalTrainer(String matricola, String nome, String cognome, String cf) {
		Trainer t = new Trainer (nome, cognome, cf, matricola);
		if (this.presenteTrainer(t)==false){
			pTrainer.put(matricola, t);
			clienti.put(cf, t);
			return t;
		}
		return null;
	}

	public PersonalTrainer getPersonalTrainer(String matricola) throws ErrPersonalTrainerInesistente {
		if (pTrainer.containsKey(matricola)){
			return (Trainer) pTrainer.get(matricola);
		}
			throw new ErrPersonalTrainerInesistente();
	}

	public void assegnaPersonalTrainer(String matricola, String cf) throws ErrPersonaInesistente, ErrPersonalTrainerInesistente {
		if (pTrainer.containsKey(matricola)==false){ 
			throw new ErrPersonalTrainerInesistente();
		}
		if (clienti.containsKey(cf)==false){ 
			throw new ErrPersonaInesistente();
		}
		if (pTrainer.get(matricola).getCodiceFiscale().compareToIgnoreCase(cf)!=0){
			((Cliente) clienti.get(cf)).setTrainer(pTrainer.get(matricola));
			((Trainer) pTrainer.get(matricola)).setCliente((Cliente) clienti.get(cf));
		}
	}

	public String caricaDati(String nomeFile) throws IOException {
		// modificare sostituendo a X, Y, Z i valori corretti
		return "Numero di righe correttamente elaborate: X - numero di righe scartate: Y - numero di righe totali: Z";
	}
  
}
