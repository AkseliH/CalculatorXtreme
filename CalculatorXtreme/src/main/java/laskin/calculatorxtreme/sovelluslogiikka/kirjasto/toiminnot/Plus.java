package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

/**
 * Yhteenlaskua vastaava laskutoimitus.
 */
public class Plus extends Laskutoimitus {
    
    public Plus() {
        super(1);
    }
    
    @Override
    public double arvo() throws IllegalStateException {        
        if (!super.laskettavatAsetettu()) {
            throw new IllegalStateException();
        }
        
        return super.getEtujasen().arvo() + super.getTakajasen().arvo();
    }
}
