package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Arvollinen;

public class Luku implements Arvollinen {
    
    private double arvo;
    
    public Luku(double arvo) {
        this.arvo = arvo;
    }
    
    @Override
    public double arvo() {
        return arvo;
    }
}
