package ecommerce;

import java.util.*;
import java.io.*;

public class Sito {

	private int prossimoNumeroProgressivoProdotto = 100;
	private int prossimoNumeroProgressivoUtente = 1;

	private Map<String,String> categorie = new TreeMap<String,String>();
	private Map<String, Prodotto> prodotti = new TreeMap<String,Prodotto>();
	private Map<Integer, Utente> utenti = new TreeMap<Integer,Utente>();
	
	
	public void nuovaCategoria(String nomeCategoria){
		String iniziale = nomeCategoria.substring(0,1);
		categorie.put(iniziale, nomeCategoria);		
	}

	public Collection<String> elencoCategorie(){
		LinkedList<String> ltemp = new LinkedList<String>(categorie.values());
		Collections.sort(ltemp);
		return ltemp;
	}
	
	public String nuovoProdotto(String nomeCategoria, String nomeProdotto, String descrizione, double prezzo){
		
		if(!categorie.containsKey(nomeCategoria.substring(0,1)))
			nuovaCategoria(nomeCategoria);
		
		String codiceProdotto;
		int numeroProgressivo = prossimoNumeroProgressivoProdotto;
		prossimoNumeroProgressivoProdotto++;
		if(numeroProgressivo<1000)
			codiceProdotto="00"+numeroProgressivo;
		else if(numeroProgressivo<10000)
			codiceProdotto="0"+numeroProgressivo;
		else if(numeroProgressivo<1000)
			codiceProdotto=""+numeroProgressivo;
		else
			codiceProdotto=""+numeroProgressivo;
		codiceProdotto=""+nomeCategoria.substring(0,1).toUpperCase()+codiceProdotto;
		
		Prodotto ptemp = new Prodotto(codiceProdotto, nomeProdotto, descrizione, prezzo);
		prodotti.put(codiceProdotto, ptemp);
		return codiceProdotto;
	}
	
	public Prodotto cercaProdotto(String stringaRicerca){
		
		for(Prodotto ptemp : prodotti.values()){
			
			if(ptemp.getCodice().toUpperCase().contains(stringaRicerca.toUpperCase()) || 
			   ptemp.getNome().toUpperCase().contains(stringaRicerca.toUpperCase()) ||
			   ptemp.getDescrizione().toUpperCase().contains(stringaRicerca.toUpperCase()))
				return ptemp;
		}
		return null;
	}
	
	public Collection<Prodotto> elencoProdottiPerNome(){
		
		LinkedList<Prodotto> ltemp = new LinkedList<Prodotto>(prodotti.values());
		Collections.sort(ltemp,new Prodotto.ComparatoreDiProdottiPerNome());
		return ltemp;

	}

	public Collection<Prodotto> elencoProdottiPerPrezzo(){
		
		LinkedList<Prodotto> ltemp = new LinkedList<Prodotto>(prodotti.values());
		Collections.sort(ltemp,new Prodotto.ComparatoreDiProdottiPerPrezzo());
		return ltemp;
	}
	
	
	public Collection<Prodotto> elencoProdottiPerNome(String nomeCategoria){
		
		LinkedList<Prodotto> ltemp = new LinkedList<Prodotto>();
		for(Prodotto ptemp : prodotti.values())
			if(ptemp.getCodice().substring(0,1).compareTo(nomeCategoria.substring(0,1))==0)
				ltemp.add(ptemp);
		
		Collections.sort(ltemp,new Prodotto.ComparatoreDiProdottiPerNome());
		return ltemp;

	}

