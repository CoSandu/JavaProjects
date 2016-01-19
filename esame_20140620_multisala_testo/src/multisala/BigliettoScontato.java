package multisala;

public class BigliettoScontato extends Biglietto{
	
	private int percSconto;
	private String tipoSconto;

	public BigliettoScontato(String codBiglietto, Proiezione proiezione, int fila, int posto,int percentualeSconto,
			String tipologiaSconto) {
		super(codBiglietto, proiezione, fila, posto);
		percSconto = percentualeSconto;
		tipoSconto = tipologiaSconto;
	}

	public int getPercentualeSconto() {
		return percSconto;
	}

	public String getTipologiaSconto() {
		return tipoSconto;
	}

	public void setPercentualeSconto(int percentualeSconto) {
		this.percSconto = percentualeSconto;
	
	}

	public void setTipologiaSconto(String tipologiaSconto) {
		this.tipoSconto=tipologiaSconto;
	}	
}
