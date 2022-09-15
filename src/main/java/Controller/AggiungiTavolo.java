
package Controller;

import Model.Tavolo;
import View.AggiungiTavoloView;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di mostrare la finestra grafica dell' aggiunta "parametrizzata" di un tavolo una volta cliccato il pulsante.
*/
public class AggiungiTavolo implements ActionListener {
    
    private Home h;
    
    private Tavolo t;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param t, riferimento del tavolo da aggiungere 
     */
    public AggiungiTavolo(Home h, Tavolo t){
       this.h = h; 
       this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AggiungiTavoloView(h, t);
    }
}
