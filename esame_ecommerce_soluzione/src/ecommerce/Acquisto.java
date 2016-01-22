package ecommerce;

public class Acquisto implements Comparable<Acquisto>{

	private String data;
	private double valore;

	public Acquisto(String data, double valore){
		this.data = data;
		this.valore = valore;
	}

	public String getData() {
		return data;
	}

	public double getValore() {
		return valore;
	}

	public int compareTo(Acquisto a) {

		if(a.getData().compareTo(data)!=0)
			return a.getData().compareTo(data);
		else
		{
			return -(int)(a.getValore()-valore);
		}
	}
	
	
}
