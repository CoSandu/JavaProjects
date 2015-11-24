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
//		distributore.aggiungiSnack("taralli1", "Taralli all'olio", 1, "salato");
//		distributore.aggiungiSnack("taralli2", "Taralli alla pizza", 1, "salato");
//		distributore.aggiungiSnack("taralli3", "Taralli al curry", 1, "salato");
//		distributore.aggiungiSnack("arachidi", "Arachidi tostate", 1, "salato");
//		distributore.aggiungiSnack("wafer1", "Wafer alla nocciola", 1, "dolce");
//		distributore.aggiungiSnack("wafer2", "Wafer al cioccolato", 1, "dolce");
//		distributore.aggiungiSnack("bounty", "Bounty", 1, "dolce");
//		distributore.aggiungiSnack("fiesta", "Fiesta", 1, "dolce");
//		System.out.println("Snack taralli1: "+distributore.getNome("taralli1")+ 
//				", prezzo: "+distributore.getPrezzo("taralli1")+
//				", tipologia: "+distributore.getTipologia("taralli1"));
//		System.out.println("Snack wafer1: "+distributore.getNome("wafer1")+ 
//				", prezzo: "+distributore.getPrezzo("wafer1")+
//				", tipologia: "+distributore.getTipologia("wafer1"));

	    distributore.caricaTessera(3, 3.0);
//	    System.out.println("Credito tessera con codice: "+distributore.getEsistente(3).getCodiceTessera()
//	    		+" e' "+ distributore.getCredito(3));
	    distributore.caricaTessera(53, 2.5);
//	    System.out.println("Credito tessera con codice: "+distributore.getEsistente(53).getCodiceTessera()
//	    		+" e' "+ distributore.getCredito(53));
	    distributore.caricaTessera(3, 3.0);
	    distributore.caricaTessera(11, 6.3);
	    distributore.caricaTessera(3, 10.0);
//	    System.out.println("Credito tessera con codice: "+distributore.getEsistente(3).getCodiceTessera()
//	    		+" e' "+ distributore.getCredito(3));
	    distributore.caricaTessera(11, 6.3);
//	    System.out.println("Credito tessera con codice: "+distributore.getEsistente(11).getCodiceTessera()
//	    		+" e' "+ distributore.getCredito(11));
	    
	    distributore.impostaDisponibilitaColonna(1, "taralli1", 1);
	    distributore.impostaDisponibilitaColonna(2, "arachidi", 9);
	    distributore.impostaDisponibilitaColonna(3, "wafer1", 11);
	    distributore.impostaDisponibilitaColonna(4, "bounty", 1);
	    distributore.impostaDisponibilitaColonna(5, "fiesta", 1);
	    distributore.impostaDisponibilitaColonna(6, "taralli3", 1);
	    System.out.println(distributore.getConfezioniDisponibili("taralli3"));
	    System.out.println(distributore.getValoreMerceInDistributore());
	    
	}
}
