package ecommerce;
import java.util.*;

public class UtenteRegistrato extends Utente{

	private String username;
	private String password;
	
	private boolean loggato=false;
	
	private List<Acquisto> storicoAcquisti = new LinkedList<Acquisto>();
	private List<String> elencoCodiciProdottiAcquistati = new LinkedList<String>();
	
	public UtenteRegistrato(int codice, String nome, String cognome, String email, String indirizzo, String username, String password) {
		super(codice, nome, cognome, email, indirizzo);

		this.username=username;
		this.password=password;
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}




	public List<Acquisto> getStoricoAcquisti() {
		return storicoAcquisti;
	}



	public List<String> getElencoCodiciProdottiAcquistati() {
		return elencoCodiciProdottiAcquistati;
	}



	public void login(String username, String password) throws EccezioneLoginFallito{
		if(this.username.compareTo(username)==0 && this.password.compareTo(password)==0){
			loggato=true;
		}			
		else{
			throw new EccezioneLoginFallito();
		}
	}

	public void logout(){
		loggato=false;
	}
	
	public boolean isLoggato() {
		return loggato;
	}
	
	
	
	public double paga(String data){
		
		for(String codiceProdotto : super.carrello.keySet()){
			elencoCodiciProdottiAcquistati.add(codiceProdotto);
		}
		
		carrello.clear();
		elencoCodiciProdottiAcquistati.clear();

		if(loggato)
			storicoAcquisti.add(new Acquisto(data, valoreCarrello));

		double risultato = valoreCarrello;
		valoreCarrello = 0;
		return risultato;
	}
	
	public String storicoAcquisti(){
		if(!loggato)
		return "Login richiesto!";
		
		String risultato="";
		Collections.sort(storicoAcquisti);
		for(Acquisto acquisto : storicoAcquisti){
			risultato +=""+acquisto.getData()+" "+acquisto.getValore()+"; ";
		}
		return risultato;
	}
	
	
	
}
