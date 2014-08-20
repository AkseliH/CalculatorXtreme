package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

public class Kosinifunktio extends Funktio {

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.argumenttiAsetettu()) {
            throw new IllegalStateException();
        }
        
        return Math.cos(super.getArgumentti().arvo());
    }
    
    
}
