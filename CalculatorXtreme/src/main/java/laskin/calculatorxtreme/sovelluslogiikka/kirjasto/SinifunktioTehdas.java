package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

public class SinifunktioTehdas extends FunktioTehdas {

    public SinifunktioTehdas() {
        super("sin");
    }
    
    @Override
    public Funktio luo() {
        return new Sinifunktio();
    }
    
}
