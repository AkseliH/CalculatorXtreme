package laskin.calculatorxtreme.sovelluslogiikka;

public class Plus extends Laskutoimitus {
    
    public Plus() {
        super();
    }
    
    @Override
    public double arvo() {
        return super.getEtujasen().arvo() + super.getTakajasen().arvo();
    }
}
