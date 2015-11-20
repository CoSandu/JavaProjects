package impresa;

public class Impresa {
	private String nome;
	private String indirizzo;
	private String cap;
	private String citta;
	private String proprietario;
	private Dipendenti dipendenti[];
	private Condominio condomini[];
	private int numdip = 1;
	final int max_dip = 51;
	private int condo = 100;
	final int max_condo = condo + 200;


	public Impresa(String nome, String indirizzo, String cap, String citta){
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		dipendenti = new Dipendenti[max_dip];
		condomini = new Condominio[max_condo];
	}
	
	public String getNome(){
		return nome;
	}

	public String getIndirizzo(){
		return indirizzo;
	}
	
	public String getCap() {
		return cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setProprietario(String nome, String cognome){
		proprietario = nome+" "+cognome;
	}
	
	public String getProprietario(){
		return proprietario;
	}	
	
	public int assumiDipendente(String nome, String cognome, double stipendio){
		Dipendenti temp = new Dipendenti(nome, cognome, stipendio);
		dipendenti[numdip] = temp;
		numdip++;
		return numdip-1;
	}
	
	public String dipendente(int codice){
		String dipendente;
		dipendente = codice+" "+ dipendenti[codice].stampaDipendente();
		return dipendente;
	}
	
	public int aggiungiCondominio(String indirizzo, String cap, String citta){
		Condominio temp = new Condominio(indirizzo, cap, citta);
		condomini[condo] = temp;
		condo++;
		return condo-1;
	}
	
	public String condominio(int codice){
		String condominio;
		condominio = codice+" "+condomini[codice].stampaCondo();
		return condominio;
	}
	
	public void assegna(int codiceDipendente, int codiceCondominio){
		condomini[codiceCondominio].AddDipendent(dipendenti[codiceDipendente]);
		dipendenti[codiceDipendente].AddCondominio(condomini[codiceCondominio]);
	}
	
	public String elencoDipendenti(int codiceCondominio){
		String dipendentiCondo = "";
		dipendentiCondo += condomini[codiceCondominio].stampaDipendenti();
		return dipendentiCondo;
	}

	public String elencoCondomini(int codiceDipendente){
		String condoDipendenti = "";
		condoDipendenti += dipendenti[codiceDipendente].StampaCondomini();
		return condoDipendenti;
	}

	public int numeroDipendenti(int codiceCondominio){
		return condomini[codiceCondominio].totDipendenti();
	}

	public int numeroCondomini(int codiceDipendente){
		return dipendenti[codiceDipendente].totCondo();
	}

	public String elencoDipendentiSenzaCondomini(){
		String dipSenzaCondo = "";
		for (int i=1; i<numdip; i++){
			if(dipendenti[i].totCondo() == 0 && dipendenti[i] != null)
				if (dipSenzaCondo == "")
					dipSenzaCondo += i+" "+ dipendenti[i].stampaDipendente()+"\n";
				else
					dipSenzaCondo += i+" "+ dipendenti[i].stampaDipendente();
			
		}
		return dipSenzaCondo;
	}

	public String elencoCondominiSenzaDipendenti(){
		String condoSenzaDip = "";
		for (int i=100; i<condo; i++){
			if(condomini[i].totDipendenti() == 0 && condomini[i] !=null)
				if (condoSenzaDip == "")
					condoSenzaDip += i+" "+condomini[i].stampaCondo() + "\n";
				else
					condoSenzaDip += i+" "+condomini[i].stampaCondo();
		}
		return condoSenzaDip;
	}

}



