package laskin.calculatorxtreme.sovelluslogiikka;

public class Jakolasku extends Laskutoimitus {
    
    public Jakolasku() {
        super(2);
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.laskettavatAsetettu() || super.getTakajasen().arvo() == 0) {
            throw new IllegalStateException();
        }
        
        return super.getEtujasen().arvo() / super.getTakajasen().arvo();
    }
    
    
}
