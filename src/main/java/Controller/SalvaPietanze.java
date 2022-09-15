
package Controller;

import View.*;
import Model.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette il salvataggio delle pietanze in un file binario.
*/
public class SalvaPietanze implements ActionListener {

    private String filePietanze = "pietanze.dat";
    
    private FileOutputStream outPut;
    
    private ObjectOutputStream objectOutput;
    
    private ArrayList <Pietanza> listaPietanze;
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home. 
     */
    public SalvaPietanze (Home h){
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
      
       listaPietanze = h.getPietanze();
       try{
            outPut = new FileOutputStream(new File(filePietanze));
            objectOutput = new ObjectOutputStream(outPut);
        }catch(IOException IOe){
            JOptionPane.showMessageDialog(null, "Errore durante la creazione del file di salvataggio", "Errore sul file di salvataggio delle pietanze", JOptionPane.ERROR_MESSAGE);
        }
        try {
            objectOutput.writeObject(listaPietanze);
            objectOutput.close();
            outPut.close();
            JOptionPane.showMessageDialog(null, "Pietanze salvate correttamente!", "Salvate!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore durante il salvataggio delle pietanze", "Errore durante il salvataggio", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

	/**
	 * @return the filePietanze
	 */
	public String getFilePietanze() {
		return filePietanze;
	}

	/**
	 * @param filePietanze the filePietanze to set
	 */
	public void setFilePietanze(String filePietanze) {
		this.filePietanze = filePietanze;
	}

	/**
	 * @return the outPut
	 */
	public FileOutputStream getOutPut() {
		return outPut;
	}

	/**
	 * @param outPut the outPut to set
	 */
	public void setOutPut(FileOutputStream outPut) {
		this.outPut = outPut;
	}

	/**
	 * @return the objectOutput
	 */
	public ObjectOutputStream getObjectOutput() {
		return objectOutput;
	}

	/**
	 * @param objectOutput the objectOutput to set
	 */
	public void setObjectOutput(ObjectOutputStream objectOutput) {
		this.objectOutput = objectOutput;
	}

	/**
	 * @return the listaPietanze
	 */
	public ArrayList<Pietanza> getListaPietanze() {
		return listaPietanze;
	}

	/**
	 * @param listaPietanze the listaPietanze to set
	 */
	public void setListaPietanze(ArrayList<Pietanza> listaPietanze) {
		this.listaPietanze = listaPietanze;
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
}
