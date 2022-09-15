package View;

import Controller.*;
import Model.Ordine;
import Model.Pietanza;
import java.awt.BorderLayout;
import javax.swing.*;
import Model.Tavolo;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout; 
import java.awt.Toolkit;
import java.util.ArrayList;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Finestra grafica che mostra la sala del ristorante.
 */
public class Home extends JFrame {
    
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -100887184272366057L;
    
    private int numeroTavoli = 0;
    
    private Tavolo[] arrayTavoli = new Tavolo[Tavolo.NUMERO_MASSIMO];
    
    /* INIZIALIZZAZIONE JMENU E JMENUITEM */
    private final JMenuBar menu = new JMenuBar();
    private final JMenu file = new JMenu("File");
    private final JMenu tavoli = new JMenu("Tavoli");
    private final JMenuItem esci = new JMenuItem("Esci");
    private final JMenu aggiungiTavoli = new JMenu("Aggiungi");
    private final JMenu eliminaTavoli = new JMenu("Elimina");
    private final JMenuItem tavoloDue = new JMenuItem("2 Persone");
    private final JMenuItem tavoloQuattro = new JMenuItem("4 Persone");
    private final JMenuItem tavoloSei = new JMenuItem("6 Persone");
    private final JMenuItem tavoloOtto = new JMenuItem("8 Persone");
    private final JMenuItem salvaTavoli = new JMenuItem("Salva Tavoli");
    private final JMenuItem caricaTavoli = new JMenuItem("Carica Tavoli");
    private final JMenuItem salvaPietanze = new JMenuItem("Salva Pietanze");
    private final JMenuItem caricaPietanze = new JMenuItem("Carica Pietanze");
    private JMenuItem[] tavoliEliminare = new JMenuItem[Tavolo.NUMERO_MASSIMO];
    
    /* INIZIALIZZAZIONE JLABEL */
    private final JLabel labelOpzioniTavoli = new JLabel("TAVOLI");
    private final JLabel labelOpzioniPietanze = new JLabel("PIETANZE");
    private final JLabel salaTavoli = new JLabel("SALA TAVOLI");
    
    /* INIZIALIZZAZIONE JBUTTON */
    private final JButton aggiungiTavoloOpzioni = new JButton("Aggiungi");
    private final JButton eliminaTavoloOpzioni = new JButton("Elimina");
    private final JButton modificaTavoloOpzioni = new JButton("Modifica");
    private final JButton aggiungiPietanzeOpzioni = new JButton("Aggiungi");
    private final JButton eliminaPietanzeOpzioni = new JButton("Elimina");
    private final JButton modificaPietanzeOpzioni = new JButton("Modifica");
    
    private JButton[] tavoliButton = new JButton[Tavolo.NUMERO_MASSIMO];
    
    /* INIZIALIZZAZIONE JPANEL */
    private final JPanel root = new JPanel();
    private final JPanel salaTavoliPanel = new JPanel();
    private final JPanel panelTavoli = new JPanel();
    private final JPanel panelOpzioni = new JPanel();
    private final JPanel panelOpzioniTavoli = new JPanel();
    private final JPanel panelOpzioniPietanze = new JPanel();
    
    private AggiungiTavoliRapido aggiungiTavoliRapido;
    
    private EliminaTavoloRapido eliminaTavoloRapido;
    
    private ArrayList<Pietanza> pietanze = new ArrayList<>();
    
    private ArrayList<Ordine>[] ordiniTavoli = new ArrayList[Tavolo.NUMERO_MASSIMO];
    
    private ArrayList<InfoTavolo> infoTavoloActionListner = new ArrayList<>();
    
