
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di caricare le pietanze da file binario una volta cliccato il JMenuItem corrispondente.
*/
public class CaricaPietanze implements ActionListener {

    private String filePietanze = "pietanze.dat";
    
    private FileInputStream input;
    
    private ObjectInputStream objectInput;
    
    private ArrayList <Pietanza> listaPietanze; //menù, lista delle pietanze da caricare
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public CaricaPietanze(Home h){
        this.h = h;
    }
    
    @SuppressWarnings("unchecked")
	@Override
    public void actionPerformed(ActionEvent ae) {
       try{
            input = new FileInputStream(filePietanze);
            objectInput = new ObjectInputStream(input);
        }catch(IOException IOe){
            JOptionPane.showMessageDialog(null, "Errore durante l'apertura del file di salvataggio", "Errore sulla lettura delle pietanze salvate", JOptionPane.ERROR_MESSAGE);
        }
        try {
            
            listaPietanze = (ArrayList < Pietanza >) objectInput.readObject();
            h.setPietanze(listaPietanze);
            input.close();
            objectInput.close();
            JOptionPane.showMessageDialog(null, "Pietanze caricate correttamente!", "Caricate!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento delle pietanze", "Errore durante il caricamento", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}

