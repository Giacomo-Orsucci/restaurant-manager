
package Controller;

import Model.Tavolo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import View.*;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette l'aggiunta rapida di un tavolo.
*/
public class AggiungiTavoliRapido implements ActionListener {

    private JButton[] tavoliButton; //array di bottoni associato a quello di tavoli
    
    private Tavolo[] arrayTavoli; //array di tavoli
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param h, riferimento della home 
     */
    public AggiungiTavoliRapido(Home h) {
        this.h = h;
        arrayTavoli = h.getArrayTavoli();
        tavoliButton = h.getTavoliButton();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem b = (JMenuItem) e.getSource();
        //controllo se è stato raggiunto il numero massimo di tavoli
        if(h.getNumeroTavoli() == Tavolo.NUMERO_MASSIMO) {
            JOptionPane.showMessageDialog(null, "Impossibile aggiungere più di " + arrayTavoli.length + " Tavoli!");
        }else { //altrimenti
            int i = 0;
            /*
                creo il nuovo tavolo nella prima posizione libera nell'array di tavoli e 
                setto le sue caratteristiche
            */
            do{
                if(arrayTavoli[i] == null) {
                    arrayTavoli[i] = new Tavolo();
                    arrayTavoli[i].setId(Integer.toString(h.getNumeroTavoli() + 1));
                    arrayTavoli[i].setId(Integer.toString(h.getNumeroTavoli()));
                    if(b.getName().equalsIgnoreCase("DUE")) {
                        arrayTavoli[i].setNumeroPosti(2);
                        h.getTavoliEliminare()[i].setVisible(true);
                    }else if(b.getName().equalsIgnoreCase("QUATTRO")) {
                        arrayTavoli[i].setNumeroPosti(4);
                        tavoliButton[i].setPreferredSize(new Dimension(280, 80));
                        h.getTavoliEliminare()[i].setVisible(true);
                    }else if(b.getName().equalsIgnoreCase("SEI")) {
                        arrayTavoli[i].setNumeroPosti(6);
                        tavoliButton[i].setPreferredSize(new Dimension(320, 80));
                        h.getTavoliEliminare()[i].setVisible(true);
                    }else if(b.getName().equalsIgnoreCase("OTTO")) {
                        arrayTavoli[i].setNumeroPosti(8);
                        tavoliButton[i].setPreferredSize(new Dimension(380, 80));
                        h.getTavoliEliminare()[i].setVisible(true);
                    }
                    
                    tavoliButton[i].removeActionListener(h.getInfoTavoloActionListner().get(i));
                    h.getInfoTavoloActionListner().set(i, new InfoTavolo(h, arrayTavoli[i]));
                    tavoliButton[i].addActionListener(h.getInfoTavoloActionListner().get(i));

                    arrayTavoli[i].setId(Integer.toString(i + 1));
                    
                    tavoliButton[i].setVisible(true);
                    h.setNumeroTavoli(h.getNumeroTavoli() + 1);
                    h.aggiornaHome();
                    return;
                }
            }while(arrayTavoli[i++] != null && i != (arrayTavoli.length));

            if(b.getName().equalsIgnoreCase("DUE")) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(2);
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }else if(b.getName().equalsIgnoreCase("QUATTRO")) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(4);
                tavoliButton[h.getNumeroTavoli()].setPreferredSize(new Dimension(280, 80));
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }else if(b.getName().equalsIgnoreCase("SEI")) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(6);
                tavoliButton[h.getNumeroTavoli()].setPreferredSize(new Dimension(320, 80));
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }else if(b.getName().equalsIgnoreCase("OTTO")) {
                arrayTavoli[h.getNumeroTavoli()].setNumeroPosti(8);
                tavoliButton[h.getNumeroTavoli()].setPreferredSize(new Dimension(380, 80));
                h.getTavoliEliminare()[h.getNumeroTavoli()].setVisible(true);
            }
            
            arrayTavoli[h.getNumeroTavoli()].setId(Integer.toString(h.getNumeroTavoli() + 1));
            
            tavoliButton[h.getNumeroTavoli()].removeActionListener(h.getInfoTavoloActionListner().get(h.getNumeroTavoli()));
            h.getInfoTavoloActionListner().set(h.getNumeroTavoli(), new InfoTavolo(h, arrayTavoli[h.getNumeroTavoli()]));
            tavoliButton[h.getNumeroTavoli()].addActionListener(h.getInfoTavoloActionListner().get(h.getNumeroTavoli()));
            
            tavoliButton[h.getNumeroTavoli()].setVisible(true);
            h.setNumeroTavoli(h.getNumeroTavoli()+1);
            h.aggiornaHome();
        }
    }
}
