package palestre;

import java.util.Collection;

public class Trainer extends Cliente implements PersonalTrainer {
	private String matricola;

	public Trainer(String nome, String cognome, String codf, String mat) {
		super(nome, cognome, codf);
		matricola = mat;
	}

	@Override
	public String getMatricola() {
		return matricola;
	}

	@Override
	public Collection<Persona> getClienti() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Persona> getClientiOrdinatiPerEtaDecrescente() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString(){
		return super.toString() +" "+ matricola;
	}

}
