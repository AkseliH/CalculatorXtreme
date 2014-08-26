package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

/**
 * Potenssiin korotusta vastaava laskutoimitus.
 */
public class Potenssi extends Laskutoimitus {
    
    public Potenssi() {
        super(3);
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.laskettavatAsetettu()) {
            throw new IllegalStateException();
        }
        
        return Math.pow(super.getEtujasen().arvo(), super.getTakajasen().arvo());
    }
}
