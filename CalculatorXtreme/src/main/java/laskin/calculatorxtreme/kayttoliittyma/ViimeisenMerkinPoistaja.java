package laskin.calculatorxtreme.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tapahtumankuuntelija, joka poistaa syotekentan viimeisen merkin.
 */
public class ViimeisenMerkinPoistaja implements ActionListener {
    
    private JTextField syotekentta;
    
    public ViimeisenMerkinPoistaja(JTextField syotekentta) {
        this.syotekentta = syotekentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String teksti = syotekentta.getText();
        
        if (!teksti.isEmpty()) {
            teksti = teksti.substring(0, teksti.length() - 1);
            syotekentta.setText(teksti);
        } 
    }
}
