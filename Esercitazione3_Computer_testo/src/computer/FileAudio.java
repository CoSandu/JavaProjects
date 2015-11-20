package computer;

public class FileAudio extends File {
	
	protected int minuti;
	protected int secondi;
	

	public FileAudio(String nf, long df, int min, int sec) {
		super(nf, df);
		minuti = min;
		secondi = sec;
	}
	
	public String printaFileSpeciale(){
		return super.toString() + minuti + secondi;
	}

}
