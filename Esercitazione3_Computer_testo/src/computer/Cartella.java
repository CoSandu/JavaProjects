package computer;

public class Cartella {
	protected String nomeNuovaCartella;
	protected Cartella cartelle[];
	protected static int MAX_CARTELLE_AND_FILE = 500;
	protected int contatore;
	protected long dimcartella;
	
	protected File files[];
	protected int contaFile;
	
	
	public Cartella() {
		this.nomeNuovaCartella = "root";
		this.cartelle = new Cartella[MAX_CARTELLE_AND_FILE];
		this.files = new File[MAX_CARTELLE_AND_FILE];
		dimcartella = 10;
	}
	
	public Cartella(String nomeNuovaCartella) {
		this.nomeNuovaCartella = nomeNuovaCartella;
		this.cartelle = new Cartella[MAX_CARTELLE_AND_FILE];
		this.files = new File[MAX_CARTELLE_AND_FILE];
		this.contatore = 0;
		this.contaFile = 0;
		dimcartella = 10;
	}
	
	public Cartella getEsistente(String nomeCartella){
		for (Cartella c: cartelle){
			if (c != null && c.toString().compareTo(nomeCartella) == 0)
				return c;
		}
		return null;
	}
	
	public Cartella aggiungiCartella(String nomeCartella){
		if (getEsistente(nomeCartella) == null){
			Cartella c = new Cartella(nomeCartella);
			cartelle[contatore] = c;
			contatore++;
			return c;	
		}
		return null;
	}
	
	public String toString(){
		return nomeNuovaCartella;
	}
	
	public String cartellaIn(String nomeCartella) {
		String cartellaTrovata = "";
		for (int i=0;i<contatore;i++)
			if (cartelle[i] != null && cartelle[i].toString().compareToIgnoreCase(nomeCartella) == 0)
				cartellaTrovata = cartelle[i].toString();
		return cartellaTrovata;
	}
	
	public File getFile(String nomeFile){
		for (File f : this.files)
			if (f != null && f.toString().compareTo(nomeFile) == 0)
				return f;
		return null;
	}
	
	public File aggiungiFile(String nomeF, long dim){
		if (getFile(nomeF)== null){
			File f = new File (nomeF, dim);
			files[contaFile] = f;
			contaFile++;
			return f;
		}
		return null;

	}
	
	public File aggiungiFileAudio(String nomeF, long dim, int minuti, int secondi){
		if (getFile(nomeF)== null){
			File f = new FileAudio(nomeF, dim, minuti, secondi);
			files[contaFile] = f;
			contaFile++;
			return f;
		}
		return null;

	}
	
	public File aggiungiFileImmagine(String nomeF, long dim, int altezzaPixel, int larghezzaPixel, String modelloDispositivo){
		if (getFile(nomeF)== null){
			File f = new FileImmagine(nomeF, dim, altezzaPixel, larghezzaPixel, modelloDispositivo);
			files[contaFile] = f;
			contaFile++;
			return f;
		}
		return null;

	}
	
	public String fileIn(String nomeFile) {
		String fileTrovato = "";
		for (int i=0;i<contaFile;i++)
			if (files[i] != null && files[i].toString().compareToIgnoreCase(nomeFile) == 0)
				fileTrovato = files[i].toString();
		return fileTrovato;
	}
	
	public String fileCartella(){
		String fileCartella = "";
		for (File t : files)
			if (t !=null)
				fileCartella += t.toString()+ "\n";
		return fileCartella;	
	}
	
	public long dimFile(){
		long dim = 0;
		for (File t : files)
			if (t !=null)
				dim += t.printdim();
		return dim;	
	}
	
	public long dimCartella(){
		long dim = dimcartella;
		for (Cartella tC:cartelle)
			if (tC !=null)
				dim += tC.dimCartella() + tC.dimFile();
		return dim;	
	}
}
