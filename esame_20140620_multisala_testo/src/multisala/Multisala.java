package multisala;

import java.util.*;

public class Multisala {
	
	
	private Map<Integer, Sala>sale = new HashMap<Integer, Sala>();
	private int codice=1;
	
	private Map<String, Film>films = new HashMap<String, Film>();
	private List<Proiezione>proiezioni = new LinkedList<Proiezione>();
	private List<Biglietto>bigliettiAcquistati = new LinkedList<Biglietto>();
	
	private int codiceBiglietto =0;
	

	public int nuovaSala(int numeroFile, int numeroPostiPerFila){
		Sala att = new Sala(codice, numeroFile, numeroPostiPerFila);
		if(codice <=10){
			sale.put(codice, att);
			codice++;
			return att.getCodiceSala();
		}
		else{
			return -1;	
		}
		
	}

	public Sala cercaSala(int codiceSala){
		if (sale.containsKey(codiceSala)){
			return sale.get(codiceSala);	
		}
		else{
			return null;
		}
	}
	
	public Collection<Sala> elencoSalePerCodice(){
		Collection<Sala>att = sale.values();
		List<Sala>ordCod = new LinkedList<Sala>(att);
		return ordCod;
	}

	public Collection<Sala> elencoSalePerNumeroDiPosti(){
		Collection<Sala>att = sale.values();
		List<Sala>ordCod = new LinkedList<Sala>(att);
		Collections.sort(ordCod);
		return ordCod;
	}
	
	public Film nuovoFilm(String titolo, String regista, int anno, int durata){
		if (films.containsKey(titolo+regista)){
			return films.get(titolo+regista);
		}
		else{
			Film tf = new Film(titolo, regista, anno, durata);
			films.put(titolo+regista, tf);
			return tf;
		}
	}
	
	public Collection<Film> elencoFilm(){
		Collection<Film>att = films.values();
		List<Film>ordCod = new LinkedList<Film>(att);
		return ordCod;
	}

	public Proiezione nuovaProiezione(int codiceSala, Film film, String data, String ora, double prezzoIntero, boolean in3D){
		if(sale.containsKey(codiceSala)==false || films.containsKey(film.getTitolo()+film.getRegista())==false){
			return null;
		}
		else{
			Proiezione pTemp = new Proiezione(sale.get(codiceSala), film, data, ora, prezzoIntero, in3D);
			proiezioni.add(pTemp);
			sale.get(codiceSala).addProiezione(pTemp);
			return pTemp;
		}
		
	}
	
	public Collection<Proiezione> elencoProiezioni(){
		return proiezioni;
	}
	
	public Collection<Proiezione> elencoProiezioniInData(String data){
		List<Proiezione> listaData = new LinkedList<Proiezione>();
		for(Proiezione p:proiezioni){
			if(p.getData().compareTo(data)==0){
				listaData.add(p);
			}
		}
		return listaData;
	}
	
	public Collection<Proiezione> cercaProiezioni(String daCercare){
		List<Proiezione> listaData = new LinkedList<Proiezione>();
		for(Proiezione p:proiezioni){
			if(p.toString().contains(daCercare)==true){
				listaData.add(p);
			}
		}
		return listaData;
	}
	
	public Biglietto acquistaBiglietto(Proiezione proiezione, int fila, int posto) throws EccezionePostoOccupato{
		Biglietto bTemp = new Biglietto(proiezione.getSala().getCodiceSala()+"-"+proiezione.getData()+"-"+
										proiezione.getOra()+"-"+codiceBiglietto, proiezione, fila, posto);
		proiezione.addBigliettoAProiezione(bTemp);
		bigliettiAcquistati.add(bTemp);
		codiceBiglietto++;
		return bTemp;
	}
	
	public BigliettoScontato acquistaBigliettoScontato(Proiezione proiezione, int fila, int posto, int percentualeSconto, String tipologiaSconto){
		BigliettoScontato bTemp = new BigliettoScontato(proiezione.getSala().getCodiceSala()+"-"+proiezione.getData()+"-"+
				proiezione.getOra()+"-"+codiceBiglietto, proiezione, fila, posto, percentualeSconto, tipologiaSconto);
		proiezione.addBigliettoAProiezione(bTemp);
		bigliettiAcquistati.add(bTemp);
		codiceBiglietto++;
		return bTemp;
	}
	
	public Biglietto cercaBiglietto(Proiezione proiezione, int fila, int posto){
		if(proiezione.getBiglietto(fila, posto)!=null){
			return proiezione.getBiglietto(fila, posto);
		}
		else{
			return null;	
		}
	}
	
	public Collection<Biglietto> acquistaBiglietti(Proiezione proiezione, int numBiglietti){
		if (proiezione.getSala().getPostitotali()<=numBiglietti){
			for(int i=1; i<=numBiglietti; i++){
				Biglietto bTemp = new Biglietto(proiezione.getSala().getCodiceSala()+"-"+proiezione.getData()+"-"+
						proiezione.getOra()+"-"+codiceBiglietto, proiezione, i, i);
				bigliettiAcquistati.add(bTemp);
				proiezione.addBigliettoAProiezione(bTemp);
				
			}
			return proiezione.getBigliettiProiezione();

			
		}
		return proiezione.getBigliettiProiezione();
	}

	public double calcolaIncassoInData(String data){
		double totale=0.0;
		for(Biglietto b:bigliettiAcquistati){
			if(b.getProiezione().getData().compareTo(data)==0){
				totale += b.getProiezione().getPrezzoIntero();	
			}
		}
		return totale; 
	}
}



