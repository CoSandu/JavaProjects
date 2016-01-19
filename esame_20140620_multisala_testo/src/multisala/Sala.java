package multisala;

import java.util.*;

public class Sala implements Comparable<Sala>{
	


	private int numFile;
	private int numPostiFila;
	private int codSala;
	private int postiTotali;
	
	private List<Proiezione>proiezioni = new LinkedList<Proiezione>();
	
	public Sala(int codSala, int numFile, int numPostiFila) {
		this.numFile = numFile;
		this.numPostiFila = numPostiFila;
		this.codSala = codSala;
		postiTotali = numFile*numPostiFila;
	}

	public int getCodiceSala() {
		return codSala;
	}

	public int getNumeroFile() {
		return numFile;
	}

	public int getNumeroPostiPerFila() {
		return numPostiFila;
	}
	
	public void setNumFile(int numFile) {
		this.numFile = numFile;
	}

	public void setNumPostiFila(int numPostiFila) {
		this.numPostiFila = numPostiFila;
	}

	public void setCodSala(int codSala) {
		this.codSala = codSala;
	}

	public Collection<Proiezione> elencoProiezioni(){
		return proiezioni;
	}

	public int compareTo(Sala a) {
		return -((this.getNumeroFile()*this.getNumeroPostiPerFila())
				-(a.getNumeroFile()*a.getNumeroPostiPerFila()));
	}
	
	public void addProiezione(Proiezione p){
		proiezioni.add(p);
		
	}
	
	public int getPostitotali(){
		return postiTotali;
		
	}
	
}
