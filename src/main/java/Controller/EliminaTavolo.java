
package Controller;

import View.EliminaTavoloView;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di mostrare la finestra grafica per eliminare i tavoli una volta cliccato il pulsante.
*/
public class EliminaTavolo implements ActionListener {
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public EliminaTavolo (Home h){
        this.h = h;   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        new EliminaTavoloView(h);
    }
}
