package palestre;

@SuppressWarnings("serial")
public class ErrPersonaInesistente extends Exception {
	public ErrPersonaInesistente(){
		super("Persona inesistente");
	}
}
