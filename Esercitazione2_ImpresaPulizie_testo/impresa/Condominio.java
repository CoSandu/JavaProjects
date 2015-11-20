package impresa;

public class Condominio {
	private String indirizzo;
	private String cap;
	private String citta;
	
	private Dipendenti dipendente[];
	private int numeroDipendentiCondominio;
	private int maxDipendenti = 4;
	
	public Condominio(String indirizzo, String cap, String citta) {
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.dipendente = new Dipendenti[maxDipendenti];
		this.numeroDipendentiCondominio = 0;
	}
	
	public String stampaCondo(){
		return indirizzo+" "+cap+" "+citta;
	}
	
	public void AddDipendent(Dipendenti dip){
		dipendente[numeroDipendentiCondominio] = dip;
		numeroDipendentiCondominio++;
	} 
		
	public String stampaDipendenti(){
		 String risultato = "";
		 for(int i = 0; i < numeroDipendentiCondominio; i++){
			 risultato += i+1 +" "+ dipendente[i].stampaDipendente();
			 if (i < numeroDipendentiCondominio-1)
				 risultato += "\n";
		 }
		 return risultato;
	}
	
	public int totDipendenti(){
		int cont = 0;
		for(int i = 0; i < numeroDipendentiCondominio; i++){
			cont++;
		}
		return cont;
	}
	
}
