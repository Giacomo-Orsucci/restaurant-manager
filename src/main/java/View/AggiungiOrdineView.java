
package View;

import Controller.ConfermaAggiungiOrdine;
import Controller.*;
import Model.Pietanza;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe per la presentazione della finestra grafica per l'aggiunta di un ordine.
 */
public class AggiungiOrdineView extends JFrame {
    
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -2251550897020053728L;
    
    private Home h;
    
    private InfoTavoloView infoTavoloView;
    
    private JLabel labelElimina = new JLabel("Seleziona il reparto ");
    
    private JPanel rootPanel = new JPanel();
    private JPanel panelNorth;
    private JPanel panelCenter = new JPanel();

    private ArrayList<Pietanza> pietanze;
    private ArrayList<JRadioButton> pietanzeButtonList = new ArrayList<>();
    
    private ButtonGroup buttonGroup = new ButtonGroup();
    
    private JButton confermaButton = new JButton("CONFERMA");
    
    private JComboBox<String> repartoBox;
    private String[] itemsReparto = {"Antipasto", "Primo", "Secondo", "Dolce", "Bibita"}; 
    
    /**
     * Costruttore parametrizzato di creazione della finestra per un nuovo ordine
     * @param h, riferimento della home
     * @param infoTavoloView, riferimento del tavolo a cui aggiungere l'ordine  
     */
    public AggiungiOrdineView(Home h, InfoTavoloView infoTavoloView){
        
        super("Aggiungi ordine");
        this.h = h;
        this.setInfoTavoloView(infoTavoloView);
        
        panelNorth = new JPanel() {
            /**
            * Serial Version UID.
            */
            private static final long serialVersionUID = -885433781594884857L;

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
        rootPanel = (JPanel) getContentPane();
        rootPanel.setLayout(new BorderLayout());
        
        rootPanel.add(panelNorth, BorderLayout.NORTH);
        rootPanel.add(panelCenter, BorderLayout.CENTER);
        
        panelNorth.add(labelElimina);
        
        panelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        panelNorth.setBackground(Color.YELLOW);
                
        //setto i label
        labelElimina.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 26));
        labelElimina.setForeground(Color.red);
        
        //setto i bottoni
        confermaButton.setFont(new Font("Courier New", Font.BOLD | Font.ITALIC, 36));
        confermaButton.setForeground(new Color(19, 74, 34));
        
        //setto la ComboBox dei reparti
        repartoBox = new JComboBox<String>();
        repartoBox.setFont(new Font("Courier New", Font.PLAIN, 26));
        
        for(var a : itemsReparto) {
            repartoBox.addItem(a);
        }
        
        panelNorth.add(repartoBox);
        
        setPietanze(h.getPietanze());
        
        /*
            aggiungo i JRadioButton delle pietanze del menu ordinabili alla finestra
            nei reparti corrispondenti
        */
        if(h.getPietanze().size() != 0) {
            for(int i = 0; i < h.getPietanze().size(); i++) {
                if(repartoBox.getSelectedIndex() == h.getPietanze().get(i).getReparto()) {
                    pietanzeButtonList.add(new JRadioButton(h.getPietanze().get(i).getNome()));
                    panelCenter.add(pietanzeButtonList.get(i));
                    pietanzeButtonList.get(i).setVisible(true);
                    pietanzeButtonList.get(i).setFont(new Font("Courier New", Font.PLAIN, 48));
                    buttonGroup.add(pietanzeButtonList.get(i));
                }else {
                    pietanzeButtonList.add(new JRadioButton(h.getPietanze().get(i).getNome()));
                    panelCenter.add(pietanzeButtonList.get(i));
                    pietanzeButtonList.get(i).setVisible(false);
                    pietanzeButtonList.get(i).setFont(new Font("Courier New", Font.PLAIN, 48));
                    buttonGroup.add(pietanzeButtonList.get(i));
                }    
            } 
        }
        
        repartoBox.addItemListener(new ItemListener(this));
            
        rootPanel.add(confermaButton, BorderLayout.SOUTH);
        
        confermaButton.addActionListener(new ConfermaAggiungiOrdine(h, pietanzeButtonList, this, infoTavoloView) );
        
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(h.getX() + (h.getWidth() / 2) - 150, h.getY() + (h.getHeight() / 2) - 100, 800, 550);
        setResizable(false);
    }

    /**
     * Metodo per aggiornare la view degli ordini
     */
    public void updateView() {
        if(h.getPietanze().size() != 0) {
            for(int i = 0; i < h.getPietanze().size(); i++) {
                if(repartoBox.getSelectedIndex() == h.getPietanze().get(i).getReparto()) {
                    pietanzeButtonList.get(i).setVisible(true);
                }else {
                    pietanzeButtonList.get(i).setVisible(false);
                }
            } 
        }
        revalidate();
        repaint();
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
	 * @return the infoTavoloView
	 */
	public InfoTavoloView getInfoTavoloView() {
		return infoTavoloView;
	}

	/**
	 * @param infoTavoloView the infoTavoloView to set
	 */
	public void setInfoTavoloView(InfoTavoloView infoTavoloView) {
		this.infoTavoloView = infoTavoloView;
	}

	/**
	 * @return the labelElimina
	 */
	public JLabel getLabelElimina() {
		return labelElimina;
	}

	/**
	 * @param labelElimina the labelElimina to set
	 */
	public void setLabelElimina(JLabel labelElimina) {
		this.labelElimina = labelElimina;
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
	 * @return the buttonGroup
	 */
	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	/**
	 * @param buttonGroup the buttonGroup to set
	 */
	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
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
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}

