import distributore.*;

public class Esempio {

	public static void main(String[] args) throws Exception {
			
		Distributore distributore = new Distributore();
		
		distributore.aggiungiSnack("taralli1", "Taralli all'olio", 0.35, "salato");
		distributore.aggiungiSnack("taralli2", "Taralli alla pizza", 0.35, "salato");
		distributore.aggiungiSnack("taralli3", "Taralli al curry", 0.35, "salato");
		distributore.aggiungiSnack("arachidi", "Arachidi tostate", 0.35, "salato");
		distributore.aggiungiSnack("wafer1", "Wafer alla nocciola", 0.40, "dolce");
		distributore.aggiungiSnack("wafer2", "Wafer al cioccolato", 0.40, "dolce");
		distributore.aggiungiSnack("bounty", "Bounty", 0.50, "dolce");
		distributore.aggiungiSnack("fiesta", "Fiesta", 0.60, "dolce");

		System.out.println("Snack taralli1: "+distributore.getNome("taralli1")+ ", prezzo: "+distributore.getPrezzo("taralli1"));

	    distributore.caricaTessera(3, 3.0);
	    distributore.caricaTessera(53, 2.5);
	    distributore.caricaTessera(11, 6.3);
	    
	    distributore.impostaDisponibilitaColonna(1, "taralli1", 30);
	    distributore.impostaDisponibilitaColonna(2, "arachidi", 30);
	    distributore.impostaDisponibilitaColonna(3, "wafer1", 20);
	    distributore.impostaDisponibilitaColonna(4, "bounty", 25);
	    distributore.impostaDisponibilitaColonna(5, "fiesta", 20);
	    distributore.impostaDisponibilitaColonna(6, "taralli3", 30);
	}
}
