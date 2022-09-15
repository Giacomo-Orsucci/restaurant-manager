
package Controller;

import Model.Ordine;
import Model.Pietanza;
import View.*;
import java.awt.HeadlessException;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JRadioButton;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di aggiungere un ordine ad un tavolo una volta premuto il pulsante corrispondente.
*/
public class ConfermaAggiungiOrdine implements ActionListener {
    
    
    private Home h;
    
    private  InfoTavoloView infoTavoloView;
    
    private ArrayList <JRadioButton> pietanzeListButton;
    private ArrayList <Pietanza> pietanzeList;
    private ArrayList <JPanel> ordiniList;
    
    private AggiungiOrdineView aggiungiOrdineView;
    private String quantitàString;
    
    private boolean eccezione = false;
    
    private int quantitàInt;
    
    private float prezzoFloat;
    private float importoFloat;
    
    private JLabel quantitàLabel;
    private JLabel descrizioneLabel;
    private JLabel prezzoLabel;
    private JLabel importoLabel;
    private JLabel[] infoPiattoArray = new JLabel[4];
    
    private JRadioButton pulsanteSelezionato;
    
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param pietanzeListButton, lista di JRadioButton del menu
     * @param aggiungiOrdineView, riferimento della view per l'aggiunta degli ordini
     * @param infoTavoloView, riferimento della view delle info del tavolo 
     */
    public ConfermaAggiungiOrdine(Home h, ArrayList<JRadioButton> pietanzeListButton, AggiungiOrdineView aggiungiOrdineView, InfoTavoloView infoTavoloView) {
        this.h = h;
        this.pietanzeListButton = pietanzeListButton;
        this.aggiungiOrdineView = aggiungiOrdineView;
        this.infoTavoloView = infoTavoloView;
    }
    
    @Override
    public void actionPerformed(ActionEvent aE) {
        pietanzeList = h.getPietanze();
        ordiniList = infoTavoloView.getOrdiniList();
        
        int controllo = 0;
        
        /*
            controllo se è stata selezionata qualche pietanza da aggiungere agli ordini
            e gestisco tutte le eccezioni e gli errori sugli input che possono essere generati.
        */
        
        for(int i = 0; i < pietanzeListButton.size(); i++) {
            if(pietanzeListButton.get(i).isSelected()) {
                break;
            }else {
                controllo++;
            }
        }
        
        if(controllo == pietanzeListButton.size()) {
            JOptionPane.showMessageDialog(null, "Nessuna pietanza selezionata!");
            return;
        }
        
        if(h.getPietanze().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Nessuna pietanza presente!<br> Aggiungi una pietanza utilizzando il pulsante <i>AGGIUNGI</html>",
                                            "Errore! Nessuna pietanza presente!", JOptionPane.ERROR_MESSAGE);
        }else {
            try {
                quantitàString = JOptionPane.showInputDialog("Inserisci la quantità");
                quantitàInt = Integer.parseInt(quantitàString);  
            }catch(HeadlessException | NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Inserire una quantità maggiore di 0",
                                            "Errore sulla conversione", JOptionPane.ERROR_MESSAGE); 
                eccezione = true;
            }   
            
