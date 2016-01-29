package torneidicalcio;

import java.util.*;

public class Dirigente extends Tesserato {

	private String ruolo;
	private Squadra squadra;
	
	private List<Squadra>squadredirett = new LinkedList<Squadra>();

	public Dirigente(int cod, String nome, String cognome, Squadra nomeSquadra, String ruolo) {
		super(cod, nome, cognome);
		this.ruolo = ruolo;
		this.squadra = nomeSquadra;
	}
	

	public Squadra getSquadra() {
		return squadra;
	}

	public String getRuolo() {
		return ruolo;
	}
	
	
}
