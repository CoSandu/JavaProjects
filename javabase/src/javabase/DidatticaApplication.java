package javabase;

public class DidatticaApplication {

	public static void main(String[] args){
		
		Studente s1 = new Studente("12345","Mario","Rossi");
		
		// Problema, voglio tener traccia, per ogni corso, degli stuenti 
		// iscritti: dovro' creare un array di oggetti di tipo Studente nella classe Corso
		
		Corso c1 = new Corso("ABCDE","Programmazione a oggetti");
		
		// Iscrivo uno studente al corso accedendo direttamente all'array
		
		(c1.getStudenti())[0] = s1;
		
		// Stampo lo studente iscritto, accedendo direttamente in lettura agli attributi (metodi getter)
		
		/*
		System.out.println("Studente s1");
		System.out.println(" Matricola: "+c1.getStudenti()[0].getMatricola()); //.matricola
		System.out.println(" Nome: "+c1.getStudenti()[0].getNome());
		System.out.println(" Cognome: "+c1.getStudenti()[0].getCognome());
		*/

		// Idem per accedere in scrittura
		
		//c1.studenti[0].matricola = "67890";
		c1.getStudenti()[0].setMatricola("67890");

		// Meglio (o indispensabile, in alcuni casi) utilizzare i metodi getter/setter
		// per accedere agli attributi di Studente, vantaggio, posso aggiungere istruzioni (es. di controllo)
		
		// c1.studenti[0].eta = 25;
		// c1.studenti[0].eta = -1;
		
		//c1.studenti[0].setEta(25);
		//c1.studenti[0].setEta(-1);

		// Delega, chiedo allo studente di stamparsi
		
		System.out.println("Studente:\n"+c1.getStudenti()[0].toString());
		
		// Delega anche per iscrivere uno studente, anziche' accedere direttamente all'array

		// L'array potrebbe non essere visibile, e anche se lo fosse (es. mediante metodo getter)
		// potrebbe non essere la strada migliore (meglio delegare, chi meglio del Corso, che
		// possiede la struttura dati, puo' sapere come iscrivere uno Studente a se stesso?)
		
		c1.iscrivi(s1);
		
		// Alternative per creare un array, inizializzato o meno
		
		Studente[] arr = new Studente[100];
		Studente arrr[] = new Studente[100];
		//Studente arrrr[] = {s1, s2, s3};
		Studente arrrrr[] = new Studente[]{ s1, new Studente("09876", "Gianni", "Verdi") };
		
	}
}






