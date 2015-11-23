package distributore;

public class Tessera {

	private int codiceTessera;
	private double ricarica;

	public Tessera(int codiceTessera, double ricarica) {
		this.codiceTessera = codiceTessera;
		this.ricarica = ricarica;
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
	
	
}
