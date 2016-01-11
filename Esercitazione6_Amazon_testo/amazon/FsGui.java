package amazon;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FsGui extends JFrame {

  public static void main(String[] args){
	  
	 FsGui f = new FsGui();
  }
  
  public Account account;
  public Amazon amazon = new Amazon();
  
  public JTextField username; // primo quadrante
  public JTextField password; // primo quadrante
  public JButton login; // primo quadrante
  public JList listaProdottiAmazon; // secondo quadrante
  public JButton aggiungiACarrello; // secondo quadrante
  public JList listaProdottiCarrello; // terzo quadrante
  public JButton acquista; //terzo quadrante
  public JLabel totale; // quarto quadrante
  public JComboBox indirizzi; // quinto quadrante
  public JButton spedisciOrdine; // quinto quadrante
  public JLabel messaggioConferma; // sesto quadrante
  private JLabel uName;
  private JLabel pWord;

  public FsGui(){
	  
  	super("Amazon");
  	
  	
  	Prodotto pp1 = null; 
  	Prodotto pp2 = null; 
  	int codP1 = amazon.aggiungiProdotto("scopa", "scopa di saggina", 18.5);
  	int codP2 = amazon.aggiungiProdotto("renna", "renna giocattolo", 20.0);
  	int codP3 = amazon.aggiungiProdotto("brum", "macchinina gialla", 5.0);
  	try {
		pp1 = amazon.getProdotto(codP1);
		pp2 = amazon.getProdotto(codP2);
		amazon.impostaDisponibilitaProdotto(codP1, 12);
		amazon.impostaDisponibilitaProdotto(codP2, 10);
		amazon.impostaDisponibilitaProdotto(codP3, 10);

		amazon.creaAccount("Mario", "Rossi", "mrossi", "a123456");
	  	Account a = amazon.getAccount("mrossi", "a123456");

	  	amazon.aggiungiIndirizzoAdAccount(a, "corso Duca 24, Torino");
	  	amazon.aggiungiIndirizzoAdAccount(a, "Piazza Castello 2, Torino");

	  	amazon.aggiungiProdottoACarrelloAccount(a, pp1, 4);
	  	amazon.aggiungiProdottoACarrelloAccount(a, pp2, 1);

  	} catch (ErrProdottoInesistente e1) {
		e1.printStackTrace();
	} catch (ErrAccountGiaEsistente e) {
		e.printStackTrace();
	} catch (ErrDatiErrati e) {
		e.printStackTrace();
	}
  	
  	
  	// TODO: continuare.... 
  	// suggerimento: usare un GridLayout(2,3)
  	
  	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	this.setSize(200, 600);
  	
  	GridLayout layout = new GridLayout(20,0);
  	this.setLayout(layout);
  	
	this.add(uName = new JLabel("Username"));
  	this.add(username = new JTextField()); // primo quadrante
  	this.add(pWord = new JLabel("Password"));
  	this.add(password = new JTextField()); // primo quadrante
  	this.add(login = new JButton("Effettua il login")); // primo quadrante
  	this.add(listaProdottiAmazon = new JList()); // secondo quadrante
  	this.add(aggiungiACarrello = new JButton("Aggiungi al carrello")); // secondo quadrante
  	this.add(listaProdottiCarrello = new JList()); // terzo quadrante
  	this.add(acquista = new JButton("Acquista i prodotti")); //terzo quadrante
  	this.add(totale = new JLabel("0.0")); // quarto quadrante
  	this.add(indirizzi = new JComboBox()); // quinto quadrante
  	this.add(spedisciOrdine = new JButton("Spedisci ordine")); // quinto quadrante
  	this.add(messaggioConferma = new JLabel()); // sesto quadrante
  	
  	
  	this.setVisible(true);
 
  }
 
}
