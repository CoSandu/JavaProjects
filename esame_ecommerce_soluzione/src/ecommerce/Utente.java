package ecommerce;
import java.util.*;

public class Utente {

	private int codice;
	private String nome;
	private String cognome;
	private String email;
	private String indirizzo;
	
	protected Map<String,Integer> carrello = new TreeMap<String,Integer>();
	protected int valoreCarrello = 0;

	
	public Utente(int codice, String nome, String cognome, String email, String indirizzo){
		this.codice=codice;
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
		this.indirizzo=indirizzo;
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
		
		if(carrello.containsKey(prodotto.getCodice())){
			int quantita = carrello.get(prodotto.getCodice());
			quantita++;
			carrello.put(prodotto.getCodice(), quantita);
		}
		else
			carrello.put(prodotto.getCodice(), 1);
			
		valoreCarrello+=prodotto.getPrezzo();
	}
	
	public double paga(String data){
		carrello.clear();
		int risultato = valoreCarrello;
		valoreCarrello = 0;
		return risultato;
	}
	
	public Map<String,Integer> getCarrello(){
		return carrello;
	}
	
}
