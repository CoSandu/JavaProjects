package multisala;

import java.util.*;

public class Proiezione {
	
	private Film nomeFilm;
	private Sala nomeSala;
	private String data;
	private String ora;
	private double prezzoIntero;
	private boolean is3D;
	private int postiLib;
	
	private List<Biglietto>bigliettiProiezione = new LinkedList<Biglietto>();
	private Biglietto mappa[][];
	
	public Proiezione(Sala nomeSala, Film nomeFilm, String data, String ora, double prezzoIntero, boolean is3d) {
		this.nomeFilm = nomeFilm;
		this.nomeSala = nomeSala;
		this.data = data;
		this.ora = ora;
		this.prezzoIntero = prezzoIntero;
		is3D = is3d;
		postiLib = nomeSala.getPostitotali();
		
		mappa = new Biglietto[nomeSala.getNumeroFile()][nomeSala.getNumeroPostiPerFila()];
	}

	public Film getFilm() {
		return nomeFilm;
	}

	public Sala getSala() {
		return nomeSala;
	}

	public String getData() {
		return data;
	}

	public String getOra() {
		return ora;
	}

	public double getPrezzoIntero() {
		return prezzoIntero;
	}

	public boolean isIn3D() {
		return is3D;
	}
	
	public int postiLiberi(){
		return postiLib;
	}

	public String situazione(){
		String risultato="";
		for(int f = 0; f < nomeSala.getNumeroFile(); f++)
		{
			risultato=risultato+" "; 		// carattere ' ' iniziale
			for(int p = 0; p < nomeSala.getNumeroPostiPerFila(); p++)
			{
				if(mappa[f][p]==null)
				  risultato=risultato+"_";
				else
	     		  risultato=risultato+"#";
			}
			if(f<nomeSala.getNumeroFile()-1) 	// per non stampare il \n finale
				risultato=risultato+"\n";
		}
		return risultato;
	}

	public void setNomeFilm(Film nomeFilm) {
		this.nomeFilm = nomeFilm;
	}

	public void setNomeSala(Sala nomeSala) {
		this.nomeSala = nomeSala;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public void setPrezzoIntero(double prezzoIntero) {
		this.prezzoIntero = prezzoIntero;
	}

	public void setIs3D(boolean is3d) {
		is3D = is3d;
	}

	public void setPostiLib(int postiLib) {
		this.postiLib = postiLib;
	}
	
	public String toString(){
		return data+" "+ora+" "+nomeFilm.getTitolo()+" "+nomeFilm.getRegista();
	}
	
	public void addBigliettoAProiezione(Biglietto b){
		bigliettiProiezione.add(b);
		this.setPostiLib(postiLib-1);
	}
	
	public Biglietto getBiglietto(int fila, int posto){
		for (Biglietto b:bigliettiProiezione){
			if(b.getFila()==fila && b.getPosto()==posto){
				return b;
			}			
		}
		return null;
	}
	
	public Collection<Biglietto> getBigliettiProiezione(){
		return bigliettiProiezione;
	}
}
