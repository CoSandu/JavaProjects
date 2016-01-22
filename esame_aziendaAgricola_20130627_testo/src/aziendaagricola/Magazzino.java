package aziendaagricola;

import java.util.*;

public class Magazzino {

	private String nome;
	private String prodotto;
	private int quantitaStoccabile;
	private int quantitaStoccata;

	private Raccolto raccolto;

	public Magazzino(String nome, String prodotto, int quantitaStoccabile) {
		this.nome = nome;
		this.prodotto = prodotto;
		this.quantitaStoccabile = quantitaStoccabile;
	}

	public String getNome() {
		return nome;
	}

	public String getProdotto() {
		return prodotto;
	}
	
	public int getQuantitaStoccabile() {
		return quantitaStoccabile;
	}

	public int getQuantitaStoccata() {
		return quantitaStoccata;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public void setProdotto(String prodotto) {
		this.prodotto=prodotto;
	}

	public void setQuantitaStoccabile(int quantitaStoccabile) {
		this.quantitaStoccabile=quantitaStoccabile;
	}

	public void setQuantitaStoccata(int quantitaStoccata) {
		this.quantitaStoccata=quantitaStoccata;

	}	
	
	public int stocca(Raccolto raccolto)throws ProdottoNonCompatibileException{
		if (raccolto.getProdotto()!=this.getProdotto()){
			throw new ProdottoNonCompatibileException();
		}
		if(raccolto.getQuantita()<=this.getQuantitaStoccabile()){
			this.raccolto = raccolto;		
		}
		this.setQuantitaStoccata(this.getQuantitaStoccabile()-raccolto.getQuantita());
		return this.getQuantitaStoccabile()-raccolto.getQuantita();
	}
	
	public void preleva(int quantita){
		raccolto.setQuantita(raccolto.getQuantita()-quantita);
		

	}
	
}
