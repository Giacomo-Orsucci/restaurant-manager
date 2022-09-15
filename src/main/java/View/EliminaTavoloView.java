package View;

import Controller.ConfermaEliminaTavolo;
import Model.Tavolo;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe che permette la creazione di una finestra grafica per eliminare i tavoli.
 */
public class EliminaTavoloView extends JFrame {
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -1343476709454717296L;

    private final Home h;
    
    /* JLABEL */
    private final JLabel labelElimina = new JLabel("ELIMINA TAVOLO");
    /* JLABEL */
    
    /* JPANEL */
    private JPanel rootPanel = new JPanel();
    private final JPanel panelNorth;
    private final JPanel panelCenter = new JPanel();
    /* JPANEL */
    
    /* JRADIOBUTTON */
    private final JRadioButton arrayRadioButton[] = new JRadioButton[Tavolo.NUMERO_MASSIMO]; 
    /* JRADIOBUTTON */
    
    /* JBUTTON */
    private final JButton confermaButton = new JButton("CONFERMA");
    /* JBUTTON */
    
    /**
     * 
     * @param h, riferimento della home. 
     * Costruttore della classe EliminaTavoloView. Contiene l'inizializzazione dei componenti grafici della finestra grafica per l'eliminazione dei tavoli.
     */
    public EliminaTavoloView(Home h){
        super("Elimina tavolo"); //Si richiama il costruttore della superclasse JFrame
        this.h = h;
        
        /* IMPOSTAZIONE GRADIENTE NEL PANEL */
        panelNorth = new JPanel() {
            /**
            * Serial Version UID.
            */
            private static final long serialVersionUID = -8920967357538784027L;
            
            //metodo per il gradiente del colore 
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
        /* IMPOSTAZIONE GRADIENTE NEL PANEL */
        
        /* IMPOSTAZIONI PANEL */
        panelNorth.setBackground(Color.YELLOW);
        labelElimina.setForeground(Color.red);
        
        rootPanel = (JPanel) getContentPane();
        rootPanel.setLayout(new BorderLayout());
        
        rootPanel.add(panelNorth, BorderLayout.NORTH);
        rootPanel.add(panelCenter, BorderLayout.CENTER);
        
        panelNorth.add(labelElimina);
        
        panelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                
        labelElimina.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 36));
        confermaButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 36));
        confermaButton.setForeground(new Color(19, 74, 34));
        /* IMPOSTAZIONI PANEL */
        
        /* IMPOSTAZIONI RADIO BUTTON */
        for(int i = 0; i < arrayRadioButton.length; i++) {
            if(h.getArrayTavoli()[i] != null) {
                if(arrayRadioButton[i] == null) {
                    arrayRadioButton[i] = new JRadioButton(h.getArrayTavoli()[i].getId());
                }else {
                    arrayRadioButton[i].setText(h.getArrayTavoli()[i].getId());
                }

                panelCenter.add(arrayRadioButton[i]);

                if(h.getTavoliButton()[i].isVisible()) {
                    arrayRadioButton[i].setVisible(true);
                }else {
                    arrayRadioButton[i].setVisible(false);
                }

                arrayRadioButton[i].setFont(new Font("Courier New", Font.PLAIN, 48));
            }
        }
        /* IMPOSTAZIONI RADIO BUTTON */
        
        //Aggiunta pulsante di conferma nel frame e aggiunta dell'ActionListener
        rootPanel.add(confermaButton, BorderLayout.SOUTH);
        confermaButton.addActionListener(new ConfermaEliminaTavolo(h, arrayRadioButton, this));
        
        /* INIZIALIZZAZIONE FRAME */
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(h.getX() + (h.getWidth() / 2) - 150, h.getY() + (h.getHeight() / 2) - 100, 800, 550);
        setResizable(false);
        /* INIZIALIZZAZIONE FRAME */
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
	 * @return the h
	 */
	public Home getH() {
		return h;
	}

	/**
	 * @return the labelElimina
	 */
	public JLabel getLabelElimina() {
		return labelElimina;
	}

	/**
	 * @return the panelNorth
	 */
	public JPanel getPanelNorth() {
		return panelNorth;
	}

	/**
	 * @return the panelCenter
	 */
	public JPanel getPanelCenter() {
		return panelCenter;
	}

	/**
	 * @return the arrayRadioButton
	 */
	public JRadioButton[] getArrayRadioButton() {
		return arrayRadioButton;
	}

	/**
	 * @return the confermaButton
	 */
	public JButton getConfermaButton() {
		return confermaButton;
	}
}
