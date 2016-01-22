package aziendaagricola;

import java.util.*;
import java.io.*;

public class Azienda {
	
	private int codzona=1000;
	private Map<Integer, Zona>zone = new HashMap<Integer, Zona>();
	
	private List<Magazzino>magazzini = new LinkedList<Magazzino>();

	public Zona aggiungiZona(){
		Zona ztemp = new Zona(codzona);
		zone.put(codzona, ztemp);
		codzona++;
		return ztemp;
	}
	
	public Zona cercaZona(int codice){
		Zona z = zone.get(codice);
		if(z==null){
			Zona c = new Zona(codice);
			return c;
 		}
		return z;
	}
	
	public void specificaCaratteristicheZona(int codice, String caratteristica){
		if(zone.containsKey(codice)){
			zone.get(codice).addCaratteristica(caratteristica);
		}
		

	}
	
	public Collection<Zona> elencoZone(){
		List<Zona>zoneTemp = new LinkedList<Zona>(zone.values());
		return zoneTemp;
	}
	
	public Collection<Zona> elencoZone(int ampiezza){
		List<Zona>zoneTemp = new LinkedList<Zona>(zone.values());
		List<Zona>zoneSel = new LinkedList<Zona>();
		for (Zona z:zoneTemp){
			if(z.getAmpiezza()>ampiezza){
				zoneSel.add(z);
			}
		}
		return zoneSel;
	}
	
	public Magazzino aggiungiMagazzino(String nome, String prodotto, int quantitaStoccabile){
		Magazzino mag = new Magazzino(nome, prodotto, quantitaStoccabile);
		magazzini.add(mag);
		return mag;		
	}
	
	public int totaleMagazzino(){
		int tot=0;
		for (Magazzino m:magazzini){
			tot+=m.getQuantitaStoccata();
		}
		return tot;
	}
	
	public void leggi(String nomeFile) throws IOException{
		try {
			BufferedReader br = new BufferedReader(new FileReader(nomeFile));

			String riga;
			while((riga=br.readLine())!=null){
				// Qui ho una riga
				StringTokenizer st = new StringTokenizer(riga, ";"); // Al posto di split()
				
				try{ // COn questo try-catch gestisco gli errori puntuali sulle singole righe del file 
					
					String type = st.nextToken(); // Metodo che restituisce la stringa/il token successivo nella riga
					
					if(type.compareTo("C")==0){
						int codice = Integer.parseInt(st.nextToken());
						String prodotto = st.nextToken();
						int meseSemina = Integer.parseInt(st.nextToken());
						int meseRaccolto = Integer.parseInt(st.nextToken());
						
						Zona z = this.cercaZona(codice);
						z.aggiungiColtivazione(prodotto, meseSemina, meseRaccolto);

						
					}
					else if(type.compareTo("R")==0){
						int codice = Integer.parseInt(st.nextToken());
						String prodotto = st.nextToken();
						String data = st.nextToken();
						int quantita = Integer.parseInt(st.nextToken());
						
						Zona z = this.cercaZona(codice);
						z.nuovoRaccolto(prodotto, data, quantita);
	
					}
				}
				catch(Exception nfe){ // Mi aspetto NumberFormatException nella conversione da String a Integer
					System.out.println("Eccezione nella gestione di una riga!");
					nfe.printStackTrace();
				}
			}
    	
    	
    	} catch (Exception e) {
			System.out.println("Eccezione generica!");

		}
    }
	
	
}
