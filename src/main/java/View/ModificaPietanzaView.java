package View;

import Controller.ConfermaModificaPietanza;
import Model.Pietanza;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Finestra grafica che permette di modificare le pietanze.
 */
public class ModificaPietanzaView extends JFrame {
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -4762486844692056943L;
	
    /* JPANEL */
    private JPanel rootPanel = new JPanel(new BorderLayout());
    private JPanel panelNorth;
    private JPanel panelCentro = new JPanel(new GridLayout(5, 1));
    private JPanel selezionaPietanzaPanel = new JPanel(new GridLayout(1, 2));
    private JPanel nomePrezzoPanel = new JPanel(new GridLayout(1, 4));
    private JPanel descrizionePanel = new JPanel(new GridLayout(1, 2));
    private JPanel repartoPanel = new JPanel(new GridLayout(1, 2));
    
    /* JLABEL */
    private JLabel modificaLabel = new JLabel("MODIFICA PIETANZA");
    private JLabel selezioneLabel = new JLabel("Seleziona la pietanza");
    private JLabel nuovoNomeLabel = new JLabel("Nuovo nome");
    private JLabel nuovoPrezzoLabel = new JLabel("Nuovo prezzo");
    private JLabel nuovaDescrizioneLabel = new JLabel("Nuova descrizione");
    private JLabel nuovaRepartoLabel = new JLabel("Nuovo reparto");
    
    /* JTEXTFIELD */
    private JTextField nuovoNomeTF = new JTextField();
    private JTextField nuovoPrezzoTF = new JTextField();
    private JTextField nuovaDescrizioneTF = new JTextField();
    
    /* JCOMBOBOX */
    private JComboBox<String> pietanzeComboBox;
    private JComboBox<String> repartoBox;
    
    /* STRING */
    private String[] nomePietanze;
    private String[] itemsReparto = {"Antipasto", "Primo", "Secondo", "Dolce", "Bibita"}; 
    
    /* ARRAYLIST */
    private ArrayList<Pietanza> pietanze;
    
    /* JBUTTON */
    private JButton conferma = new JButton("CONFERMA");
    
