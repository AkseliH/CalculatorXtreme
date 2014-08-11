package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public abstract class LaskutoimitusTehdas {
    
    private String tunnus;
    
    public LaskutoimitusTehdas(String tunnus) {
        this.tunnus = tunnus;
    }
    
    public String getTunnus() {
        return tunnus;
    }
    
    public abstract Laskutoimitus luo();
}
