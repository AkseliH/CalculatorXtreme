package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

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
