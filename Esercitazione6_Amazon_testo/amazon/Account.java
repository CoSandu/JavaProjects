package amazon;

import java.util.Collection;
import java.util.*;

public class Account {
	
	private String Nome;
	private String Cognome;
	private String UserName;
	private String Password;
	private List<String> indirizi;
	
	private Map<Integer, Prodotto>carrello;
	private int Quantita;

	public Account(String nome, String cognome, String userName, String password) {
		Nome = nome;
		Cognome = cognome;
		UserName = userName;
		Password = password;
		indirizi = new LinkedList<String>();
		carrello = new HashMap<Integer, Prodotto>();
	}
	
	public String getNome() {
		return Nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public String getUserName() {
		return UserName;
	}

	public String getPassword() {
		return Password;
	}
	
	public Collection<String> elencoIndirizziSpedizione() {
		return indirizi;
	}

	public Collection<Prodotto> elencoProdottiInOrdineDiInserimento(){
		return null;
	}
	
	public Collection<Prodotto> elencoProdottiPerImportoCrescente(){
		return null;
	}
	
	public int getQuantita(){
		return Quantita;
	}

	public double getTotaleCarrello(){
		for (Prodotto i:carrello.values()){
			return i.getPrezzo()*getQuantita();
		}
		return 0.0;
	}

	public void setCarrello(Prodotto p, int Quantita) {
		carrello.put(p.getCodice(), p);
		this.Quantita=Quantita;
	}
	
}
