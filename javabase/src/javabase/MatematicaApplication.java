package javabase;

import java.math.*;

import javax.swing.JOptionPane;

public class MatematicaApplication {

	public static void main(String[] args) {

		ClasseMatematica cm = new ClasseMatematica();
		
		double inv = cm.inverso(12);
		
		System.out.println("Inverso di 12: "+inv);
		
		// Per evitare l'ovehead di creare un'istanza della classe 
		// ClasseMatematica posso usare la parola chiave final nel definire 
		// il metodo inverso()
		
		// Se il metodo e' definito static (quindi ne esiste 
		// una sola copia per l'intra applicazione) che bisogno c'e' di 
		// invocarlo su un particolare oggetto?
		
		inv = ClasseMatematica.inverso(24);
		
		// include <math.h>
		
		double potenza = Math.pow(10, 3);
		System.out.println("Valore: "+potenza);
		
		// Un minimo di grafica
		
		// JOptionPane.showMessageDialog(null, "Ciao utente!");
		
		String nome = JOptionPane.showInputDialog("Ciao utente, inserisci il tuo nome");
		
		System.out.println(nome);
		
	}

}
