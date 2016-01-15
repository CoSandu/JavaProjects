package supermercato;

public class ProdottoDaFrigo extends Prodotto{
	
	private int TemperaturaDiConservazione;

	public ProdottoDaFrigo(String codice, String nome, int volume, boolean daFrigo) {
		super(codice, nome, volume, daFrigo);
	}

	public int getTemperaturaDiConservazione(){
		return TemperaturaDiConservazione;
	}

	public void setTemperaturaDiConservazione(int temperaturaDiConservazione){
		this.TemperaturaDiConservazione = temperaturaDiConservazione;
	}

}
