
package Controller;

import View.EliminaTavoloView;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che elimina uno o più tavoli una volta cliccato il pulsante.
*/
public class ConfermaEliminaTavolo implements ActionListener{
    private Home h;
    
    private JRadioButton[] radioButtonArray; 
    
    private EliminaTavoloView eliminaTavolo;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param radioButtonArray, array di JRadioButton per l'eliminazione dei tavoli
     * @param eliminaTavolo, riferimento della view per l'eliminazione dei tavoli 
     */
    public ConfermaEliminaTavolo(Home h, JRadioButton[] radioButtonArray, EliminaTavoloView eliminaTavolo) {
        this.h = h;
        this.radioButtonArray = radioButtonArray;
        this.eliminaTavolo = eliminaTavolo;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            Controllo quali tavoli sono stati selezionati per essere eliminati e li elimino
        */
        int t = 0;
        for(int i = 0; i < radioButtonArray.length; i++) {
            if(radioButtonArray[i] != null) {
                if(radioButtonArray[i].isSelected()) {
                    h.getArrayTavoli()[i] = null;
                    h.getTavoliButton()[i].setVisible(false);
                    h.setNumeroTavoli(h.getNumeroTavoli() - 1);
                    radioButtonArray[i] = null;
                    h.getOrdiniTavoli()[i].clear();
                    h.getTavoliEliminare()[i].setVisible(false);
                /*
                    Controllo se sono stati creati dei tavoli vedendo se i JRadioButton dell'eliminazione
                    corrispondenti sono a true. Tutte le volte che sono a false incremento il contatore.
                */
                }else if(!radioButtonArray[i].isVisible()) { 
                    t++;
                }
            }else {
                t++;
            }
        }
        
        /*
            se sono arrivato con un valore del contatore pari a quello dell'array
            vuol dire che sono stati creati tavoli e che quindi non è possibile
            nemmeno eliminarli
        */
        if(t == radioButtonArray.length) {
            JOptionPane.showMessageDialog(null, "<html>Nessun tavolo presente!<br> Aggiungi un tavolo utilizzando il pulsante <i>AGGIUNGI</html>",
                                            "Errore! Nessun tavolo presente!", JOptionPane.ERROR_MESSAGE);
        }
        
        eliminaTavolo.dispose();
        h.aggiornaHome();
    }
}
