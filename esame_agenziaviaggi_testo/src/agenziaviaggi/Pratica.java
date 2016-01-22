package agenziaviaggi;

import java.util.*;

public class Pratica implements Comparable<Pratica>{
	
	private int codPratica;
	private String descrizione;
	private Cliente cliente;
	
	private List<Prenotazione>prenotazioni = new LinkedList<Prenotazione>();
	
	public Pratica(Cliente tempc, String descrizione) {
		this.cliente=tempc;
		this.descrizione=descrizione;
	}

	public Cliente getCliente(){
		return cliente;
	}
	
	public void setCliente(Cliente c){
		this.cliente=c;
	}

	public int getIdPratica(){
		return codPratica;
	}
	
	public void setCodPratica(int cod){
		this.codPratica=cod;
	}
	
	public String getDescrizione(){
		return descrizione;
	}
	
	public void aggiungiPrenotazione(Prenotazione prenotazione){
		prenotazioni.add(prenotazione);
	}
	
	public double getImportoTotale(){
		double totale = 0.0;
		for(Prenotazione p:prenotazioni){
			totale +=p.getImporto();
		}
		return totale;
	}
	
	public Collection<Prenotazione> elencoPrenotazioniPerImporto(){
		Collections.sort(prenotazioni, new PrenotazioniPerImportoComparato());
		return prenotazioni;
	}

	public Collection<Prenotazione> elencoPrenotazioniPerData(){
		Collections.sort(prenotazioni, new PrenotazioniPerDataComparato());
		return prenotazioni;
	}

	public int compareTo(Pratica o) {
		
		return -((int) (this.getImportoTotale()-o.getImportoTotale()));
	}
}
