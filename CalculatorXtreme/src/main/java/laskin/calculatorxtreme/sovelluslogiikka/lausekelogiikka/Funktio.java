package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

/**
 * Abstrakti luokka, joka edustaa yhden muuttujan funktiota. Tarjoaa
 * toiminnallisuuden funktio argumentin asettamiseksi.
 */
public abstract class Funktio implements Arvollinen {
    
    /**
     * Funktion argumentti, eli milla muuttujan arvolla funktion arvoa
     * kysytaan.
     */
    private Arvollinen argumentti;
    
    public Funktio() {
        
    }
    
    public Arvollinen getArgumentti() {
        return argumentti;
    }
    
    public void setArgumentti(Arvollinen argumentti) {
        this.argumentti = argumentti;
    }
    
    /**
     * Palauttaa true, jos funktion argumentti on asetettu.
     * 
     * @return 
     */
    public boolean argumenttiAsetettu() {
        return argumentti != null;
    }
    
    @Override
    public abstract double arvo() throws IllegalStateException;
}