            if(quantitàInt <= 0 && eccezione == false) {
            JOptionPane.showMessageDialog(null, "Inserire una quantità maggiore di 0",
                                            "Inserire i dati correttamente", JOptionPane.ERROR_MESSAGE);    
            }else if (quantitàInt > 0 && eccezione == false) {
                quantitàLabel = new JLabel(quantitàString);
                
                for(int i = 0; i < pietanzeListButton.size(); i++) {
                    if(pietanzeListButton.get(i).isSelected()) {
                        descrizioneLabel = new JLabel(pietanzeListButton.get(i).getText());
                        pulsanteSelezionato = pietanzeListButton.get(i);
                    }
                }
       
                /*
                    confronto il nome del pulsante selezionato per l'ordine
                    con i nomi delle pietanze del menu per ricavarmi le altre
                    informazioni oltre al nome.
                */
                for(int i = 0; i < pietanzeList.size(); i++) {    
                    if(pietanzeList.get(i).getNome().equalsIgnoreCase(pulsanteSelezionato.getText())){      
                        prezzoFloat = pietanzeList.get(i).getCosto(); 
                        prezzoLabel = new JLabel(String.valueOf(prezzoFloat));
                        h.getOrdiniTavoli()[infoTavoloView.getNumeroTavolo()].add(new Ordine(quantitàInt, pietanzeList.get(i)));
                    }
                }        
                importoFloat = prezzoFloat * quantitàInt;
                importoLabel = new JLabel(String.valueOf(importoFloat));
                
                //preparo l'array di JPanel che verrà stampato negli ordini del tavolo
                infoPiattoArray[0] = quantitàLabel;
                infoPiattoArray[1] = descrizioneLabel;
                infoPiattoArray[2] = prezzoLabel;
                infoPiattoArray[3] = importoLabel;
                
                /*
                    aggiorno la view delle info del tavolo (e quindi anche gli ordini)
                    con gli ordini aggiunti
                */
                infoTavoloView.updateInfoTavoloView(infoPiattoArray);
            }
        }
        aggiungiOrdineView.dispose();
        eccezione = false;
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
	 * @return the pietanzeListButton
	 */
	public ArrayList<JRadioButton> getPietanzeListButton() {
		return pietanzeListButton;
	}

	/**
	 * @param pietanzeListButton the pietanzeListButton to set
	 */
	public void setPietanzeListButton(ArrayList<JRadioButton> pietanzeListButton) {
		this.pietanzeListButton = pietanzeListButton;
	}

	/**
	 * @return the pietanzeList
	 */
	public ArrayList<Pietanza> getPietanzeList() {
		return pietanzeList;
	}

	/**
	 * @param pietanzeList the pietanzeList to set
	 */
	public void setPietanzeList(ArrayList<Pietanza> pietanzeList) {
		this.pietanzeList = pietanzeList;
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
	 * @return the aggiungiOrdineView
	 */
	public AggiungiOrdineView getAggiungiOrdineView() {
		return aggiungiOrdineView;
	}

	/**
	 * @param aggiungiOrdineView the aggiungiOrdineView to set
	 */
	public void setAggiungiOrdineView(AggiungiOrdineView aggiungiOrdineView) {
		this.aggiungiOrdineView = aggiungiOrdineView;
	}

	/**
	 * @return the quantitàString
	 */
	public String getQuantitàString() {
		return quantitàString;
	}

	/**
	 * @param quantitàString the quantitàString to set
	 */
	public void setQuantitàString(String quantitàString) {
		this.quantitàString = quantitàString;
	}

	/**
	 * @return the eccezione
	 */
	public boolean isEccezione() {
		return eccezione;
	}

	/**
	 * @param eccezione the eccezione to set
	 */
	public void setEccezione(boolean eccezione) {
		this.eccezione = eccezione;
	}

	/**
	 * @return the quantitàInt
	 */
	public int getQuantitàInt() {
		return quantitàInt;
	}

	/**
	 * @param quantitàInt the quantitàInt to set
	 */
	public void setQuantitàInt(int quantitàInt) {
		this.quantitàInt = quantitàInt;
	}

	/**
	 * @return the prezzoFloat
	 */
	public float getPrezzoFloat() {
		return prezzoFloat;
	}

	/**
	 * @param prezzoFloat the prezzoFloat to set
	 */
	public void setPrezzoFloat(float prezzoFloat) {
		this.prezzoFloat = prezzoFloat;
	}

	/**
	 * @return the importoFloat
	 */
	public float getImportoFloat() {
		return importoFloat;
	}

	/**
	 * @param importoFloat the importoFloat to set
	 */
	public void setImportoFloat(float importoFloat) {
		this.importoFloat = importoFloat;
	}

	/**
	 * @return the quantitàLabel
	 */
	public JLabel getQuantitàLabel() {
		return quantitàLabel;
	}

	/**
	 * @param quantitàLabel the quantitàLabel to set
	 */
	public void setQuantitàLabel(JLabel quantitàLabel) {
		this.quantitàLabel = quantitàLabel;
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
	 * @return the importoLabel
	 */
	public JLabel getImportoLabel() {
		return importoLabel;
	}

	/**
	 * @param importoLabel the importoLabel to set
	 */
	public void setImportoLabel(JLabel importoLabel) {
		this.importoLabel = importoLabel;
	}

	/**
	 * @return the infoPiattoArray
	 */
	public JLabel[] getInfoPiattoArray() {
		return infoPiattoArray;
	}

	/**
	 * @param infoPiattoArray the infoPiattoArray to set
	 */
	public void setInfoPiattoArray(JLabel[] infoPiattoArray) {
		this.infoPiattoArray = infoPiattoArray;
	}

	/**
	 * @return the pulsanteSelezionato
	 */
	public JRadioButton getPulsanteSelezionato() {
		return pulsanteSelezionato;
	}

	/**
	 * @param pulsanteSelezionato the pulsanteSelezionato to set
	 */
	public void setPulsanteSelezionato(JRadioButton pulsanteSelezionato) {
		this.pulsanteSelezionato = pulsanteSelezionato;
	}
}
