package aziendaagricola;

public class Coltivazione {
	
	private String prodotto;
	private int meseSemina;
	private int mseRaccolto;
	private Fertilizzante fertilizzante;


	public Coltivazione(String prodotto, int meseSemina, int mseRaccolto) {
		this.prodotto = prodotto;
		this.meseSemina = meseSemina;
		this.mseRaccolto = mseRaccolto;
	}

	public String getProdotto() {
		return prodotto;
	}

	public int getMeseSemina() {
		return meseSemina;
	}

	public int getMeseRaccolta() {
		return mseRaccolto;
	}
	
	public void setProdotto(String prodotto) {
		
	}

	public void setMeseSemina(int meseSemina) {
		
	}

	public void setMeseRaccolta(int meseRaccolta) {
		
	}

   public Fertilizzante richiedeFertilizzante(char tipo, String nome, float costo, int periodicita, int quantitaImpiego){
	   if(tipo=='N'){
		   fertilizzante = new FertilizzanteNaturale(tipo, nome, costo, periodicita, quantitaImpiego);
		   return fertilizzante;
	   }
	   else{
		   fertilizzante = new FertilizzanteArtificiale(tipo, nome, costo, periodicita, quantitaImpiego);
	   		return fertilizzante;
	   }

	   
   }
	
}
