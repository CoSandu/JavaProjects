import computer.Cartella;
import computer.Computer;
import computer.File;

public class Esempio {
	
	public static void main(String[] args) {
		
		Computer c = new Computer(100000);
		System.out.println("Dimensione hd computer " + c.getDimensioneHardDisk());
		
		Cartella root = c.getRoot();
		System.out.println("La radice e': " + root);
		
		Cartella doc = c.creaCartella("Documents", root);
		System.out.println("La documents e': " + doc.toString() +" " + root.toString());
		File f10 = c.creaFile("File semplice", root, 123456);
		Cartella img = c.creaCartella("Images", root);
		System.out.println("La images e': " + img.toString() +" " + root.toString());
		
		Cartella aud = c.creaCartella("Audio", root);
		Cartella aud2 = c.creaCartella("Audio", root);
		System.out.println(aud.toString());
//		System.out.println(aud2.toString());
		System.out.println("Il nome di audio e': "+ c.cercaCartella("Audio", root));
		
		
		
		File f1 = c.creaFile("documento1", doc, 10020);
		System.out.println(f1.toString());
		System.out.println("Il nome file': "+ c.cercaFile("documento1", doc));
		File f2 = c.creaFile("documento2", doc, 5004);

		File f3 = c.creaFileAudio("audio1", aud, 20809, 2, 53);
		System.out.println("Il nome file': "+ c.cercaFile("audio1", aud));
		File f4 = c.creaFileAudio("audio2", aud, 32398, 4, 12);
		System.out.println("Il nome file': "+ c.cercaFile("audio2", aud));
		File f5 = c.creaFile("lista canzoni", aud, 5009);
		
		Cartella imgVacanze = c.creaCartella("Estate2015", img);
		System.out.println("Il nome di audio e': "+ c.cercaCartella("Estate2015", img));
		Cartella imgClipart = c.creaCartella("Clipart", img);
		
		System.out.println("lista cartelle create: "+ c.elencoFileCartella(aud));
		
		File f6 = c.creaFileImmagine("gruppo", imgVacanze, 8957, 2304, 3456, "Canon EOS");
		System.out.println("Il nome di audio e': "+ c.cercaFile("gruppo", imgVacanze));
		File f7 = c.creaFileImmagine("tramonto sul mare", imgVacanze, 4359, 2304, 3456, "Canon EOS");
		File f8 = c.creaFileImmagine("gita in montagna", imgVacanze, 5550, 2304, 3456, "Canon EOS");
		
		System.out.println("Dim Disco "+ c.calcolaDimensioneOccupata(root));
	}

}
