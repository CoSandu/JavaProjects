package collections;

public class Studente {
	
	private int matricola;
	private String name;
	private String cognome;
	private double media;
	
	public Studente(int matricola, String name, String cognome, double media) {
		this.matricola = matricola;
		this.name = name;
		this.cognome = cognome;
		this.media = media;
	}

	public int getMatricola() {
		return matricola;
	}

	public void setMatricola(int matricola) {
		this.matricola = matricola;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}
	
	public String toString(){
		return ""+this.matricola+" "+this.name+" "+this.cognome+" "+this.media;
	}


	public boolean equals(Object obj) { //mai cambiare la firma
		Studente altros = (Studente) obj; //operazione di downcast perche' aumento la specificita' di object 
		if(this.matricola == altros.matricola && 
				this.name.compareTo(altros.name)==0 &&
				this.cognome.compareTo(altros.cognome)==0 &&
				this.media == altros.media)
			return true;
		else
			return false;
	}
	
	

}
