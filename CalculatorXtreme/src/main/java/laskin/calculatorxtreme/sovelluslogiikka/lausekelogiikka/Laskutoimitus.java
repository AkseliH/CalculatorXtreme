package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

/**
 * Abstrakti luokka, joka edustaa laskutoimitusta. Tarjoaa toiminnallisuuden
 * laskutoimituksen laskettavien asettamiseksi.
 */
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
    
    /**
     * Palauttaa true, jos laskutoimitukselle on asetettu laskettavat.
     * @return 
     */
    public boolean laskettavatAsetettu() {
       return etujasen != null && takajasen != null;
    }
    
    public int getPrioriteetti() {
        return prioriteetti;
    }
    
    @Override
    public abstract double arvo() throws IllegalStateException;
}
