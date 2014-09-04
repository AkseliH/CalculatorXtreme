package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

/**
 * Tarjoaa toiminnallisuuden ohjelman tarjoamien toimintojen hakemiseksi
 * String tyyppisen tunnisteen perusteella. Kokoaa eri tehdasluokkien
 * palvelut yhden luokan alle.
 */
public class ToimintoKirjasto {
    
    /**
     * Tehdas, jolta haetaan laskutoimitukset.
     */
    private LaskutoimitusTehdas laskutoimitukset;
    
    /**
     * Tehdas, jolta haetaan funktiot.
     */
    private FunktioTehdas funktiot;
    
    
    public ToimintoKirjasto() {
        this.laskutoimitukset = new LaskutoimitusTehdas();
        this.funktiot = new FunktioTehdas();
    }
    
    /**
     * Palauttaa tunnusta vastaavan laskutoimituksen. Jos tallaista ei ole
     * palautetaan null.
     * @param tunnus Tunnus, jolla haetaan.
     * @return Tunnusta vastaava laskutoimitus.
     */
    public Laskutoimitus haeLaskutoimitus(String tunnus) {
        return laskutoimitukset.hae(tunnus);
    }
    
    /**
     * Palauttaa tunnusta vastaavan funktion. Jos tallaista ei ole
     * palautetaan null.
     * @param tunnus Tunnus, jolla haetaan.
     * @return Tunnusta vastaava funktio.
     */
    public Funktio haeFunktio(String tunnus) {
        return funktiot.hae(tunnus);
    }
}
