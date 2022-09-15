
package Controller;

import View.*;
import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.*;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di caricare i tavoli da file binario una volta cliccato il JMenuItem corrispondente.
*/
public class CaricaTavoli implements ActionListener {
   
    private static final String fileTavoli = "tavoli.dat";
    private static final String fileVisibile = "bottoniTavoli.dat";
    
    private FileInputStream inputTavoli;
    private FileInputStream inputBottoniTavoli;
    
    private ObjectInputStream objectInputTavoli;
    private ObjectInputStream objectInputBottoniTavoli;
    
    private Tavolo[] arrayTavoli = new Tavolo[Tavolo.NUMERO_MASSIMO]; //array di tavoli da caricare
    private boolean[] visibile = new boolean[Tavolo.NUMERO_MASSIMO]; //array di booleani con la visibilità dei tavoli da caricare
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public CaricaTavoli(Home h){
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
       try{
            inputTavoli = new FileInputStream(fileTavoli);
            objectInputTavoli = new ObjectInputStream(inputTavoli);
            
            inputBottoniTavoli = new FileInputStream(fileVisibile);
            objectInputBottoniTavoli = new ObjectInputStream(inputBottoniTavoli);
        }catch(IOException IOe){
            JOptionPane.showMessageDialog(null, "Errore durante l'apertura del file di salvataggio", "Errore sulla lettura dei tavoli salvati", JOptionPane.ERROR_MESSAGE);
        }
        try {  
            arrayTavoli = (Tavolo[]) objectInputTavoli.readObject();
            visibile = (boolean[]) objectInputBottoniTavoli.readObject();
            
            inputTavoli.close();
            objectInputTavoli.close();
            
            h.caricaTavoli(arrayTavoli, visibile);
            h.aggiornaHome();
            JOptionPane.showMessageDialog(null, "Tavoli caricati correttamente!", "Caricati!", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Errore durante il caricamento dei tavoli", "Errore durante il caricamento", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
    
}
