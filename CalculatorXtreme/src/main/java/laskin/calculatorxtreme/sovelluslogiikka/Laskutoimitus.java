package laskin.calculatorxtreme.sovelluslogiikka;

public abstract class Laskutoimitus implements Arvollinen {
    
    private Arvollinen etujasen;
    private Arvollinen takajasen;
    private int prioriteetti;
    
    public Laskutoimitus(int prioriteetti) {
        this.prioriteetti = prioriteetti;
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
    
    @Override
    public abstract double arvo() throws IllegalStateException;
}
