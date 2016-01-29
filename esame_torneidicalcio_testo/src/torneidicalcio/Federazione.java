package torneidicalcio;

import java.util.*;


public class Federazione {

	private String sigla;
	private String denominazione;
	private String sitoweb;
	private Map<String, Torneo>tornei = new HashMap<String, Torneo>();
	private List<Torneo>torneilist = new LinkedList<Torneo>();
	
	private Map<String, Squadra>squadre = new HashMap<String, Squadra>();
	private List<Squadra>squadlist = new LinkedList<Squadra>();
	
	
	private int codTess = 1000;
	private Map<String, Tesserato>tesserati = new HashMap<String, Tesserato>();
	private Map<Integer, Tesserato>tesseratiMap = new HashMap<Integer, Tesserato>();

	public Federazione(String sigla, String denominazione, String sitoWeb){
		this.sigla = sigla;
		this.denominazione = denominazione;
		this.sitoweb = sitoWeb;
	}
	
	public String getSigla() {
		return sigla;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public String getSitoWeb() {
		return sitoweb;
	}

	public Torneo nuovoTorneo(String nomeTorneo, int numeroSquadre){
		boolean presente = false;
		Torneo t = new Torneo(nomeTorneo, numeroSquadre);
		if (tornei.containsKey(nomeTorneo))
			presente = true;
		if (!presente){
			tornei.put(nomeTorneo, t);
			torneilist.add(t);
		}
		return tornei.get(nomeTorneo);
	}

	public void nuovaSquadra(String nome, String citta, int anno, String stadio){
		Squadra s = new Squadra(nome, citta, anno, stadio);
		if(squadre.containsKey(nome)!=true){
			squadre.put(nome, s);
			squadlist.add(s);
		}
			
		
		
			
	}

	public Squadra cercaSquadra(String nomeSquadra){
		if(squadre.containsKey(nomeSquadra))
			return squadre.get(nomeSquadra);
		return null;
	}

	public Collection<Torneo> elencoTornei(){
		return torneilist;
	}

	public Collection<Squadra> elencoSquadre(){
		List<Squadra>elnome = new LinkedList<Squadra>(squadre.values());
		Collections.sort(elnome);
		return elnome;
	}
	
	public void iscriviSquadraTorneo(String nomeTorneo, String nomeSquadra){
		if(tornei.containsKey(nomeTorneo)!=false && squadre.containsKey(nomeSquadra)!=false)
			Torneo.addSquadra(squadre.get(nomeSquadra));
	}

	public Collection<Squadra> elencoSquadreTorneo(String nomeTorneo){
		if(tornei.containsKey(nomeTorneo)==true){
			return tornei.get(nomeTorneo).listaSTorn();
		}
		
		return null;
	}
	
	public int tesseramento(String nome, String cognome, String nomeSquadra, String ruolo) throws EccezioneErroreDatiTesseramento{
		if(nome =="" && cognome=="" && nomeSquadra==""&& ruolo=="")
			throw new EccezioneErroreDatiTesseramento();
		Tesserato t = new Dirigente(codTess,nome, cognome, squadre.get(nomeSquadra), ruolo);
		tesseratiMap.put(codTess, t);
		Squadra.addTesserto(t);
		tesserati.put(nome+cognome,t);
		codTess++;
		return t.getCod();
	}

	public int tesseramento(String nome, String cognome, String nomeSquadra, String ruolo, int numeroMaglia) throws EccezioneErroreDatiTesseramento{
		if(nome =="" && cognome=="" && nomeSquadra==""&& ruolo=="" && numeroMaglia<0)
			throw new EccezioneErroreDatiTesseramento();
		Tesserato t = new Calciatore(codTess,nome, cognome, squadre.get(nomeSquadra), ruolo, numeroMaglia);
		tesseratiMap.put(codTess, t);
		Squadra.addTesserto(t);
		tesserati.put(nome+cognome,t);
		codTess++;
		
		return t.getCod();
	}
	
	public int tesseramento(String nome, String cognome, String sezione) throws EccezioneErroreDatiTesseramento{
		if(nome =="" && cognome=="" && sezione=="")
			throw new EccezioneErroreDatiTesseramento();
		Tesserato t = new Arbitro(codTess,nome, cognome, sezione);
		tesseratiMap.put(codTess, t);
		tesserati.put(nome+cognome,t);
		codTess++;
		return t.getCod();
	}
	
	public Tesserato cercaTesseratoPerNumeroTessera(int numeroTessera) throws EccezioneTesseratoInesistente{
		if(tesseratiMap.containsKey(numeroTessera)==true){
			return tesseratiMap.get(numeroTessera);
		}
		else
			throw new EccezioneTesseratoInesistente();

	}

	public Tesserato cercaTesseratoPerNomeCognome(String nome, String cognome) throws EccezioneTesseratoInesistente{
		if(tesserati.containsKey(nome+cognome)==true){
			return tesserati.get(nome+cognome);
		}
		else
			throw new EccezioneTesseratoInesistente();
	}
	
	public Collection<Tesserato> elencoTesseratiSquadra(String nomeSquadra){
		List<Tesserato>ts = new LinkedList<Tesserato>();
		for(Squadra s:squadlist){
			if (s.getNome().compareTo(nomeSquadra)==0)
				ts=(List<Tesserato>) s.tesserati();
		}
		return ts ;
	}
	
	public Incontro nuovoIncontro(String nomeTorneo, int giornata, String nomeSquadraCasa, String nomeSquadraOspite, 
			String risultato, String nomeArbitro, String cognomeArbitro){
		Incontro a = new Incontro(tornei.get(nomeTorneo), giornata, squadre.get(nomeSquadraCasa), squadre.get(nomeSquadraOspite),
				Integer.parseInt(risultato.substring(0, 1)), Integer.parseInt(risultato.substring(2, 3)),nomeArbitro + cognomeArbitro);
		tornei.get(nomeTorneo).addIncontro(a);
		return a;
	}

	public Collection<Incontro> elencoIncontriPerGiornata(String nomeTorneo){
		return tornei.get(nomeTorneo).incontri();
	}

	public Collection<Incontro> elencoIncontriPerDifferenzaReti(String nomeTorneo){
		return null;
	}

	public int puntiSquadra(String nomeSquadra){
		return -1;
	}
	
	public String classificaTorneo(String nomeTorneo){
		return null;
	}
}
