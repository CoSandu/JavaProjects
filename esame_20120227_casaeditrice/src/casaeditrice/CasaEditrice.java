package casaeditrice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CasaEditrice {
	
	private int codnum = 10000;
	private Map<Integer, Autore>autori = new HashMap<Integer, Autore>();


	public Autore definisciAutore(String nome, String cognome, String email){
		Autore at = new Autore(codnum, nome, cognome, email);
		autori.put(codnum, at);
		codnum++;
		return at;
	}
	
	public Collection<Autore> elencoAutori(){
		List<Autore>aut = new LinkedList<Autore>(autori.values());
		Collections.sort(aut);
		return aut;
	}
	
	public Autore getAutore(int codice){
		if(autori.containsKey(codice)){
			return autori.get(codice);
		}
		return null;
    }

	public Autore getAutore(String nome, String cognome){
		List<Autore>aut = new LinkedList<Autore>(autori.values());
		for(Autore a:aut){
			if(a.getNome().compareToIgnoreCase(nome)==0 &&
					a.getCognome().compareToIgnoreCase(cognome)==0){
				return a;
			}
		}
     	return null;
	}

	public Collection<Pubblicazione> pubblicazioniAutore(String nome, String cognome) throws AutoreInesistenteException {
		Autore autor = this.getAutore(nome, cognome);
		if (autor == null){
			throw new AutoreInesistenteException();
		}
		else{
			List<Autore>aut = new LinkedList<Autore>(autori.values());
			for(Autore a:aut){
				if (a.getNome().compareToIgnoreCase(autor.getNome())==0 && a.getCognome().compareToIgnoreCase(autor.getCognome())==0){
					return a.elencoPubblicazioni();
				}
			}
		}
		return null;
	}
	
	public void leggiPubblicazioni(String nomeFile) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;
		Pubblicazione p=null;
		boolean primo=false;
		
		String titolo=null;
		String tipologia=null;
		String volume=null;
		String anno=null;
		
		while ((linea = in.readLine()) != null) {
			
			try {
			    StringTokenizer st = new StringTokenizer(linea, ";");
			    String iniziale = st.nextToken().trim();
			    if (iniziale.toUpperCase().equals("P")) 
			    {
			       titolo = st.nextToken().trim();
			       tipologia = st.nextToken().trim();
			       volume = st.nextToken().trim();
			       anno = st.nextToken().trim();
			       primo=true;
			    } 
			    else 
			    {
			       
			       String nome = st.nextToken().trim();
			       String cognome = st.nextToken().trim();
			       String email = st.nextToken().trim();
			       String contributo = st.nextToken().trim();
			       
			       Autore a;
			       if(getAutore(nome, cognome)!=null)
			    	   a = getAutore(nome, cognome);
			       else 
			    	   a = definisciAutore(nome, cognome, email);
			       
			       if(primo==true)
			       {
			    	   p = a.aggiungiPubblicazione(titolo, tipologia.charAt(0), volume, Integer.parseInt(anno), Integer.parseInt(contributo));
				       primo=false;
			       }
			       else
			       {
			    	   p.aggiungiCoautori(a, Integer.parseInt(contributo));
			       }
			       
			    }
			} 
			catch (Exception e) {
			    //System.err.println("Errore");
				e.printStackTrace();
				
			    
			}
			
		}
		in.close();
	}
		
	

}
