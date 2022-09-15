
package Controller;

import Model.*;
import View.AggiungiPietanzaView;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che aggiunge una pietanza una volta cliccato il pulsante.
*/
public class ConfermaAggiuntaPietanza implements ActionListener {
   
    private AggiungiPietanzaView aView;
    
    private Home h;
    
    private Pietanza p;
    
    private String nome;
    private String descrizione;
    
    private float prezzo;
    
    private int reparto;
    
    private boolean controllo = false;
    
    /**
     * Costruttore parametrizzato
     * @param aView, riferimento della view per l'aggiunta della pietanza
     * @param h, riferimento della home 
     */
    public ConfermaAggiuntaPietanza(AggiungiPietanzaView aView, Home h) {
        this.aView = aView;
        this.h = h;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            Controllo tutte le possibili eccezioni ed i possibili errori sull'inserimento
            delle caratteristiche e aggiungo la pietanza con le caratteristiche indicate
            al menu.
        */
        if(!controllo) {
            String itemsReparto = (String) aView.getRepartoBox().getSelectedItem();

            if(itemsReparto.equalsIgnoreCase(aView.getItemsReparto()[Pietanza.ANTIPASTO])) {
                this.reparto = Pietanza.ANTIPASTO;
                p = new Antipasto();
            }else if(itemsReparto.equalsIgnoreCase(aView.getItemsReparto()[Pietanza.PRIMO_PIATTO])) {
                this.reparto = Pietanza.PRIMO_PIATTO;
                p = new PrimoPiatto();
            }else if(itemsReparto.equalsIgnoreCase(aView.getItemsReparto()[Pietanza.SECONDO_PIATTO])) {
                this.reparto = Pietanza.SECONDO_PIATTO;
                p = new SecondoPiatto();
            }else if(itemsReparto.equalsIgnoreCase(aView.getItemsReparto()[Pietanza.DOLCE])) {
                this.reparto = Pietanza.DOLCE;
                p = new Dolce();
            }else if(itemsReparto.equalsIgnoreCase(aView.getItemsReparto()[Pietanza.BIBITA])) {
                this.reparto = Pietanza.BIBITA;
                p = new Bibita();
            }
            
            nome = aView.getNomeTF().getText();
            String prezzoStringa = null;
            do {
                if(aView.getPrezzoTF().getText().isEmpty() || aView.getPrezzoTF().getText().isBlank()) {
                    prezzoStringa = JOptionPane.showInputDialog(null, "Per favore inserire un prezzo!", "Nessun prezzo inserito!", JOptionPane.QUESTION_MESSAGE);
                    try {
                        this.prezzo = Float.parseFloat(prezzoStringa);
                        controllo = false;
                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Per favore inserire un numero nella casella del prezzo.", 
                                            "ERRORE! Impossibile convertire il prezzo!", JOptionPane.ERROR_MESSAGE);
                        controllo = true;
                    }
                }else {
                    try {
                        prezzoStringa = aView.getPrezzoTF().getText();
                        this.prezzo = Float.parseFloat(prezzoStringa);
                        controllo = false;
                    }catch(NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Per favore inserire un numero nella casella del prezzo.", 
                                            "ERRORE! Impossibile convertire il prezzo!", JOptionPane.ERROR_MESSAGE);
                        controllo = true;
                    }
                }
            }while(prezzoStringa.isEmpty() || aView.getPrezzoTF().getText().isBlank() && controllo);
            
            if(nome.isBlank() || nome.isEmpty()) {
                do {
                    nome = JOptionPane.showInputDialog(null, "Inserire un nome!", "Nessun nome inserito!", JOptionPane.QUESTION_MESSAGE);
                }while(nome.isBlank() || nome.isEmpty());
            }
            
            descrizione = aView.getDescrizioneTF().getText();
            
            p.setCosto(prezzo);
            p.setDescrizione(descrizione);
            p.setNome(nome);
            p.setReparto(reparto);
            h.getPietanze().add(p);
        }
        
        h.aggiornaHome();
        aView.dispose();
    }
}
