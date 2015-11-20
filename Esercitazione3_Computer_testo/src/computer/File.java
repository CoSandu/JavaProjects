package computer;

public class File {
	protected String nomefile;
	protected long dimensione;
	
	public File(String nf, long df) {
		nomefile = nf;
		dimensione = df;
	}
	
	public String toString(){
		return nomefile;
	}
	
	public long printdim(){
		return dimensione;
	}
}
