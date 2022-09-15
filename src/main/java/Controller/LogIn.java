
package Controller;

import View.Home;
import View.LoginView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
*
* @author Beragnoli
* @author Orsucci
* Classe che permette di aprire la Classe Home una volta effettuato il LogIn.
*/
public class LogIn implements ActionListener {
    
    private LoginView logView;
    
    /**
     * Costruttore parametrizzato
     * @param logView, riferimento della view del login 
     */
    public LogIn(LoginView logView) {
        this.logView = logView;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //controllo che vengana inserite le credenziali giuste
        char[] pass = {'a', 'd', 'm', 'i', 'n'};
        
        if(logView.getUsername().getText().equalsIgnoreCase("admin")) {
            if(Arrays.equals(logView.getPassword().getPassword(), pass)) {
                logView.dispose();
                new Home();
            }else {
                JOptionPane.showMessageDialog(null, "Username o password errati!");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Username o password errati!");
        }
    }
}
