package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

/**
 * Rakentaa suoritettavan rakenteen laskutoimituksista. 
 * Luokalle annetaan laskutoimituksia ja arvollisia niiden 
 * luonnollisessa jarjestyksessa. Arvoksi maaraytyy lausekkeen arvo
 * laskettaessa ensimmaisesta viimeiseen.
 */
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
        return viimeinen == null;
    }
    
    /**
     * Palauttaa tiedon siita, etta jono ei sisalla laskutoimituksia
     * ja muisti on tyhja.
     * 
     * @return 
     */
    public boolean onTyhja() {
        return eiSisallaLaskutoimituksia() && seuraavaArvollinen == null;
    }
    
    public Laskutoimitus getViimeinen() {
        return viimeinen;
    }
    
    public Arvollinen getSeuraavaArvollinen() {
        return seuraavaArvollinen;
    }
    
    /**
     * Lisaa jonoon ensimmaisen laskutoimituksen.
     * 
     * @param ensimmainen Lisattava laskutoimitus.
     * @throws IllegalArgumentException Lisattava ei saa olla null.
     * @throws IllegalStateException  Ensimmaista ei voida lisata, jos 
     * ensin ei ole lisatty arvollista.
     */
    public void asetaEnsimmainen(Laskutoimitus ensimmainen) throws IllegalArgumentException, IllegalStateException {
        if (ensimmainen == null) {
            throw new IllegalArgumentException();
        }
        
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        this.viimeinen = ensimmainen;
        viimeinen.setEtujasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
    }
    
    /**
     * Lisaa jonoon laskutoimituksen linkittaen laskutoimitukset oikein.
     * 
     * @param lisattava Lisattava laskutoimitus.
     * @throws IllegalArgumentException Lisattava ei saa olla null.
     * @throws IllegalStateException Laskutoimitusta ei voida lisata, jos 
     * edellisen laskutoimituksen jalkeen ei ole lisatty arvollista.
     */
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
    
    /**
     * Lisaa jonon muistiin arvollisen.
     * 
     * @param arvollinen Lisattava arvollinen.
     * @throws IllegalArgumentException Lisattava ei saa olla null.
     * @throws IllegalStateException Muistin tulee olla tyhja ennen lisaysta.
     */
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
    
    /**
     * Asettaa viimeiselle laskutoimitukselle takajasenen ellei jono
     * ole tyhja. Kutsun jalkeen jonon metodia arvo voidaan kutsua. Kutsun
     * jalkeen jonon tilaa muuttavia metodeja ei tule kutsua.
     * 
     * @throws IllegalStateException Muistissa taytyy olla arvollinen.
     */
    public void paataJono() throws IllegalStateException {
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        if (this.eiSisallaLaskutoimituksia()) {
            return;
        }
        
        viimeinen.setTakajasen(seuraavaArvollinen);
        seuraavaArvollinen = null;
    }

    /**
     * Palauttaa jonon arvon. Ennen metodin kayttoa metodia paataJono()
     * tulee olla kutsuttu kerran.
     * 
     * @return Jonon arvo laskettaessa laskutoimitukset ensimmaisesta viimeiseen.
     * @throws IllegalStateException Tyhjan jonon arvoa ei voida kutsua.
     */
    @Override
    public double arvo() throws IllegalStateException {
        if (onTyhja()) {
            throw new IllegalStateException();
        }
        
        if (this.eiSisallaLaskutoimituksia()) {
            return seuraavaArvollinen.arvo();
        }
        
        return viimeinen.arvo();
    }
}
