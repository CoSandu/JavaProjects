package libreria;

import java.io.*;
import java.util.*;

public class Libreria {

	TreeMap<String, Editore> editori = new TreeMap<String, Editore>();
	ArrayList<Libro> libri = new ArrayList<Libro>();
	ArrayList<Ordine> ordini = new ArrayList<Ordine>();
	
    public Editore creaEditore(String nome, int tempoConsegna, String email){
        
    	// Creo l'oggetto di tipo Editore
    	Editore etemp = new Editore(nome, tempoConsegna, email);
    	
    	// Lo aggiungo alla struttura dati
    	editori.put(nome, etemp);

    	// Restituisco l'oggetto creato
    	return etemp;
    }

    public Editore getEditore(String nome){
    	return(editori.get(nome)); // Sfrutto la mappa, ed il fatto che sia facile ottenere l'el. data la chiave
    }

    public Collection getEditori(){
    	// Deve restituire una collezione di Editori ord. per nome
    	return editori.values(); // Metodo che restituisce la colonna dei valori (ord. per chiave, se TreeMap)
    }

    public Libro creaLibro(String titolo, String autore, int anno, double prezzo, String nomeEditore)
    			throws EditoreInesistente {
    	
    	Editore editore = editori.get(nomeEditore);
    	
    	// Se l'editore il cui nome e' stato passato come parametro non esiste, in editore ci sara' null
    	if(editore==null)
    		throw new EditoreInesistente(); // Scateno un'eccezione
    	
    														// non passo il nome, ma direttamente l'oggetto Editore
    	//Libro ltemp = new Libro(titolo, autore, anno, prezzo, editore );
    	
    																// per passare al Libro un rif. all'oggetto corrente
    	Libro ltemp = new Libro(titolo, autore, anno, prezzo, editore, this );
    	
    	libri.add(ltemp);
    	
        return ltemp;
    }
    
    public Libro getLibro(String autore, String titolo){
        
    	for(int i=0;i<libri.size();i++){
    		
    		Libro l = libri.get(i);
    		
    		// In l ho l'oggetto i-esimo, scrivo l'algoritmo di ricerca
    		if( (autore == null || autore.compareTo(l.getAutore())==0) &&
    			(titolo == null || titolo.compareTo(l.getTitolo())==0) ) 
    			return l;
    	}
    	return null; // Libro non trovato
    }
    
    public Collection getClassificaSettimana(int settimana){

    	// Creo una copia della lista visto che mi serviranno ordinamenti diversi
    	ArrayList<Libro> altraLista = new ArrayList<Libro>(libri);
    	
    	// Creo un comparatore "al volo", anonimo, senza definire la classe in un altro file
    	Collections.sort(altraLista, new Comparator<Libro>(){
    		
    		public int compare(Libro a, Libro b){
    			return -(a.settimane[settimana-1]-b.settimane[settimana-1]); // Posso accedere al param. settimana
    		}
    		
    	});
    	
    	return altraLista;
    
    }
    
    public Collection getClassificaMese(final int mese){

    	// Stesso codice del metodo getClassificaSettimana(), sost. settiman* con mes*
    	
    	ArrayList<Libro> altraLista = new ArrayList<Libro>(libri);
    	
    	Collections.sort(altraLista, new Comparator<Libro>(){
    		
    		public int compare(Libro a, Libro b){
    			return -(a.mesi[mese-1]-b.mesi[mese-1]); // Posso accedere al param. settimana
    		}
    		
    	});
    	
    	return altraLista;
    }
    
    // Metodo aggiunto per gestire la creazione di ordini dalla classe Libro (delega)
    public void creaOrdine(Libro libro, int quantitaRiordino){
    	Ordine otemp = new Ordine(ordini.size(), libro, quantitaRiordino);
    	ordini.add(otemp);
    }
    
    public Collection getOrdini(){
        return ordini;
    }
    
    public void ordineRicevuto(int numOrdine){
    	Ordine otemp = ordini.get(numOrdine);
    	otemp.consegna();
    }
    
    public void leggi(String file) {
    	
    	try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String riga;
			while((riga=br.readLine())!=null){
				// Qui ho una riga
				StringTokenizer st = new StringTokenizer(riga, ";"); // Al posto di split()
				
				try{ // COn questo try-catch gestisco gli errori puntuali sulle singole righe del file 
					
					String type = st.nextToken(); // Metodo che restituisce la stringa/il token successivo nella riga
					
					if(type.compareTo("E")==0){
						// E' un editore
						
						String nome = st.nextToken(); 
						int tempoConsegna = Integer.parseInt(st.nextToken());
						String email = st.nextToken();
						
						// Qui posso usare le info lette per creare un Editore e aggoiungerlo alla struttura dati
						creaEditore(nome, tempoConsegna, email); // Uso il metodo definito in precedenza
						
					}
					else if(type.compareTo("L")==0){
						//E' un libro
						
						String titolo = st.nextToken(); 
						String autore = st.nextToken(); 
						int anno = Integer.parseInt(st.nextToken());
						double prezzo = Double.parseDouble(st.nextToken());
						String nomeEditore = st.nextToken();
						int quantita = Integer.parseInt(st.nextToken());
						
						Libro ltemp = this.creaLibro(titolo, autore, anno, prezzo, nomeEditore);
						ltemp.setQuantita(quantita);
	
					}
				}
				catch(Exception nfe){ // Mi aspetto NumberFormatException nella conversione da String a Integer
					System.out.println("Eccezione nella gestione di una riga!");
					//nfe.printStackTrace();
				}
				
				
			}
    	
    	
    	} catch (Exception e) {
			System.out.println("Eccezione generica!");
			//e.printStackTrace();
		}
    }
}
