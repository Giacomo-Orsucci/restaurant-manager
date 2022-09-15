
package View;

import java.io.FileNotFoundException;

/**
 * @author Beragnoli
 * @author Orsucci
 * Classe contenente il main
 */
public class Test {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        
        SplashScreenView s = new SplashScreenView();
        try {
            for(int i = 0; i < 100; i++) {
                s.getPercentuale().setText(Integer.toString(i) + "%");
                Thread.sleep(20);
            }
            s.dispose();
        }catch(InterruptedException ex) {
            
        }
        new LoginView();
    }
    
}
