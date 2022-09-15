
package Controller;

import View.Home;
import View.InfoTavoloView;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette la stampa dello scontrino tramite stampante e tramite file.
*/
public class StampaScontrino implements ActionListener {
    
    private InfoTavoloView infoTavoloView;
    
    private Home h;
    
    /**
     * Costruttore parametrizzato
     * @param infoTavoloView, riferimento della view con le info del tavolo
     * @param h, riferimento della home 
     */
    public StampaScontrino(InfoTavoloView infoTavoloView, Home h) {
        this.infoTavoloView = infoTavoloView;
        this.setH(h);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /*
            Si apre la finestra di stampa generica dove l'utente può decidere se stampare
            il JPanel con gli ordini in PDF o direttamente su stampante
        */
        PrinterJob pJob = PrinterJob.getPrinterJob();
        
        pJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
                if(pageIndex > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                    
                Graphics2D g2 = (Graphics2D) graphics;
                g2.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
                infoTavoloView.getPanelDestro().paint(g2);
                return Printable.PAGE_EXISTS;
            }
        });
        if(pJob.printDialog() == false) {
            return;
        }
        try {
            pJob.print();
        }catch(PrinterException ex) {
            
        }
    }
   
    /**
     * Getter della home
     * @return h, riferimento della home 
     */
    public Home getH() {
	return h;
    }

    /**
     * Setter della home
     * @param h, setta il riferimento della home 
     */
    public void setH(Home h) {
	this.h = h;
    }
}
