package amazon;

public class Acquisto extends Prodotto {
	
	private int quantita;

	public Acquisto(int codice, String nome, String descrizione, double prezzo, int quantita) {
		super(codice, nome, descrizione, prezzo);
		this.quantita = quantita;
	}
	
	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		if (quantita>=0){
			this.quantita = quantita + quantita;
		}
		this.quantita = quantita;
	}

	public String toString(){
		return super.toString()+"-"+ quantita;
	}

}
