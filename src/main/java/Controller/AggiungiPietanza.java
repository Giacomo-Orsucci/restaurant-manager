
package Controller;

import View.*;
import java.awt.event.*;


/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di mostrare una finestra grafica per l'aggiunta di una pietanza una volta cliccato il pulsante.
*/
public class AggiungiPietanza implements ActionListener {
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public AggiungiPietanza(Home h) {
        
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        new AggiungiPietanzaView(h);
    }
}
