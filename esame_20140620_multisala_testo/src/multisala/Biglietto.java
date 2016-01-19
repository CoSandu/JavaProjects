package multisala;

import java.util.*;

public class Biglietto {
	
	private String codBiglietto;
	private Proiezione proiezione;
	private int fila;
	private int posto;
	
	public Biglietto(String codBiglietto, Proiezione proiezione, int fila, int posto) {
		this.codBiglietto = codBiglietto;
		this.proiezione = proiezione;
		this.fila = fila;
		this.posto = posto;
	}
	
	public String getCodiceBiglietto() {
		return codBiglietto;
	}

	public Proiezione getProiezione() {
		return proiezione;
	}

	public int getFila() {
		return fila;
	}

	public int getPosto() {
		return posto;
	}
	
	public String toString(){
		return codBiglietto+"-"+fila+"-"+posto;
	}
	
	
}
