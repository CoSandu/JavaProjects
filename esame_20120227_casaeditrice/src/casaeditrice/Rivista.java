package casaeditrice;

public class Rivista extends Pubblicazione{

	private String isbn;
	
	
	public Rivista(String titolo, char tipologia, String volume, int anno, int contributo) {
		super(titolo, tipologia, volume, anno, contributo);
	}
	
	
	
	public String getIsbn() {
		return isbn;
	}



	public void setIsbn(String isbn){
		this.isbn=isbn;
	}
	
}
