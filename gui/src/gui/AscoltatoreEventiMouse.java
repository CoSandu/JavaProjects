package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AscoltatoreEventiMouse implements ActionListener{

	Contatore model;
	Finestra view;
	
	public AscoltatoreEventiMouse(Contatore model, Finestra view){
		this.model=model;
		this.view=view;
	}
	
	public void actionPerformed(ActionEvent ev) {

		// Lo stesso codice gia' scritto nel metodo omonimo nella classe Controllore
		if(ev.getSource() == view.pulsantePiu){
			model.incrementa();
			view.aggiorna();
		}
		else if (ev.getSource() == view.pulsanteMeno){
			model.decrementa();
			view.aggiorna();
		}
		
	}

}
