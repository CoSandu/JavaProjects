package agenziaviaggi;

import java.util.Comparator;

public class PrenotazioniPerDataComparato implements Comparator<Prenotazione> {

	public int compare(Prenotazione o1, Prenotazione o2) {
		String dataa = "";
		String datab = "";
		
		if(o1 instanceof PrenotazioneAlbergo){
			dataa = ((PrenotazioneAlbergo) o1).getDataCheckIn();
		}
		if(o1 instanceof PrenotazioneVolo){
			dataa = ((PrenotazioneVolo) o1).getDataPartenza();
		}
		
		if(o2 instanceof PrenotazioneAlbergo){
			datab = ((PrenotazioneAlbergo) o2).getDataCheckIn();
		}
		if(o2 instanceof PrenotazioneVolo){
			datab = ((PrenotazioneVolo) o2).getDataPartenza();
		}
		
		return dataa.compareTo(datab);
	}

}
