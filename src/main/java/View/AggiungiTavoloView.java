
package View;

import Controller.ConfermaAggiungiTavoloOpzioni;
import Model.Tavolo;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe della finestra grafica per l'aggiunta di un nuovo tavolo.
 */
public class AggiungiTavoloView extends JFrame{
     /**
     * Serial version UID
     */
    private static final long serialVersionUID = -9088567318186558363L;

    private Home h;
    
    private JLabel statoLabel = new JLabel("STATO");
    private JLabel numeroPostiLabel = new JLabel("NUMERO POSTI");
    private JLabel modNumTavLabel = new JLabel("INSERISCI NOME TAVOLO");
    
    private JTextField modificaNumeroTavoloTF = new JTextField();
    
    private JRadioButton libero = new JRadioButton("Libero");
    private JRadioButton occupato = new JRadioButton("Occupato");
    private JRadioButton inAttCon = new JRadioButton("In attesa di conto");
    private JRadioButton inAttPag = new JRadioButton("In attesa di pagamento");
    private JRadioButton duePersone = new JRadioButton("2");
    private JRadioButton quattroPersone = new JRadioButton("4");
    private JRadioButton seiPersone = new JRadioButton("6");
    private JRadioButton ottoPersone = new JRadioButton("8");
    
    private JButton conferma = new JButton("CONFERMA");
    
    private ButtonGroup buttonGroupStato = new ButtonGroup(); 
    private ButtonGroup buttonGroupNumero = new ButtonGroup(); 
    
    private JPanel rootPanel = new JPanel();
    private JPanel panelStato = new JPanel();
    private JPanel panelNumeroPersone = new JPanel();
    private JPanel panelModificaNumero = new JPanel();
    
