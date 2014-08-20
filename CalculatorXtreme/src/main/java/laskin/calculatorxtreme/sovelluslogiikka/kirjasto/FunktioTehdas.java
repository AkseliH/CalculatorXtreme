package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

public class FunktioTehdas {
    
    public Funktio hae(String tunnus) {
        if (tunnus.equals("sin")) { return new Sinifunktio(); }
        if (tunnus.equals("cos")) { return new Kosinifunktio(); }
        
        return null;
    }
}
