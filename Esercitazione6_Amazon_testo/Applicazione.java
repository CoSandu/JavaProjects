import amazon.Amazon;
import amazon.ErrProdottoInesistente;

public class Applicazione {

	public static void main(String[] args) throws ErrProdottoInesistente {
		
		Amazon a = new Amazon();
		a.aggiungiProdotto("patate", "patate verdi", 2.0);
		System.out.println(a.getProdotto(0).getPrezzo());
		

	}

}
