package aziendaagricola;

public class Raccolto implements Comparable<Raccolto> {
	
	
	

	private double prezzoIngro;
	private String prodotto;
	private String data;
	private int quantita;
	
	

	public Raccolto(String prodotto, String data, int quantita) {
		this.prodotto = prodotto;
		this.data = data;
		this.quantita = quantita;
	}

	public double getPrezzoIngrosso() {

		return prezzoIngro;
	}

	public String getProdotto() {

		return prodotto;
	}
	
	public String getData() {

		return data;
	}
	
	public int getQuantita() {

		return quantita;
	}
	
	public void setPrezzoIngrosso(int prezzoIngrosso) {
		this.prezzoIngro=prezzoIngrosso;

	}
	
	public void setProdotto(String prodotto) {
		this.prodotto=prodotto;
	}

	public void setData(String data) {
		this.data=data;
	}

	public void setQuantita(int quantita) {
		this.quantita=quantita;
	}
	
	public int compareTo(Raccolto a){
		if (this.getData().compareTo(a.getData())==0){
			return this.getData().compareTo(a.getData());
		}
		return this.getQuantita()-a.getQuantita();
	}
	
}
