
package View;

import Controller.AggiungiOrdine;
import Controller.ConfermaEliminaOrdine;
import Controller.InfoTavoloButton;
import Controller.StampaScontrino;
import Model.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Finestra grafica che mostra le informazioni del tavolo selezionato.
 */
public class InfoTavoloView extends JFrame {
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -2696392302089419333L;
    private Home h;
    private Tavolo tavolo;
    
    /* INIZIALIZZAZIONE LABEL */
    private JLabel statoLabel = new JLabel("STATO");
    private JLabel numeroPostiLabel = new JLabel("NUMERO POSTI");
    private JLabel modNumTavLabel = new JLabel("MODIFICA NOME TAVOLO");
    private JLabel quantita = new JLabel("Q.tà");
    private JLabel descrizione = new JLabel("Desc.");
    private JLabel prezzo = new JLabel("Prezzo");
    private JLabel importo = new JLabel("Importo");
    private JLabel eliminaLabel = new JLabel("Elimina");
    private JLabel totaleLabel = new JLabel("Totale");
    
    /* INIZIALIZZAZIONE TEXTFIELD */
    private JTextField modificaNumeroTavoloTF = new JTextField();
    private JTextField totaleTF = new JTextField("0.00");
    
    /* INIZIALIZZAZIONE RADIOBUTTON */
    private JRadioButton libero = new JRadioButton("Libero");
    private JRadioButton occupato = new JRadioButton("Occupato");
    private JRadioButton inAttCon = new JRadioButton("In attesa di conto");
    private JRadioButton inAttPag = new JRadioButton("In attesa di pagamento");
    private JRadioButton duePersone = new JRadioButton("2");
    private JRadioButton quattroPersone = new JRadioButton("4");
    private JRadioButton seiPersone = new JRadioButton("6");
    private JRadioButton ottoPersone = new JRadioButton("8");
    
    /* INIZIALIZZAZIONE BUTTON */
    private JButton conferma = new JButton("CONFERMA");
    private JButton aggiungi = new JButton("AGGIUNGI");
    private JButton elimina = new JButton("ELIMINA");
    private JButton stampaScontrino = new JButton("STAMPA");
    
    /* INIZIALIZZAZIONE BUTTONGROUP */
    private ButtonGroup buttonGroupStato = new ButtonGroup(); 
    private ButtonGroup buttonGroupNumero = new ButtonGroup(); 
    
    /* INIZIALIZZAZIONE PANEL */
    private JPanel rootPanel = new JPanel();
    private JPanel panelSinistro = new JPanel();
    private JPanel panelDestro = new JPanel();
    private JPanel panelDestroFondo = new JPanel();
    private JPanel panelStato = new JPanel();
    private JPanel panelNumeroPersone = new JPanel();
    private JPanel panelModificaNumero = new JPanel();
    private JPanel descrizioneOrdini = new JPanel();
    private JPanel ordiniListPanel = new JPanel();
    private JPanel panelDestraFondoPulsanti = new JPanel();
    
    /* INIZIALIZZAZIONE ARRAYLIST */
    private ArrayList<JPanel> ordiniList = new ArrayList<>();
    private ArrayList<JLabel> ordiniLabelList = new ArrayList<>();
    private ArrayList<JCheckBox> checkBox = new ArrayList<>();
    
    /* VARIABILI DI TIPO PRIMITIVO*/
    private int numeroPiatti = 0;
    private int numeroTavolo;
    
    private float totaleFloat;
    
