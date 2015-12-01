import palestre.*;

public class ApplicazionePalestre {

	public static void main(String[] args) {
		GestionePalestre palestraStadio = new GestionePalestre();
		Persona c1 = palestraStadio.aggiungiPersona("Muro", "Pino", "Z223CTF");
		System.out.println(c1);
		Persona c2 = palestraStadio.aggiungiPersona("Mur", "Pin", "Z223CTF");
		System.out.println(c2);

	}

}
