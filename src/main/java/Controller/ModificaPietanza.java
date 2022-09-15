
package Controller;

import View.Home;
import View.ModificaPietanzaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di aprire la finestra grafica per modificare le pietanze.
*/
public class ModificaPietanza implements ActionListener {
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public ModificaPietanza(Home h) {
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new ModificaPietanzaView(h);
    }
}
