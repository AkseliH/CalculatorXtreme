package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

/**
 * Sinia vastaava funktio.
 */
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
