package agenziaviaggi;

import java.util.Comparator;

public class PrenotazioniPerImportoComparato implements Comparator<Prenotazione> {

	public int compare(Prenotazione o1, Prenotazione o2) {
		return (int) (o1.getImporto()-o2.getImporto());
	}

}
