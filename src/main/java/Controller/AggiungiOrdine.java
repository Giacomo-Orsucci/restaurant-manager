
package Controller;

import View.AggiungiOrdineView;
import View.Home;
import View.InfoTavoloView;
import java.awt.event.*;


/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di mostrare una finestra grafica per l'aggiunta dell'ordine una volta cliccato il pulsante.
*/
public class AggiungiOrdine implements ActionListener{
   
    private Home h;
    
    private InfoTavoloView infoTavoloView;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param infoTavoloView, riferimento della finestra del tavolo 
     */
    public AggiungiOrdine(Home h, InfoTavoloView infoTavoloView){   
    
        this.h = h;
        this.infoTavoloView = infoTavoloView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AggiungiOrdineView(h, infoTavoloView);
    }    
}
