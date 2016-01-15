package supermercato;

import java.util.*;
import java.lang.*;

public class Supermercato {
	
	private Map<String,Corsia> corsie = new HashMap<String,Corsia>();
	private Map<String,Prodotto> prodotti = new HashMap<String,Prodotto>();
	
	private int primoCodScontrino = 1000;
	private Map<Integer, Scontrino> scontrini = new HashMap<Integer, Scontrino>();

	public void aggiungiCorsia(String nome, int capienzaMassima){
		if (corsie.containsKey(nome)==false){
			Corsia c = new Corsia(nome, capienzaMassima);
			corsie.put(nome, c);
		}
	}
	
	public Collection<Corsia> getCorsie(){
		Collection<Corsia> corsia = corsie.values();
		List<Corsia> corsieListate = new LinkedList<Corsia>(corsia);
		return corsieListate;
	}
	
	public Prodotto catalogaProdotto(String codiceProdotto, String nomeProdotto, int volume, boolean daFrigo){
		if (daFrigo == true){
			Prodotto pF = new ProdottoDaFrigo(codiceProdotto, nomeProdotto, volume, daFrigo);
			prodotti.put(codiceProdotto, pF);
			return pF;
		}
		else if (prodotti.containsKey(codiceProdotto)==false){
			Prodotto p = new Prodotto(codiceProdotto, nomeProdotto, volume, daFrigo);
			prodotti.put(codiceProdotto, p);
			return p;			
		}
		return null;
	}	
	
	public Collection<Prodotto> elencoProdotti(){
		Collection<Prodotto> prodottiValori = prodotti.values();
		List<Prodotto> prodottiPrezzo = new LinkedList<Prodotto>(prodottiValori);
		Collections.sort(prodottiPrezzo);
		return prodottiPrezzo; 
	}
	
	public Prodotto cercaProdotto(String codiceProdotto) throws ProdottoInesistenteException{
		Prodotto risulato = null;
		if (prodotti.containsKey(codiceProdotto)){
			risulato = prodotti.get(codiceProdotto);
		}
		else{
			throw new ProdottoInesistenteException();
		}
		return risulato;
	}
	
	public void esponiProdotto(String nomeCorsia, Prodotto prodotto, int quantita){
		Corsia c = corsie.get(nomeCorsia);
		int capienza = c.getCapienzaMassima();
		int volumeProd = prodotto.getVolume();
		if ((volumeProd*quantita)<=capienza){
			c.setProdottiCorsia(prodotto, quantita);		
		}
		
	}

	public int calcolaPercentualeDiOccupazione(String nomeCorsia){
		Corsia att =  corsie.get(nomeCorsia);
		return (int)((double)att.getTotOccupato()/(double)att.getCapienzaMassima()*100); 
	}
	
	public Collection<String> elencoCodiciProdottoPerCorsia(String nomeCorsia){
		Corsia att = corsie.get(nomeCorsia);
		List<String> codici = new LinkedList<String>();
		for (Prodotto p:att.getProdottiCorsia()){
			codici.add(p.getCodice());
		}
		return codici;
	}

	public int quantitaProdottoEsposto(Prodotto prodotto, String nomeCorsia){
		Corsia att = corsie.get(nomeCorsia);
		return att.getQuantitaCorsia(prodotto);
	}
	
	public int quantitaProdottoEsposto(Prodotto prodotto){
		int ris = 0;
		for (Corsia c:corsie.values()){
			ris += c.getQuantitaCorsia(prodotto);
		}
		return ris;
	}
	
	public int apriScontrino(){
		int scontrinoAttuale = primoCodScontrino;
		Scontrino s = new Scontrino(scontrinoAttuale);
		scontrini.put(scontrinoAttuale, s);
		primoCodScontrino++;
		return scontrinoAttuale;
	}
	
	public void acquistaProdotto(int codiceScontrino, Prodotto prodotto, String nomeCorsia, int quantita) throws CorsiaInesistenteException{
		Scontrino s = scontrini.get(codiceScontrino);
		Corsia c = corsie.get(nomeCorsia);
		
		if (c==null){
			throw new CorsiaInesistenteException();
		}
		

	}
	
	public String dettagliScontrino(int codiceScontrino){
		return null;
	}
	
	public double chiudiScontrino(int codiceScontrino) throws ProdottoInesistenteException{
		return -1.0;
	}
	
	public void leggiFile(String nomeFile) {

	}	
	
}
