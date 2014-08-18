package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class PotenssiTehdas extends LaskutoimitusTehdas {
    
    public PotenssiTehdas() {
        super("'");
    }

    @Override
    public Laskutoimitus luo() {
        return new Potenssi();
    }
}
