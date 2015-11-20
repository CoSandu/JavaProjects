package impresa;

public class Dipendenti {
	private String nome;
	private String cognome;
	private double stipendio;
	private Condominio condomini[];
	private int maxCondo = 10;
	private int numeroCondominiDipendenti = 0;
	
	public Dipendenti(String nome, String cognome, double stipendio) {
		this.nome = nome;
		this.cognome = cognome;
		this.stipendio = stipendio;
		this.condomini = new Condominio[maxCondo];
	}
	
	public String stampaDipendente(){
		return nome+" "+cognome+" "+stipendio;
	}

	public void AddCondominio(Condominio con){
		condomini[numeroCondominiDipendenti] = con;
		numeroCondominiDipendenti++;
	} 
		
	public String StampaCondomini(){
		 String risultato = "";
		 for(int i = 0; i < numeroCondominiDipendenti; i++){
			 risultato += i+100+" "+ condomini[i].stampaCondo();
			 if (i < numeroCondominiDipendenti-1)
				 risultato += "\n";
		 }
		 return risultato;
	}
	
	public int totCondo(){
		int cont = 0;
		for(int i = 0; i < numeroCondominiDipendenti; i++){
			cont++;
		}
		return cont;
	}

}
