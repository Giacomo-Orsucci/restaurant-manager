
package Controller;

import View.AggiungiOrdineView;
import java.awt.event.ItemEvent;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di modificare la view dei piatti ordinabili ogni volta che viene cambiata la JComboBox dei reparti.
*/
public class ItemListener implements java.awt.event.ItemListener {
    
    private AggiungiOrdineView aView;
    
    /**
     * Costruttore parametrizzato
     * @param aView, riferimento della view per l'aggiunta degli ordini 
     */
    public ItemListener(AggiungiOrdineView aView) {
        this.aView = aView;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        aView.updateView();
    }
}
