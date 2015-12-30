package amazon;


@SuppressWarnings("serial")
public class ErrAccountGiaEsistente extends Exception {
	public ErrAccountGiaEsistente(){
		super("Attenzione, l'account e' gia' esistente");
	}
}
