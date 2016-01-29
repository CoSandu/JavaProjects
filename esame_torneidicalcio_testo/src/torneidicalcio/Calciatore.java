package torneidicalcio;

public class Calciatore extends Tesserato{

	private String ruolo;
	private int maglia;
	private Squadra squadra;
	
	public Calciatore(int cod, String nome, String cognome, Squadra nomeSquadra, String ruolo,
			int maglia) {
		super(cod, nome, cognome);
		this.ruolo = ruolo;
		this.maglia = maglia;
		this.squadra = nomeSquadra;
	}

	public Squadra getSquadra() {
		return squadra;
	}

	public String getRuolo() {
		return ruolo;
	}

	public int getNumeroMaglia() {
		return maglia;
	}
	
}

