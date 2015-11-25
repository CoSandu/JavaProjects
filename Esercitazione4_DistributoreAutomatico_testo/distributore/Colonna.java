package distributore;

import java.util.LinkedList;
import java.util.List;

public class Colonna {

	private int codCol;
	private List <Snack> snacks;
	
	public Colonna(int codCol) {
		this.codCol = codCol;
		snacks = new LinkedList<Snack>();	  
	}

	public int getCodCol() {
		return codCol;
	}

	public void setCodCol(int codCol) {
		this.codCol = codCol;
	}

	public void addSnack(Snack s){
		snacks.add(s);
	}
	
	public int writeColonna(int codCol) {
		return codCol;
	}
	
	public int listLenght(String codiceSnack){
		int lung = 0;
		for (Snack s:snacks){
			if(s!=null && s.getCodice().equalsIgnoreCase(codiceSnack)){
				lung += snacks.size();
				break;
			}
		}
		return lung;
	}
	
	public double merceDist(){
		double p = 0.0;
		for (Snack s:snacks){
			if(s!=null){
				p+= snacks.size()*s.getPrezzoSnack();
				break;
			}
		}
		return p;
	}
}
