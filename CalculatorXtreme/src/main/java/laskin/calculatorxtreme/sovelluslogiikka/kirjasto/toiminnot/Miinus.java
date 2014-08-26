package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

/**
 * Vahennyslaskua vastaava laskutoimitus.
 */
public class Miinus extends Laskutoimitus {
    
    public Miinus() {
        super(1);
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.laskettavatAsetettu()) {
            throw new IllegalStateException();
        }
        
        return super.getEtujasen().arvo() - super.getTakajasen().arvo();
    }
    
    
}
