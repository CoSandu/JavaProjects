package distributore;

public class Colonna {
	
	private int numColonna;
	private Snack snack[];

	private final static int MAXCOL = 10;
	
	public Colonna() {
		this.numColonna = 0;
		snack = new Snack[MAXCOL];
		
	}
	
	public void addSnack(Snack c){
		snack[numColonna] = c;
		numColonna++;
	}

}
