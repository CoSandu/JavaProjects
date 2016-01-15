package supermercato;

import java.util.*;

public class Prodotto implements Comparable<Prodotto>{

	private String codice;
	private String nome;
	private int volume;
	private boolean daFrigo;
	private double prezzoListino = 0;
	private int percentualeSconto = 0;
	private int quantita = 0;
	
	public Prodotto(String codice, String nome, int volume, boolean daFrigo) {
		this.codice = codice;
		this.nome = nome;
		this.volume = volume;
		this.daFrigo = daFrigo;
		
	}
	
	public String getCodice(){
		return codice;
	}
	
	public String getNome(){
		return nome;
	}
	
	public int getVolume(){
		return volume;
	}

	public void setPrezzoListino(double prezzo) {
		this.prezzoListino=prezzo;

	}

	public double getPrezzoListino() {
		return prezzoListino;
	}

	public void setPercentualeSconto(int percentualeSconto) {
		this.percentualeSconto = percentualeSconto;

	}

	public int getPercentualeSconto() {
		return percentualeSconto;
	}

	public boolean isDaFrigo(){
		return false;
	}

	@Override
	public int compareTo(Prodotto o) {
		return -(int) (this.getPrezzoListino()-o.getPrezzoListino());
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	
}