    /**
     * Costruttore della classe InfoTavoloView. Contiene l'inizializzazione dei componenti grafici della sua finestra grafica.
     * @param n, numero dei tavoli
     * @param h, riferimento della home
     * @param t, riferimento del tavolo 
     */
    public InfoTavoloView(int n, Home h, Tavolo t) {
        super("Informazioni e modifica tavolo: " + h.getArrayTavoli()[n].getId());
       
        numeroTavolo = n;
        
        this.h = h;
        this.tavolo = t;
        
        rootPanel = (JPanel) getContentPane();
        rootPanel.setLayout(new GridLayout(0, 2));
        panelSinistro.setPreferredSize(new Dimension(500, this.getHeight()));
        panelDestro.setPreferredSize(new Dimension(300, this.getHeight()));
        
        panelSinistro.setLayout(new GridLayout(7, 1));
        rootPanel.add(panelSinistro);
        rootPanel.add(panelDestro);
        
        /* PANEL SINISTRO CON LE INFO DEL TAVOLO */
        
        //visualizzo a schermo le informazioni del tavolo selezionato
        panelStato.setLayout(new GridLayout(2, 2));
        panelNumeroPersone.setLayout(new GridLayout(1, 4));
        
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
        
        modificaNumeroTavoloTF.setText(t.getId());
        modificaNumeroTavoloTF.setHorizontalAlignment(JTextField.CENTER);
        
        conferma.setForeground(new Color(19, 74, 34));
        conferma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        libero.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        occupato.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inAttCon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        inAttPag.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        duePersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        quattroPersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seiPersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ottoPersone.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        panelStato.add(libero);
        panelStato.add(occupato);
        panelStato.add(inAttCon);
        panelStato.add(inAttPag);
        
        buttonGroupStato.add(libero);
        buttonGroupStato.add(occupato);
        buttonGroupStato.add(inAttCon);
        buttonGroupStato.add(inAttPag);
        
        panelNumeroPersone.add(duePersone);
        panelNumeroPersone.add(quattroPersone);
        panelNumeroPersone.add(seiPersone);
        panelNumeroPersone.add(ottoPersone);
        
        buttonGroupNumero.add(duePersone);
        buttonGroupNumero.add(quattroPersone);
        buttonGroupNumero.add(seiPersone);
        buttonGroupNumero.add(ottoPersone);
        
        quantita.setFont(new Font("Courier New", Font.PLAIN, 15));
        descrizione.setFont(new Font("Courier New", Font.PLAIN, 15));
        prezzo.setFont(new Font("Courier New", Font.PLAIN, 15));
        importo.setFont(new Font("Courier New", Font.PLAIN, 15));
        eliminaLabel.setFont(new Font("Courier New", Font.PLAIN, 15));
        statoLabel.setFont(new Font("Courier New", Font.BOLD, 24));
        numeroPostiLabel.setFont(new Font("Courier New", Font.BOLD, 24));
        modNumTavLabel.setFont(new Font("Courier New", Font.BOLD, 24));
        libero.setFont(new Font("Courier New", Font.PLAIN, 14));
        occupato.setFont(new Font("Courier New", Font.PLAIN, 14));
        inAttCon.setFont(new Font("Courier New", Font.PLAIN, 14));
        inAttPag.setFont(new Font("Courier New", Font.PLAIN, 12));
        duePersone.setFont(new Font("Courier New", Font.PLAIN, 20));
        quattroPersone.setFont(new Font("Courier New", Font.PLAIN, 20));
        seiPersone.setFont(new Font("Courier New", Font.PLAIN, 20));
        ottoPersone.setFont(new Font("Courier New", Font.PLAIN, 20));
        modificaNumeroTavoloTF.setFont(new Font("Courier New", Font.PLAIN, 20));
        conferma.setFont(new Font("Courier New", Font.ITALIC | Font.BOLD, 22));
        totaleLabel.setFont(new Font("Courier New", Font.ITALIC, 20));
        
        panelSinistro.add(statoLabel);
        panelSinistro.add(panelStato);
        panelSinistro.add(numeroPostiLabel);
        panelSinistro.add(panelNumeroPersone);
        panelSinistro.add(modNumTavLabel);
        panelSinistro.add(modificaNumeroTavoloTF);
        panelSinistro.add(conferma);
        
        panelSinistro.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 3, Color.BLACK));
        
        conferma.addActionListener(new InfoTavoloButton(this, t));
        
        /* PANEL DESTRO */
        //visualizzo gli ordini del tavolo selezionato
        panelDestro.setLayout(new BorderLayout());
        panelDestroFondo.setLayout(new GridLayout(2, 1));
        descrizioneOrdini.setLayout(new GridLayout());
        ordiniListPanel.setLayout(new GridLayout(0, 1));
        panelDestroFondo.setLayout(new GridLayout(2, 1));
        panelDestraFondoPulsanti.setLayout(new GridLayout(1, 3));
        
        panelDestro.add(descrizioneOrdini, BorderLayout.PAGE_START);
        panelDestro.add(ordiniListPanel, BorderLayout.CENTER);
        panelDestro.add(panelDestroFondo, BorderLayout.PAGE_END);
        
        descrizioneOrdini.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        quantita.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        descrizione.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        prezzo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        importo.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        
        quantita.setHorizontalAlignment(JLabel.CENTER);
        descrizione.setHorizontalAlignment(JLabel.CENTER);
        prezzo.setHorizontalAlignment(JLabel.CENTER);
        importo.setHorizontalAlignment(JLabel.CENTER);
        eliminaLabel.setHorizontalAlignment(JLabel.CENTER);
        for(var a : checkBox) {
            a.setHorizontalAlignment(JCheckBox.CENTER);
        }
        
        descrizioneOrdini.add(quantita);
        descrizioneOrdini.add(descrizione);
        descrizioneOrdini.add(prezzo);
        descrizioneOrdini.add(importo);
        descrizioneOrdini.add(eliminaLabel);
        
        aggiungi.addActionListener(new AggiungiOrdine(h, this));
        elimina.addActionListener(new ConfermaEliminaOrdine(h, this));
        stampaScontrino.addActionListener(new StampaScontrino(this, h));
        
        if(ordiniList.size() < 7) {
            for(int i = 0; i < 7; i++) {
                ordiniList.add(new JPanel());
                ordiniList.get(i).setLayout(new GridLayout(1, 5));
            }
        }else {
            for(var a : ordiniList) {
                a.add(new JPanel());
                a.setLayout(new GridLayout(1, 5));
            }
        }
        for(var a : ordiniList) {
            a.setLayout(new GridLayout(1, 5));
            ordiniListPanel.add(a);
            a.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }
        
        panelDestroFondo.add(totaleLabel);
        panelDestroFondo.add(panelDestraFondoPulsanti);
        
        totaleTF.setEditable(false);
        totaleLabel.setHorizontalAlignment(JLabel.RIGHT);
        
        panelDestraFondoPulsanti.add(elimina);
        panelDestraFondoPulsanti.add(aggiungi);
        panelDestraFondoPulsanti.add(stampaScontrino);
        panelDestraFondoPulsanti.add(totaleTF);
        
        if(!h.getOrdiniTavoli()[numeroTavolo].isEmpty()) {
            for(int i = 0; i < h.getOrdiniTavoli()[numeroTavolo].size(); i++) {
                Ordine get = (Ordine) h.getOrdiniTavoli()[numeroTavolo].get(i);
                JLabel[] infoPiattoArray = new JLabel[4];
                for(int j = 0; j < infoPiattoArray.length; j++) {
                    switch(j) {
                        case 0:
                            infoPiattoArray[j] = new JLabel(Integer.toString(get.getNumeroOrdini()));
                            break;
                        case 1:
                            infoPiattoArray[j] = new JLabel(get.getP().getNome());
                            break;
                        case 2:
                            infoPiattoArray[j] = new JLabel(Float.toString(get.getP().getCosto()));
                            break;
                        case 3:
                            infoPiattoArray[j] = new JLabel(Float.toString(get.getNumeroOrdini() * get.getP().getCosto()));
                            break;
                    }
                }
                updateInfoTavoloView(infoPiattoArray);
            }
        }
        
        setVisible(true);
        setBounds(0, 0, 800, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        centeredFrame(this);
    }
    
    /**
     * 
     * @param infoPiattoArray, array con i piatti e le loro info. 
     * Metodo per l'update grafico del frame InfoTavoloView.
     */
    public void updateInfoTavoloView(JLabel[] infoPiattoArray) {
        if(numeroPiatti >= ordiniList.size()) {
            ordiniList.add(new JPanel());
        }
        ordiniList.get(numeroPiatti).setVisible(true);
        
        checkBox.add(numeroPiatti, new JCheckBox());
        
        infoPiattoArray[0].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infoPiattoArray[1].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infoPiattoArray[2].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infoPiattoArray[3].setBorder(BorderFactory.createMatteBorder(0, 0, 0, 1, Color.BLACK));
        infoPiattoArray[0].setHorizontalAlignment(JLabel.CENTER);
        infoPiattoArray[1].setHorizontalAlignment(JLabel.CENTER);
        infoPiattoArray[2].setHorizontalAlignment(JLabel.CENTER);
        infoPiattoArray[3].setHorizontalAlignment(JLabel.CENTER);
        infoPiattoArray[0].setFont(new Font("Courier New", Font.PLAIN, 20));
        infoPiattoArray[1].setFont(new Font("Courier New", Font.PLAIN, 10));
        infoPiattoArray[2].setFont(new Font("Courier New", Font.PLAIN, 20));
        infoPiattoArray[3].setFont(new Font("Courier New", Font.PLAIN, 20));
        
        ordiniList.get(numeroPiatti).add(infoPiattoArray[0]);
        ordiniList.get(numeroPiatti).add(infoPiattoArray[1]);
        ordiniList.get(numeroPiatti).add(infoPiattoArray[2]);
        ordiniList.get(numeroPiatti).add(infoPiattoArray[3]);
        ordiniList.get(numeroPiatti).add(checkBox.get(numeroPiatti));
        
        checkBox.get(numeroPiatti).setHorizontalAlignment(JCheckBox.CENTER);
        
        totaleFloat = totaleFloat + Float.parseFloat(infoPiattoArray[3].getText());
        totaleTF.setText(String.valueOf(totaleFloat));
        
        this.revalidate();
        this.repaint();
        numeroPiatti++;
    }
    
    /**
     * 
     * @param objFrame 
     * Metodo per centrare il Frame (InfoTavoloView) nel centro dello schermo.
     */
    private void centeredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        objFrame.setLocation(iCoordX, iCoordY); 
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
	 * @return the tavolo
	 */
	public Tavolo getTavolo() {
		return tavolo;
	}

	/**
	 * @param tavolo the tavolo to set
	 */
	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
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
	 * @return the quantita
	 */
	public JLabel getQuantita() {
		return quantita;
	}

	/**
	 * @param quantita the quantita to set
	 */
	public void setQuantita(JLabel quantita) {
		this.quantita = quantita;
	}

	/**
	 * @return the descrizione
	 */
	public JLabel getDescrizione() {
		return descrizione;
	}

	/**
	 * @param descrizione the descrizione to set
	 */
	public void setDescrizione(JLabel descrizione) {
		this.descrizione = descrizione;
	}

	/**
	 * @return the prezzo
	 */
	public JLabel getPrezzo() {
		return prezzo;
	}

	/**
	 * @param prezzo the prezzo to set
	 */
	public void setPrezzo(JLabel prezzo) {
		this.prezzo = prezzo;
	}

	/**
	 * @return the importo
	 */
	public JLabel getImporto() {
		return importo;
	}

	/**
	 * @param importo the importo to set
	 */
	public void setImporto(JLabel importo) {
		this.importo = importo;
	}

	/**
	 * @return the eliminaLabel
	 */
	public JLabel getEliminaLabel() {
		return eliminaLabel;
	}

	/**
	 * @param eliminaLabel the eliminaLabel to set
	 */
	public void setEliminaLabel(JLabel eliminaLabel) {
		this.eliminaLabel = eliminaLabel;
	}

	/**
	 * @return the totaleLabel
	 */
	public JLabel getTotaleLabel() {
		return totaleLabel;
	}

	/**
	 * @param totaleLabel the totaleLabel to set
	 */
	public void setTotaleLabel(JLabel totaleLabel) {
		this.totaleLabel = totaleLabel;
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
	 * @return the totaleTF
	 */
	public JTextField getTotaleTF() {
		return totaleTF;
	}

	/**
	 * @param totaleTF the totaleTF to set
	 */
	public void setTotaleTF(JTextField totaleTF) {
		this.totaleTF = totaleTF;
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
	 * @return the aggiungi
	 */
	public JButton getAggiungi() {
		return aggiungi;
	}

	/**
	 * @param aggiungi the aggiungi to set
	 */
	public void setAggiungi(JButton aggiungi) {
		this.aggiungi = aggiungi;
	}

	/**
	 * @return the elimina
	 */
	public JButton getElimina() {
		return elimina;
	}

	/**
	 * @param elimina the elimina to set
	 */
	public void setElimina(JButton elimina) {
		this.elimina = elimina;
	}

	/**
	 * @return the stampaScontrino
	 */
	public JButton getStampaScontrino() {
		return stampaScontrino;
	}

	/**
	 * @param stampaScontrino the stampaScontrino to set
	 */
	public void setStampaScontrino(JButton stampaScontrino) {
		this.stampaScontrino = stampaScontrino;
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
	 * @return the panelSinistro
	 */
	public JPanel getPanelSinistro() {
		return panelSinistro;
	}

	/**
	 * @param panelSinistro the panelSinistro to set
	 */
	public void setPanelSinistro(JPanel panelSinistro) {
		this.panelSinistro = panelSinistro;
	}

	/**
	 * @return the panelDestro
	 */
	public JPanel getPanelDestro() {
		return panelDestro;
	}

	/**
	 * @param panelDestro the panelDestro to set
	 */
	public void setPanelDestro(JPanel panelDestro) {
		this.panelDestro = panelDestro;
	}

	/**
	 * @return the panelDestroFondo
	 */
	public JPanel getPanelDestroFondo() {
		return panelDestroFondo;
	}

	/**
	 * @param panelDestroFondo the panelDestroFondo to set
	 */
	public void setPanelDestroFondo(JPanel panelDestroFondo) {
		this.panelDestroFondo = panelDestroFondo;
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

	/**
	 * @return the descrizioneOrdini
	 */
	public JPanel getDescrizioneOrdini() {
		return descrizioneOrdini;
	}

	/**
	 * @param descrizioneOrdini the descrizioneOrdini to set
	 */
	public void setDescrizioneOrdini(JPanel descrizioneOrdini) {
		this.descrizioneOrdini = descrizioneOrdini;
	}

	/**
	 * @return the ordiniListPanel
	 */
	public JPanel getOrdiniListPanel() {
		return ordiniListPanel;
	}

	/**
	 * @param ordiniListPanel the ordiniListPanel to set
	 */
	public void setOrdiniListPanel(JPanel ordiniListPanel) {
		this.ordiniListPanel = ordiniListPanel;
	}

	/**
	 * @return the panelDestraFondoPulsanti
	 */
	public JPanel getPanelDestraFondoPulsanti() {
		return panelDestraFondoPulsanti;
	}

	/**
	 * @param panelDestraFondoPulsanti the panelDestraFondoPulsanti to set
	 */
	public void setPanelDestraFondoPulsanti(JPanel panelDestraFondoPulsanti) {
		this.panelDestraFondoPulsanti = panelDestraFondoPulsanti;
	}

	/**
	 * @return the ordiniList
	 */
	public ArrayList<JPanel> getOrdiniList() {
		return ordiniList;
	}

	/**
	 * @param ordiniList the ordiniList to set
	 */
	public void setOrdiniList(ArrayList<JPanel> ordiniList) {
		this.ordiniList = ordiniList;
	}

	/**
	 * @return the ordiniLabelList
	 */
	public ArrayList<JLabel> getOrdiniLabelList() {
		return ordiniLabelList;
	}

	/**
	 * @param ordiniLabelList the ordiniLabelList to set
	 */
	public void setOrdiniLabelList(ArrayList<JLabel> ordiniLabelList) {
		this.ordiniLabelList = ordiniLabelList;
	}

	/**
	 * @return the checkBox
	 */
	public ArrayList<JCheckBox> getCheckBox() {
		return checkBox;
	}

	/**
	 * @param checkBox the checkBox to set
	 */
	public void setCheckBox(ArrayList<JCheckBox> checkBox) {
		this.checkBox = checkBox;
	}

	/**
	 * @return the numeroPiatti
	 */
	public int getNumeroPiatti() {
		return numeroPiatti;
	}

	/**
	 * @param numeroPiatti the numeroPiatti to set
	 */
	public void setNumeroPiatti(int numeroPiatti) {
		this.numeroPiatti = numeroPiatti;
	}

	/**
	 * @return the numeroTavolo
	 */
	public int getNumeroTavolo() {
		return numeroTavolo;
	}

	/**
	 * @param numeroTavolo the numeroTavolo to set
	 */
	public void setNumeroTavolo(int numeroTavolo) {
		this.numeroTavolo = numeroTavolo;
	}

	/**
	 * @return the totaleFloat
	 */
	public float getTotaleFloat() {
		return totaleFloat;
	}

	/**
	 * @param totaleFloat the totaleFloat to set
	 */
	public void setTotaleFloat(float totaleFloat) {
		this.totaleFloat = totaleFloat;
	}
}