    /**
     * Costruttore di default della classe Home. Contiene l'inizializzazione dei componenti grafici.
     */
    public Home() {
        super("Gestione Ristorante");
        Font fontMenuOpzioni = new Font("Courier New", Font.BOLD, 16);
        getContentPane().add(root);
        setJMenuBar(menu);
        root.setLayout(new BorderLayout());
        getRootPane().setDefaultButton(null);
        
        /* INIZIALIZZAZIONE MENU */
        menu.add(file);
        menu.add(tavoli);
        menu.add(esci);
        
        Font menuFont = new Font("Geo Sans Light", Font.PLAIN, 18);
        
        file.setFont(menuFont);
        tavoli.setFont(menuFont);
        esci.setFont(menuFont);
        
        file.setPreferredSize(new Dimension(60, 35));
        tavoli.setPreferredSize(new Dimension(60, 35));
        esci.setPreferredSize(new Dimension(60, 35));
        esci.setMaximumSize(new Dimension(80, 35));
        
        file.add(salvaTavoli);
        file.add(caricaTavoli);
        file.add(salvaPietanze);
        file.add(caricaPietanze);
        
        tavoli.add(aggiungiTavoli);
        tavoli.add(eliminaTavoli);
        
        aggiungiTavoli.add(tavoloDue);
        aggiungiTavoli.add(tavoloQuattro);
        aggiungiTavoli.add(tavoloSei);
        aggiungiTavoli.add(tavoloOtto);
        
        /* SETTAGGIO PANEL SALA TAVOLI */
        salaTavoli.setHorizontalAlignment(JLabel.CENTER);
        salaTavoli.setFont(new Font("Geo Sans Light", Font.PLAIN, 22));
        salaTavoliPanel.setBackground(Color.yellow);
        salaTavoli.setForeground(Color.red);
        salaTavoliPanel.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.BLACK));
        
        /* INIZIALIZZAZIONE TAVOLI */
        /*
            I tavoli vengono inizializzati tutti all'inizio, poi verranno resi visibili
            quando l'utente li aggiunge.
        */
        root.add(panelTavoli, BorderLayout.CENTER);
        for(int i = 0; i < tavoliButton.length; i++) {
            arrayTavoli[i] = new Tavolo();
            arrayTavoli[i].setId(Integer.toString(i + 1));
            tavoliButton[i] = new JButton("<html>Tavolo " + arrayTavoli[i].getId() + "<br>N.Posti: " + arrayTavoli[i].getNumeroPosti() + "</html>");
            tavoliEliminare[i] = new JMenuItem(arrayTavoli[i].getId());
            tavoliEliminare[i].setVisible(false);
            eliminaTavoli.add(tavoliEliminare[i]);
        }
        for(var a : tavoliButton) { 
            a.setVisible(false);
            panelTavoli.add(a);
        }
        
        /* SETTAGGIO PANEL OPZIONI */
        root.add(salaTavoliPanel, BorderLayout.NORTH);
        root.add(panelOpzioni, BorderLayout.LINE_END);
        salaTavoliPanel.add(salaTavoli);
        panelOpzioni.setLayout(new GridLayout(2, 1));
        panelOpzioni.add(panelOpzioniTavoli);
        panelOpzioni.add(panelOpzioniPietanze);
        panelOpzioniTavoli.setLayout(new GridLayout(3, 1));
        panelOpzioniPietanze.setLayout(new GridLayout(3, 1));
        
        panelOpzioni.setPreferredSize(new Dimension(300, 900));
        
        /* IMPOSTAZIONE BORDI */
        panelOpzioniTavoli.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.black));
        panelOpzioni.setBorder(BorderFactory.createMatteBorder(0, 3, 3, 3, Color.BLACK));
        
        /* SETTAGGIO DEL MENU TAVOLI (in alto a sx)*/
        aggiungiTavoloOpzioni.setFont(fontMenuOpzioni);
        eliminaTavoloOpzioni.setFont(fontMenuOpzioni);
        
        labelOpzioniTavoli.setHorizontalAlignment(JLabel.CENTER);
        labelOpzioniTavoli.setFont(new Font("Courier New", Font.BOLD, 32));
        labelOpzioniTavoli.setForeground(Color.RED);
        labelOpzioniTavoli.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        
        panelOpzioniTavoli.add(labelOpzioniTavoli);
        panelOpzioniTavoli.add(aggiungiTavoloOpzioni);
        panelOpzioniTavoli.add(eliminaTavoloOpzioni);

        
        /* SETTAGGIO DEL MENU PIETANZE (in alto a sx) */
        aggiungiPietanzeOpzioni.setFont(fontMenuOpzioni);
        eliminaPietanzeOpzioni.setFont(fontMenuOpzioni);
        modificaPietanzeOpzioni.setFont(fontMenuOpzioni);
        JPanel panelOpzioniPietanzeDuePulsanti = new JPanel(new GridLayout(1, 2));
        
        labelOpzioniPietanze.setFont(new Font("Courier New", Font.BOLD, 32));
        labelOpzioniPietanze.setForeground(Color.RED);
        labelOpzioniPietanze.setHorizontalAlignment(JLabel.CENTER);
        labelOpzioniPietanze.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        
        panelOpzioniPietanzeDuePulsanti.add(aggiungiPietanzeOpzioni);
        panelOpzioniPietanzeDuePulsanti.add(eliminaPietanzeOpzioni);
        panelOpzioniPietanze.add(labelOpzioniPietanze);       
        panelOpzioniPietanze.add(panelOpzioniPietanzeDuePulsanti);
        panelOpzioniPietanze.add(modificaPietanzeOpzioni);
        
        /*IMPOSTAZIONE NOMI PULSANTI */
        tavoloDue.setName("DUE");
        tavoloQuattro.setName("QUATTRO");
        tavoloSei.setName("SEI");
        tavoloOtto.setName("OTTO");
        
        for(int i = 0; i < tavoliButton.length; i++) {
            tavoliButton[i].setName("" + i);
        }
        
        /* IMPOSTAZIONE ACTION LISTENERS */
        /*
            settaggio tutti gli actioListener della home, compresi quelli dei tavoli e 
            dei JMenuItem per l'eliminazione rapida
        */
        aggiungiTavoliRapido = new AggiungiTavoliRapido(this);
        esci.addActionListener(new Esci());
        tavoloDue.addActionListener(aggiungiTavoliRapido);
        tavoloQuattro.addActionListener(aggiungiTavoliRapido);
        tavoloSei.addActionListener(aggiungiTavoliRapido);
        tavoloOtto.addActionListener(aggiungiTavoliRapido);
        
        aggiungiTavoloOpzioni.addActionListener(new AggiungiTavolo(this, arrayTavoli[numeroTavoli]));
        eliminaTavoloOpzioni.addActionListener(new EliminaTavolo(this));
        
        aggiungiPietanzeOpzioni.addActionListener(new AggiungiPietanza(this));
        eliminaPietanzeOpzioni.addActionListener(new EliminaPietanza(this));
        modificaPietanzeOpzioni.addActionListener(new ModificaPietanza(this));
        
        salvaTavoli.addActionListener(new SalvaTavoli(this));
        caricaTavoli.addActionListener(new CaricaTavoli(this));
        salvaPietanze.addActionListener(new SalvaPietanze(this));
        caricaPietanze.addActionListener(new CaricaPietanze(this));
        
        for(int i = 0; i < tavoliButton.length; i++) {
            infoTavoloActionListner.add(new InfoTavolo(this, arrayTavoli[i]));
            tavoliButton[i].addActionListener(infoTavoloActionListner.get(i));
            tavoliButton[i].setPreferredSize(new Dimension(200, 80));
        }
        
        for(int i = 0; i < tavoliEliminare.length; i++) {
            eliminaTavoloRapido = new EliminaTavoloRapido(i, this);
            tavoliEliminare[i].addActionListener(eliminaTavoloRapido);
        }
        
        for(int i = 0; i < ordiniTavoli.length; i++) {
            ordiniTavoli[i] = new ArrayList<Ordine>();
        }
        
        /* INIZIALIZZAZIONE FRAME */
        setResizable(false);
        setVisible(true);
        setBounds(0, 0, 1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        centeredFrame(this);
    }
    
    /**
     * Metodo che permette l'aggiornamento della parte grafica della classe Home.
     */
    public void aggiornaHome() {
        numeroTavoli = 0;
        for(int i = 0; i < Tavolo.NUMERO_MASSIMO; i++) {
            if(arrayTavoli[i] != null) {
                /* IMPOSTAZIONE DEI PULSANTI DEI TAVOLI */
                tavoliButton[i].setText("<html>Tavolo " + arrayTavoli[i].getId() + "<br>N.Posti: " + arrayTavoli[i].getNumeroPosti() 
                                    + "<br>" + arrayTavoli[i].getStatoString() + "</html>");
                if(tavoliButton[i].isVisible()) numeroTavoli++;
                
                /* IMPOSTAZIONE DELLO STATO DEI TAVOLI */
                switch (arrayTavoli[i].getStato()) {
                    case Tavolo.LIBERO:
                        tavoliButton[i].setBackground(Color.green);
                        break;
                    case Tavolo.OCCUPATO:
                        tavoliButton[i].setBackground(Color.red);
                        break;
                    case Tavolo.ATTESA_CONTO:
                        tavoliButton[i].setBackground(Color.MAGENTA);
                        break;
                    default:
                        tavoliButton[i].setBackground(Color.ORANGE);
                        break;
                }
                
                /* IMPOSTAZIONE DEL NUMERO DEI POSTI */
                switch (arrayTavoli[i].getNumeroPosti()) {
                    case 2:
                        tavoliButton[i].setPreferredSize(new Dimension(250, 80));
                        break;
                    case 4:
                        tavoliButton[i].setPreferredSize(new Dimension(280, 80));
                        break;
                    case 6:
                        tavoliButton[i].setPreferredSize(new Dimension(320, 80));
                        break;
                    case 8:
                        tavoliButton[i].setPreferredSize(new Dimension(380, 80));
                        break;
                    default:
                        break;
                }
                
                /* IMPOSTAZIONE DEL MENU A TENDINA */ 
                tavoliEliminare[i].setText(arrayTavoli[i].getId());
                tavoliEliminare[i].setText(arrayTavoli[i].getId());
                tavoliEliminare[i].removeActionListener(eliminaTavoloRapido);
                tavoliEliminare[i].addActionListener(new EliminaTavoloRapido(i, this));
                if(tavoliButton[i].isVisible()) {
                    tavoliEliminare[i].setVisible(true);
                }else {
                    tavoliEliminare[i].setVisible(false);
                }
                
                /* AGGIUNTA E RIMOZIONE ACTION LISTENER */ 
                tavoliButton[i].removeActionListener(infoTavoloActionListner.get(i));
                infoTavoloActionListner.set(i, new InfoTavolo(this, arrayTavoli[i]));
                tavoliButton[i].addActionListener(infoTavoloActionListner.get(i));
            }
            /* DESIGN */ 
            tavoliButton[i].setHorizontalAlignment(JButton.CENTER);
            this.tavoliButton[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
        }
        
        /* AGGIUNTA E RIMOZIONE ACTION LISTNER */ 
        tavoloDue.removeActionListener(aggiungiTavoliRapido);
        tavoloQuattro.removeActionListener(aggiungiTavoliRapido);
        tavoloSei.removeActionListener(aggiungiTavoliRapido);
        tavoloOtto.removeActionListener(aggiungiTavoliRapido);
        aggiungiTavoliRapido = null;
        aggiungiTavoliRapido = new AggiungiTavoliRapido(this);
        tavoloDue.addActionListener(aggiungiTavoliRapido);
        tavoloQuattro.addActionListener(aggiungiTavoliRapido);
        tavoloSei.addActionListener(aggiungiTavoliRapido);
        tavoloOtto.addActionListener(aggiungiTavoliRapido);
        repaint();
    }
    
    /**
     * 
     * @param arrayTavoli, array di Tavoli
     * @param visibile, array booleano della visibilità dei tavoli
     * Metodo che permette il caricamento dei tavoli da file.
     */
    public void caricaTavoli(Tavolo[] arrayTavoli, boolean[] visibile){
        this.arrayTavoli = arrayTavoli;
        
        /* CANCELLAZIONE VECCHIO ARRAY */
        for(var a : tavoliEliminare) {
            a.setVisible(false);
        }
        tavoliEliminare = null;
        tavoliEliminare = new JMenuItem[Tavolo.NUMERO_MASSIMO];
        
        numeroTavoli = 0;
        /* CARICAMENTO DEL NUOVO ARRAY */   
        for(int i = 0; i < Tavolo.NUMERO_MASSIMO; i++) {
            if(arrayTavoli[i] != null) {
                /* IMPOSTAZIONE DEI PULSANTI DEI TAVOLI */
                this.tavoliButton[i].setText("<html>Tavolo " + arrayTavoli[i].getId() + "<br>N.Posti: " + arrayTavoli[i].getNumeroPosti() 
                                    + "<br>" + arrayTavoli[i].getStatoString() + "</html>");
                if(visibile[i]) numeroTavoli++;
                this.tavoliButton[i].setVisible(visibile[i]);
                tavoliEliminare[i] = new JMenuItem(arrayTavoli[i].getId());
                eliminaTavoli.add(tavoliEliminare[i]);
                
                /* IMPOSTAZIONE DELLO STATO DEI TAVOLI */
                switch (arrayTavoli[i].getStato()) {
                    case Tavolo.LIBERO:
                        this.tavoliButton[i].setBackground(Color.green);
                        break;
                    case Tavolo.OCCUPATO:
                        this.tavoliButton[i].setBackground(Color.red);
                        break;
                    case Tavolo.ATTESA_CONTO:
                        this.tavoliButton[i].setBackground(Color.MAGENTA);
                        break;
                    default:
                        this.tavoliButton[i].setBackground(Color.ORANGE);
                        break;
                }
                
                /* IMPOSTAZIONE DEL NUMERO DEI POSTI */ 
                switch(arrayTavoli[i].getNumeroPosti()) {
                    case 2:
                        this.tavoliButton[i].setPreferredSize(new Dimension(250, 80));
                        break;
                    case 4:
                        this.tavoliButton[i].setPreferredSize(new Dimension(280, 80));
                        break;
                    case 6:
                        this.tavoliButton[i].setPreferredSize(new Dimension(320, 80));
                        break;
                    case 8:
                        this.tavoliButton[i].setPreferredSize(new Dimension(380, 80));
                        break;
                    default:
                        break;
                }
                
                /* IMPOSTAZIONE DEL MENU A TENDINA */ 
                tavoliEliminare[i].setText(arrayTavoli[i].getId());
                tavoliEliminare[i].removeActionListener(eliminaTavoloRapido);
                tavoliEliminare[i].addActionListener(new EliminaTavoloRapido(i, this));
                if(this.tavoliButton[i].isVisible()) {
                    tavoliEliminare[i].setVisible(true);
                }else {
                    tavoliEliminare[i].setVisible(false);
                } 
                
                /* RIMOZIONE E AGGIUNTA ACTION LISTENER */ 
                tavoliButton[i].removeActionListener(infoTavoloActionListner.get(i));
                infoTavoloActionListner.set(i, new InfoTavolo(this, arrayTavoli[i]));
                tavoliButton[i].addActionListener(infoTavoloActionListner.get(i)); 
            }else {
                //Aggiunta del tavolo
                this.arrayTavoli[i] = new Tavolo();
            }
            
            /* DESIGN */
            this.tavoliButton[i].setHorizontalAlignment(JButton.CENTER);
            this.tavoliButton[i].setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, true));
            repaint();
        }
        
        /* RIMOZIONE E AGGIUNTA ACTION LISTENER */
        tavoloDue.removeActionListener(aggiungiTavoliRapido);
        tavoloQuattro.removeActionListener(aggiungiTavoliRapido);
        tavoloSei.removeActionListener(aggiungiTavoliRapido);
        tavoloOtto.removeActionListener(aggiungiTavoliRapido);
        aggiungiTavoliRapido = null;
        aggiungiTavoliRapido = new AggiungiTavoliRapido(this);
        tavoloDue.addActionListener(aggiungiTavoliRapido);
        tavoloQuattro.addActionListener(aggiungiTavoliRapido);
        tavoloSei.addActionListener(aggiungiTavoliRapido);
        tavoloOtto.addActionListener(aggiungiTavoliRapido);
    }
    
    /**
     * 
     * @param objFrame 
     * Metodo per centrare il Frame (Home) al centro dello schermo. 
     */
    private void centeredFrame(javax.swing.JFrame objFrame){
        
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        
        objFrame.setLocation(iCoordX, iCoordY); 
    }

	/**
	 * @return the numeroTavoli
	 */
	public int getNumeroTavoli() {
		return numeroTavoli;
	}

	/**
	 * @param numeroTavoli the numeroTavoli to set
	 */
	public void setNumeroTavoli(int numeroTavoli) {
		this.numeroTavoli = numeroTavoli;
	}

	/**
	 * @return the arrayTavoli
	 */
	public Tavolo[] getArrayTavoli() {
		return arrayTavoli;
	}

	/**
	 * @param arrayTavoli the arrayTavoli to set
	 */
	public void setArrayTavoli(Tavolo[] arrayTavoli) {
		this.arrayTavoli = arrayTavoli;
	}

	/**
	 * @return the tavoliEliminare
	 */
	public JMenuItem[] getTavoliEliminare() {
		return tavoliEliminare;
	}

	/**
	 * @param tavoliEliminare the tavoliEliminare to set
	 */
	public void setTavoliEliminare(JMenuItem[] tavoliEliminare) {
		this.tavoliEliminare = tavoliEliminare;
	}

	/**
	 * @return the tavoliButton
	 */
	public JButton[] getTavoliButton() {
		return tavoliButton;
	}

	/**
	 * @param tavoliButton the tavoliButton to set
	 */
	public void setTavoliButton(JButton[] tavoliButton) {
		this.tavoliButton = tavoliButton;
	}

	/**
	 * @return the aggiungiTavoliRapido
	 */
	public AggiungiTavoliRapido getAggiungiTavoliRapido() {
		return aggiungiTavoliRapido;
	}

	/**
	 * @param aggiungiTavoliRapido the aggiungiTavoliRapido to set
	 */
	public void setAggiungiTavoliRapido(AggiungiTavoliRapido aggiungiTavoliRapido) {
		this.aggiungiTavoliRapido = aggiungiTavoliRapido;
	}

	/**
	 * @return the eliminaTavoloRapido
	 */
	public EliminaTavoloRapido getEliminaTavoloRapido() {
		return eliminaTavoloRapido;
	}

	/**
	 * @param eliminaTavoloRapido the eliminaTavoloRapido to set
	 */
	public void setEliminaTavoloRapido(EliminaTavoloRapido eliminaTavoloRapido) {
		this.eliminaTavoloRapido = eliminaTavoloRapido;
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
	 * @return the ordiniTavoli
	 */
	public ArrayList<Ordine>[] getOrdiniTavoli() {
		return ordiniTavoli;
	}

	/**
	 * @param ordiniTavoli the ordiniTavoli to set
	 */
	public void setOrdiniTavoli(ArrayList<Ordine>[] ordiniTavoli) {
		this.ordiniTavoli = ordiniTavoli;
	}

	/**
	 * @return the infoTavoloActionListner
	 */
	public ArrayList<InfoTavolo> getInfoTavoloActionListner() {
		return infoTavoloActionListner;
	}

	/**
	 * @param infoTavoloActionListner the infoTavoloActionListner to set
	 */
	public void setInfoTavoloActionListner(ArrayList<InfoTavolo> infoTavoloActionListner) {
		this.infoTavoloActionListner = infoTavoloActionListner;
	}

	/**
	 * @return the menu
	 */
	public JMenuBar getMenu() {
		return menu;
	}

	/**
	 * @return the file
	 */
	public JMenu getFile() {
		return file;
	}

	/**
	 * @return the tavoli
	 */
	public JMenu getTavoli() {
		return tavoli;
	}

	/**
	 * @return the esci
	 */
	public JMenuItem getEsci() {
		return esci;
	}

	/**
	 * @return the aggiungiTavoli
	 */
	public JMenu getAggiungiTavoli() {
		return aggiungiTavoli;
	}

	/**
	 * @return the eliminaTavoli
	 */
	public JMenu getEliminaTavoli() {
		return eliminaTavoli;
	}

	/**
	 * @return the tavoloDue
	 */
	public JMenuItem getTavoloDue() {
		return tavoloDue;
	}

	/**
	 * @return the tavoloQuattro
	 */
	public JMenuItem getTavoloQuattro() {
		return tavoloQuattro;
	}

	/**
	 * @return the tavoloSei
	 */
	public JMenuItem getTavoloSei() {
		return tavoloSei;
	}

	/**
	 * @return the tavoloOtto
	 */
	public JMenuItem getTavoloOtto() {
		return tavoloOtto;
	}

	/**
	 * @return the salvaTavoli
	 */
	public JMenuItem getSalvaTavoli() {
		return salvaTavoli;
	}

	/**
	 * @return the caricaTavoli
	 */
	public JMenuItem getCaricaTavoli() {
		return caricaTavoli;
	}

	/**
	 * @return the salvaPietanze
	 */
	public JMenuItem getSalvaPietanze() {
		return salvaPietanze;
	}

	/**
	 * @return the caricaPietanze
	 */
	public JMenuItem getCaricaPietanze() {
		return caricaPietanze;
	}

	/**
	 * @return the labelOpzioniTavoli
	 */
	public JLabel getLabelOpzioniTavoli() {
		return labelOpzioniTavoli;
	}

	/**
	 * @return the labelOpzioniPietanze
	 */
	public JLabel getLabelOpzioniPietanze() {
		return labelOpzioniPietanze;
	}

	/**
	 * @return the salaTavoli
	 */
	public JLabel getSalaTavoli() {
		return salaTavoli;
	}

	/**
	 * @return the aggiungiTavoloOpzioni
	 */
	public JButton getAggiungiTavoloOpzioni() {
		return aggiungiTavoloOpzioni;
	}

	/**
	 * @return the eliminaTavoloOpzioni
	 */
	public JButton getEliminaTavoloOpzioni() {
		return eliminaTavoloOpzioni;
	}

	/**
	 * @return the modificaTavoloOpzioni
	 */
	public JButton getModificaTavoloOpzioni() {
		return modificaTavoloOpzioni;
	}

	/**
	 * @return the aggiungiPietanzeOpzioni
	 */
	public JButton getAggiungiPietanzeOpzioni() {
		return aggiungiPietanzeOpzioni;
	}

	/**
	 * @return the eliminaPietanzeOpzioni
	 */
	public JButton getEliminaPietanzeOpzioni() {
		return eliminaPietanzeOpzioni;
	}

	/**
	 * @return the modificaPietanzeOpzioni
	 */
	public JButton getModificaPietanzeOpzioni() {
		return modificaPietanzeOpzioni;
	}

	/**
	 * @return the root
	 */
	public JPanel getRoot() {
		return root;
	}

	/**
	 * @return the salaTavoliPanel
	 */
	public JPanel getSalaTavoliPanel() {
		return salaTavoliPanel;
	}

	/**
	 * @return the panelTavoli
	 */
	public JPanel getPanelTavoli() {
		return panelTavoli;
	}

	/**
	 * @return the panelOpzioni
	 */
	public JPanel getPanelOpzioni() {
		return panelOpzioni;
	}

	/**
	 * @return the panelOpzioniTavoli
	 */
	public JPanel getPanelOpzioniTavoli() {
		return panelOpzioniTavoli;
	}

	/**
	 * @return the panelOpzioniPietanze
	 */
	public JPanel getPanelOpzioniPietanze() {
		return panelOpzioniPietanze;
	}
}
