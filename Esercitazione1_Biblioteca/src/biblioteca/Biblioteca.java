package biblioteca;

public class Biblioteca {

    // Inserire tutti gli attributi necessari
    // Eventualmente creare altre classi
	private String nomeBiblioteca;
	private String[] libri = new String [100];
	private int i=1;
	
  /**
   * Crea una nuova biblioteca
   */
  public Biblioteca() {

  }

  /**
   * Imposta il nome della biblioteca
   */
  public void setNome(String nome) {
	  nomeBiblioteca = nome;
  }

  /**
   * Restituisce il nome della biblioteca
   */
  public String getNome() {
	  return nomeBiblioteca;
  }

  /**
   * Aggiunge un nuovo libro alla biblioteca
   */  
  public void aggiungiLibro(String titolo, String autore, String editore){
	  libri[i] = titolo + '-'  + autore + '-' + editore;
	  i++;
  }

  /**
   * Restituisce il primo libro
   */  
  public String primo() {
	  return libri[1];
  }

  /**
   * Restituisce l'i-esimo libro presente nel catalogo della biblioteca
   */
  public String libro(int i) {
	  return libri[i];
  }

  /**
   * Restituisce una stringa con l'elenco dei libri,
   * ciascuno su una riga diversa
   * Ogni riga termina con ';\n', l'ultima con '.'
   */
  public String elenco() {
	  String libro = new String(libri[1]);
	  for (int i = 2; i < libri.length; i++){
		  if (i < libri.length && libri[i] != null){
			  libro = libro + ";\n" + libri[i];
		  }
	  }
	  return libro + '.';
  }
}
