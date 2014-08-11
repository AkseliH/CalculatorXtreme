package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

public class Sinifunktio extends Funktio {
    
    public Sinifunktio() {
        super();
    }

    @Override
    public double arvo() {
        if (!super.argumenttiAsetettu()) {
            throw new IllegalStateException();
        }
        
        return Math.sin(super.getArgumentti().arvo());
    }
    
    
}
