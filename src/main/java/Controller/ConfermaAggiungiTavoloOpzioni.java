
package Controller;

import Model.Tavolo;
import View.AggiungiTavoloView;
import View.Home;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che aggiunge un tavolo una volta cliccato il pulsante.
*/
public class ConfermaAggiungiTavoloOpzioni implements ActionListener{
    
    private Home h;
    
    private AggiungiTavoloView aTV;
    
    private Tavolo arrayTavoli[];  
    
    private JButton tavoliButton[];
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param aTV, riferimento della view per l'aggiunta del tavolo 
     */
    public ConfermaAggiungiTavoloOpzioni(Home h, AggiungiTavoloView aTV){
        this.h = h;
        this.arrayTavoli = h.getArrayTavoli();
        this.tavoliButton = h.getTavoliButton();
        this.aTV = aTV;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //controllo se è stato raggiunto il numero massimo di tavoli consentiti
        if(h.getNumeroTavoli() == Tavolo.NUMERO_MASSIMO) {
            JOptionPane.showMessageDialog(null, "Impossibile aggiungere più di " + arrayTavoli.length + " Tavoli!");
        /*
            se non è stato raggiunto controllo tutte le possibili eccezioni e gli errori sull'inserimento
            dei dati del tavolo, lo creo e lo aggiungo nel primo posto libero dell'array di tavoli.
        */
        }else { 
            int i = 0;
            do{
                if(arrayTavoli[i] == null) {
                    arrayTavoli[i] = new Tavolo();
                    if(aTV.getModificaNumeroTavoloTF().getText().isBlank() || aTV.getModificaNumeroTavoloTF().getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "<html>Nessun nome inserito!<br>Inserire il nome</html>",
                                   "Nessun nome!", JOptionPane.ERROR_MESSAGE);
                        return;
                    }else {
                        arrayTavoli[i].setId(aTV.getModificaNumeroTavoloTF().getText()); 
                    }
                    
                    tavoliButton[i].setVisible(true);
                    
                    if(aTV.getDuePersone().isSelected()) {
                        arrayTavoli[i].setNumeroPosti(2);
                        h.getTavoliEliminare()[i].setVisible(true);
                    }else if(aTV.getQuattroPersone().isSelected()) {
                        arrayTavoli[i].setNumeroPosti(4);
                        tavoliButton[i].setPreferredSize(new Dimension(280, 80));
                        h.getTavoliEliminare()[i].setVisible(true);
                    }else if(aTV.getSeiPersone().isSelected()) {
                        arrayTavoli[i].setNumeroPosti(6);
                        tavoliButton[i].setPreferredSize(new Dimension(320, 80));
                        h.getTavoliEliminare()[i].setVisible(true);
                    }else if(aTV.getOttoPersone().isSelected()) {
                        arrayTavoli[i].setNumeroPosti(8);
                        tavoliButton[i].setPreferredSize(new Dimension(380, 80));
                        h.getTavoliEliminare()[i].setVisible(true);
                    }
                    
                    if(aTV.getLibero().isSelected()){
                        arrayTavoli[i].setStato(Tavolo.LIBERO);
                    }
                    else if(aTV.getOccupato().isSelected()){
                        arrayTavoli[i].setStato(Tavolo.OCCUPATO);
                    }
                    else if(aTV.getInAttCon().isSelected()){
                        arrayTavoli[i].setStato(Tavolo.ATTESA_CONTO);
                    }
                    else if(aTV.getInAttPag().isSelected()){
                        arrayTavoli[i].setStato(Tavolo.ATTESA_PAGAMENTO);
                    }
                    
                    h.setNumeroTavoli(h.getNumeroTavoli()+1);
                    h.aggiornaHome();
                    aTV.dispose();
                    return;
                }
            } while(arrayTavoli[i++] != null && i != (arrayTavoli.length));
            
            if(aTV.getModificaNumeroTavoloTF().getText().isBlank() || aTV.getModificaNumeroTavoloTF().getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "<html>Nessun nome inserito!<br>Inserire il nome</html>",
                                   "Nessun nome!", JOptionPane.ERROR_MESSAGE);
                return;
            }else {
                arrayTavoli[h.getNumeroTavoli()].setId(aTV.getModificaNumeroTavoloTF().getText()); 
            }
            
            tavoliButton[h.getNumeroTavoli()].setVisible(true);
            
            if(aTV.getDuePersone().isSelected()) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(2);
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }else if(aTV.getQuattroPersone().isSelected()) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(4);
                tavoliButton[h.getNumeroTavoli()].setPreferredSize(new Dimension(280, 80));
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }else if(aTV.getSeiPersone().isSelected()) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(6);
                tavoliButton[h.getNumeroTavoli()].setPreferredSize(new Dimension(320, 80));
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }else if(aTV.getOttoPersone().isSelected()) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(8);
                tavoliButton[h.getNumeroTavoli()].setPreferredSize(new Dimension(380, 80));
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }
            
            if(aTV.getLibero().isSelected()){
                arrayTavoli[h.getNumeroTavoli()].setStato(Tavolo.LIBERO);
            }
            else if(aTV.getOccupato().isSelected()){
                arrayTavoli[h.getNumeroTavoli()].setStato(Tavolo.OCCUPATO);
            }
            else if(aTV.getInAttCon().isSelected()){
                arrayTavoli[h.getNumeroTavoli()].setStato(Tavolo.ATTESA_CONTO);
            }
            else if(aTV.getInAttPag().isSelected()){
                arrayTavoli[h.getNumeroTavoli()].setStato(Tavolo.ATTESA_PAGAMENTO);
            }
            
            h.setNumeroTavoli(h.getNumeroTavoli() + 1);
            h.aggiornaHome();
        }
        
        aTV.dispose();
    }
}
