package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

/**
 * Kosinia vastaava funktio.
 */
public class Kosinifunktio extends Funktio {

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.argumenttiAsetettu()) {
            throw new IllegalStateException();
        }
        
        return Math.cos(super.getArgumentti().arvo());
    }
    
    
}
