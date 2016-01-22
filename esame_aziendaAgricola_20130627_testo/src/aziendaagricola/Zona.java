package aziendaagricola;

import java.util.*;


public class Zona implements Comparable<Zona>{
	
	private int codzona;
	private int ampiezza;
	private int tempmedia;
	private float irrmedio;
	private List<String>caratteristiche = new LinkedList<String>();
	
	private Map<String, Coltivazione>coltivazioni= new HashMap<String, Coltivazione>();
	private Map<String,Raccolto> raccolti= new HashMap<String, Raccolto>();
	

	public Zona(int codzona) {
		this.codzona = codzona;
	}

	public int getCodice() {
		
		return codzona;
	}
	
	public int getAmpiezza() {
		
		return ampiezza;
	}

	public int getTemperaturaMedia() {
		
		return tempmedia;
	}

	public float getIrraggiamentoMedio() {
		
		return irrmedio;
	}
	
	public void setAmpiezza(int ampiezza) {
		this.ampiezza=ampiezza;

	}

	public void setTemperaturaMedia(int temperaturaMedia) {
		this.tempmedia=temperaturaMedia;

	}

	public void setIrraggiamentoMedio(float irraggiamentoMedio) {
		irrmedio=irraggiamentoMedio;

	}
	
	public void addCaratteristica(String carratteristica){
		boolean trovato = false;
		for (String s:caratteristiche){
			if (s.compareToIgnoreCase(carratteristica)==0){
				trovato=true;
			}
		}
		if (trovato == false){
			caratteristiche.add(carratteristica);	
		}

	}

	public Collection<String> elencoCaratteristiche(){
		List<String>carOrd = new LinkedList<String>(caratteristiche);
		Collections.sort(carOrd, new Comparator<String>(){
			public int compare(String a, String b) {
				return a.compareTo(b);
			}
		});
		return carOrd;
	}
	
	public Coltivazione aggiungiColtivazione(String prodotto, int meseSemina, int meseRaccolto) throws ColtivazioneDuplicataException {
		Coltivazione c = new Coltivazione(prodotto, meseSemina, meseRaccolto);
		Coltivazione p = coltivazioni.get(prodotto);
		if (p!=null && p.getMeseSemina() == c.getMeseSemina()){
			throw new ColtivazioneDuplicataException();
		}
		else{
			coltivazioni.put(prodotto, c);
			return c;
		}
	}

	public Collection<Coltivazione> elencoColtivazioni(){
		List<Coltivazione> ctemp = new LinkedList<Coltivazione>(coltivazioni.values());
		return ctemp;
	}
	
	
	public Raccolto nuovoRaccolto(String prodotto, String data, int quantita){
		Raccolto r = new Raccolto(prodotto, data, quantita);
		raccolti.put(prodotto, r);
		return r;
	}
	
	public Raccolto cercaRaccolto(String prodotto, String data){
		Raccolto r = raccolti.get(prodotto);
		return r;
	}
	
	public Collection<Raccolto>elencoRaccolti(){
		List<Raccolto>tempr = new LinkedList<Raccolto>(raccolti.values());
		Collections.sort(tempr);
		return tempr;
	}

	@Override
	public int compareTo(Zona arg0) {
		
		return 0;
	}


	
}
