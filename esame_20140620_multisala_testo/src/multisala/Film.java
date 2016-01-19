package multisala;

public class Film {
	private String titolo;
	private String regista;
	private int anno;
	private int durata;
	
	public Film(String titolo, String regista, int anno, int durata) {
		this.titolo = titolo;
		this.regista = regista;
		this.anno = anno;
		this.durata = durata;
	}

	public String getTitolo() {
		return titolo;
	}

	public String getRegista() {
		return regista;
	}

	public int getAnno() {
		return anno;
	}

	public int getDurata() {
		return durata;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public void setRegista(String regista) {
		this.regista = regista;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
}
