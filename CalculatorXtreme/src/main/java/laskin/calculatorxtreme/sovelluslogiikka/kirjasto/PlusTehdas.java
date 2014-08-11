package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class PlusTehdas extends LaskutoimitusTehdas {

    public PlusTehdas() {
        super("+");
    }
    
    @Override
    public Laskutoimitus luo() {
        return new Plus();
    }
    
}