    /**
     * Costruttore parametrizzato per la creazione della finestra grafica per l'aggiunta di un tavolo "parametrizzato".
     * @param h, riferimento della home
     * @param t, riferimento del tavolo
     */
    public AggiungiTavoloView(Home h, Tavolo t) {
        super("Aggiungi tavolo");
        this.h = h;
        rootPanel = (JPanel) getContentPane();
        rootPanel.setLayout(new GridLayout(7, 1));
        
        /* ROOT PANEL */
        panelStato.setLayout(new GridLayout(2, 2));
        panelNumeroPersone.setLayout(new GridLayout(1, 4));
        
        //guardo da quanti posti è nuovo tavolo
        switch(t.getNumeroPosti()) {
            case 2:
                duePersone.setSelected(true);
                break;
            case 4:
                quattroPersone.setSelected(true);
                break;
            case 6:
                seiPersone.setSelected(true);
                break;
            case 8:
                ottoPersone.setSelected(true);
                break;
            default:
                break;
        }
        
       //guardo lo stato del nuovo tavolo
        switch(t.getStato()) {
            case 0:
                libero.setSelected(true);
                break;
            case 1:
                occupato.setSelected(true);
                break;
            case 2:
                inAttCon.setSelected(true);
                break;
            case 3:
                inAttPag.setSelected(true);
                break;
            default:
                break;
        }
        
        //setto i TextField
        modificaNumeroTavoloTF.setText(h.getNumeroTavoli() + 1 + " ");
        modificaNumeroTavoloTF.setHorizontalAlignment(JTextField.CENTER);
        
        //setto il bottone di conferma
        conferma.setForeground(new Color(19, 74, 34));
        conferma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        //setto il passaggio del mouse sopra ai JRadioButton dello stato e del numero di posti 
        libero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        occupato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inAttCon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inAttPag.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        duePersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        quattroPersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seiPersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ottoPersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
       //setto i panel
        panelStato.add(libero);
        panelStato.add(occupato);
        panelStato.add(inAttCon);
        panelStato.add(inAttPag);
        
        //aggiungi i JRadioButton ai relativi ButtonGroup
        buttonGroupStato.add(libero);
        buttonGroupStato.add(occupato);
        buttonGroupStato.add(inAttCon);
        buttonGroupStato.add(inAttPag);
        
        //settaggi vari
        panelNumeroPersone.add(duePersone);
        panelNumeroPersone.add(quattroPersone);
        panelNumeroPersone.add(seiPersone);
        panelNumeroPersone.add(ottoPersone);
        
        buttonGroupNumero.add(duePersone);
        buttonGroupNumero.add(quattroPersone);
        buttonGroupNumero.add(seiPersone);
        buttonGroupNumero.add(ottoPersone);
        
        duePersone.setSelected(true);
        
        //setto il font
        statoLabel.setFont(new Font("Courier New", Font.BOLD, 32));
        numeroPostiLabel.setFont(new Font("Courier New", Font.BOLD, 32));
        modNumTavLabel.setFont(new Font("Courier New", Font.BOLD, 32));
        libero.setFont(new Font("Courier New", Font.PLAIN, 24));
        occupato.setFont(new Font("Courier New", Font.PLAIN, 24));
        inAttCon.setFont(new Font("Courier New", Font.PLAIN, 24));
        inAttPag.setFont(new Font("Courier New", Font.PLAIN, 24));
        duePersone.setFont(new Font("Courier New", Font.PLAIN, 29));
        quattroPersone.setFont(new Font("Courier New", Font.PLAIN, 29));
        seiPersone.setFont(new Font("Courier New", Font.PLAIN, 29));
        ottoPersone.setFont(new Font("Courier New", Font.PLAIN, 29));
        modificaNumeroTavoloTF.setFont(new Font("Courier New", Font.PLAIN, 30));
        conferma.setFont(new Font("Courier New", Font.ITALIC | Font.BOLD, 32));
        
        //setto i bordi
        statoLabel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        numeroPostiLabel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        modNumTavLabel.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
        modificaNumeroTavoloTF.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        
        //aggiungo i vari componenti al rootPanel
        rootPanel.add(statoLabel);
        rootPanel.add(panelStato);
        rootPanel.add(numeroPostiLabel);
        rootPanel.add(panelNumeroPersone);
        rootPanel.add(modNumTavLabel);
        rootPanel.add(modificaNumeroTavoloTF);
        rootPanel.add(conferma);
        
        conferma.addActionListener(new ConfermaAggiungiTavoloOpzioni(h, this));
        
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
	 * @return the statoLabel
	 */
	public JLabel getStatoLabel() {
		return statoLabel;
	}

	/**
	 * @param statoLabel the statoLabel to set
	 */
	public void setStatoLabel(JLabel statoLabel) {
		this.statoLabel = statoLabel;
	}

	/**
	 * @return the numeroPostiLabel
	 */
	public JLabel getNumeroPostiLabel() {
		return numeroPostiLabel;
	}

	/**
	 * @param numeroPostiLabel the numeroPostiLabel to set
	 */
	public void setNumeroPostiLabel(JLabel numeroPostiLabel) {
		this.numeroPostiLabel = numeroPostiLabel;
	}

	/**
	 * @return the modNumTavLabel
	 */
	public JLabel getModNumTavLabel() {
		return modNumTavLabel;
	}

	/**
	 * @param modNumTavLabel the modNumTavLabel to set
	 */
	public void setModNumTavLabel(JLabel modNumTavLabel) {
		this.modNumTavLabel = modNumTavLabel;
	}

	/**
	 * @return the modificaNumeroTavoloTF
	 */
	public JTextField getModificaNumeroTavoloTF() {
		return modificaNumeroTavoloTF;
	}

	/**
	 * @param modificaNumeroTavoloTF the modificaNumeroTavoloTF to set
	 */
	public void setModificaNumeroTavoloTF(JTextField modificaNumeroTavoloTF) {
		this.modificaNumeroTavoloTF = modificaNumeroTavoloTF;
	}

	/**
	 * @return the libero
	 */
	public JRadioButton getLibero() {
		return libero;
	}

	/**
	 * @param libero the libero to set
	 */
	public void setLibero(JRadioButton libero) {
		this.libero = libero;
	}

	/**
	 * @return the occupato
	 */
	public JRadioButton getOccupato() {
		return occupato;
	}

	/**
	 * @param occupato the occupato to set
	 */
	public void setOccupato(JRadioButton occupato) {
		this.occupato = occupato;
	}

	/**
	 * @return the inAttCon
	 */
	public JRadioButton getInAttCon() {
		return inAttCon;
	}

	/**
	 * @param inAttCon the inAttCon to set
	 */
	public void setInAttCon(JRadioButton inAttCon) {
		this.inAttCon = inAttCon;
	}

	/**
	 * @return the inAttPag
	 */
	public JRadioButton getInAttPag() {
		return inAttPag;
	}

	/**
	 * @param inAttPag the inAttPag to set
	 */
	public void setInAttPag(JRadioButton inAttPag) {
		this.inAttPag = inAttPag;
	}

	/**
	 * @return the duePersone
	 */
	public JRadioButton getDuePersone() {
		return duePersone;
	}

	/**
	 * @param duePersone the duePersone to set
	 */
	public void setDuePersone(JRadioButton duePersone) {
		this.duePersone = duePersone;
	}

	/**
	 * @return the quattroPersone
	 */
	public JRadioButton getQuattroPersone() {
		return quattroPersone;
	}

	/**
	 * @param quattroPersone the quattroPersone to set
	 */
	public void setQuattroPersone(JRadioButton quattroPersone) {
		this.quattroPersone = quattroPersone;
	}

	/**
	 * @return the seiPersone
	 */
	public JRadioButton getSeiPersone() {
		return seiPersone;
	}

	/**
	 * @param seiPersone the seiPersone to set
	 */
	public void setSeiPersone(JRadioButton seiPersone) {
		this.seiPersone = seiPersone;
	}

	/**
	 * @return the ottoPersone
	 */
	public JRadioButton getOttoPersone() {
		return ottoPersone;
	}

	/**
	 * @param ottoPersone the ottoPersone to set
	 */
	public void setOttoPersone(JRadioButton ottoPersone) {
		this.ottoPersone = ottoPersone;
	}

	/**
	 * @return the conferma
	 */
	public JButton getConferma() {
		return conferma;
	}

	/**
	 * @param conferma the conferma to set
	 */
	public void setConferma(JButton conferma) {
		this.conferma = conferma;
	}

	/**
	 * @return the buttonGroupStato
	 */
	public ButtonGroup getButtonGroupStato() {
		return buttonGroupStato;
	}

	/**
	 * @param buttonGroupStato the buttonGroupStato to set
	 */
	public void setButtonGroupStato(ButtonGroup buttonGroupStato) {
		this.buttonGroupStato = buttonGroupStato;
	}

	/**
	 * @return the buttonGroupNumero
	 */
	public ButtonGroup getButtonGroupNumero() {
		return buttonGroupNumero;
	}

	/**
	 * @param buttonGroupNumero the buttonGroupNumero to set
	 */
	public void setButtonGroupNumero(ButtonGroup buttonGroupNumero) {
		this.buttonGroupNumero = buttonGroupNumero;
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
	 * @return the panelStato
	 */
	public JPanel getPanelStato() {
		return panelStato;
	}

	/**
	 * @param panelStato the panelStato to set
	 */
	public void setPanelStato(JPanel panelStato) {
		this.panelStato = panelStato;
	}

	/**
	 * @return the panelNumeroPersone
	 */
	public JPanel getPanelNumeroPersone() {
		return panelNumeroPersone;
	}

	/**
	 * @param panelNumeroPersone the panelNumeroPersone to set
	 */
	public void setPanelNumeroPersone(JPanel panelNumeroPersone) {
		this.panelNumeroPersone = panelNumeroPersone;
	}

	/**
	 * @return the panelModificaNumero
	 */
	public JPanel getPanelModificaNumero() {
		return panelModificaNumero;
	}

	/**
	 * @param panelModificaNumero the panelModificaNumero to set
	 */
	public void setPanelModificaNumero(JPanel panelModificaNumero) {
		this.panelModificaNumero = panelModificaNumero;
	}
}
