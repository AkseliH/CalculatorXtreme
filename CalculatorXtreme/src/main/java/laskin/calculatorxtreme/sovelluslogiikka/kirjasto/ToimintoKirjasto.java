package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;


public class ToimintoKirjasto {
    
    private LaskutoimitusTehdas laskutoimitukset;
    private FunktioTehdas funktiot;
    
    
    public ToimintoKirjasto() {
        this.laskutoimitukset = new LaskutoimitusTehdas();
        this.funktiot = new FunktioTehdas();
    }
    
    public Laskutoimitus haeLaskutoimitus(String tunnus) {
        return laskutoimitukset.hae(tunnus);
    }
    
    public Funktio haeFunktio(String tunnus) {
        return funktiot.hae(tunnus);
    }
}
