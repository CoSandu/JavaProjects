package amazon;

public class Prodotto {
	


	private int Codice=-1;
	private String Nome;
	private String Descrizione;
	private double Prezzo;
	
	public Prodotto(String nome, String descrizione, double prezzo) {
		Nome = nome;
		Descrizione = descrizione;
		Prezzo = prezzo;
		Codice++;
	}

	public int getCodice() {
		return Codice;
	}

	public String getNome() {
		return Nome;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public double getPrezzo() {
		return Prezzo;
	}

	public int getDisponibilita() {
		return -1;
	}

}
