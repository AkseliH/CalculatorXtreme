package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

public abstract class Laskutoimitus implements Arvollinen {
    
    private Arvollinen etujasen;
    private Arvollinen takajasen;
    private int prioriteetti;
    private boolean samaPrioriteettiVasemmaltaOikealle;
    
    public Laskutoimitus(int prioriteetti, boolean samaPrioriteettiVasemmaltaOikealle) {
        this.prioriteetti = prioriteetti;
        this.samaPrioriteettiVasemmaltaOikealle = samaPrioriteettiVasemmaltaOikealle;
    }
    
    public void setEtujasen(Arvollinen etujasen) {
        this.etujasen = etujasen;
    }
    
    public Arvollinen getEtujasen() {
        return etujasen;
    }
    
    public void setTakajasen(Arvollinen takajasen) {
        this.takajasen = takajasen;
    }
    
    public Arvollinen getTakajasen() {
        return takajasen;
    }
    
    public boolean laskettavatAsetettu() {
        if (etujasen == null || takajasen == null) {
            return false;
        }
        
        return true;
    }
    
    public int getPrioriteetti() {
        return prioriteetti;
    }
    
    public boolean samaPrioriteettiVasemmaltaOikealle() {
        return samaPrioriteettiVasemmaltaOikealle;
    }
    
    @Override
    public abstract double arvo() throws IllegalStateException;
}
