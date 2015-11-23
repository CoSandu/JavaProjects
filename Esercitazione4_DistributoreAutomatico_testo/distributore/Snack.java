package distributore;

public class Snack {
	private String codice;
	private String nome;
	private double prezzoSnack; 
	private String tipologiaSnack;
	
	public Snack(String codice, String nome, double prezzoSnack, String tipologiaSnack) {
		this.codice = codice;
		this.nome = nome;
		this.prezzoSnack = prezzoSnack;
		this.tipologiaSnack = tipologiaSnack;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPrezzoSnack() {
		return prezzoSnack;
	}

	public void setPrezzoSnack(double prezzoSnack) {
		this.prezzoSnack = prezzoSnack;
	}

	public String getTipologiaSnack() {
		return tipologiaSnack;
	}

	public void setTipologiaSnack(String tipologiaSnack) {
		this.tipologiaSnack = tipologiaSnack;
	}
	

}
