package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

public abstract class FunktioTehdas {
    
    private String tunnus;
    
    public FunktioTehdas(String tunnus) {
        this.tunnus = tunnus;
    }
    
    public String getTunnus() {
        return tunnus;
    }
    
    public abstract Funktio luo();
}
