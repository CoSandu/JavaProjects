package ecommerce;

import java.io.*;
import java.util.*;

public class Sito {
	
	private int contaProdotti = 100;
	private String categoria;
	
	private List<String>categorie = new LinkedList<String>();
	
	private Map<String, Prodotto>prodotti = new HashMap<String, Prodotto>();
	
	private int contaUtenti = 1;
	private Map<Integer, Utente>utenti = new HashMap<Integer, Utente>();

	
	
	public void nuovaCategoria(String nomeCategoria){
		this.categoria=nomeCategoria;
		categorie.add(nomeCategoria);
	}

	public Collection<String> elencoCategorie(){
		List<String> ordAlfa = new LinkedList<String>(categorie);
		Collections.sort(ordAlfa, new Comparator<String>(){
			public int compare(String a, String b) {
				return (int) (a.compareTo(b)-b.compareTo(a));
			}
		});
		return ordAlfa;
		
	}
	
	public String nuovoProdotto(String nomeCategoria, String nomeProdotto, String descrizione, double prezzo){
		if(!categorie.contains(nomeCategoria)){
			this.nuovaCategoria(nomeCategoria);

		}
		String codAlfaProddoto =  nomeCategoria.substring(0, 1)+"00"+contaProdotti;
		Prodotto p = new Prodotto(codAlfaProddoto, nomeCategoria, nomeProdotto, descrizione, prezzo);
		prodotti.put(codAlfaProddoto, p);
		contaProdotti++;
		return p.getCodice();
	}
	
	public Prodotto cercaProdotto(String stringaRicerca){
		if(prodotti.containsKey(stringaRicerca)){
			return prodotti.get(stringaRicerca);
		}
		return null;
	}
	
	public Collection<Prodotto> elencoProdottiPerNome(){
		List<Prodotto>elenconome = new LinkedList<Prodotto>(prodotti.values());
		Collections.sort(elenconome);
		return elenconome;
	}

	public Collection<Prodotto> elencoProdottiPerPrezzo(){
		List<Prodotto>elencoprezzo = new LinkedList<Prodotto>(prodotti.values());
		Collections.sort(elencoprezzo, new ComparatoreProdottiPrezzo());
		return elencoprezzo;
	}
	
	public Collection<Prodotto> elencoProdottiPerNome(String nomeCategoria){
		List<Prodotto>elenconome = new LinkedList<Prodotto>(prodotti.values());
		List<Prodotto>catnome = new LinkedList<Prodotto>();
		for(Prodotto p:elenconome){
			if(p.getCategoria().compareTo(nomeCategoria)==0){
				catnome.add(p);
			}
		}
		Collections.sort(catnome);
		return catnome;
	}

	public Collection<Prodotto> elencoProdottiPerPrezzo(String nomeCategoria){
		List<Prodotto>elenconome = new LinkedList<Prodotto>(prodotti.values());
		List<Prodotto>catnome = new LinkedList<Prodotto>();
		for(Prodotto p:elenconome){
			if(p.getCategoria().compareTo(nomeCategoria)==0){
				catnome.add(p);
			}
		}
		Collections.sort(catnome, new ComparatoreProdottiPrezzo());
		return catnome;
	}
	
	public void nuovoUtente(String nome, String cognome, String email, String indirizzo){
		boolean trovato = false;
		List<Utente>valutenti = new LinkedList<Utente>(utenti.values());
		Utente u = new Utente(contaUtenti, nome, cognome, email, indirizzo);
		for(Utente ut:valutenti){
			if(ut!=null && ut.getEmail().compareToIgnoreCase(u.getEmail())!=0){
				trovato = true;
			}			
		}
		if (trovato == false){
			utenti.put(contaUtenti, u);
			contaUtenti++;	
		}
	}
	
	public void nuovoUtente(String nome, String cognome, String email, String indirizzo, String username, String password){
		boolean trovato = false;
		List<UtenteRegistrato>valutenti = new LinkedList<UtenteRegistrato>();
		UtenteRegistrato u = new UtenteRegistrato(contaUtenti, nome, cognome, email, indirizzo, username, password);
		for(Utente ut:valutenti){
			if(ut!=null && ut.getEmail().compareToIgnoreCase(u.getEmail())!=0){
				trovato = true;
			}			
		}
		if (trovato == false){
			utenti.put(contaUtenti, u);
			contaUtenti++;	
		}
	}
	
	public Utente cercaUtente(int codiceUtente) throws EccezioneUtenteInesistente{
		if(utenti.containsKey(codiceUtente)==false){
			throw new EccezioneUtenteInesistente();
		}
		
		return utenti.get(codiceUtente);
	}
	
	public String dettagliCarrello(int codiceUtente) throws EccezioneUtenteInesistente{
		String carrello = "";
		if(utenti.containsKey(codiceUtente)){
			carrello += utenti.get(codiceUtente).carrello();	
		}
		else{
			throw new EccezioneUtenteInesistente();
		}
		return carrello;
		
	}
	
    public void leggiFile(String file)throws IOException{
    	
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
