package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Plus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Potenssi;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Miinus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Kertolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Jakolasku;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

/**
 * Tehdasluokka, joka tarjoaa toiminnallisuuden oikeiden laskutoimitusolioiden
 * luomiseksi String tyyppisen tunnisteen perusteella.
 */
public class LaskutoimitusTehdas {
    
    /**
     * Paluttaa tunnusta vastaavan laskutoimituksen. Jos tallaista ei ole
     * palauttaa null.
     * 
     * @param tunnus Tunnus, jolla haetaan.
     * @return Tunnusta vastaava laskutoimitus.
     */
    public Laskutoimitus hae(String tunnus) {
        if (tunnus.equals("+")) { return new Plus(); }
        if (tunnus.equals("-")) { return new Miinus(); }
        if (tunnus.equals("*")) { return new Kertolasku(); }
        if (tunnus.equals("/")) { return new Jakolasku(); }
        if (tunnus.equals("'")) { return new Potenssi(); }
         
        return null;
    }
}
