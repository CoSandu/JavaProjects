package gui;

public class Applicazione {

	public static void main(String[] args) {

		// Una applicazione grafica necessita comunque di un metodo main
		
		// Poi, occorre creare una istanza della/e classe/i che implementano il pattern MVC
		
		// Uso come nomi per le variabili riferimento il "ruolo" che queste/i 
		// classi/componenti giocano nel pattern MVC, quindi model, view, ecc.
		
		Contatore model = new Contatore();
		Finestra view = new Finestra(model);
		Controllore controller = new Controllore(model,view);
		
	}

}
