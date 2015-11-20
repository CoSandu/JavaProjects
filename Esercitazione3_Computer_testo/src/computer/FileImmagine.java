package computer;

public class FileImmagine extends File {
	
	protected int altezza;
	protected int larghezza;
	protected String nomeDispositivo;

	public FileImmagine(String nf, long df, int alt, int lar, String nDisp) {
		super(nf, df);
		altezza = alt;
		larghezza = lar;
		nomeDispositivo = nDisp;
	}
	public String nomeFile(){
		return super.toString() + altezza + larghezza + nomeDispositivo;		
	}

}