    /**
     * 
     * @param h, riferimento della home. 
     * Costruttore di Default che permette la creazione della finestra grafica per modificare le pietanze.
     * Contiene l'inizializzazione dei componenti grafici.
     */
    public ModificaPietanzaView(Home h) {
        super("Modifica pietanza");
        
        getContentPane().add(rootPanel);
        
        /* JCOMBOBOX */
        repartoBox = new JComboBox<String>();
        Font f = new Font("Geo Sans Light", Font.PLAIN, 18);
        
        for(var a : itemsReparto) {
            repartoBox.addItem(a);
        }
        
        /* IMPOSTAZIONE GRADIENTE DEL COLORE NEL PANEL */
        panelNorth = new JPanel() {
            /**
            * Serial Version UID.
            */
            private static final long serialVersionUID = -7418343463169456844L;

            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                Graphics2D g2d = (Graphics2D) grphcs;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                GradientPaint gp = new GradientPaint(0, 0,
                        getBackground().brighter().brighter(), 0, getHeight(),
                        Color.WHITE);
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, getWidth(), getHeight()); 

            }

        };
        /* IMPOSTAZIONE GRADIENTE DEL COLORE NEL PANEL */
        
        panelNorth.setBackground(Color.YELLOW);
        modificaLabel.setForeground(Color.red);
        
        /* AGGIUNTA PIETANZE  */
        pietanze = h.getPietanze();
        nomePietanze = new String[pietanze.size()];
        for(int i = 0; i < pietanze.size(); i++) {
            nomePietanze[i] = pietanze.get(i).getNome();
            nuovoNomeTF.setText(pietanze.get(i).getNome());
            nuovaDescrizioneTF.setText(pietanze.get(i).getDescrizione());
            nuovoPrezzoTF.setText(Float.toString(pietanze.get(i).getCosto()));
            repartoBox.setSelectedIndex(pietanze.get(i).getReparto());
        }
        
        pietanzeComboBox = new JComboBox<String>(nomePietanze);
        pietanzeComboBox.setSelectedIndex(pietanze.size() - 1);
        repartoBox.setSelectedIndex(pietanze.get(pietanze.size() - 1).getReparto());
        
        /* AGGIUNTA ELEMENTI AL JPANEL */
        rootPanel.add(panelNorth, BorderLayout.NORTH);
        rootPanel.add(panelCentro, BorderLayout.CENTER);
        rootPanel.add(conferma, BorderLayout.SOUTH);
        
        panelNorth.add(modificaLabel);
        
        panelCentro.add(selezionaPietanzaPanel);
        panelCentro.add(nomePrezzoPanel);
        panelCentro.add(descrizionePanel);
        panelCentro.add(repartoPanel);
        
        selezionaPietanzaPanel.add(selezioneLabel);
        selezionaPietanzaPanel.add(pietanzeComboBox);
        nomePrezzoPanel.add(nuovoNomeLabel);
        nomePrezzoPanel.add(nuovoNomeTF);
        nomePrezzoPanel.add(nuovoPrezzoLabel);
        nomePrezzoPanel.add(nuovoPrezzoTF);
        descrizionePanel.add(nuovaDescrizioneLabel);
        descrizionePanel.add(nuovaDescrizioneTF);
        repartoPanel.add(nuovaRepartoLabel);
        repartoPanel.add(repartoBox);
        
        /* DESIGN */
        modificaLabel.setHorizontalAlignment(JLabel.CENTER);
        modificaLabel.setFont(new Font("Geo Sans Light", Font.ITALIC, 36));
        
        selezioneLabel.setFont(f);
        selezioneLabel.setHorizontalAlignment(JLabel.CENTER);
        nuovoPrezzoLabel.setFont(f);
        nuovoPrezzoLabel.setHorizontalAlignment(JLabel.CENTER);
        nuovoNomeLabel.setFont(f);
        nuovoNomeLabel.setHorizontalAlignment(JLabel.CENTER);
        nuovaDescrizioneLabel.setFont(f);
        nuovaDescrizioneLabel.setHorizontalAlignment(JLabel.CENTER);
        nuovaRepartoLabel.setFont(f);
        nuovaRepartoLabel.setHorizontalAlignment(JLabel.CENTER);
        
        /* IMPOSTAZIONE BORDI */
        rootPanel.setBorder(BorderFactory.createBevelBorder(2, Color.lightGray, Color.yellow));
        selezionaPietanzaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        panelCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        nomePrezzoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        descrizionePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        repartoPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
        selezioneLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        nuovoNomeLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        nuovoPrezzoLabel.setBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.BLACK));
        nuovaDescrizioneLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        nuovaRepartoLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
        
        conferma.setFont(new Font("Geo Sans Light", Font.PLAIN, 26));
        
        /* ACTION LISTENER */
        conferma.addActionListener(new ConfermaModificaPietanza(h, this));
        pietanzeComboBox.addItemListener((e) -> updateView());
        
        /* INIZIALIZZAZIONE FRAME */
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(h.getX() + (h.getWidth() / 2) - 150, h.getY() + (h.getHeight() / 2) - 100, 800, 550);
        setResizable(false);
    }
    
    /**
     * metodo privato per essere invocato all'interno di questa stessa classer per l'aggiornamento della view
     */
    private void updateView() {
       //si visualizzano a schermo le caratteristiche della pietanza che si intende modificare
        for(int i = 0; i < pietanze.size(); i++) {
            if(pietanzeComboBox.getSelectedIndex() == i) {
                nomePietanze[i] = pietanze.get(i).getNome();
                nuovoNomeTF.setText(pietanze.get(i).getNome());
                nuovaDescrizioneTF.setText(pietanze.get(i).getDescrizione());
                nuovoPrezzoTF.setText(Float.toString(pietanze.get(i).getCosto()));
                repartoBox.setSelectedIndex(pietanze.get(i).getReparto());
            }
        }
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
	 * @return the panelNorth
	 */
	public JPanel getPanelNorth() {
		return panelNorth;
	}

	/**
	 * @param panelNorth the panelNorth to set
	 */
	public void setPanelNorth(JPanel panelNorth) {
		this.panelNorth = panelNorth;
	}

	/**
	 * @return the panelCentro
	 */
	public JPanel getPanelCentro() {
		return panelCentro;
	}

	/**
	 * @param panelCentro the panelCentro to set
	 */
	public void setPanelCentro(JPanel panelCentro) {
		this.panelCentro = panelCentro;
	}

	/**
	 * @return the selezionaPietanzaPanel
	 */
	public JPanel getSelezionaPietanzaPanel() {
		return selezionaPietanzaPanel;
	}

	/**
	 * @param selezionaPietanzaPanel the selezionaPietanzaPanel to set
	 */
	public void setSelezionaPietanzaPanel(JPanel selezionaPietanzaPanel) {
		this.selezionaPietanzaPanel = selezionaPietanzaPanel;
	}

	/**
	 * @return the nomePrezzoPanel
	 */
	public JPanel getNomePrezzoPanel() {
		return nomePrezzoPanel;
	}

	/**
	 * @param nomePrezzoPanel the nomePrezzoPanel to set
	 */
	public void setNomePrezzoPanel(JPanel nomePrezzoPanel) {
		this.nomePrezzoPanel = nomePrezzoPanel;
	}

	/**
	 * @return the descrizionePanel
	 */
	public JPanel getDescrizionePanel() {
		return descrizionePanel;
	}

	/**
	 * @param descrizionePanel the descrizionePanel to set
	 */
	public void setDescrizionePanel(JPanel descrizionePanel) {
		this.descrizionePanel = descrizionePanel;
	}

	/**
	 * @return the repartoPanel
	 */
	public JPanel getRepartoPanel() {
		return repartoPanel;
	}

	/**
	 * @param repartoPanel the repartoPanel to set
	 */
	public void setRepartoPanel(JPanel repartoPanel) {
		this.repartoPanel = repartoPanel;
	}

	/**
	 * @return the modificaLabel
	 */
	public JLabel getModificaLabel() {
		return modificaLabel;
	}

	/**
	 * @param modificaLabel the modificaLabel to set
	 */
	public void setModificaLabel(JLabel modificaLabel) {
		this.modificaLabel = modificaLabel;
	}

	/**
	 * @return the selezioneLabel
	 */
	public JLabel getSelezioneLabel() {
		return selezioneLabel;
	}

	/**
	 * @param selezioneLabel the selezioneLabel to set
	 */
	public void setSelezioneLabel(JLabel selezioneLabel) {
		this.selezioneLabel = selezioneLabel;
	}

	/**
	 * @return the nuovoNomeLabel
	 */
	public JLabel getNuovoNomeLabel() {
		return nuovoNomeLabel;
	}

	/**
	 * @param nuovoNomeLabel the nuovoNomeLabel to set
	 */
	public void setNuovoNomeLabel(JLabel nuovoNomeLabel) {
		this.nuovoNomeLabel = nuovoNomeLabel;
	}

	/**
	 * @return the nuovoPrezzoLabel
	 */
	public JLabel getNuovoPrezzoLabel() {
		return nuovoPrezzoLabel;
	}

	/**
	 * @param nuovoPrezzoLabel the nuovoPrezzoLabel to set
	 */
	public void setNuovoPrezzoLabel(JLabel nuovoPrezzoLabel) {
		this.nuovoPrezzoLabel = nuovoPrezzoLabel;
	}

	/**
	 * @return the nuovaDescrizioneLabel
	 */
	public JLabel getNuovaDescrizioneLabel() {
		return nuovaDescrizioneLabel;
	}

	/**
	 * @param nuovaDescrizioneLabel the nuovaDescrizioneLabel to set
	 */
	public void setNuovaDescrizioneLabel(JLabel nuovaDescrizioneLabel) {
		this.nuovaDescrizioneLabel = nuovaDescrizioneLabel;
	}

	/**
	 * @return the nuovaRepartoLabel
	 */
	public JLabel getNuovaRepartoLabel() {
		return nuovaRepartoLabel;
	}

	/**
	 * @param nuovaRepartoLabel the nuovaRepartoLabel to set
	 */
	public void setNuovaRepartoLabel(JLabel nuovaRepartoLabel) {
		this.nuovaRepartoLabel = nuovaRepartoLabel;
	}

	/**
	 * @return the nuovoNomeTF
	 */
	public JTextField getNuovoNomeTF() {
		return nuovoNomeTF;
	}

	/**
	 * @param nuovoNomeTF the nuovoNomeTF to set
	 */
	public void setNuovoNomeTF(JTextField nuovoNomeTF) {
		this.nuovoNomeTF = nuovoNomeTF;
	}

	/**
	 * @return the nuovoPrezzoTF
	 */
	public JTextField getNuovoPrezzoTF() {
		return nuovoPrezzoTF;
	}

	/**
	 * @param nuovoPrezzoTF the nuovoPrezzoTF to set
	 */
	public void setNuovoPrezzoTF(JTextField nuovoPrezzoTF) {
		this.nuovoPrezzoTF = nuovoPrezzoTF;
	}

	/**
	 * @return the nuovaDescrizioneTF
	 */
	public JTextField getNuovaDescrizioneTF() {
		return nuovaDescrizioneTF;
	}

	/**
	 * @param nuovaDescrizioneTF the nuovaDescrizioneTF to set
	 */
	public void setNuovaDescrizioneTF(JTextField nuovaDescrizioneTF) {
		this.nuovaDescrizioneTF = nuovaDescrizioneTF;
	}

	/**
	 * @return the pietanzeComboBox
	 */
	public JComboBox<String> getPietanzeComboBox() {
		return pietanzeComboBox;
	}

	/**
	 * @param pietanzeComboBox the pietanzeComboBox to set
	 */
	public void setPietanzeComboBox(JComboBox<String> pietanzeComboBox) {
		this.pietanzeComboBox = pietanzeComboBox;
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
	 * @return the nomePietanze
	 */
	public String[] getNomePietanze() {
		return nomePietanze;
	}

	/**
	 * @param nomePietanze the nomePietanze to set
	 */
	public void setNomePietanze(String[] nomePietanze) {
		this.nomePietanze = nomePietanze;
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
	 * @return the pietanze
	 */
	public ArrayList<Pietanza> getPietanze() {
		return pietanze;
	}

	/**
	 * @param pietanze the pietanze to set
	 */
	public void setPietanze(ArrayList<Pietanza> pietanze) {
		this.pietanze = pietanze;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
