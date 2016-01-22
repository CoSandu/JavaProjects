package casaeditrice;

public class Conferenza extends Pubblicazione{
	private String luogo;

	public Conferenza(String titolo, char tipologia, String volume, int anno, int contributo) {
		super(titolo, tipologia, volume, anno, contributo);
	}





	public String getLuogo() {
		return luogo;
	}







	public void setLuogo(String luogo) {
		this.luogo=luogo;
	}
	
}
