package torneidicalcio;
public class Classifica implements Comparable<Classifica>{
	private int punti;
	private String nomeS;
	public Classifica(int punti, String nomeS) {
		this.punti = punti;
		this.nomeS = nomeS;
	}
	public int getPunti() {
		return punti;
	}
	public int compareTo(Classifica o) {
		return -(this.punti-o.getPunti());
	}	
	public String toString(){
		return punti+" "+nomeS;
	}
}
