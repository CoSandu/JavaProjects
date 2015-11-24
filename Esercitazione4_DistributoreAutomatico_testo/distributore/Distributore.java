package distributore;

import java.util.LinkedList;
import java.util.List;

public class Distributore {
	private List <Snack> snacks;
	private List <Tessera> tessere;
	
	private Colonna colonne[];
	private final static int MAXCOL = 10;
	private int colAtt;
  /**
   * Costruttore del distributore automatico
   */
	
  public Distributore() {
	 snacks = new LinkedList<Snack>();	  
	 tessere = new LinkedList<Tessera>();
	 
	 colonne = new Colonna[MAXCOL];
	 this.colAtt = 0;
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
	  Snack s = new Snack(codiceSnack, nomeSnack, prezzoSnack, tipologiaSnack);
	  snacks.add(s);
  }
  
  /**
   * Restituisce il prezzo dello snack corrispondente
   * al codice dato
   * @param codiceSnack il codice dello snack
   * @return prezzo dello snack (se non trovato, ritorna 0.0)
   */
  public double getPrezzo(String codiceSnack) {
	  double prezzo = 0.0;
	  for (Snack s:snacks){
		  if(s!=null && s.getCodice().equalsIgnoreCase(codiceSnack))
			  prezzo += s.getPrezzoSnack();
	  }
	  return prezzo;
  }

  /**
   * Restituisce il nome dello snack corrispondente
   * al codice dato
   * @param codiceSnack il codice dello snack
   * @return nome dello snack (se non trovato, ritorna "")
   */
  public String getNome(String codiceSnack) {
	  String nome = "";
	  for (Snack s:snacks){
		  if (s!=null && s.getCodice().equalsIgnoreCase(codiceSnack))
			  nome+=s.getNome();
	  }
	  return nome;
  }

  /**
   * Restituisce la tipologia dello snack corrispondente
   * al codice dato
   * @param codiceSnack il codice dello snack
   * @return tipologia dello snack (se non trovato, ritorna "")
   */
  public String getTipologia(String codiceSnack) {
	  String tipologia = "";
	  for (Snack s:snacks){
		  if (s!=null && s.getCodice().equalsIgnoreCase(codiceSnack))
			  tipologia+=s.getTipologiaSnack();
	  }
	  return tipologia;
  }
  
  /**
   * Controlla l'esistenza di tessere nel sistema
   * @param codiceTessera
   */
  public Tessera getEsistente(int codiceTessera){
	  for (Tessera t:tessere){
		  if (t!=null && t.getCodiceTessera() == codiceTessera)
			  return t;
	  }
	  return null;
  }

  /**
   * Carica una tessera specificando il codice ed il credito
   * Se non trova una nuova tessera, la crea e ne imposta il codice
   * @param codiceTessera il codice della tessera da ricaricare/creare
   * @param ricarica valore da caricare sulla tessera
   */
  public void caricaTessera(int codiceTessera, double ricarica) {
	  if (this.getEsistente(codiceTessera)==null){
		  Tessera t = new Tessera(codiceTessera, ricarica);
		  tessere.add(t);
	  }
	  else{
		  Tessera t = this.getEsistente(codiceTessera);
		  t.setRicarica(ricarica + t.getRicarica());
	  }  		  
	  		  
  }

  /**
   * Resituisce il credito corrispondente ad una tessera (se non trovato, restituisce 0.0)
   * @param codiceTessera il codice della tessera
   * @return credito corrispondente, oppure 0.0
   */
  public double getCredito(int codiceTessera) {
	  double credito = 0.0;
	  for (Tessera t:tessere){
		  if(t!=null && t.getCodiceTessera() == codiceTessera)
			  credito+=t.getRicarica();
	  }
	  return credito;
  }

  /**
   * Restituisco lo snack in base ad un codice di input
   * @param codiceSnack
   * @return oggetto snack ricercato, oppure null
   */
  public Snack getSnackFromCode(String codiceSnack){
	  for (Snack s:snacks){
		  if (s.getCodice() == codiceSnack)
			  return s;
	  }
	  return null;
  }
  
  /**
  * Controlla l'esistenza delle colonne già presenti
  * @param numeroColonna
  * @return l'oggetto colonna se già presente, oppure null
  */
 public Colonna getEsistenteColonna(int numeroColonna){
	  for (Colonna c:colonne){
		  if (c!=null && c.getCodCol() == numeroColonna)
			  return c;
	  }
	  return null;
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
	  if (this.getEsistenteColonna(numeroColonna)==null){
		  int completo = 0;
		  Colonna c = new Colonna(numeroColonna);
		  while (completo < numeroSnack){
			  c.addSnack(getSnackFromCode(codiceSnack));
			  completo++;
	  }
		  colonne[colAtt] = c;
		  colAtt++;
	  }
	  else {
		  int completo = 0;
		  Colonna c = new Colonna(numeroColonna);
		  while (completo < numeroSnack){
			  c.addSnack(getSnackFromCode(codiceSnack));
			  completo++;
	  }
		  colonne[c.writeColonna(numeroColonna)-1] = c;
	  }

  }
  

  /**
   * Resituisce il numero di confezioni disponibili per un dato
   * codice di snack
   * @param codiceSnack codice dello snack
   * @return numero di confezioni disponibili nel distributore
   */
  public int getConfezioniDisponibili(String codiceSnack)  {
	  int confDisp =0;
	  for (Colonna c:colonne){
		  if(c!=null){
			  confDisp += c.listLenght(codiceSnack);
		  }
	  }
	  return confDisp;
  }

  /**
   * Calcola il valore della merce contenuta nel distributore
   * @return valore della merce contenuta
   */
  public double getValoreMerceInDistributore(){
	  double pTot=0.0;
	  for (Colonna c:colonne){
		  if(c!=null){
			  pTot+=c.merceDist();
		  }
	  }
	  return pTot;
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
