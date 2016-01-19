package ufficiotecnico;

import java.util.*;

public class Monumento {
	private String rap;
	private String dat;
	private String art;
	private char pos;
	private Collection<String> materiali;

	public Monumento(String rappresenta, String data, String artista, char posizione) {
		rap = rappresenta;
		dat = data;
		art = artista;
		pos = posizione;
		materiali = new LinkedList<String>();
	}

	public String getRappresenta() {
		
		return rap;
	}

	public String getData() {
		
		return dat;
	}

	public String getArtista() {
		
		return art;
	}

	public char getPosizione() {
		
		return pos;
	}

	public void aggiungiMateriale(String materiale){
		materiali.add(materiale);
	}
	
	public Collection<String> elencoMateriali(){
		return materiali;
	}
}
