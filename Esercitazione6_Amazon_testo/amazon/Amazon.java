package amazon;

import java.util.Collection;
import java.util.*;

public class Amazon {
	
	Map<Integer, Prodotto>prodotti = new HashMap<Integer, Prodotto>();

	public int aggiungiProdotto(String nome, String descrizione, double prezzo){
		Prodotto p = new Prodotto(nome, descrizione, prezzo);
		prodotti.put(p.getCodice(), p);
		return p.getCodice();
	}
	
	public Prodotto getProdotto(int codiceProdotto) throws ErrProdottoInesistente{
		if (prodotti.containsKey(codiceProdotto)){
			return prodotti.get(codiceProdotto);
		}
		throw new ErrProdottoInesistente();
	}
	
	public void impostaDisponibilitaProdotto(int codiceProdotto, int disponibilita) throws ErrProdottoInesistente{
	}
	
	public String creaAccount(String nome, String cognome, String userName, String password) throws ErrAccountGiaEsistente{
		return null;
	}
	
	public Account getAccount(String userName, String password) throws ErrDatiErrati{
		return null;
	}
	
	public void aggiungiIndirizzoAdAccount(Account a, String indirizzoSpedizione){
	}
	
	public void aggiungiProdottoACarrelloAccount(Account a, Prodotto p, int quantita){
	}
	
	public Collection<Prodotto> elencoProdottiPerImportoCrescente(){
		return null;
	}

}


