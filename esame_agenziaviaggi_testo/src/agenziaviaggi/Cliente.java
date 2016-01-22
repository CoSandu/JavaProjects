package agenziaviaggi;

import java.util.*;

public class Cliente implements Comparable<Cliente>{
	
	private String cognome;
	private String nome;
	private String indirizzo;
	
	private List<String>contatti = new LinkedList<String>();
	private Map<Integer, Pratica>pratiche = new HashMap<Integer, Pratica>();
	
	public Cliente(String cognome, String nome, String indirizzo) {
		this.cognome = cognome;
		this.nome = nome;
		this.indirizzo = indirizzo;
			
	}

	public String getCognome(){
		return cognome;
	}
	
	public String getNome(){
		return nome;
	}
	
	public String getIndirizzo(){
		return indirizzo;
	}

	public void aggiungiContatto(String contatto){
		boolean trovato = false;
		if (contatto != null){
			for (String c:contatti){
				if (c.compareToIgnoreCase(contatto)==0){
					trovato = true;
				}
			}
			
		if(trovato==false){
			contatti.add(contatto);
		}
		}
		
	}

	public Collection<String> elencoContatti(){
		return contatti;
	}

	public Collection<Pratica> elencoPratiche(){
		LinkedList<Pratica> elencoP = new LinkedList<Pratica>(pratiche.values());
		Collections.sort(elencoP);
		return elencoP;
	}

	public int compareTo(Cliente a) {
		if(this.getCognome().compareTo(a.getCognome())!=0){
			return this.getCognome().compareTo(a.getCognome());
		}
		else if(this.getNome().compareTo(a.getNome())!=0){
			return this.getNome().compareTo(a.getNome());
		}
		return this.getIndirizzo().compareTo(a.getIndirizzo());
	}
	
	public String toString(){
		return cognome + nome + indirizzo; 
	}

	public void aggiungiPratica(Pratica tempp) {
		pratiche.put(tempp.getIdPratica(), tempp);
		
	}

	public void eliminaPratica(int idPratica) {
		pratiche.remove(idPratica);
		
	}
}
