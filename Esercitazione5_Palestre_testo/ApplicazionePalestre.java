import palestre.*;

public class ApplicazionePalestre {
	private static String err = "--ERR--";

	public static void main(String[] args) throws ErrPersonaInesistente {
		GestionePalestre palestraStadio = new GestionePalestre();
		Persona c1 = palestraStadio.aggiungiPersona("Muro", "Pino", "Z223CTF");
		System.out.println(c1);
		Persona c2 = palestraStadio.aggiungiPersona("Mur", "Pin", "Z223CTF");
		System.out.println(c2);
		Persona c3 = palestraStadio.aggiungiPersona( "", "", "Z223CTR");
		System.out.println(c3);
		Persona c4 = palestraStadio.aggiungiPersona( "Mario", "Gino", "N223CGF");
		System.out.println(c4);
		try{
			palestraStadio.getPersona("Z223CT");
		}
		catch (Exception e){
			System.out.println(err+e.getMessage()+err);
		}
		Persona c6 = palestraStadio.aggiungiPersonalTrainer("25ST25", "Mario", null, "2242TST");
		System.out.println(c6);
		Persona c7 = palestraStadio.aggiungiPersonalTrainer("25ST2", "Marzio", "Cane", "2242TST");
		System.out.println(c7);
		Persona c8 = palestraStadio.aggiungiPersonalTrainer("25ST25", "Zio", "Pino", "2242TS");
		System.out.println(c8);
	}

}
