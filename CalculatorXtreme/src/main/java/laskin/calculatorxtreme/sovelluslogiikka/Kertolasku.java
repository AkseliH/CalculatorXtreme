package laskin.calculatorxtreme.sovelluslogiikka;

public class Kertolasku extends Laskutoimitus {
    
    public Kertolasku() {
        super(2);
    }    

    @Override
    public double arvo() throws IllegalStateException {
        if (!super.laskettavatAsetettu()) {
            throw new IllegalStateException();
        }
        
        return super.getEtujasen().arvo() * super.getTakajasen().arvo();
    }
    
}
