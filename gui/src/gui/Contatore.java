package gui;

public class Contatore {

	private int valore;
	
	public Contatore(){
		valore=0;
	}
	
	public int getValore(){
		return valore;
	}
	
	public void incrementa(){
		valore++;
	}
	
	public void decrementa(){
		valore--;
	}
	
}
