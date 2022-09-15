
package Controller;

import Model.Pietanza;
import View.Home;
import View.ModificaPietanzaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che modifica la pietanza uan volta cliccato il pulsante corrispondente.
*/
public class ConfermaModificaPietanza implements ActionListener {
    private Home h;
    
    private ModificaPietanzaView mPV;
    
    private String nuovoNome;
    private String nuovaDescrizione;
    
    private float nuovoPrezzo;
    private int nuovoReparto;
    
    private boolean controllo = false;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home
     * @param mPV, riferimento della view per la modifica delle pietanze 
     */
    public ConfermaModificaPietanza(Home h, ModificaPietanzaView mPV) {
        this.h = h;
        this.mPV = mPV;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            Controllo tutte le possibili eccezioni e gli errori sull'inserimento dei dati
            e modifico la pietanza selezionata come indicato.
        */
        if(mPV.getPietanze().isEmpty()) {
            JOptionPane.showMessageDialog(null, "<html>Nessuna pietanza presente!<br> Aggiungi una pietanza utilizzando il pulsante <i>AGGIUNGI</html>",
                                            "Errore! Nessuna pietanza presente!", JOptionPane.ERROR_MESSAGE);
            mPV.dispose();
            return;
        }
        nuovoNome = mPV.getNuovoNomeTF().getText();
        String prezzoStringa = null;
        
        do {
            if(mPV.getNuovoPrezzoTF().getText().isEmpty() || mPV.getNuovoPrezzoTF().getText().isBlank()) {
                prezzoStringa = JOptionPane.showInputDialog(null, "Per favore inserire un prezzo!", "Nessun prezzo inserito!", JOptionPane.QUESTION_MESSAGE);
            try {
                this.nuovoPrezzo = Float.parseFloat(prezzoStringa);
                controllo = false;
                }catch(NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Per favore inserire un numero nella casella del prezzo.", 
                                            "ERRORE! Impossibile convertire il prezzo!", JOptionPane.ERROR_MESSAGE);
                    controllo = true;
                }
            }else {
                try {
                    prezzoStringa = mPV.getNuovoPrezzoTF().getText();
                    this.nuovoPrezzo = Float.parseFloat(prezzoStringa);
                    controllo = false;
                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Per favore inserire un numero nella casella del prezzo.", 
                                            "ERRORE! Impossibile convertire il prezzo!", JOptionPane.ERROR_MESSAGE);
                    controllo = true;
                    }
                }
            }while(prezzoStringa.isEmpty() || mPV.getNuovoPrezzoTF().getText().isBlank() && controllo);
            
            if(nuovoNome.isBlank() || nuovoNome.isEmpty()) {
                do {
                    nuovoNome = JOptionPane.showInputDialog(null, "Inserire un nome!", "Nessun nome inserito!", JOptionPane.QUESTION_MESSAGE);
                }while(nuovoNome.isBlank() || nuovoNome.isEmpty());
            }
        
        nuovoReparto = (int) mPV.getRepartoBox().getSelectedIndex();
        
        String nomePietanza = (String) mPV.getPietanzeComboBox().getSelectedItem();
        
        /*
            Questo for deve esser stato trasformato in questa forma automaticamente
            dall'IDE, ma non fa altro che scorrere la lista della pietanza (il menu)
            e settare le caratteristiche modificate della pietanza interessata.
        */
        for (Iterator<Pietanza> it = mPV.getPietanze().iterator(); it.hasNext();) {
            Model.Pietanza a = it.next();
            if(nomePietanza.equalsIgnoreCase(a.getNome())) {
                a.setNome(nuovoNome);
                a.setCosto(nuovoPrezzo);
                a.setDescrizione(nuovaDescrizione);
                a.setReparto(nuovoReparto);
            }
            mPV.dispose();
            h.aggiornaHome();
        }
    }
}
