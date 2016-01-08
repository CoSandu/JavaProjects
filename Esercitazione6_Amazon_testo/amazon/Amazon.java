package amazon;

import java.util.Collection;
import java.util.*;

public class Amazon {
	
	Map<Integer, Prodotto>prodotti = new HashMap<Integer, Prodotto>();
	Map<String, Account>accounts = new HashMap<String, Account>();

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
		if (prodotti.containsKey(codiceProdotto)){
			prodotti.get(codiceProdotto).setDisponibilita(disponibilita);
		}
		else {
			throw new ErrProdottoInesistente();
		}
	}
	
	public String creaAccount(String nome, String cognome, String userName, String password) throws ErrAccountGiaEsistente{
		if (accounts.containsKey(userName)==false){
			Account a = new Account(nome, cognome, userName, password);
			accounts.put(a.getUserName(), a);
			return a.getUserName();
		}
		throw new ErrAccountGiaEsistente();
	}
	
	public Account getAccount(String userName, String password) throws ErrDatiErrati{
		if(accounts.containsKey(userName) && 
				accounts.get(userName).getPassword().compareTo(password)==0){
			return accounts.get(userName);
		}
		throw new ErrDatiErrati();
	}
	
	public void aggiungiIndirizzoAdAccount(Account a, String indirizzoSpedizione){
		if(a.elencoIndirizziSpedizione().contains(indirizzoSpedizione)==false){
			a.elencoIndirizziSpedizione().add(indirizzoSpedizione);
		}		
	}
	
	public void aggiungiProdottoACarrelloAccount(Account a, Prodotto p, int quantita){
		if(p.getDisponibilita()>=quantita){
			a.setCarrello(p, quantita);
		}
		else{
			System.out.println("Prodotti insufficienti");
		}
		
	}
	
	public Collection<Prodotto> elencoProdottiPerImportoCrescente(){
		return null;
	}

}


