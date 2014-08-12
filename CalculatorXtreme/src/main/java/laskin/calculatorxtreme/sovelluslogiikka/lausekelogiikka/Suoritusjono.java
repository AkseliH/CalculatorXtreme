package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

public class Suoritusjono implements Arvollinen {
    
    private Laskutoimitus ensimmainen;
    private Laskutoimitus viimeinen;
    private Arvollinen seuraavaArvollinen;
    
    public Suoritusjono(Arvollinen ensimmainenArvollinen) {
        
        this.seuraavaArvollinen = ensimmainenArvollinen;
    }
    
    public Suoritusjono() {
        this(null);
    }
    
    public boolean onTyhja() {
        if (ensimmainen == null) {
            return true;
        }
        
        return false;
    }
    
    public Laskutoimitus getEnsimmainen() {
        return ensimmainen;
    }
    
    public Laskutoimitus getViimeinen() {
        return viimeinen;
    }
    
    public Arvollinen getSeuraavaArvollinen() {
        return seuraavaArvollinen;
    }
    
    public void asetaEnsimmainen(Laskutoimitus ensimmainen) throws IllegalArgumentException, IllegalStateException {
        if (ensimmainen == null) {
            throw new IllegalArgumentException();
        }
        
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        this.ensimmainen = ensimmainen;
        this.viimeinen = ensimmainen;
        ensimmainen.setEtujasen(seuraavaArvollinen);
    }
    
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) throws IllegalArgumentException, IllegalStateException {
        if (lisattava == null) {
            throw new IllegalArgumentException();
        }
        
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        if (this.onTyhja()) {
            this.asetaEnsimmainen(lisattava);
            return;
        }
        
        
        lisattava.setEtujasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
        
        viimeinen.setTakajasen(lisattava);
        viimeinen = lisattava;
    }
    
    public void lisaaSeuraavaArvollinen(Arvollinen arvollinen) throws IllegalArgumentException {
        if (arvollinen == null) {
            throw new IllegalArgumentException();
        }
        
        this.seuraavaArvollinen = arvollinen;
    }
    
    public void paataJono() throws IllegalStateException {
        if (this.onTyhja()) {
            return;
        }
        
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        viimeinen.setTakajasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
    }
    
    public int nykyinenPrioriteetti() {
        if (this.onTyhja()) {
            return 0;
        }
        
        return viimeinen.getPrioriteetti();
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (this.onTyhja() && seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        if (this.onTyhja()) {
            return seuraavaArvollinen.arvo();
        }
        
        return ensimmainen.arvo();
    }
}
