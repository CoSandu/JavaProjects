package ecommerce;

import java.util.*;

public class Utente {

	private int codice;
	private String nome;
	private String cognome;
	private String email;
	private String indirizzo;
	
	
	private Map<String,Prodotto>carrello = new HashMap<String,Prodotto>();

	public Utente(int codice, String nome, String cognome, String email, String indirizzo) {
		this.codice = codice;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.indirizzo = indirizzo;
	}

	public int getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public String getEmail() {
		return email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void selezionaProdotto(Prodotto prodotto){
		if(prodotto!=null){
			carrello.put(prodotto.getCodice(),prodotto);

		}
		
	}
	
	public double paga(String data){
		double totale = 0;
		List<Prodotto>prodottiutente = new LinkedList<Prodotto>(carrello.values());
		for(Prodotto p:prodottiutente){
			totale += p.getPrezzo();
		}
		return totale;
	}

	public String carrello() {
		String prod = "\n";
		List<Prodotto>prodottiutente = new LinkedList<Prodotto>(carrello.values());
		for(Prodotto p:prodottiutente){
			prod += p.toString();
		}
		return prod;
	}

}
