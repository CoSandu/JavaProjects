package casaeditrice;

import java.util.*;

public class Autore implements Comparable<Autore>{

	private String nome;
	private String cognome;
	private String email;
	private int codice;
	
	private List<Pubblicazione>pubblicazioni = new LinkedList<Pubblicazione>();

	public Autore(int codice, String nome, String cognome, String email) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		
	}

	public String getNome(){
		return nome;
	}

	public String getCognome(){
		return cognome;
	}

	public String getEmail(){
		return email;
	}
	
	public int getCodice(){
		return codice;
	}
	
	public Pubblicazione aggiungiPubblicazione(String titolo, char tipologia, String volume, int anno, int contributo) {
		if(tipologia=='P'){
			Pubblicazione p = new Pubblicazione( titolo, tipologia, volume, anno, contributo);
			pubblicazioni.add(p);
			p.setProprietario(this, contributo);
			return p;
		}
		else if(tipologia=='R'){
			Rivista p = new Rivista(titolo, tipologia, volume, anno, contributo);
			pubblicazioni.add(p);
			p.setProprietario(this, contributo);
			return p;
		}
		else if(tipologia=='C'){
			Conferenza p = new Conferenza(titolo, tipologia, volume, anno, contributo);
			pubblicazioni.add(p);
			p.setProprietario(this, contributo);
			return p;
		}
		return null;
	}
	
	public Collection<Pubblicazione> elencoPubblicazioni(){
		List<Pubblicazione>elencoanno = new LinkedList<Pubblicazione>(pubblicazioni);
		Collections.sort(elencoanno);
		return elencoanno;
	}

	@Override
	public int compareTo(Autore a) {
		if(this.getNome().compareTo(a.getNome())==0){
			return this.getNome().compareTo(a.getNome());
		}
		return this.getCognome().compareTo(a.getCognome());
	}

	public void aggiungiPubblicazione(Pubblicazione pubblicazione) {
		if(pubblicazioni.contains(pubblicazione)==false){
			pubblicazioni.add(pubblicazione);
		}
		
	}
	
}
