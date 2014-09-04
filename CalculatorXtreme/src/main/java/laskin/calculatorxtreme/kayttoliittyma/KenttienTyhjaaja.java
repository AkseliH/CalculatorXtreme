package laskin.calculatorxtreme.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * Tapahtumankuuntelija, joka tyhjentaa kentat.
 */
public class KenttienTyhjaaja implements ActionListener {
    
    private JTextField syotekentta;
    private JTextField tulostekentta;
    
    public KenttienTyhjaaja(JTextField syotekentta, JTextField tulostekentta) {
        this.syotekentta = syotekentta;
        this.tulostekentta = tulostekentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        syotekentta.setText("");
        tulostekentta.setText("");
    }
}
