package aziendaagricola;

public class FertilizzanteArtificiale extends Fertilizzante{
	
	private int rischio;

	public FertilizzanteArtificiale(char tipo, String nome, float costo, int periodicita, int quantitaImpiego) {
		super(tipo, nome, costo, periodicita, quantitaImpiego);
		
	}

	public void setRischio(int rischio){
		this.rischio =rischio;

	}

	public int getRischio(){

		return rischio;
	}

}
