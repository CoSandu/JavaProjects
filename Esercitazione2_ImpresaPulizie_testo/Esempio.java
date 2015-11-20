import impresa.*;

/**
 * Classe con un main di esempio.
 */
public class Esempio {

	public static void main(String[] args) {
		
		String nomeImpresa = "Pulisci e Splendi";
		String indirizzoImpresa = "Piazza Castello 1";
		String capImpresa = "10124";
		String cittaImpresa = "Torino";
		
		Impresa impresa = new Impresa(nomeImpresa, indirizzoImpresa, capImpresa, cittaImpresa);
		
		impresa.setProprietario("Linda", "Bianchi");
		
		System.out.println("Proprietario dell'impresa " 
		+ impresa.getNome() + " con sede in "+impresa.getIndirizzo()+ ", cap "+impresa.getCap()+", citta' "+impresa.getCitta()+": "
				+ impresa.getProprietario());
		
		int dA = impresa.assumiDipendente("Marco", "Rossi", 40000.0);
		int dB = impresa.assumiDipendente("Gianni", "Neri", 50000.0);
		
		System.out.println();
		System.out.println("Dipendenti creati: ");
		System.out.println(dA);
		System.out.println(dB);
		
		System.out.println();
		System.out.println("Dipendente con il primo codice: " + impresa.dipendente(dA));
		
		int cX = impresa.aggiungiCondominio("Piazza Vittorio 5", "10123", "Torino");
		
		impresa.aggiungiCondominio("Corso Duca degli Abruzzi 1", "10129", "Torino");
		
		impresa.assegna(dA, cX);
		impresa.assegna(dB, cX);
		
		System.out.println();
		System.out.println("Elenco dipendenti assegnati al condominio con codice "+cX+":");
		System.out.println(impresa.elencoDipendenti(cX));
		
		System.out.println();
		System.out.println("Elenco condomini non assegnati a nessun dipendente:");
		System.out.println(impresa.elencoCondominiSenzaDipendenti());
	}
}
