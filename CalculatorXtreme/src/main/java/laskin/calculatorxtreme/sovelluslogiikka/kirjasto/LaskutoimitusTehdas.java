package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class LaskutoimitusTehdas {
    
    public Laskutoimitus hae(String tunnus) {
        if (tunnus.equals("+")) { return new Plus(); }
        if (tunnus.equals("-")) { return new Miinus(); }
        if (tunnus.equals("*")) { return new Kertolasku(); }
        if (tunnus.equals("/")) { return new Jakolasku(); }
        if (tunnus.equals("'")) { return new Potenssi(); }
         
        return null;
    }
}
