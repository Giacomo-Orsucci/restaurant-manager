
package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette il salvataggio dei tavoli in un file binario.
*/
public class SalvaTavoli implements ActionListener{

    private String fileTavoli = "tavoli.dat";
    private String fileBottoniTavoli = "bottoniTavoli.dat";
    
    private FileOutputStream outPutTavoli;
    private FileOutputStream outPutVisibile;
    
    private ObjectOutputStream objectOutputTavoli;
    private ObjectOutputStream objectOutputVisibile;
    
    private Tavolo[] arrayTavoli = new Tavolo[Tavolo.NUMERO_MASSIMO];
    private JButton[] arrayBottoniTavoli = new JButton[Tavolo.NUMERO_MASSIMO];
    private JMenuItem[] arrayTavoliEliminare = new JMenuItem[Tavolo.NUMERO_MASSIMO];
    
    private Home h;
    
    private boolean[] visibile = new boolean[Tavolo.NUMERO_MASSIMO];
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public SalvaTavoli (Home h){
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       arrayTavoliEliminare = h.getTavoliEliminare();
       arrayTavoli = h.getArrayTavoli();
       arrayBottoniTavoli = h.getTavoliButton();
       
        for(int i = 0; i < Tavolo.NUMERO_MASSIMO; i++) {
            visibile[i] = arrayBottoniTavoli[i].isVisible();
            if(!visibile[i]) {
                arrayTavoli[i] = null;
            }
        }
       
       try{
            outPutTavoli = new FileOutputStream(new File(fileTavoli));
            objectOutputTavoli = new ObjectOutputStream(outPutTavoli);
            
            outPutVisibile = new FileOutputStream(new File(fileBottoniTavoli));
            objectOutputVisibile = new ObjectOutputStream(outPutVisibile);
        }catch(IOException IOe){
            JOptionPane.showMessageDialog(null, "Errore durante la creazione del file di salvataggio ", "Errore sul file di salvataggio dei tavoli", JOptionPane.ERROR_MESSAGE);
        }
        try {
            objectOutputTavoli.writeObject(arrayTavoli);
            objectOutputVisibile.writeObject(visibile);
            
            System.out.println("Salvati");
            objectOutputTavoli.close();
            objectOutputVisibile.close();
            outPutTavoli.close();
            outPutVisibile.close();
            JOptionPane.showMessageDialog(null, "Tavoli salvati correttamente!", "Salvati!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore durante il salvataggio dei tavoli", "Errore durante il salvataggio", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

	/**
	 * @return the fileTavoli
	 */
	public String getFileTavoli() {
		return fileTavoli;
	}

	/**
	 * @param fileTavoli the fileTavoli to set
	 */
	public void setFileTavoli(String fileTavoli) {
		this.fileTavoli = fileTavoli;
	}

	/**
	 * @return the fileBottoniTavoli
	 */
	public String getFileBottoniTavoli() {
		return fileBottoniTavoli;
	}

	/**
	 * @param fileBottoniTavoli the fileBottoniTavoli to set
	 */
	public void setFileBottoniTavoli(String fileBottoniTavoli) {
		this.fileBottoniTavoli = fileBottoniTavoli;
	}

	/**
	 * @return the outPutTavoli
	 */
	public FileOutputStream getOutPutTavoli() {
		return outPutTavoli;
	}

	/**
	 * @param outPutTavoli the outPutTavoli to set
	 */
	public void setOutPutTavoli(FileOutputStream outPutTavoli) {
		this.outPutTavoli = outPutTavoli;
	}

	/**
	 * @return the outPutVisibile
	 */
	public FileOutputStream getOutPutVisibile() {
		return outPutVisibile;
	}

	/**
	 * @param outPutVisibile the outPutVisibile to set
	 */
	public void setOutPutVisibile(FileOutputStream outPutVisibile) {
		this.outPutVisibile = outPutVisibile;
	}

	/**
	 * @return the objectOutputTavoli
	 */
	public ObjectOutputStream getObjectOutputTavoli() {
		return objectOutputTavoli;
	}

	/**
	 * @param objectOutputTavoli the objectOutputTavoli to set
	 */
	public void setObjectOutputTavoli(ObjectOutputStream objectOutputTavoli) {
		this.objectOutputTavoli = objectOutputTavoli;
	}

	/**
	 * @return the objectOutputVisibile
	 */
	public ObjectOutputStream getObjectOutputVisibile() {
		return objectOutputVisibile;
	}

	/**
	 * @param objectOutputVisibile the objectOutputVisibile to set
	 */
	public void setObjectOutputVisibile(ObjectOutputStream objectOutputVisibile) {
		this.objectOutputVisibile = objectOutputVisibile;
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
	 * @return the arrayBottoniTavoli
	 */
	public JButton[] getArrayBottoniTavoli() {
		return arrayBottoniTavoli;
	}

	/**
	 * @param arrayBottoniTavoli the arrayBottoniTavoli to set
	 */
	public void setArrayBottoniTavoli(JButton[] arrayBottoniTavoli) {
		this.arrayBottoniTavoli = arrayBottoniTavoli;
	}

	/**
	 * @return the arrayTavoliEliminare
	 */
	public JMenuItem[] getArrayTavoliEliminare() {
		return arrayTavoliEliminare;
	}

	/**
	 * @param arrayTavoliEliminare the arrayTavoliEliminare to set
	 */
	public void setArrayTavoliEliminare(JMenuItem[] arrayTavoliEliminare) {
		this.arrayTavoliEliminare = arrayTavoliEliminare;
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
	 * @return the visibile
	 */
	public boolean[] getVisibile() {
		return visibile;
	}

	/**
	 * @param visibile the visibile to set
	 */
	public void setVisibile(boolean[] visibile) {
		this.visibile = visibile;
	}
}
