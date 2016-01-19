package libreria;

public class Ordine {

	private Libro libro;
	private int quantita;
	private int numero;
	
	private boolean consegnato = false;
	
	public Ordine(int numero, Libro libro, int quantita){
		this.numero=numero;
		this.libro=libro;
		this.quantita=quantita;
	}
	
    public Editore getEditore(){
        return libro.getEditore();
    }
    
    public Libro getLibro(){
        return libro;
    }
    
    public int getQuantita(){
        return quantita;
    }

    public boolean isConsegnato(){
        return consegnato;
    }

    public int getNumero(){
        return numero;
    }
    
    // Metodo aggiunto per gestire la consegna degli ordini (delega)
    public void consegna(){
    	consegnato=true;
    	libro.incrementa(quantita);
    }
    
    public String toString(){
    	return ""+libro+" "+quantita+" "+numero;
    }
}
