package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class MiinusTehdas extends LaskutoimitusTehdas {
    
    public MiinusTehdas() {
        super("-");
    }

    @Override
    public Laskutoimitus luo() {
        return new Miinus();
    }
    
}
