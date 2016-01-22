package ecommerce;

public class ProdottoAcquistato extends Prodotto {
	
	private int quantita;
	private String data;

	public ProdottoAcquistato(String codice, String categoria, String nome, String descrizione, double prezzo) {
		super(codice, categoria, nome, descrizione, prezzo);
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	public String toString(){
		return super.toString() + quantita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	

}
