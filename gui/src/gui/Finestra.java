package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class Finestra extends JFrame {

	JButton pulsantePiu;
	JButton pulsanteMeno;
	JLabel etichetta;
	
	Contatore model;
	
	public Finestra(Contatore model){
		
		this.model = model; // In questo modo, quando ho bisogno
		                    // di accedere al model, ad es. per leggere
		                    // il valore della variabile contatore,
		                    // ho la variabile riferimento che mi serve
		
		this.setSize(300, 200);
		this.setTitle("La mia applicazione");
		
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE  );

		pulsantePiu = new JButton("+");
		pulsanteMeno = new JButton("-");
		etichetta = new JLabel("?");
		
		// Prima di definire i widget devo creare un layout e assegnarlo alla finestra
		
		// FlowLayout layout = new FlowLayout();
		// this.setLayout(layout);
		
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		
		// Dopo aver creato i widget devo aggiungerli alla finestra
		
		this.add(pulsantePiu, BorderLayout.NORTH);
		this.add(pulsanteMeno, BorderLayout.SOUTH);
		this.add(etichetta, BorderLayout.CENTER);
		
		etichetta.setHorizontalAlignment(JLabel.CENTER);
		
		this.setVisible(true);
	}
	
	public void aggiorna(){
		
		// Leggo il val. della variabile contatore e lo mostro nella etichetta
		etichetta.setText(""+model.getValore());
	}
}





