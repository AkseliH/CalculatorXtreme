package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class JakolaskuTehdas extends LaskutoimitusTehdas {
    
    public JakolaskuTehdas() {
        super("/");
    }

    @Override
    public Laskutoimitus luo() {
        return new Jakolasku();
    }
}
