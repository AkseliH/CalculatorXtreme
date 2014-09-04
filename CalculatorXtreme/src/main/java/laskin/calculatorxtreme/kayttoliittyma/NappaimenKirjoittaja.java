package laskin.calculatorxtreme.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tapahtumankuuntelija, joka lisaa syotekenttaan konstruktorin
 * parametrina annetun merkkijonon.
 */
public class NappaimenKirjoittaja implements ActionListener {
    
    private String syote;
    private JTextField syotekentta;
    
    public NappaimenKirjoittaja(String syote,JTextField syotekentta) {
        this.syote = syote;
        this.syotekentta = syotekentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String teksti = syotekentta.getText();
        teksti = teksti + syote;
        syotekentta.setText(teksti);
    }
    
    
}
