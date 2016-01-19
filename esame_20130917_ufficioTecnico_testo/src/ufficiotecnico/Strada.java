package ufficiotecnico;

public class Strada extends ElementoTopografico {
	
	private int lung;

	public Strada(String nome, int codice) {
		super(nome, codice);
		lung = 0;
	}

	public int getLunghezza() {
		return lung;
	}

	public void setLunghezza(int lunghezza) {
		lung = lung + lunghezza;

	}
}
