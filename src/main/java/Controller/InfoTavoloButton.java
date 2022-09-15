
package Controller;

import Model.Tavolo;
import View.AggiungiTavoloView;
import View.InfoTavoloView;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di modificare gli attributi di un tavolo.
*/
public class InfoTavoloButton implements ActionListener{
    
    private InfoTavoloView infoTavolo;
    
    private Tavolo t;
    
    /**
     * Costruttore parametrizzato
     * @param infoTavolo, riferimento della view con le info del tavolo
     * @param t, riferimento del tavolo interessato 
     */
    public InfoTavoloButton(InfoTavoloView infoTavolo, Tavolo t) {
        this.infoTavolo = infoTavolo;
        this.t = t;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        /*
            Modifico il tavolo con le nuove caratteristiche scelte
        */
        JButton origine = (JButton) e.getSource();
        
        if(origine.getText().equalsIgnoreCase("Conferma")) {   
            
            String nome;
            
            nome = infoTavolo.getModificaNumeroTavoloTF().getText();
            
            while(nome.isBlank() || nome.isEmpty()){
                nome = JOptionPane.showInputDialog(null, "Inserire un nome", "Nessun nome inserito!", JOptionPane.QUESTION_MESSAGE);
            }
            
            t.setId(nome);
            
            if(infoTavolo.getDuePersone().isSelected()) {
                t.setNumeroPosti(2);
            }
            else if(infoTavolo.getQuattroPersone().isSelected()) {
                t.setNumeroPosti(4); 
            }
            else if(infoTavolo.getSeiPersone().isSelected()) {
                t.setNumeroPosti(6); 
            }
            else {
                t.setNumeroPosti(8); 
            } 
            
            if(infoTavolo.getLibero().isSelected()){
                t.setStato(Tavolo.LIBERO);
            }
            else if(infoTavolo.getOccupato().isSelected()){
                t.setStato(Tavolo.OCCUPATO);
            }
            else if(infoTavolo.getInAttCon().isSelected()){
                t.setStato(Tavolo.ATTESA_CONTO);
            }
            else {
                t.setStato(Tavolo.ATTESA_PAGAMENTO);
            }
            
            infoTavolo.setTitle("Informazioni e modifica tavolo: " + t.getId());
            infoTavolo.getH().aggiornaHome();
        }
    }
	/**
	 * @return the infoTavolo
	 */
	public InfoTavoloView getInfoTavolo() {
		return infoTavolo;
	}
	/**
	 * @param infoTavolo the infoTavolo to set
	 */
	public void setInfoTavolo(InfoTavoloView infoTavolo) {
		this.infoTavolo = infoTavolo;
	}
	
	/**
	 * @return the t
	 */
	public Tavolo getT() {
		return t;
	}
	/**
	 * @param t the t to set
	 */
	public void setT(Tavolo t) {
		this.t = t;
	}   
}
