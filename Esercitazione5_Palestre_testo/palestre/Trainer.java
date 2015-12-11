package palestre;

import java.util.*;

public class Trainer extends Cliente implements PersonalTrainer {
	private String matricola;
	private List<Persona> clienti = new LinkedList<Persona>();

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
		Collections.sort(clienti);
		return clienti;
	}
	
	public void setCliente(Cliente c){
		clienti.add(c);
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
