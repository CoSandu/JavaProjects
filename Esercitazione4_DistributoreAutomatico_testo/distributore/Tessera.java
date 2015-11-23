package distributore;

public class Tessera {

	private int codiceTessera;
	private double ricarica;
	
	protected Tessera tessere[];
	private int contaTessera;
	private static final int MAXTESSERE = 10;

	public Tessera(int codiceTessera, double ricarica) {
		this.codiceTessera = codiceTessera;
		this.ricarica = ricarica;
		contaTessera = 0;
		tessere = new Tessera[MAXTESSERE];
	}

	public int getCodiceTessera() {
		return codiceTessera;
	}

	public void setCodiceTessera(int codiceTessera) {
		this.codiceTessera = codiceTessera;
	}

	public double getRicarica() {
		return ricarica;
	}

	public void setRicarica(double ricarica) {
		this.ricarica = ricarica;
	}
	
	public Tessera getEsistente(int codiceTessera){
		for (Tessera t:tessere){
			if (t!=null && t.getCodiceTessera() == codiceTessera)
				return t;
		}
		return null;
	}
	
	public Tessera aggiungiTessera(int codiceTessera){
		Tessera t = new Tessera (codiceTessera, getRicarica());
		tessere[contaTessera] = t;
		contaTessera++;
		return t;
	
	}
	

}
