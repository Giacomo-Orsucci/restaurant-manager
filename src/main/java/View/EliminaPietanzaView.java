
package View;

import Controller.ConfermaEliminaPietanza;
import Model.Pietanza;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe che mostra la finestra grafica per eliminare la pietanza.
 */
public class EliminaPietanzaView extends JFrame {
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -1588856205695176519L;

    private final Home h;
    
    private final JLabel labelElimina = new JLabel("ELIMINA PIETANZA");
    
    private JPanel rootPanel = new JPanel();
    private final JPanel panelNorth;
    private final JPanel panelCenter = new JPanel();

    private final ArrayList<Pietanza> pietanze;
    
    private ArrayList<JRadioButton> pietanzeButtonList = new ArrayList<>();
    
    private final JButton confermaButton = new JButton("CONFERMA");
    
    private ButtonGroup buttonGroupElimina = new ButtonGroup();
    
    /**
     * 
     * @param h, riferimento della home. 
     * Costruttore della classe EliminaPietanzaView. Contiene l'inizializzazione dei componenti grafici della finestra per l'eliminazione di una pietanza dal menu.
     */
    public EliminaPietanzaView(Home h){
        super("Elimina pietanza");
        this.h = h;
        
        labelElimina.setForeground(Color.red);
        
        panelNorth = new JPanel() {
            /**
            * Serial Version UID.
            */
            private static final long serialVersionUID = 5465438502476126143L;
            
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
        
        //setto i panel
        panelNorth.setBackground(Color.YELLOW);
        
        rootPanel = (JPanel) getContentPane();
        rootPanel.setLayout(new BorderLayout());
        
        rootPanel.add(panelNorth, BorderLayout.NORTH);
        rootPanel.add(panelCenter, BorderLayout.CENTER);
        
        panelNorth.add(labelElimina);
        
        panelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                
        //setto i font
        labelElimina.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 36));
        confermaButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 36));
        confermaButton.setForeground(new Color(19, 74, 34));
        
        pietanze = h.getPietanze();
        
        /*
            Creo e aggiungo alla finestra i JRadioButton 
            per l'eliminazione delle pietanze dal menu   
        */
        if(h.getPietanze().size() != 0) {
            for(int i = 0; i < h.getPietanze().size(); i++) {
                pietanzeButtonList.add(new JRadioButton(h.getPietanze().get(i).getNome()));
                panelCenter.add(pietanzeButtonList.get(i));
                pietanzeButtonList.get(i).setVisible(true);
                pietanzeButtonList.get(i).setFont(new Font("Courier New", Font.PLAIN, 48));
            } 
        }
            
        rootPanel.add(confermaButton, BorderLayout.SOUTH);
        
        confermaButton.addActionListener(new ConfermaEliminaPietanza(h, pietanzeButtonList, this));
        
        
        /*
            aggiungo tutti i JRadioButton allo stesso ButtonGroup per permettere
            un'eliminazione alla volta di una pietaza dal menù.
        */
        for(int i = 0; i < pietanzeButtonList.size(); i++) {
            buttonGroupElimina.add(pietanzeButtonList.get(i));
            
        }
        
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(h.getX() + (h.getWidth() / 2) - 150, h.getY() + (h.getHeight() / 2) - 100, 800, 550);
        setResizable(false);
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
	 * @return the pietanzeButtonList
	 */
	public ArrayList<JRadioButton> getPietanzeButtonList() {
		return pietanzeButtonList;
	}

	/**
	 * @param pietanzeButtonList the pietanzeButtonList to set
	 */
	public void setPietanzeButtonList(ArrayList<JRadioButton> pietanzeButtonList) {
		this.pietanzeButtonList = pietanzeButtonList;
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
	 * @return the pietanze
	 */
	public ArrayList<Pietanza> getPietanze() {
		return pietanze;
	}

	/**
	 * @return the confermaButton
	 */
	public JButton getConfermaButton() {
		return confermaButton;
	}
}
