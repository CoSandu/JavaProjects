package gui;

import java.awt.event.*;

public class Controllore implements ActionListener{

	// Il controller deve poter accedere sia alla view che al model
	Contatore model;
	Finestra view;
	
	public Controllore(Contatore model, Finestra view){
		this.model=model;
		this.view=view;
		
		//view.pulsantePiu.addActionListener( this );
		//view.pulsanteMeno.addActionListener( this );
	
		AscoltatoreEventiMouse ascMouse = 
				new AscoltatoreEventiMouse(model,view);
	
		view.pulsantePiu.addActionListener(ascMouse);
		view.pulsanteMeno.addActionListener(ascMouse);
		
		AscoltatoreEventiTastiera ascTastiera =
				new AscoltatoreEventiTastiera();
		
		view.pulsantePiu.addKeyListener(ascTastiera);
		view.pulsanteMeno.addKeyListener(ascTastiera);
	}

	// Metodo che verra' invocato quando l'utente fara' click
	public void actionPerformed(ActionEvent ev) {
		System.out.println("Ha fatto click!");

		if(ev.getSource()==view.pulsantePiu) // == perche voglio confrontare i riferimenti
		{
			System.out.println("+");
			model.incrementa();
			view.aggiorna();
		}
		else if(ev.getSource()==view.pulsanteMeno)
		{
			System.out.println("-");
			model.decrementa();
			view.aggiorna();
		}
	}
	
}
