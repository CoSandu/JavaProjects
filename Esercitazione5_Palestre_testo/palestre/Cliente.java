package palestre;

public class Cliente implements Persona {
	
	private String nome;
	private String cognome;
	private String codf;

	public Cliente(String nome, String cognome, String codf) {
		this.nome = nome;
		this.cognome = cognome;
		this.codf = codf;
	}

	@Override
	public int compareTo(Persona arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public String getCognome() {
		return cognome;
	}

	@Override
	public String getCodiceFiscale() {
		return codf;
	}

	@Override
	public PersonalTrainer getPersonalTrainer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		return nome+" "+cognome+" "+" "+codf;
	}

}
