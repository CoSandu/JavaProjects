package amazon;

public class Prodotto implements Comparable<Prodotto> {
	
	private int Codice;
	private String Nome;
	private String Descrizione;
	private double Prezzo;
	private int Disponibilita;
	
	public Prodotto(int codice,String nome, String descrizione, double prezzo) {
		Nome = nome;
		Descrizione = descrizione;
		Prezzo = prezzo;
		Disponibilita=0;
		Codice = codice;
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
		return Disponibilita;
	}

	public void setDisponibilita(int disponibilita) {
		if (Disponibilita!=0){
			Disponibilita = Disponibilita + disponibilita;
		}
		else{
			Disponibilita = disponibilita;
		}
	}

	public String toString(){
		return Codice+"-" + Nome+"-" + Descrizione+"-" + Prezzo+"-" + Disponibilita;
	}
	
	public int compareTo(Prodotto p){
		return (int) (this.getPrezzo()-p.getPrezzo());
	}
	

}
