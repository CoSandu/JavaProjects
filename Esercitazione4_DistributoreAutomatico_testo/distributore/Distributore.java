package distributore;

public class Distributore {
	
  /**
   * Costruttore del distributore automatico
   */
  public Distributore() {
  }

  /**
   * Aggiunge uno snack al
   * distributore.
   * @param codiceSnack codice dello snack
   * @param nomeSnack nome dello snack
   * @param prezzoSnack prezzo dello snack
   * @param tipologiaSnack tipologia dello snack (dolce/salato)
   */
  public void aggiungiSnack(String codiceSnack, String nomeSnack, double prezzoSnack, String tipologiaSnack) {
  }
  
  /**
   * Restituisce il prezzo dello snack corrispondente
   * al codice dato
   * @param codiceSnack il codice dello snack
   * @return prezzo dello snack (se non trovato, ritorna 0.0)
   */
  public double getPrezzo(String codiceSnack) {
	  return 0.0;
  }

  /**
   * Restituisce il nome dello snack corrispondente
   * al codice dato
   * @param codiceSnack il codice dello snack
   * @return nome dello snack (se non trovato, ritorna "")
   */
  public String getNome(String codiceSnack) {
	  return "";
  }

  /**
   * Restituisce la tipologia dello snack corrispondente
   * al codice dato
   * @param codiceSnack il codice dello snack
   * @return tipologia dello snack (se non trovato, ritorna "")
   */
  public String getTipologia(String codiceSnack) {
	  return "";
  }

  /**
   * Carica una tessera specificando il codice ed il credito
   * Se non trova una nuova tessera, la crea e ne imposta il codice
   * @param codiceTessera il codice della tessera da ricaricare/creare
   * @param ricarica valore da caricare sulla tessera
   */
  public void caricaTessera(int codiceTessera, double ricarica) {
  }

  /**
   * Resituisce il credito corrispondente ad una tessera (se non trovato, restituisce 0.0)
   * @param codiceTessera il codice della tessera
   * @return credito corrispondente, oppure 0.0
   */
  public double getCredito(int codiceTessera) {
	  return 0.0;
  }

  /**
   * Imposta il contenuto di una colonna di snack
   * del distributore
   * @param numeroColonna numero della colonna per la quale impostare il numero di snack
   * @param codiceSnack codice dello snack
   * @param numeroSnack numero di snack inseriti nella colonna
   */
  public void impostaDisponibilitaColonna(int numeroColonna, String codiceSnack,
		  int numeroSnack) {
  }

  /**
   * Resituisce il numero di confezioni disponibili per un dato
   * codice di snack
   * @param codiceSnack codice dello snack
   * @return numero di confezioni disponibili nel distributore
   */
  public int getConfezioniDisponibili(String codiceSnack)  {
	  return 0;
  }

  /**
   * Calcola il valore della merce contenuta nel distributore
   * @return valore della merce contenuta
   */
  public double getValoreMerceInDistributore(){
	  return 0.0;
  }

  /**
   * Eroga lo snack verificando le condizioni necessarie
   * @return se ci sono abbastanza soldi sulla tessera e l'erogazione va a buon fine (viene trovato lo snack) ritorna il nuovo credito della tessera, altrimenti ritorna il vecchio credito;
   * Qualora non fosse stata identificata nessuna tessera con quel codice, ritorna 0.0.
   */
  public double eroga(String codiceSnack, int codiceTessera) {
	  return 0.0;
  }
}
