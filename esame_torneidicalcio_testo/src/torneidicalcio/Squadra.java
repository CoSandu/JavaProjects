package torneidicalcio;

import java.util.*;

public class Squadra implements Comparable<Squadra>{

	private String nome;
	private String citta;
	private int anno;
	private String stadio;
	
	private static List<Tesserato>tesserati= new LinkedList<Tesserato>();


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
//		Collections.sort(ts, new DirigentiCalciatoriComparator());

		return ts;
	}
	
	

}
