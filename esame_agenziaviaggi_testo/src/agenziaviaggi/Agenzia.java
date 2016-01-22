package agenziaviaggi;

import java.util.*;

public class Agenzia {
	
	List<Cliente>clienti = new LinkedList<Cliente>();
	
	int contaPratiche = 1000;
	Map<Integer, Pratica>pratiche = new HashMap<Integer, Pratica>();

	public Cliente aggiungiCliente(String cognome, String nome, String indirizzo) throws EccezioneClienteGiaEsistente{
		boolean trovato = false;
		for (Cliente c:clienti){
			if(c.getNome().compareToIgnoreCase(nome)==0 &&
					c.getCognome().compareToIgnoreCase(cognome)==0 &&
					c.getIndirizzo().compareToIgnoreCase(indirizzo)==0){
				trovato = true;
			}
		}
		if(trovato==false){
			Cliente c = new Cliente (cognome, nome, indirizzo);
			clienti.add(c);
			return c;
		}
		else{
			throw new EccezioneClienteGiaEsistente();
		}
	}
	
	public Collection<Cliente> elencoClienti(){
		List<Cliente>elencoClienti = new LinkedList<Cliente>(clienti);
		Collections.sort(elencoClienti);
		return elencoClienti;
	}
	
	public Cliente cercaCliente(String cognome, String nome, String indirizzo){
		for (Cliente c:clienti){
			if(c.getNome().compareToIgnoreCase(nome)==0 &&
					c.getCognome().compareToIgnoreCase(cognome)==0 &&
					c.getIndirizzo().compareToIgnoreCase(indirizzo)==0){
				return c;
			}
		}
		return null;
	}
	
	public Cliente cercaCliente(String ricerca){
		for (Cliente c:clienti){
			if(c.toString().contains(ricerca)){
				return c;
			}
		}
		return null;
	}
	
	public int nuovaPratica(String descrizione, String cognome, String nome, String indirizzo){
		Cliente tempc = cercaCliente(cognome, nome, indirizzo);
		if (tempc == null){
			tempc = new Cliente (cognome, nome, indirizzo);
			clienti.add(tempc);
		}
		
		Pratica tempp = new Pratica (tempc, descrizione);
		tempp.setCodPratica(contaPratiche);
		pratiche.put(contaPratiche, tempp);
		tempc.aggiungiPratica(tempp);
		contaPratiche++;
		return tempp.getIdPratica();
	}
	public Pratica getPratica(int idPratica)throws EccezionePraticaInesistente{
		if(pratiche.containsKey(idPratica)){
			return pratiche.get(idPratica);
		}
		else{
			throw new EccezionePraticaInesistente();
		}
		
	}
	
	public void eliminaPratica(int idPratica)throws EccezionePraticaInesistente{
		if (pratiche.containsKey(idPratica)==false){
			throw new EccezionePraticaInesistente();
		}
		pratiche.remove(idPratica);
		Pratica p = pratiche.get(idPratica);
		p.getCliente().eliminaPratica(idPratica);
		
	}
	
	public Collection<Pratica> elencoPratiche(){
		List<Pratica>elenco = new LinkedList<Pratica>(pratiche.values());
		Collections.sort(elenco);
		return elenco;
	}

	public double calcolaImportoPerPeriodo(String da, String a){
		List<Pratica>temp = new LinkedList<Pratica>(pratiche.values());
		List<Prenotazione>plist;
		String data="";
		double tot=0.0;
		for(Pratica p:temp){
			plist = new LinkedList<Prenotazione>(p.elencoPrenotazioniPerData());
			for (Prenotazione pA:plist){
				if (pA instanceof PrenotazioneAlbergo){
					data = (((PrenotazioneAlbergo) pA).getDataCheckIn());
				}
				else if (pA instanceof PrenotazioneVolo){
					data = ((PrenotazioneVolo) pA).getDataPartenza();
				}
				if(data.compareTo(da)>=0 && data.compareTo(a)<=0){
					tot+=pA.getImporto();
				}
			}
		}
		return tot;
	}
	
	public Collection<Cliente> elencoClientiSelezionati(double importo){
		List<Cliente> templist = new LinkedList<Cliente>();
		Collections.sort(clienti);
		for(Cliente c:clienti){
			double tot= 0;
			for(Pratica p:c.elencoPratiche()){
				tot+=p.getImportoTotale();
			}
			if(tot>importo){
				templist.add(c);
			}
		}
		
		return templist;
	}
}
