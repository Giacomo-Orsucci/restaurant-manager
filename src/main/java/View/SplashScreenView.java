
package View;

import java.awt.Font;
import java.awt.*;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Finestra grafica che emula il caricamento.
 */
public class SplashScreenView extends JFrame {
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = -6499526635091645146L;

    /* JPANEL */
    private JPanel panel = new JPanel(new GridLayout(3, 1));
    
    /* JLABEL */
    private JLabel splashScreen = new JLabel("CARICAMENTO GESTIONALE RISTORANTE");
    private JLabel autori = new JLabel("di Beragnoli - Orsucci");
    private JLabel percentuale = new JLabel("0%");
    
    /**
     * Costruttore di Default di SplashScreenView. Contiene l'inizializzazione dei componenti grafici.
     */
    public SplashScreenView() {
        super();
        panel.setBackground(Color.DARK_GRAY);
        
        /* IMPOSTAZIONE COLORI */
        splashScreen.setForeground(Color.WHITE);
        autori.setForeground(Color.WHITE);
        percentuale.setForeground(Color.WHITE);
        
        /* AGGIUNTA AL PANEL */
        getContentPane().add(panel);
        panel.add(splashScreen);
        panel.add(autori);
        panel.add(percentuale);
        
        /* ALLINEAMENTO AL CENTRO */
        splashScreen.setHorizontalAlignment(JLabel.CENTER);
        percentuale.setHorizontalAlignment(JLabel.CENTER);
        autori.setHorizontalAlignment(JLabel.CENTER);
        
        /* AUTORI */
        autori.setFont(new Font("Geo Sans Light", Font.PLAIN, 24));
        splashScreen.setFont(new Font("Geo Sans Light", Font.PLAIN, 32));
        percentuale.setFont(new Font("Geo Sans Light", Font.PLAIN, 38));
        
        /* INIZIALIZZAZIONE FRAME */
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(true);
        setVisible(true);
        setBounds(400, 300, 800, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        centeredFrame(this);
    }
    
    /**
     * 
     * @param objFrame 
     * Permette di centrare il Frame (SplashScreenView) al centro della finestra.
     */
    private void centeredFrame(javax.swing.JFrame objFrame){
        Dimension objDimension = Toolkit.getDefaultToolkit().getScreenSize();
        
        int iCoordX = (objDimension.width - objFrame.getWidth()) / 2;
        int iCoordY = (objDimension.height - objFrame.getHeight()) / 2;
        
        objFrame.setLocation(iCoordX, iCoordY); 
    }

	/**
	 * @return the panel
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * @param panel the panel to set
	 */
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	/**
	 * @return the splashScreen
	 */
	public JLabel getSplashScreen() {
		return splashScreen;
	}

	/**
	 * @param splashScreen the splashScreen to set
	 */
	public void setSplashScreen(JLabel splashScreen) {
		this.splashScreen = splashScreen;
	}

	/**
	 * @return the autori
	 */
	public JLabel getAutori() {
		return autori;
	}

	/**
	 * @param autori the autori to set
	 */
	public void setAutori(JLabel autori) {
		this.autori = autori;
	}

	/**
	 * @return the percentuale
	 */
	public JLabel getPercentuale() {
		return percentuale;
	}

	/**
	 * @param percentuale the percentuale to set
	 */
	public void setPercentuale(JLabel percentuale) {
		this.percentuale = percentuale;
	}
}
