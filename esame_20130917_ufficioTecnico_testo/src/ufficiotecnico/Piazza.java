package ufficiotecnico;

import java.util.*;

public class Piazza extends ElementoTopografico {
	
	private String form;
	private double ext;
	
	private Map<Character, Monumento>monumenti = new HashMap<Character, Monumento>();
	

	public Piazza(String nome, int codice) {
		super(nome, codice);
		form="";
		ext=0.0;
		
	}

	public String getForma() {

		return form;
	}
	
	public void setForma(String forma) {
		form = form+ forma;

	}
	
	public double getEstensione() {
		return ext;
	}
	
	public void setEstensione(double estensione) {
		ext = estensione;

	}

	public Monumento aggiungiMonumento(String rappresenta, String data, String artista, char posizione){
		Monumento m = new Monumento(rappresenta, data, artista, posizione);
		monumenti.put(posizione, m );
		return m;		
	}

	public boolean monumentoPresenteInPosizione(char posizione){
		if (monumenti.containsKey(posizione)==true){
			return true;
		}
		return false;
	}
	
	public Collection<Monumento> tuttiMonumentiPiazza(){
		Collection<Monumento>monuVal = monumenti.values();
		List<Monumento>allMonu = new LinkedList<Monumento>(monuVal);
		return allMonu;	
	}
}
