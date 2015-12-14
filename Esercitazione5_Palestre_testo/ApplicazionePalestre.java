import java.io.IOException;

import palestre.*;

public class ApplicazionePalestre {
	private static String err = "--ERR--";

	public static void main(String[] args) throws ErrPersonaInesistente {
		GestionePalestre palestraStadio = new GestionePalestre();
		Persona c1 = palestraStadio.aggiungiPersona("Auro", "Pino", "RSSGNN33B30F316I");
		System.out.println(c1);
		Persona c2 = palestraStadio.aggiungiPersona("Banna", "Panna", "Z223CTT");
		System.out.println(c2);
		Persona c3 = palestraStadio.aggiungiPersona( "", "", "Z223CTR");
		System.out.println(c3);
		Persona c4 = palestraStadio.aggiungiPersona( "Mario", "Gino", "VRDGPP76F09B666I");
		Persona c5 = palestraStadio.aggiungiPersona( "Mario", "Gino", "ARDGPP76F09B63");
		System.out.println(c4);
		try{
			palestraStadio.getPersona("Z223CT");
		}
		catch (Exception e){
			System.out.println(err+e.getMessage()+err);
		}
		Persona c6 = palestraStadio.aggiungiPersonalTrainer("25ST25", "Mario", null, "2242TST");
		Persona c7 = palestraStadio.aggiungiPersonalTrainer("XY345Z", "Marzio", "Cane", "B888888888SSDFF8");
		Persona c8 = palestraStadio.aggiungiPersonalTrainer("XXXXXX", "Zio", "Pinto", "A2XX22");
		Persona c9 = palestraStadio.aggiungiPersonalTrainer("555555", "Mauro", "Pirla", "999999999999");

		try {
			palestraStadio.assegnaPersonalTrainer("555555", "RSSGNN33B30F316I");
			palestraStadio.assegnaPersonalTrainer("555555", "VRDGPP76F09B666I");
			palestraStadio.assegnaPersonalTrainer("555555", "B888888888SSDFF8");
			palestraStadio.assegnaPersonalTrainer("555555", "A2XX22");
			palestraStadio.assegnaPersonalTrainer("555555", "ARDGPP76F09B63");
		
		} catch (Exception e) {
			System.out.println(err+e.getMessage()+err);
		}
		
		System.out.println(c1.getPersonalTrainer());
		System.out.println(((PersonalTrainer) c9).getClienti());
		try {
			System.out.println(palestraStadio.caricaDati("elenco.txt"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
