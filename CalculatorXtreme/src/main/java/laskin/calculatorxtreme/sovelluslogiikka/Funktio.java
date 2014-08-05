package laskin.calculatorxtreme.sovelluslogiikka;

public abstract class Funktio implements Arvollinen {
    
    private Arvollinen argumentti;
    
    public Funktio() {
        
    }
    
    public Arvollinen getArgumentti() {
        return argumentti;
    }
    
    public void setArgumentti(Arvollinen argumentti) {
        this.argumentti = argumentti;
    }
    
    public boolean argumenttiAsetettu() {
        if (argumentti == null) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public abstract double arvo();
}
