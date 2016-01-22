package casaeditrice;

import java.util.*;

public class Pubblicazione implements Comparable<Pubblicazione>{

	private String titolo;
	private String volume;
	private int anno;
	private Autore proprietario;
	private char tipologia;
	private int contributo;
	
	private Map<Autore, Integer> coautori = new HashMap<Autore, Integer>();
	
	
	
	public Pubblicazione(String titolo, char tipologia, String volume, int anno, int contributo) {
		this.titolo = titolo;
		this.volume = volume;
		this.anno = anno;
		this.tipologia = tipologia;
		this.contributo = contributo;
	}

	public int getContributo() {
		return contributo;
	}

	public void setContributo(int contributo) {
		this.contributo = contributo;
	}

	public char getTipologia() {
		return tipologia;
	}

	public void setTipologia(char tipologia) {
		this.tipologia = tipologia;
	}

	public String getTitolo(){
		return titolo;
	}
	
	public String getVolume(){
		return volume;
	}
	
	public int getAnno(){
		return anno;
	}

	public Autore getProprietario(){
		return proprietario;
	}

	public void aggiungiCoautori(Autore a, int contributo) throws AutoreDuplicatoException{
		boolean t = false;
		List<Autore>coaut = new LinkedList<Autore>(coautori.keySet());
		for(Autore ar:coaut){
			if(ar.getCognome().equals(a.getCognome()) && ar.getNome().equals(a.getNome())){
				t=true;
			}
		}
		if(t == true){
			throw new AutoreDuplicatoException();
		}
		else{
			coautori.put(a, contributo);
			a.aggiungiPubblicazione(this);
		}
		
	}
	
	public Collection<Autore> elencoAutori(){
		List<Autore> autori = new LinkedList<Autore>(coautori.keySet());
		Collections.sort(autori);
		return autori;
	}

	public int getContributo(Autore a){
		return coautori.get(a);
	}

	@Override
	public int compareTo(Pubblicazione o) {
		
		return -(this.getAnno()-o.getAnno());
	}
	
	public void setProprietario(Autore proprietario, int contributo){
		this.proprietario=proprietario;
		this.coautori.put(proprietario, contributo);
	}
	
}
