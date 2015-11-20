package biblioteca;

public class Libro {

	private String titolo;
	private String autore;
	private String editore;
	// double prezzo;
	// String ISBN;
	// ...
	
	public Libro(String titolo, String autore, String editore) {
		this.titolo = titolo;
		this.autore = autore;
		this.editore = editore;
	}
	
	public String stampati(){
		return titolo+"-"+autore+"-"+editore; // +"-"+prezzo+"-"+ISBN;
	}

	
	
}
