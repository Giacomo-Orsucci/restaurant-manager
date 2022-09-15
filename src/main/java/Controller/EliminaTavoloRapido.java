
package Controller;

import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di eliminare rapidamente i tavoli.
*/
public class EliminaTavoloRapido implements ActionListener {
    private int i;
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param i, indice del tavolo da eliminare
     * @param h, riferimento della home 
     */
    public EliminaTavoloRapido(int i, Home h) {
        this.i = i;
        this.h = h;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            Elimino il tavolo cancellando tutti i suoi componenti e quelli annessi
            come il tavolo stesso, il JMenuItem corrispondente per l'eliminazione rapida etc...
        */
        JMenuItem source = (JMenuItem) e.getSource();
        source.setVisible(false);
        h.getTavoliButton()[i].setVisible(false);
        h.getArrayTavoli()[i] = null;
        h.setNumeroTavoli(h.getNumeroTavoli() - 1);
        h.getTavoliEliminare()[i].setVisible(false);
        h.aggiornaHome();
    }
}
