package javabase;

public class Car {

	 private String color; // Se si aggiunge private, l'attributo non sara' piu' visibile (accesso tramite metodi pubblici)
	 private String brand;
	 private boolean turnedOn;

	 // COSTRUTTORE: "metodo" un po' particolare, stesso nome della classe, nessun valore di ritorno
	 //              che si occupa di allocare la memoria per l'oggetto (creare lo "scatolone") ed inizializzarlo

	 // Inizializzarlo come?
	 
	 // Costruttore di default (vuoto), senza parametri, c'e' e a volte non si vede
	 // Puo' essere ridefinito per effettuare le inizializzazioni del caso
	 // Qui, inizializzazione con tutte automobili senza colore, senza marca e spente
	 
	 public Car(){
		 color = "";
		 brand = "";
		 turnedOn = false;
	 }

	 // Costruttore pensato per inizializzare ad esempio con parametri. Quali/Quanti parametri?
	 // Quelli che servono, non e' necessario passare parametri per inizializzare tutti gli attributi
	 
	 public Car(String c, String b, boolean to){
		 color = c;
		 brand = b;
		 turnedOn = to;
	 }
	 
	 // E' pero' consigliabile inizializzare in qualche modo tutti gli attributi
	 
	 // Costruttore in OVERLOADING, stesso nome ma diversi parametri (diversa firma)
	 
	 public Car(String c, String b){ 
		 color = c;
		 brand = b;
		 turnedOn = false;
	 }
	 
	 // Uso di this (questo oggetto) per risolvere casi di omonimia nei nomi dei parametri/attributi
	 
	 public Car(String brand) {
		this.brand = brand;
	 }

	 public String readColor()
	 {
		 return color;
	 }
	 
	 public String readBrand(){
		 return brand;
	 }
	 
	 public boolean readState(){
		 return turnedOn;
	 }
	 
	 public String stampati(){
		 return ""+color+" "+brand+" "+turnedOn;
		 
	 }
	 
}
