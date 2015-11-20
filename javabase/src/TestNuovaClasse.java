// Importando la classe, questa diviene visibile ed utilizzabile
// import nuovopackage.NuovaClasse;

import nuovopackage.*;

import java.lang.String;
//import java.awt.Button;
//import java.math.*;

// #include <stdio.h>

public class TestNuovaClasse {

	public static void main(String[] args) {

		NuovaClasse nc = new NuovaClasse();
		
		System.out.println("Valore: "+nc.getValore());

		nc.incrementa();
		
		System.out.println("Valore dopo incremento: "+nc.getValore());
		
		String s;
		
		java.lang.String ss; // Altro modo di dichiarare la stringa
		                     // usando il fully qualified name
		
		
		
	}

}
