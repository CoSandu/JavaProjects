package biblioteca;

public class Biblioteca {

    // Inserire tutti gli attributi necessari
    // Eventualmente creare altre classi
	
  String nome;	
  
  // Tre array "paralleli", uno per i titoli, uno per gli autori, uno per gli editori
  
  final int MAX_LIBRI = 100;
  
  /*
   String titoli[];
   String autori[];
   String editori[];
  */
  
  Libro libri[];
  
  int numLibri;
		  
  /**
   * Crea una nuova biblioteca
   */
  public Biblioteca() {
	  nome="";
	  /*
	   titoli = new String[MAX_LIBRI];
	   autori = new String[MAX_LIBRI];
       editori = new String[MAX_LIBRI];
      */
	  libri = new Libro[MAX_LIBRI];
      numLibri = 0;
  }

  /**
   * Imposta il nome della biblioteca
   */
  public void setNome(String nome) {
	  this.nome = nome; // Copio il contenuto del param. nome 
	                    // nell'attributo omonimo
	                    // this significa questo oggetto (not. puntata)
  }

  /**
   * Restituisce il nome della biblioteca
   */
  public String getNome() {
	  return nome;
  }

  /**
   * Aggiunge un nuovo libro alla biblioteca
   */  
  public void aggiungiLibro(String titolo, String autore, String editore){
      /*
	   titoli[numLibri] = titolo;
	   autori[numLibri] = autore;
	   editori[numLibri] = editore;
      */
	  
	  // 1) Creare un oggetto di tipo Libro
	  
	  Libro temp = new Libro(titolo, autore, editore);
	  
	  // 2) Aggiungere il libro creato all'array libri
	  
	  libri[numLibri] = temp;
	  
	  // 3) Aggiorna numero di libri nell'array
	  
	  numLibri++;
  }

  /**
   * Restituisce il primo libro
   */  
  public String primo() {
	  
	  // System.out.println()
	  
	  String risultato; 
	  //risultato = titoli[0]+"-"+autori[0]+"-"+editori[0];
	  //risultato = libri[0].titolo+"-"+libri[0].autore+"-"+libri[0].editore;
	  risultato = libri[0].stampati();
	  return risultato;
  }

  /**
   * Restituisce l'i-esimo libro presente nel catalogo della biblioteca
   */
  public String libro(int i) {

	  String risultato;
	  //risultato = titoli[i-1]+"-"+autori[i-1]+"-"+editori[i-1];
	  //risultato = libri[i-1].titolo+"-"+libri[i-1].autore+"-"+libri[i-1].editore;
	  risultato = libri[i-1].stampati();
	  return risultato;
  }

  /**
   * Restituisce una stringa con l'elenco dei libri,
   * ciascuno su una riga diversa
   * Ogni riga termina con ';\n', l'ultima con '.'
   */
  public String elenco() {

	  String risultato = "";
	  for(int i = 1; i <= numLibri; i++){
		  //risultato += titoli[i-1]+"-"+autori[i-1]+"-"+editori[i-1];
		  //risultato += libri[i-1].titolo+"-"+libri[i-1].autore+"-"+libri[i-1].editore;
		  risultato+= libri[i-1].stampati();
		  if(i!=numLibri)
			  risultato+=";\n";
		  else
			  risultato+=".\n";
	  }
	  
	  return risultato;
  }
  
}








