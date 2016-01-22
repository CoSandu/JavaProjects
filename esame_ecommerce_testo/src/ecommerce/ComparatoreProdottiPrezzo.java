package ecommerce;

import java.util.Comparator;

public class ComparatoreProdottiPrezzo implements Comparator<Prodotto> {

	@Override
	public int compare(Prodotto a, Prodotto b) {
		
		return (int) (a.getPrezzo()-b.getPrezzo());
	}

}
