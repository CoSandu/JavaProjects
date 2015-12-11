package palestre;

public class Cliente implements Persona {
	
	private String nome;
	private String cognome;
	private String codf;
	
	private PersonalTrainer trainer;

	public Cliente(String nome, String cognome, String codf) {
		this.nome = nome;
		this.cognome = cognome;
		this.codf = codf;
	}

	@Override
	public int compareTo(Persona pers) {
		if(this.cognome.compareTo(pers.getCognome())!=0)
			return this.cognome.compareTo(pers.getCognome());
		if(this.nome.compareTo(pers.getNome())!=0)
			return this.nome.compareTo(pers.getNome());
		return this.codf.compareTo(pers.getCodiceFiscale());
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
		return trainer;
	}
	
	public String toString(){
		return nome+" "+cognome+" "+" "+codf;
	}


	public void setTrainer(PersonalTrainer t) {
		this.trainer = t;
	}

}
