package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

public class Suoritusjono implements Arvollinen {
    
    private Laskutoimitus viimeinen;
    private Arvollinen seuraavaArvollinen;
    
    public Suoritusjono(Arvollinen ensimmainenArvollinen) {
        
        this.seuraavaArvollinen = ensimmainenArvollinen;
    }
    
    public Suoritusjono() {
        this(null);
    }
    
    public boolean eiSisallaLaskutoimituksia() {
        if (viimeinen == null) {
            return true;
        }
        
        return false;
    }
    
    public boolean onTyhja() {
        return eiSisallaLaskutoimituksia() && seuraavaArvollinen == null;
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
        
        this.viimeinen = ensimmainen;
        ensimmainen.setEtujasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
    }
    
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) throws IllegalArgumentException, IllegalStateException {
        if (lisattava == null) {
            throw new IllegalArgumentException();
        }
        
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        if (this.eiSisallaLaskutoimituksia()) {
            this.asetaEnsimmainen(lisattava);
            return;
        }
        
        viimeinen.setTakajasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
        lisattava.setEtujasen(viimeinen);        

        viimeinen = lisattava;
    }
    
    public void lisaaSeuraavaArvollinen(Arvollinen arvollinen) 
            throws IllegalArgumentException, IllegalStateException {
        if (arvollinen == null) {
            throw new IllegalArgumentException();
        }
        
        if (seuraavaArvollinen != null) {
            throw new IllegalStateException();
        }
        
        this.seuraavaArvollinen = arvollinen;
    }
    
    public void paataJono() throws IllegalStateException {
        if (this.eiSisallaLaskutoimituksia()) {
            return;
        }
        
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        viimeinen.setTakajasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
    }
    
    public int nykyinenPrioriteetti() {
        if (this.eiSisallaLaskutoimituksia()) {
            return 1;
        }
        
        return viimeinen.getPrioriteetti();
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (this.eiSisallaLaskutoimituksia() && seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        if (this.eiSisallaLaskutoimituksia()) {
            return seuraavaArvollinen.arvo();
        }
        
        return viimeinen.arvo();
    }
}
