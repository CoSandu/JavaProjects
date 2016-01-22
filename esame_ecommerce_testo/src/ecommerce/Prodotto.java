package ecommerce;

public class Prodotto implements Comparable<Prodotto>{

	private String codice;
	private String categoria;
	private String nome;
	private String descrizione;
	private double prezzo;
	

	public Prodotto(String codice, String categoria, String nome, String descrizione, double prezzo) {
		this.codice = codice;
		this.categoria = categoria;
		this.nome = nome;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	@Override
	public int compareTo(Prodotto a) {
		return this.getNome().compareTo(a.getNome());
	}
	
	public String toString(){
		return codice+prezzo;
	}
}


