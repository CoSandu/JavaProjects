package supermercato;

import java.util.*;

public class Corsia {
	
	private String nome;
	private int capienzaMassima;
	private List<Prodotto> prodottiCorsia = new LinkedList<Prodotto>();
	
	public Corsia(String nome, int capienzaMassima) {
		this.nome = nome;
		this.capienzaMassima = capienzaMassima;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCapienzaMassima() {
		return capienzaMassima;
	}
	public void setCapienzaMassima(int capienzaMassima) {
		this.capienzaMassima = capienzaMassima;
	}
	
	public String toString(){
		return nome +" "+ capienzaMassima;
	}

	public Collection<Prodotto> getProdottiCorsia() {
		return prodottiCorsia;
	}
	public void setProdottiCorsia(Prodotto prodotto, int quantita) {
		prodotto.setQuantita(quantita);
		prodottiCorsia.add(prodotto);
	}

	public int getTotOccupato(){
		int totVolOcu = 0;
		for (Prodotto p: prodottiCorsia){
			totVolOcu = p.getVolume()*p.getQuantita();
		}
		return totVolOcu;
	}
	
	public int getQuantitaCorsia(Prodotto p){
		return p.getQuantita();
	}

}
