package computer;

public class Computer {
	
	/*
	 * alla creazione, un computer deve essere dotato di una cartella con nome "root"
	 */
	protected long dimensioneHardDisk;
	
	protected Cartella cartella;
	
	public Computer(long dimensioneHardDisk) {
		this.dimensioneHardDisk = dimensioneHardDisk;
		
		this.cartella = new Cartella();
		
	}

	public long getDimensioneHardDisk() {
		return dimensioneHardDisk;
	}
	
	public Cartella getRoot(){
		return cartella;
	}
	
	public Cartella creaCartella(String nomeCartella, Cartella cartellaSuperiore){
		return cartellaSuperiore.aggiungiCartella(nomeCartella);
	}
	
	public String cercaCartella(String nomeCartella, Cartella cartellaSuperiore){
		return cartellaSuperiore.cartellaIn(nomeCartella)+"-"+cartellaSuperiore.toString();
	}
	
	public File creaFile(String nomeFile, Cartella cartellaSuperiore, long dimensione){
		return cartellaSuperiore.aggiungiFile(nomeFile, dimensione);
	}

	public String cercaFile(String nomeFile, Cartella cartellaSuperiore){
		return cartellaSuperiore.fileIn(nomeFile)+"-"+cartellaSuperiore.toString()+"-"+cartellaSuperiore.dimFile();
	}

	public File creaFileAudio(String nomeFile, Cartella cartellaSuperiore, long dimensione, int minuti, int secondi){
		return cartellaSuperiore.aggiungiFileAudio(nomeFile, dimensione, minuti, secondi);
	}

	public File creaFileImmagine(String nomeFile, Cartella cartellaSuperiore, long dimensione, int altezzaPixel, int larghezzaPixel, String modelloDispositivo){
		return cartellaSuperiore.aggiungiFileImmagine(nomeFile, dimensione, altezzaPixel, larghezzaPixel, modelloDispositivo);
	}

	public String elencoFileCartella(Cartella cartellaSuperiore){
		return cartellaSuperiore.fileCartella();
	}

	public long calcolaDimensioneOccupata(Cartella cartella){
		return cartella.dimCartella();	
	}
		
}
