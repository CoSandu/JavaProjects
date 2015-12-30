package amazon;


@SuppressWarnings("serial")
public class ErrDatiErrati extends Exception {
	public ErrDatiErrati(){
		super("Attenzione, username o password errati!");
	}
}