	public Collection<Prodotto> elencoProdottiPerPrezzo(String nomeCategoria){
		
		LinkedList<Prodotto> ltemp = new LinkedList<Prodotto>();
		for(Prodotto ptemp : prodotti.values())
			if(ptemp.getCodice().substring(0,1).compareTo(nomeCategoria.substring(0,1))==0)
				ltemp.add(ptemp);

		Collections.sort(ltemp,new Prodotto.ComparatoreDiProdottiPerPrezzo());
		return ltemp;
	}
	
	
	public void nuovoUtente(String nome, String cognome, String email, String indirizzo){

		boolean trovato=false;
		for(Utente utente : utenti.values())
			if(utente.getEmail().compareTo(email)==0)
				trovato = true;
		
		if(trovato==false)
		{
			int codiceUtente = prossimoNumeroProgressivoUtente;
			prossimoNumeroProgressivoUtente++;
			Utente utemp = new Utente(codiceUtente, nome, cognome, email, indirizzo);
			utenti.put(codiceUtente, utemp);
		}
		
		
	}
	
	public void nuovoUtente(String nome, String cognome, String email, String indirizzo, String username, String password){
		boolean trovato=false;
		for(Utente utente : utenti.values())
			if(utente.getEmail().compareTo(email)==0)
				trovato = true;
		
		if(trovato==false)
		{
			int codiceUtente = prossimoNumeroProgressivoUtente;
			prossimoNumeroProgressivoUtente++;
			UtenteRegistrato utemp = new UtenteRegistrato(codiceUtente, nome, cognome, email, indirizzo, username, password);
			utenti.put(codiceUtente, utemp);
		}
	
	}
	
	public Utente cercaUtente(int codiceUtente) throws EccezioneUtenteInesistente{
		if(utenti.containsKey(codiceUtente))
			return utenti.get(codiceUtente);
		else
		{
			throw new EccezioneUtenteInesistente();
		}
	}
	
	
	
	
	
	
	public String dettagliCarrello(int codiceUtente) throws EccezioneUtenteInesistente{
		
		Utente utemp = cercaUtente(codiceUtente);
		
		String risultato="";
		int i=0;
		
		for(String codiceProdotto : utemp.getCarrello().keySet())
		{
			Prodotto p = prodotti.get(codiceProdotto);
			
			int quantita = utemp.getCarrello().get(codiceProdotto);
			if(i!=0)
				risultato+= "\n "+codiceProdotto+" "+p.getPrezzo()+" "+quantita;
			else
				risultato+= " "+codiceProdotto+" "+p.getPrezzo()+" "+quantita;
			i++;
		}
			
		return risultato;
	}
	
	
    public void leggiFile(String file){
    	
    	try 
    	{
			Reader r = new FileReader(file);
			BufferedReader br = new BufferedReader(r);
			String riga;
			
			while((riga=br.readLine())!=null){

				// Qui ho una riga
				StringTokenizer st = new StringTokenizer(riga,";");
				
				// Con questo blocco try-catch gestisco gli errori puntuali, scartando (ignorando) le righe errate
				try{

					// Alla prima invocazione, st restituisce il primo token, in questo caso il tipo della riga (P o U)
					String type = st.nextToken();

					if(type.equals("P")){
						// Se sono qui e' la riga che descrive un prodotto
						String nomeCategoria = st.nextToken();
						String nomeProdotto = st.nextToken(); 
						String descrizione = st.nextToken();
						Double prezzo = Double.parseDouble(st.nextToken());
						this.nuovoProdotto(nomeCategoria, nomeProdotto, descrizione, prezzo);
					}
					else if(type.equals("U")){
						// Se sono qui e' la riga che descrive un utente
						String nome = st.nextToken();
						String cognome = st.nextToken();
						String email = st.nextToken();
						String indirizzo = st.nextToken();
						if(st.hasMoreTokens()){
							// Allora e' un utente registrato
							String username = st.nextToken();
							String password = st.nextToken();
							this.nuovoUtente(nome, cognome, email, indirizzo, username, password);
						}
						else{
							// Altrimento no
							this.nuovoUtente(nome, cognome, email, indirizzo);
						}
					
					
					}
				}
				catch(Exception e){
					// e.printStackTrace();
				}
			}

	    	br.close();
	    	r.close();
			
    	} catch (Exception e) {
    		// e.printStackTrace();
		}
    	
    }	
	
	
	
	
}
