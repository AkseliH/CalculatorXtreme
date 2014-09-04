package laskin.calculatorxtreme.kayttoliittyma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely.MerkkijononKasittelija;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;

/**
 * Tapahtumankuuntelija, joka laskee syotekentassa olevan lausekkeen arvon
 * ja tulostaa tuloksen tulostekenttaan.
 */
public class LausekkeenLaskija implements ActionListener {
    
    private JTextField syotekentta;
    private JTextField tulostekentta;
    private ToimintoKirjasto kirjasto;
    
    public LausekkeenLaskija(JTextField syotekentta, JTextField tulostekentta, 
            ToimintoKirjasto kirjasto) {
        this.syotekentta = syotekentta;
        this.tulostekentta = tulostekentta;
        this.kirjasto = kirjasto;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MerkkijononKasittelija kasittelija 
                = new MerkkijononKasittelija(syotekentta.getText(), kirjasto);
        
        try {
            kasittelija.kasitteleLauseke();
            tulostekentta.setText("" + kasittelija.arvo());
        } catch (IllegalStateException virhe) {
            tulostekentta.setText("Virheellinen lauseke.");
        } catch (IllegalArgumentException virhe) {
            tulostekentta.setText("Virheellinen lauseke.");
        }
    }
    
}
