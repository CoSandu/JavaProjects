package torneidicalcio;

import java.util.*;

public class Torneo {

	private String nome;
	private int numS;
	
	private List<Squadra>sTorn = new LinkedList<Squadra>();
	private List<Incontro>incontri = new LinkedList<Incontro>();
	
	public Torneo(String nome, int numS) {
		this.nome = nome;
		this.numS = numS;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroSquadre() {
		return numS;
	}

	public void addSquadra(Squadra squadra) {
		sTorn.add(squadra);
		
	}
	
	public Collection<Squadra> listaSTorn(){
		List<Squadra>stemp = new LinkedList<Squadra>(sTorn);
		Collections.sort(stemp);
		return stemp;
	}

	public void addIncontro(Incontro a) {
		incontri.add(a);
		
	}
	
	public Collection<Incontro> incontri(){
		List<Incontro>stemp = new LinkedList<Incontro>(incontri);
		Collections.sort(stemp);
		return stemp;
	}

	public void setNumS(int numS) {
		this.numS = numS;
	}

	public Collection<Incontro> incontriDifReti() {
		List<Incontro>stemp = new LinkedList<Incontro>(incontri);
		Collections.sort(stemp, new Comparator<Incontro>(){
			public int compare(Incontro a, Incontro b){
				return a.getDifReti()-b.getDifReti();
			}
		});
		return stemp;
	}

	
	

}
