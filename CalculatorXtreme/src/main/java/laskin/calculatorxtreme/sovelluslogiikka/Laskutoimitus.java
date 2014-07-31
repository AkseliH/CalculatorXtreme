package laskin.calculatorxtreme.sovelluslogiikka;

public abstract class Laskutoimitus implements Arvollinen {
    
    private Arvollinen etujasen;
    private Arvollinen takajasen;
    
    public Laskutoimitus() {
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
    
    @Override
    public abstract double arvo();
}
