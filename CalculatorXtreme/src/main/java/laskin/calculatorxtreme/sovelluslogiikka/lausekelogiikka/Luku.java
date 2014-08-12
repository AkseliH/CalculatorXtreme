package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

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
