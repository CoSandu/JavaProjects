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
		if(tornei.containsKey(nomeTorneo)!=false && squadre.containsKey(nomeSquadra)!=false && tornei.containsKey(nomeTorneo) && 
				tornei.get(nomeTorneo).getNumeroSquadre() > 0)
			tornei.get(nomeTorneo).addSquadra(squadre.get(nomeSquadra));
			tornei.get(nomeTorneo).setNumS(tornei.get(nomeTorneo).getNumeroSquadre()-1);
	}

	public Collection<Squadra> elencoSquadreTorneo(String nomeTorneo){
		if(tornei.containsKey(nomeTorneo)==true){
			return tornei.get(nomeTorneo).listaSTorn();
		}
		
		return null;
	}
	
	public int tesseramento(String nome, String cognome, String nomeSquadra, String ruolo) throws EccezioneErroreDatiTesseramento{
		Tesserato t=null;
		if(nome !="" && nome!=null && cognome!=""&& cognome!=null && nomeSquadra!="" && nomeSquadra!=null && ruolo!="" && ruolo!=null)	
			t = new Dirigente(codTess,nome, cognome, squadre.get(nomeSquadra), ruolo);
			tesseratiMap.put(codTess, t);
			Squadra.addTesserto(t);
			tesserati.put(nome+cognome,t);
			codTess++;
			if (t!=null)	
				return t.getCod();
			else
				throw new  EccezioneErroreDatiTesseramento();
	}

	public int tesseramento(String nome, String cognome, String nomeSquadra, String ruolo, int numeroMaglia) throws EccezioneErroreDatiTesseramento{
		Tesserato t=null;
		if(nome !="" && nome!=null && cognome!=""&& cognome!=null && nomeSquadra!="" && nomeSquadra!=null && ruolo!="" && ruolo!=null && numeroMaglia>0)
			t = new Calciatore(codTess,nome, cognome, squadre.get(nomeSquadra), ruolo, numeroMaglia);
			tesseratiMap.put(codTess, t);
			Squadra.addTesserto(t);
			tesserati.put(nome+cognome,t);
			codTess++;
			if (t!=null)	
				return t.getCod();
			else
				throw new  EccezioneErroreDatiTesseramento();
	}
	
	public int tesseramento(String nome, String cognome, String sezione) throws EccezioneErroreDatiTesseramento{
		Tesserato t=null;
		if(nome !="" && nome!=null && cognome!="" && cognome!=null && sezione!=""&& sezione!=null)
			t = new Arbitro(codTess,nome, cognome, sezione);
			tesseratiMap.put(codTess, t);
			tesserati.put(nome+cognome,t);
			codTess++;
			if (t!=null)	
				return t.getCod();
			else
				throw new  EccezioneErroreDatiTesseramento();
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
			String risultato, String nomeArbitro, String cognomeArbitro) throws NumberFormatException, EccezioneTesseratoInesistente{
		Incontro a = new Incontro(tornei.get(nomeTorneo), giornata, squadre.get(nomeSquadraCasa), squadre.get(nomeSquadraOspite),
				Integer.parseInt(risultato.substring(0, 1)), Integer.parseInt(risultato.substring(2, 3)),"("+nomeArbitro +" "+cognomeArbitro+", "+ ((Arbitro) this.cercaTesseratoPerNomeCognome(nomeArbitro, cognomeArbitro)).getSezione()+ ")");
		tornei.get(nomeTorneo).addIncontro(a);
		squadre.get(nomeSquadraCasa).addIncontro(a);
		squadre.get(nomeSquadraOspite).addIncontro(a);
		return a;
	}

	public Collection<Incontro> elencoIncontriPerGiornata(String nomeTorneo){
		return tornei.get(nomeTorneo).incontri();
	}

	public Collection<Incontro> elencoIncontriPerDifferenzaReti(String nomeTorneo){
		return tornei.get(nomeTorneo).incontriDifReti();
	}

	public int puntiSquadra(String nomeSquadra){
		int tot=0;
		List<Incontro>incontriS = new LinkedList<Incontro>(squadre.get(nomeSquadra).getIncontri());
		for(Incontro i:incontriS){
			if (i.getSquadraCasa().getNome().compareTo(nomeSquadra)==0)
				if (i.getNumeroGolSquadraCasa()-i.getNumeroGolSquadraOspite()==0)
					tot+=1;
				else if (i.getNumeroGolSquadraCasa()-i.getNumeroGolSquadraOspite()<0)
					tot+=0;
				else 
					tot+=3;
			else if(i.getSquadraOspite().getNome().compareTo(nomeSquadra)==0)
				if (i.getNumeroGolSquadraCasa()-i.getNumeroGolSquadraOspite()==0)
					tot+=1;
				else if (i.getNumeroGolSquadraCasa()-i.getNumeroGolSquadraOspite()<0)
					tot+=3;
				else 
					tot+=0;
		}
		return tot;
	}
	
	public String classificaTorneo(String nomeTorneo){
		Torneo t = tornei.get(nomeTorneo);
		List<Classifica>c=new LinkedList<Classifica>();
		String sa= "";
		Classifica sc = null;
		for(Squadra s:t.listaSTorn()){
			sc = new Classifica(this.puntiSquadra(s.getNome()), s.getNome());
			c.add(sc);
		}
		Collections.sort(c);
		for(int i=0; i<c.size(); i++){
			sa += c.get(i).toString();
			if(i<c.size()-1)
				sa+=";\n";
			else
				sa+=".";
		}
		return sa;
	}
}
