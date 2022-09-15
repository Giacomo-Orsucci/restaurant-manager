
package View;

import Controller.LogIn;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Beragnoli
 * @author Orsucci
 * Classe che permette la creazione di una finestra grafica per il LogIn.
 */
public class LoginView extends JFrame {
    /**
    * Serial Version UID.
    */
    private static final long serialVersionUID = 6727596786385882432L;
    private JPanel panel = new JPanel(new BorderLayout());
    private JPanel panelCentro = new JPanel(new GridLayout(2, 1));
    private JPanel panelCentroUsername = new JPanel(new FlowLayout());
    private JPanel panelCentroPassword = new JPanel(new FlowLayout());
    
    private JLabel topLabel = new JLabel("LogIn - Gestionale Ristorante");
    private JLabel splashScreen = new JLabel("Caricamento");
    private JLabel percentuale = new JLabel("0%");
    private JLabel usernameLabel = new JLabel("Username: ");
    private JLabel passwordLabel = new JLabel("Password: ");
    
    private JTextField username = new JTextField();
    private JPasswordField password = new JPasswordField();
    
    private JButton entra = new JButton("LOGIN");
    
    /**
     * Costruttore di default della classe LoginView. Contiene l'inizializzazione dei componenti grafici.
     */
    public LoginView() {
        super("LOGIN - Gestionale Ristorante");
        
        Font font = new Font("Geo Sans Light", Font.PLAIN, 18);
        
        getContentPane().add(panel);
        panel.add(topLabel, BorderLayout.NORTH);
        panel.add(panelCentro, BorderLayout.CENTER);
        panelCentro.add(panelCentroUsername);
        panelCentro.add(panelCentroPassword);
        panel.add(entra, BorderLayout.SOUTH);
        
        panelCentroUsername.add(usernameLabel);
        panelCentroUsername.add(username);
        panelCentroPassword.add(passwordLabel);
        panelCentroPassword.add(password);
        
        username.setPreferredSize(new Dimension(400, 33));
        password.setPreferredSize(new Dimension(400, 33));
        
        entra.setPreferredSize(new Dimension(this.getWidth(), 65));
        
        topLabel.setFont(font);
        topLabel.setHorizontalAlignment(JLabel.CENTER);
        entra.setFont(font);
        usernameLabel.setFont(font);
        username.setFont(font);
        passwordLabel.setFont(font);
        password.setFont(font);
        
        entra.addActionListener(new LogIn(this));
        entra.setMnemonic(KeyEvent.VK_ENTER);
        
        setVisible(true);
        setBounds(400, 300, 600, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        centeredFrame(this);
    }
    
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
	 * @return the panelCentro
	 */
	public JPanel getPanelCentro() {
		return panelCentro;
	}

	/**
	 * @param panelCentro the panelCentro to set
	 */
	public void setPanelCentro(JPanel panelCentro) {
		this.panelCentro = panelCentro;
	}

	/**
	 * @return the panelCentroUsername
	 */
	public JPanel getPanelCentroUsername() {
		return panelCentroUsername;
	}

	/**
	 * @param panelCentroUsername the panelCentroUsername to set
	 */
	public void setPanelCentroUsername(JPanel panelCentroUsername) {
		this.panelCentroUsername = panelCentroUsername;
	}

	/**
	 * @return the panelCentroPassword
	 */
	public JPanel getPanelCentroPassword() {
		return panelCentroPassword;
	}

	/**
	 * @param panelCentroPassword the panelCentroPassword to set
	 */
	public void setPanelCentroPassword(JPanel panelCentroPassword) {
		this.panelCentroPassword = panelCentroPassword;
	}

	/**
	 * @return the topLabel
	 */
	public JLabel getTopLabel() {
		return topLabel;
	}

	/**
	 * @param topLabel the topLabel to set
	 */
	public void setTopLabel(JLabel topLabel) {
		this.topLabel = topLabel;
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

	/**
	 * @return the usernameLabel
	 */
	public JLabel getUsernameLabel() {
		return usernameLabel;
	}

	/**
	 * @param usernameLabel the usernameLabel to set
	 */
	public void setUsernameLabel(JLabel usernameLabel) {
		this.usernameLabel = usernameLabel;
	}

	/**
	 * @return the passwordLabel
	 */
	public JLabel getPasswordLabel() {
		return passwordLabel;
	}

	/**
	 * @param passwordLabel the passwordLabel to set
	 */
	public void setPasswordLabel(JLabel passwordLabel) {
		this.passwordLabel = passwordLabel;
	}

	/**
	 * @return the username
	 */
	public JTextField getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(JTextField username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public JPasswordField getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(JPasswordField password) {
		this.password = password;
	}

	/**
	 * @return the entra
	 */
	public JButton getEntra() {
		return entra;
	}

	/**
	 * @param entra the entra to set
	 */
	public void setEntra(JButton entra) {
		this.entra = entra;
	}
}
