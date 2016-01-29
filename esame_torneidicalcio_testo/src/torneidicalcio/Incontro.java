package torneidicalcio;

public class Incontro implements Comparable<Incontro>{
	
	private Torneo torneo;
	private int giornata;
	private Squadra squadra;
	private Squadra sospite;
	private int golCasa;
	private int golOspite;
	private String arbitro;
	
	


	public Incontro(Torneo torneo, int giornata, Squadra squadra, Squadra sospite,
			int golCasa, int golOspite, String arbitro) {
		this.giornata = giornata;
		this.squadra = squadra;
		this.sospite = sospite;
		this.golCasa = golCasa;
		this.golOspite = golOspite;
		this.arbitro = arbitro;
	}

	public int getGiornata() {
		return giornata;
	}

	public Squadra getSquadraCasa() {
		return squadra;
	}

	public Squadra getSquadraOspite() {
		return sospite;
	}

	public int getNumeroGolSquadraCasa() {
		return golCasa;
	}

	public int getNumeroGolSquadraOspite() {
		return golOspite;
	}

	public String getArbitro() {
		return arbitro;
	}

	@Override
	public int compareTo(Incontro ar) {
		
		return this.getGiornata()-ar.getGiornata();
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

}
