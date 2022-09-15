
package Controller;

import View.EliminaPietanzaView;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di mostrare una finestra grafica per l'eliminazione delle pietanze.
*/
public class EliminaPietanza implements ActionListener {
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public EliminaPietanza(Home h) {
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new EliminaPietanzaView(h);
    }
}
