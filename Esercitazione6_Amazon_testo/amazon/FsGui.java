package amazon;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class FsGui extends JFrame{

  public static void main(String[] args){
	  
	 FsGui f = new FsGui();
  }
  
  public Account account;
  public Amazon amazon = new Amazon();
  
  public JTextField username; // primo quadrante
  public JTextField password; // primo quadrante
  public JButton login; // primo quadrante
  public JList<Prodotto> listaProdottiAmazon; // secondo quadrante
  public JButton aggiungiACarrello; // secondo quadrante
  public JList<Prodotto> listaProdottiCarrello; // terzo quadrante
  public JButton acquista; //terzo quadrante
  public JLabel totale; // quarto quadrante
  public JComboBox<String> indirizzi; // quinto quadrante
  public JButton spedisciOrdine; // quinto quadrante
  public JLabel messaggioConferma; // sesto quadrante
  public JLabel uName;
  public JLabel pWord;
  public JScrollPane elencoProd;
  public JScrollPane elencoCarr;

  public FsGui(){
	  
  	super("Amazon");
  	
  	
  	Prodotto pp1 = null; 
  	Prodotto pp2 = null; 
  	int codP1 = amazon.aggiungiProdotto("scopa", "scopa di saggina", 15.0);
  	int codP2 = amazon.aggiungiProdotto("renna", "renna giocattolo", 20.0);
  	int codP3 = amazon.aggiungiProdotto("brum", "macchinina gialla", 5.0);
  	int codP4 = amazon.aggiungiProdotto("mazza", "mazza baseball", 10.0);
  	int codP5 = amazon.aggiungiProdotto("filo", "filo interdentale", 4.0);
  	try {
		pp1 = amazon.getProdotto(codP1);
		pp2 = amazon.getProdotto(codP2);
		amazon.impostaDisponibilitaProdotto(codP1, 12);
		amazon.impostaDisponibilitaProdotto(codP2, 10);
		amazon.impostaDisponibilitaProdotto(codP3, 10);
		amazon.impostaDisponibilitaProdotto(codP4, 5);
		amazon.impostaDisponibilitaProdotto(codP5, 6);

		amazon.creaAccount("Mario", "Rossi", "mrossi", "a123456");
	  	Account a = amazon.getAccount("mrossi", "a123456");

	  	amazon.aggiungiIndirizzoAdAccount(a, "corso Duca 24, Torino");
	  	amazon.aggiungiIndirizzoAdAccount(a, "Piazza Castello 2, Torino");

	  	amazon.aggiungiProdottoACarrelloAccount(a, pp1, 2);
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
  	this.setSize(900, 450);
  	
  	GridLayout layout = new GridLayout(2,3);
  	this.setLayout(layout);
  	
  	JPanel pan1 = new JPanel();
  	this.add(pan1);
	pan1.add(uName = new JLabel("Username"));
  	pan1.add(username = new JTextField(25)); // primo quadrante
  	pan1.add(pWord = new JLabel("Password"));
  	pan1.add(password = new JTextField(25)); // primo quadrante
  	pan1.add(login = new JButton("Effettua il login")); // primo quadrante
  	login.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			doLogin();
			showProdottiUtente();
			showIndirizzi();
		}
	});
  	
  	JPanel pan2 = new JPanel();
  	this.add(pan2);
	pan2.add(elencoProd = new JScrollPane(listaProdottiAmazon = new JList<Prodotto>())); // secondo quadrante
  	pan2.add(aggiungiACarrello = new JButton("Aggiungi al carrello")); // secondo quadrante
  	aggiungiACarrello.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent e){
  			addToCarrello();
  		}
  	});
  	
  	JPanel pan3 = new JPanel();
  	this.add(pan3);
  	pan3.add(elencoCarr = new JScrollPane(listaProdottiCarrello = new JList<Prodotto>())); // terzo quadrante
  	pan3.add(acquista = new JButton("Acquista i prodotti")); //terzo quadrante
  	acquista.addActionListener(new ActionListener(){
  		public void actionPerformed(ActionEvent e){
  			account.getTotaleCarrello();
  			System.out.println(account.getTotaleCarrello());
  			totale.setText(String.valueOf(account.getTotaleCarrello()));
  		}
  	});
  	
  	JPanel pan4 = new JPanel();
  	this.add(pan4);
  	pan4.add(totale = new JLabel("0.0")); // quarto quadrante
  
  	JPanel pan5 = new JPanel();
  	this.add(pan5);
  	pan5.add(indirizzi = new JComboBox()); // quinto quadrante
  	pan5.add(spedisciOrdine = new JButton("Spedisci ordine")); // quinto quadrante
  	spedisciOrdine.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
  			String ind = (String) indirizzi.getSelectedItem();
  			messaggioConferma.setText("Tot: "+ totale.getText()+"," +" spedito in: "+ind);
  		}
  	});
  	
  	
  	JPanel pan6 = new JPanel();
  	this.add(pan6);
  	pan6.add(messaggioConferma = new JLabel()); // sesto quadrante
  	
//------------DATI-----------
  	Prodotto[] arrayProd = new Prodotto[(amazon.elencoProdottiPerImportoCrescente()).size()];
  	listaProdottiAmazon.setListData(amazon.elencoProdottiPerImportoCrescente().toArray(arrayProd));
  	this.setVisible(true);
  }
  
  
//-------------EVENTI-----------
	
	public void doLogin() {
		String uName = (String)username.getText();
		String pWord = (String)password.getText();
		
		try{
			account = amazon.getAccount(uName, pWord);
			System.out.println(account.getCognome());
		} catch (ErrDatiErrati e){
			e.printStackTrace();
		}
	}
	
	public void showProdottiUtente(){
		Prodotto[] arrayUtente = new Prodotto[(account.elencoProdottiInOrdineDiInserimento()).size()];
		this.listaProdottiCarrello.setListData(account.elencoProdottiInOrdineDiInserimento().toArray(arrayUtente));
	}
	
	public void showIndirizzi() {
		for (String s:account.elencoIndirizziSpedizione()){
			this.indirizzi.addItem(s);
		}
	}	
	
	public void addToCarrello(){
		Prodotto a = this.listaProdottiAmazon.getSelectedValue();
		amazon.aggiungiProdottoACarrelloAccount(account, a, 1);
		showProdottiUtente();
	}

}
