package torneidicalcio;

import java.util.*;

public class Squadra implements Comparable<Squadra>{

	private String nome;
	private String citta;
	private int anno;
	private String stadio;
	
	private static List<Tesserato>tesserati= new LinkedList<Tesserato>();
	private List<Incontro>incontri = new LinkedList<Incontro>();


	public Squadra(String nome, String citta, int anno, String stadio) {
		this.nome = nome;
		this.citta = citta;
		this.anno = anno;
		this.stadio = stadio;
	}

	public String getNome() {
		return nome;
	}

	public String getCitta() {
		return citta;
	}

	public int getAnno() {
		return anno;
	}

	public String getStadio() {
		return stadio;
	}

	@Override
	public int compareTo(Squadra arg) {
		return this.getNome().compareTo(arg.getNome());
	}

	public static void addTesserto(Tesserato t) {
		tesserati.add(t);
		
	}

	public Collection<Tesserato> tesserati() {
		List<Tesserato>ts = new LinkedList<Tesserato>(tesserati);
		List<Tesserato>dir = new LinkedList<Tesserato>();
		List<Tesserato>calc = new LinkedList<Tesserato>();
		Collections.sort(ts);
		for(Tesserato t:ts){
			if(t instanceof Dirigente)
				dir.add(t);
			else
				calc.add(t);
		}
		List<Tesserato>gen = new LinkedList<Tesserato>(dir);
		gen.addAll(calc);
		return gen;
	}

	public void addIncontro(Incontro a) {
		incontri.add(a);
		
	}

	public Collection<Incontro> getIncontri() {
		return incontri;
	}

	
	

}
