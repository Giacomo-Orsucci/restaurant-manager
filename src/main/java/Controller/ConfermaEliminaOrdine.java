
package Controller;

import Model.Ordine;
import View.Home;
import View.InfoTavoloView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che elimina uno o più ordini una volta cliccato il pulsante.
*/
public class ConfermaEliminaOrdine implements ActionListener {
    
    private Home h;
    
    private InfoTavoloView infoTavolo;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param infoTavolo, rifermento del tavolo da cui eliminare l'ordine 
     */
    public ConfermaEliminaOrdine(Home h, InfoTavoloView infoTavolo) {
        this.h = h;
        this.infoTavolo = infoTavolo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*
            controllo quali checkbox per la cancellazione sono state selezionate
            ed elimino le righe degli ordini corrispondenti
        */
        switch(JOptionPane.showConfirmDialog(null, "Sei sicuro di voler eliminare le pietanze selezionate?", "Conferma elimina ordinazioni", JOptionPane.OK_OPTION)) {
            case JOptionPane.OK_OPTION:
                ArrayList<Ordine> ordiniAppoggio = new ArrayList<>();
                for(int i = 0; i < infoTavolo.getCheckBox().size(); i++) {
                    if(!infoTavolo.getCheckBox().get(i).isSelected()) {
                        ordiniAppoggio.add((Ordine) h.getOrdiniTavoli()[infoTavolo.getNumeroTavolo()].get(i));
                    }else {
                        infoTavolo.setNumeroPiatti(infoTavolo.getNumeroPiatti() - 1);
                    }
                }
                h.getOrdiniTavoli()[infoTavolo.getNumeroTavolo()].clear();
                h.getOrdiniTavoli()[infoTavolo.getNumeroTavolo()] = ordiniAppoggio;
                break;
            case JOptionPane.NO_OPTION:
            default:
        }
        //chiudo e riapro la visualizzazione degli ordini con i nuovi ordini rimasti
        infoTavolo.dispose();
        infoTavolo = new InfoTavoloView(infoTavolo.getNumeroTavolo(), h, infoTavolo.getTavolo());
    }
}
