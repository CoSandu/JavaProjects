package libreria;

public class Libro {

	private String titolo;
	private String autore;
	private int anno;
	private double prezzo;
	private Editore editore; // Riferimento all'editore, non il nome
	private int quantita;    // No caratteri speciali
	
	// Gestione classifiche
	int mesi[] = new int[12];
	int settimane[] = new int[52]; 
	
	// Gestione ordini
	private int soglia;
	private int quantitaRiordino;
	private Libreria libreria;
	
    public Libro(String titolo, String autore, int anno, double prezzo, Editore editore, Libreria libreria) {
    	this.titolo = titolo;
    	this.autore = autore;
    	this.anno=anno;
    	this.prezzo=prezzo;
    	this.editore=editore;
    	for(int i=0;i<12;i++)
    		mesi[i]=0;
    	for(int i=0;i<52;i++)
    		settimane[i]=0;
    	this.libreria= libreria;
	}

	public String getTitolo(){
        return titolo;
    }
    
    public String getAutore(){
        return autore;
    }
    
    public int getAnno(){
        return anno;
    }

    public double getPrezzo(){
        return prezzo;
    }
    
    public Editore getEditore(){
        return editore;
    }

    public void setQuantita(int q){        
    	quantita=q;
    }
    
    public int getQuantita(){
        return quantita;	
    }

    public void registraVendita(int settimana, int mese){
    	mesi[mese-1]++;
    	settimane[settimana-1]++;
    	this.quantita--;
    	
    	if(this.quantita==this.soglia)
    		libreria.creaOrdine(this,quantitaRiordino);
    }
    

    public void setParametri(int soglia, int quantitaRiordino){   
    	this.soglia=soglia;
    	this.quantitaRiordino=quantitaRiordino;
    }
    
    // Metodo aggiunto per gestire l'incremento delle quantita' dalla classe Ordine (delega)
    public void incrementa(int quantita){
    	this.quantita+=quantita;
    }

    // Metodo aggiunto perche' il Libro sappia descriversi
    public String toString(){
    	return ""+titolo+" "+autore+" ecc.";
    }
}











