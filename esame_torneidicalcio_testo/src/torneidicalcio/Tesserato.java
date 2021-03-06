package torneidicalcio;

public class Tesserato implements Comparable<Tesserato> {

	private String nome;
	private String cognome;
	private int cod;
	
	
	public Tesserato(int cod, String nome, String cognome) {
		this.cod = cod;
		this.nome = nome;
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public String getCognome() {
		return cognome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	@Override
	public int compareTo(Tesserato a) {
		if(this.getNome().compareTo(a.getNome())!=0){
			return this.getNome().compareTo(a.getNome());
		}
		return this.getCognome().compareTo(a.getCognome());
	}


	
	
}
