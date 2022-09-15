
package Controller;

import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che elimina la pietanza selezionata (una sola) una volta cliccato il pulsante.
*/
public class ConfermaEliminaPietanza implements ActionListener {
    private Home h;
    
    private ArrayList<JRadioButton> pietanzeList;
    
    private EliminaPietanzaView elimView;

    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param pietanzeList, lista delle pietanza sul menu
     * @param elimView, riferimento della finestra per l'eliminazione di una pietanza dal menu 
     */
    public ConfermaEliminaPietanza(Home h, ArrayList<JRadioButton> pietanzeList, EliminaPietanzaView elimView) {
        this.h = h;
        this.pietanzeList = pietanzeList;
        this.elimView = elimView;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(h.getPietanze().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Nessuna pietanza presente!<br> Aggiungi una pietanza utilizzando il pulsante <i>AGGIUNGI</html>",
                                            "Errore! Nessuna pietanza presente!", JOptionPane.ERROR_MESSAGE);
        }
        
        //guardo quale pietanza è stata selezionata e la elimino
        for(int i = 0; i < h.getPietanze().size(); i++) {
            if(pietanzeList.get(i) != null) {
                if(pietanzeList.get(i).isSelected()) {
                    h.getPietanze().remove(i);
                    pietanzeList.remove(i);
                }
            }
        }
        elimView.dispose();
    }
}
