package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Sinifunktio;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Kosinifunktio;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

/**
 * Tehdasluokka, joka tarjoaa toiminnallisuuden oikeiden funktio-olioiden
 * luomiseksi String tyyppisen tunnisteen perusteella.
 */
public class FunktioTehdas {
    
    /**
     * Palauttaa tunnusta vastaavan funktion. Jos tallaista ei ole 
     * palauttaa null.
     * 
     * @param tunnus Tunnus, jolla haetaan.
     * @return Tunnusta vastaava funktio.
     */
    public Funktio hae(String tunnus) {
        if (tunnus.equals("sin")) { return new Sinifunktio(); }
        if (tunnus.equals("cos")) { return new Kosinifunktio(); }
        
        return null;
    }
}
