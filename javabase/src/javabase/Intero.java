package javabase;

public class Intero {

	// Ipotetico tipo di dato di tipo classe per gestire un valore intero
	
	private int valore;
	
	public Intero(){
		this.valore = 0;
	}
	
	public Intero(int valore){
		this.valore = valore;
	}
	  
	public int getValore(){
		return valore;
	}
	
	public void setValore(int valore){
		this.valore = valore;
	}
	
}
