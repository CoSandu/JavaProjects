package amazon;

import java.util.*;

public class Account{
	
	private String Nome;
	private String Cognome;
	private String UserName;
	private String Password;
	private List<String> indirizi = new LinkedList<String>();
	
	private List<Prodotto> carrello = new LinkedList<Prodotto>();
	private int Quantita;

	public Account(String nome, String cognome, String userName, String password) {
		Nome = nome;
		Cognome = cognome;
		UserName = userName;
		Password = password;
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
		return carrello;
	}
	
	public Collection<Prodotto> elencoProdottiPerImportoCrescente(){
		List<Prodotto> ordPrezzo = new LinkedList<Prodotto>(carrello);
		Collections.sort(ordPrezzo, new Comparator<Prodotto>(){
			public int compare(Prodotto a, Prodotto b) {
				return (int) (a.getPrezzo()-b.getPrezzo());
			}
		});
		return ordPrezzo;
	}
	
	public int getQuantita(){
		return Quantita;
	}

	public double getTotaleCarrello(){
		for (Prodotto i:carrello){
			return i.getPrezzo()*getQuantita();
		}
		return 0.0;
	}

	public void setCarrello(Prodotto p, int Quantita) {
		carrello.add(p);
		this.Quantita=Quantita;
	}
	
}
