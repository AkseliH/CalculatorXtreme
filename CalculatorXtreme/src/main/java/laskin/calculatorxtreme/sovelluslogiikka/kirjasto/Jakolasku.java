package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class Jakolasku extends Laskutoimitus {
    
    public Jakolasku() {
        super(2, true);
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.laskettavatAsetettu() || super.getTakajasen().arvo() == 0) {
            throw new IllegalStateException();
        }
        
        return super.getEtujasen().arvo() / super.getTakajasen().arvo();
    }
    
    
}
