package collections;

import java.util.*;

public class PrimoTestCollections {

	public static void main(String[] args) {
		
		Collection c = new LinkedList(); //posso decidere non solo il dato che memorizzo
							  //ma anche il tipo di contenitore
		c.add(new Studente(0000, "Renato", "Zero", 25.0));
		c.add(new Studente(1111, "Gianni", "Uno", 26.0));
		c.add(new Studente(2222, "Alberto", "Due", 26.0));
		System.out.println("Dimensione: "+ c.size());
		System.out.println(c.isEmpty());
		System.out.println("Contenuto: "+ c.toString());

	}

}
