package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class Plus extends Laskutoimitus {
    
    public Plus() {
        super(1, true);
    }
    
    @Override
    public double arvo() throws IllegalStateException {        
        if (!super.laskettavatAsetettu()) {
            throw new IllegalStateException();
        }
        
        return super.getEtujasen().arvo() + super.getTakajasen().arvo();
    }
}
