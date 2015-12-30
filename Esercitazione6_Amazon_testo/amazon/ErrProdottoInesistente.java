package amazon;


@SuppressWarnings("serial")
public class ErrProdottoInesistente extends Exception {
	public ErrProdottoInesistente(){
		super("Attenzione, il prodotto e' inesistente");
	}
}
