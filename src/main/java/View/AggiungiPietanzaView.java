
package View;

import Controller.ConfermaAggiuntaPietanza;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe che permette la creazione di una finestra grafica per l'aggiunta di una pietanza al menù.
 */
public class AggiungiPietanzaView extends JFrame {
    
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = 1L;

    private Home h;
    
    private JLabel nomeLabel = new JLabel("NOME");
    private JLabel prezzoLabel = new JLabel("PREZZO");
    private JLabel descrizioneLabel = new JLabel("DECRIZIONE");
    private JLabel repartoLabel = new JLabel("REPARTO");
    
    private JTextField nomeTF = new JTextField("");
    private JTextField prezzoTF = new JTextField("0.00");
    private JTextField descrizioneTF = new JTextField ("");
    
    private JComboBox<String> repartoBox;
    
    private JButton confermaButton = new JButton("CONFERMA");
    
    private String[] itemsReparto = {"Antipasto", "Primo", "Secondo", "Dolce", "Bibita"}; 
    
    private JPanel rootPanel = new JPanel();
    private JPanel panelCenter = new JPanel();
    private JPanel panelNomePrezzo = new JPanel();
    private JPanel panelDescrizione = new JPanel();
    private JPanel panelReparto = new JPanel();
    
    /**
     * Costruttore parametrizzato per la creazione di una finestra per l'aggiunta di una pietanza al menu
     * @param h, riferimento della home. 
     */
    public AggiungiPietanzaView(Home h) {   
        
        super("Aggiungi pietanza");
        this.h = h;
        
        //setto i pannelli
        rootPanel = (JPanel) getContentPane();
        rootPanel.setLayout(new BorderLayout());
        
        panelCenter.setLayout(new GridLayout(4, 1));
        panelNomePrezzo.setLayout(new GridLayout(1, 4));
        panelDescrizione.setLayout(new GridLayout(1, 2));
        panelReparto.setLayout(new GridLayout(1, 2));
        
        //setto la ComboBox dei reparti con le pietanze relative
        repartoBox = new JComboBox<String>();
        
        for(var a : itemsReparto) {
            repartoBox.addItem(a);
        }
        
        rootPanel.add(confermaButton, BorderLayout.SOUTH);
        rootPanel.add(panelCenter, BorderLayout.CENTER);
        //rootPanel.add(panelNomePrezzo, BorderLayout.NORTH);
        
        //setto i pannelli
        panelCenter.add(panelNomePrezzo);
        panelCenter.add(panelDescrizione);
        panelCenter.add(panelReparto);
        
        panelNomePrezzo.add(nomeLabel);
        panelNomePrezzo.add(nomeTF);
        panelNomePrezzo.add(prezzoLabel);
        panelNomePrezzo.add(prezzoTF);
        panelDescrizione.add(descrizioneLabel);
        panelDescrizione.add(descrizioneTF);
        panelReparto.add(repartoLabel);
        panelReparto.add(repartoBox);
        
        //setto i label
        nomeLabel.setFont(new Font("Courier New", Font.BOLD, 27));
        prezzoLabel.setFont(new Font("Courier New", Font.BOLD, 27));
        descrizioneLabel.setFont(new Font("Courier New", Font.BOLD, 27));
        repartoLabel.setFont(new Font("Courier New", Font.BOLD, 27));
        nomeTF.setFont(new Font("Courier New", Font.BOLD, 27));
        prezzoTF.setFont(new Font("Courier New", Font.BOLD, 27));
        descrizioneTF.setFont(new Font("Courier New", Font.BOLD, 27));
        repartoBox.setFont(new Font("Courier New", Font.BOLD, 27));
        confermaButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 33)); //Gli anni di cristo 
        
        //settaggi vari
        panelNomePrezzo.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        prezzoLabel.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 0, Color.BLACK));
        panelDescrizione.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        panelReparto.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.BLACK));
        
        confermaButton.setForeground(new Color(19, 74, 34));
        confermaButton.addActionListener(new ConfermaAggiuntaPietanza(this, h));
        
        nomeLabel.setHorizontalAlignment(JLabel.CENTER);
        prezzoLabel.setHorizontalAlignment(JLabel.CENTER);
        descrizioneLabel.setHorizontalAlignment(JLabel.CENTER);
        repartoLabel.setHorizontalAlignment(JLabel.CENTER);
        
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(h.getX() + (h.getWidth() / 2) - 150, h.getY() + (h.getHeight() / 2) - 100, 800, 550);
        setResizable(false);
    }

	/**
	 * @return the h
	 */
	public Home getH() {
		return h;
	}

	/**
	 * @param h the h to set
	 */
	public void setH(Home h) {
		this.h = h;
	}

	/**
	 * @return the nomeLabel
	 */
	public JLabel getNomeLabel() {
		return nomeLabel;
	}

	/**
	 * @param nomeLabel the nomeLabel to set
	 */
	public void setNomeLabel(JLabel nomeLabel) {
		this.nomeLabel = nomeLabel;
	}

	/**
	 * @return the prezzoLabel
	 */
	public JLabel getPrezzoLabel() {
		return prezzoLabel;
	}

	/**
	 * @param prezzoLabel the prezzoLabel to set
	 */
	public void setPrezzoLabel(JLabel prezzoLabel) {
		this.prezzoLabel = prezzoLabel;
	}

	/**
	 * @return the descrizioneLabel
	 */
	public JLabel getDescrizioneLabel() {
		return descrizioneLabel;
	}

	/**
	 * @param descrizioneLabel the descrizioneLabel to set
	 */
	public void setDescrizioneLabel(JLabel descrizioneLabel) {
		this.descrizioneLabel = descrizioneLabel;
	}

	/**
	 * @return the repartoLabel
	 */
	public JLabel getRepartoLabel() {
		return repartoLabel;
	}

	/**
	 * @param repartoLabel the repartoLabel to set
	 */
	public void setRepartoLabel(JLabel repartoLabel) {
		this.repartoLabel = repartoLabel;
	}

	/**
	 * @return the nomeTF
	 */
	public JTextField getNomeTF() {
		return nomeTF;
	}

	/**
	 * @param nomeTF the nomeTF to set
	 */
	public void setNomeTF(JTextField nomeTF) {
		this.nomeTF = nomeTF;
	}

	/**
	 * @return the prezzoTF
	 */
	public JTextField getPrezzoTF() {
		return prezzoTF;
	}

	/**
	 * @param prezzoTF the prezzoTF to set
	 */
	public void setPrezzoTF(JTextField prezzoTF) {
		this.prezzoTF = prezzoTF;
	}

	/**
	 * @return the descrizioneTF
	 */
	public JTextField getDescrizioneTF() {
		return descrizioneTF;
	}

	/**
	 * @param descrizioneTF the descrizioneTF to set
	 */
	public void setDescrizioneTF(JTextField descrizioneTF) {
		this.descrizioneTF = descrizioneTF;
	}

	/**
	 * @return the repartoBox
	 */
	public JComboBox<String> getRepartoBox() {
		return repartoBox;
	}

	/**
	 * @param repartoBox the repartoBox to set
	 */
	public void setRepartoBox(JComboBox<String> repartoBox) {
		this.repartoBox = repartoBox;
	}

	/**
	 * @return the confermaButton
	 */
	public JButton getConfermaButton() {
		return confermaButton;
	}

	/**
	 * @param confermaButton the confermaButton to set
	 */
	public void setConfermaButton(JButton confermaButton) {
		this.confermaButton = confermaButton;
	}

	/**
	 * @return the itemsReparto
	 */
	public String[] getItemsReparto() {
		return itemsReparto;
	}

	/**
	 * @param itemsReparto the itemsReparto to set
	 */
	public void setItemsReparto(String[] itemsReparto) {
		this.itemsReparto = itemsReparto;
	}

	/**
	 * @return the rootPanel
	 */
	public JPanel getRootPanel() {
		return rootPanel;
	}

	/**
	 * @param rootPanel the rootPanel to set
	 */
	public void setRootPanel(JPanel rootPanel) {
		this.rootPanel = rootPanel;
	}

	/**
	 * @return the panelCenter
	 */
	public JPanel getPanelCenter() {
		return panelCenter;
	}

	/**
	 * @param panelCenter the panelCenter to set
	 */
	public void setPanelCenter(JPanel panelCenter) {
		this.panelCenter = panelCenter;
	}

	/**
	 * @return the panelNomePrezzo
	 */
	public JPanel getPanelNomePrezzo() {
		return panelNomePrezzo;
	}

	/**
	 * @param panelNomePrezzo the panelNomePrezzo to set
	 */
	public void setPanelNomePrezzo(JPanel panelNomePrezzo) {
		this.panelNomePrezzo = panelNomePrezzo;
	}

	/**
	 * @return the panelDescrizione
	 */
	public JPanel getPanelDescrizione() {
		return panelDescrizione;
	}

	/**
	 * @param panelDescrizione the panelDescrizione to set
	 */
	public void setPanelDescrizione(JPanel panelDescrizione) {
		this.panelDescrizione = panelDescrizione;
	}

	/**
	 * @return the panelReparto
	 */
	public JPanel getPanelReparto() {
		return panelReparto;
	}

	/**
	 * @param panelReparto the panelReparto to set
	 */
	public void setPanelReparto(JPanel panelReparto) {
		this.panelReparto = panelReparto;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
