package ufficiotecnico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class BaseDatiTopografica {
	
	
	
	int codiceStrada = 1;
	int codicePiazza = 10001;
	
	Map<Integer, Strada>strade = new HashMap<Integer, Strada>();
	Map<Integer, Piazza>piazze = new HashMap<Integer, Piazza>();
	Map<Integer, ElementoTopografico>elTopo = new HashMap<Integer, ElementoTopografico>();
	
	Map<Integer,Incrocio>incroci = new HashMap<Integer, Incrocio>();

	public ElementoTopografico aggiungiElementoTopografico(String tipologia){
		String strada = "strada";
		String piazza = "piazza";
		if (tipologia.equalsIgnoreCase(strada)){
			Strada sT = new Strada(tipologia, codiceStrada);
			strade.put(codiceStrada, sT);
			elTopo.put(codiceStrada, sT);
			codiceStrada++;
			return sT;
		}
		else if (tipologia.equalsIgnoreCase(piazza)){
			Piazza sP = new Piazza(tipologia, codicePiazza);
			piazze.put(codicePiazza, sP);
			elTopo.put(codicePiazza, sP);
			codicePiazza++;
			return sP;
		}
		return null;
	}
	
	public Collection<ElementoTopografico> elencoElementiTopografici(){
		Collection<ElementoTopografico>elementi = elTopo.values();
		List<ElementoTopografico>eleOrd = new LinkedList<ElementoTopografico>(elementi);
		Collections.sort(eleOrd);

		return eleOrd;
	}
	
	public Collection<Piazza> elencoPiazze(){
		Collection<Piazza>elementi = piazze.values();
		List<Piazza>eleOrd = new LinkedList<Piazza>(elementi);
		Collections.sort(eleOrd);
		return eleOrd;
	}

	public Collection<Strada> elencoStradePerNome(){
		Collection<Strada>elementi = strade.values();
		List<Strada>eleOrd = new LinkedList<Strada>(elementi);
		Collections.sort(eleOrd);
		return eleOrd;
	}
	
	public Collection<Strada> elencoStradePerLunghezza(){
		Collection<Strada>elementi = strade.values();
		List<Strada> eleOrd = new LinkedList<Strada>(elementi);
		Collections.sort(eleOrd, new Comparator<Strada>(){
			public int compare(Strada a, Strada b) {
				return -(a.getLunghezza()-b.getLunghezza());
			}
		});
		return eleOrd;
	}
	
	public ElementoTopografico cercaElementoTopografico(int codice) throws EccezioneElementoTopograficoInesistente{
		if (codice<=10000){
			return strade.get(codice);
		}
		else if (codice>10000){
			return piazze.get(codice);
		}
		else{
			throw new EccezioneElementoTopograficoInesistente();
		}
		
	}
	
	public double estensionePiazze(){
		double totale = 0.0;
		Collection<Piazza> elementi = piazze.values();
		for (Piazza e:elementi){
			totale = totale + e.getEstensione();
		}
		return totale;
	}
	
	public Collection<Monumento> elencoMonumenti(int codicePiazza){
		Piazza tempP = piazze.get(codicePiazza);
		return tempP.tuttiMonumentiPiazza();
	}

	public void definisciIncrocio(int codiceA, int codiceB, boolean semafori){
		ElementoTopografico a = elTopo.get(codiceA);
		ElementoTopografico b = elTopo.get(codiceB);
		Incrocio incT = new Incrocio(a,b,semafori);
		incroci.put(codiceA,incT);
	}
	
	public boolean eliminaIncrocio(int codiceA, int codiceB){
		if(incroci.containsKey(codiceA)&&incroci.get(codiceA).getStrada2().getCodice()==codiceB){
			incroci.remove(codiceA, incroci.get(codiceA).getStrada2().getCodice()==codiceB);
			return true;
		}
		return false;
	}
	
	public Collection<ElementoTopografico> elencoIncroci(int codice) throws EccezioneElementoTopograficoInesistente{
		List<ElementoTopografico>tL = new LinkedList<ElementoTopografico>();
		if(incroci.get(codice).getStrada2()!=null){
			tL.add(incroci.get(codice).getStrada2());
			return tL;
		}
		else{
			throw new EccezioneElementoTopograficoInesistente();
		}
	}
	
	public void leggi(String nomeFile) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader(nomeFile));
		String linea;

		String nome=null;
		String lunghezza=null;
		String forma=null;
		String estensione=null;
		String codiceA = null;
		String codiceB = null;
		String semafori=null;
		
		
		while ((linea = in.readLine()) != null) {
			
			try {
			    StringTokenizer st = new StringTokenizer(linea, ";");
			    String iniziale = st.nextToken().trim();
			    if (iniziale.compareTo("strada")==0) 
			    {
			       nome = st.nextToken().trim();
			       lunghezza = st.nextToken().trim();
			       Strada stemp = (Strada)this.aggiungiElementoTopografico("STRADA");
			       stemp.setNome(nome);
			       stemp.setLunghezza(Integer.parseInt(lunghezza));
			    } 
			    else if (iniziale.compareTo("piazza")==0) 
			    {
				   nome = st.nextToken().trim();
				   forma = st.nextToken().trim();
				   estensione = st.nextToken().trim();
				   Piazza ptemp = (Piazza)this.aggiungiElementoTopografico("PIAZZA");
				   ptemp.setNome(nome);
				   ptemp.setForma(forma);
				   ptemp.setEstensione(Double.parseDouble(estensione));
			    }
			    else if (iniziale.compareTo("incrocio")==0) 
			    {
				   codiceA = st.nextToken().trim();
				   codiceB = st.nextToken().trim();
				   semafori = st.nextToken().trim();
				   
				   this.definisciIncrocio(Integer.parseInt(codiceA), Integer.parseInt(codiceB), Boolean.parseBoolean(semafori));
			    }
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		in.close();
	}	
}



