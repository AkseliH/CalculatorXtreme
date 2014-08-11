package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class KertolaskuTehdas extends LaskutoimitusTehdas {

    public KertolaskuTehdas() {
        super("*");
    } 
    
    @Override
    public Laskutoimitus luo() {
        return new Kertolasku();
    }
    
}
