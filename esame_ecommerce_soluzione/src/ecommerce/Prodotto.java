package ecommerce;

import java.util.*;

public class Prodotto {

	private String codice;
	private String nome;
	private String descrizione;
	private double prezzo;

	int numeroAcquisti = 0;
	int sommaGiudizi = 0;
	
	public Prodotto(String codice, String nome, String descrizione, double prezzo){
		
		this.codice = codice;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public String getCodice() {
		return codice;
	}

	public String getNome() {
		return nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}
	

	public static class ComparatoreDiProdottiPerNome implements Comparator<Prodotto>{
		public int compare(Prodotto p1, Prodotto p2) {
			return p1.getNome().compareTo(p2.getNome());
		}
	}
	
	public static class ComparatoreDiProdottiPerPrezzo implements Comparator<Prodotto>{
		public int compare(Prodotto p1, Prodotto p2) {
			return (int)(p1.getPrezzo()-p2.getPrezzo());
		}
	}
	
}


