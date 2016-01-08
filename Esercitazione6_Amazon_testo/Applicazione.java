import amazon.Account;
import amazon.Amazon;
import amazon.ErrAccountGiaEsistente;
import amazon.ErrDatiErrati;
import amazon.ErrProdottoInesistente;
import amazon.Prodotto;

public class Applicazione {

	public static void main(String[] args) throws ErrProdottoInesistente, ErrAccountGiaEsistente, ErrDatiErrati {
		
		Amazon a = new Amazon();
		a.aggiungiProdotto("patate", "patate verdi", 2.0);
		a.aggiungiProdotto("cioccolato", "cioccolato bianco", 32.0);
		System.out.println(a.getProdotto(0).getPrezzo());
		Prodotto pata = a.getProdotto(0);
		Prodotto cioc = a.getProdotto(1);
		
		a.impostaDisponibilitaProdotto(0, 12);
		a.impostaDisponibilitaProdotto(0, 2);
		System.out.println(a.getProdotto(0).getDisponibilita());
//		a.impostaDisponibilitaProdotto(1, 12);
		
		a.creaAccount("Pippo", "Pappo", "pipPa", "0000");
		Account acc1 = a.getAccount("pipPa", "0000");
//		a.creaAccount("Pipo", "Pao", "pipPa", "0000");
		a.aggiungiIndirizzoAdAccount(acc1, "via Tortora 30, Torino");
		a.aggiungiIndirizzoAdAccount(acc1, "via Tort 330, Torino");
		a.aggiungiIndirizzoAdAccount(acc1, "via Torta 331, Torino");
		a.aggiungiIndirizzoAdAccount(acc1, "via Torta 331, Torino");
		a.aggiungiIndirizzoAdAccount(acc1, "via Tort 330, Torino");
//		a.aggiungiIndirizzoAdAccount(a.getAccount("pipPa", "0000"), "Via Trino, 30");
		System.out.println(acc1.elencoIndirizziSpedizione());
		a.aggiungiProdottoACarrelloAccount(acc1, pata, 3);
		a.aggiungiProdottoACarrelloAccount(acc1, cioc, 1);
		System.out.println(acc1.getTotaleCarrello());
	}

}
