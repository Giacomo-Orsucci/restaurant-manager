
package Controller;

import Model.Tavolo;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che mostra la finestra grafica una volta cliccato il pulsante.
*/
public class InfoTavolo implements ActionListener {

    private Home h;
    
    private Tavolo t;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param t, riferimento del tavolo interessato 
     */
    public InfoTavolo(Home h, Tavolo t) {
        this.h = h;
        this.t = t;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        int n = Integer.parseInt(b.getName());
        new InfoTavoloView(n, h, t);
    } 
}
