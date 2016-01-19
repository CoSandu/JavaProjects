package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

public class FinestraDisegno extends JFrame implements MouseMotionListener{

	int x;
	int y;
	
	public FinestraDisegno(){
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.addMouseMotionListener(this);
		
		this.setVisible(true);
	}

	public void paint(Graphics g){
		
		//g.drawLine(0, 0, 200, 150);
		g.clearRect(0, 0, 400, 300); // Cancello l'area di disegno prima di disegnare
		g.setColor(Color.red);
		g.fillOval(x-10, y-10, 20, 20);
	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {

		x = e.getX();
		y = e.getY();
		
		this.repaint(); // Forzo il ridisegno del frame (quindi invocazione di paint)
		
	}
	
}
