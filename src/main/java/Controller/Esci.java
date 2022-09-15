
package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette l'uscita dal programma.
*/
public class Esci implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
