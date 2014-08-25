package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;

/**
 * Tarjoaa toiminnallisuuden String tyyppisen lausekkeen muuntamiseksi
 * suoritettavaan muotoon.
 */
public class MerkkijononKasittelija {
    
    private String syote;
    private ToimintoKirjasto kirjasto;
    private Lauseke lauseke;
    private int paikka;
    
    public MerkkijononKasittelija(String syote, ToimintoKirjasto kirjasto) {
        this.lauseke = new Lauseke();
        this.syote = syote;
        this.kirjasto = kirjasto;
        this.paikka = 0;
    }
    
    public MerkkijononKasittelija(ToimintoKirjasto kirjasto) {
        this(null, kirjasto);
    }
    
    public void setSyote(String syote) {
        this.syote = syote;
    }
    
    /**
     * Kasittelee syotteesta seuraavan elementin lukien kutsuhetken
     * paikasta.
     * 
     * @throws IllegalStateException
     * @throws IllegalArgumentException 
     */
    private void kasitteleSeuraava() 
            throws IllegalStateException, IllegalArgumentException {
        if (seuraavanaLuku()) {
            kasitteleLuku();            
        } else if (seuraavanaLaskutoimitus()){
            kasitteleLaskutoimitus();            
        } else if (seuraavanaFunktio()) {
            kasitteleFunktio();            
        } else if (syote.substring(paikka, paikka + 1).equals("(")) {
            lauseke.avaaUusiLohko();
            paikka++;
        } else if (syote.substring(paikka, paikka + 1).equals(")")) {
            lauseke.suljeLohko();
            paikka++;
        } else {
            throw new IllegalStateException();
        }
    }
    
    /**
     * Tarkistaa onko seuraava elementti luku lukien kutsuhetken 
     * paikasta.
     * 
     * @return 
     */
    private boolean seuraavanaLuku() {
        if (syote.substring(paikka, paikka + 1).matches("[0-9|.]")) {
            return true;
        }
        
        if (syote.substring(paikka, paikka + 1).equals("-") 
                && lauseke.nykyinenLohko().onTyhja()) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa onko seuraava elementti laskutoimitus lukien kutsuhetken 
     * paikasta.
     * 
     * @return 
     */
    private boolean seuraavanaLaskutoimitus() {        
        if (syote.substring(paikka, paikka + 1).equals("-")) {
            return true;
        }
        
        return syote.substring(paikka, paikka + 1).matches("[+|*|/|']");
    }
    
    /**
     * Tarkistaa onko seuraava elementti funktio lukien kutsuhetken 
     * paikasta.
     * 
     * @return 
     */
    private boolean seuraavanaFunktio() {
        return syote.substring(paikka, paikka + 1).matches("[a-z]");
    }
    
    /**
     * Lukee syotteen elementti kerrallaan rakentaen suoritettavan 
     * lausekkeen. Metodia tulee kutsua vain kerran.
     * 
     * @throws IllegalStateException
     * @throws IllegalArgumentException 
     */
    public void kasitteleLauseke() 
            throws IllegalStateException, IllegalArgumentException {
        while (paikkaSisaltyySyotteeseen()) {
            kasitteleSeuraava();
        }
        
        lauseke.suljeLohko();
    }
    
    /**
     * Metodin kasitteleSeuraava apumetodi. Lukee luvun kutsuhetken paikasta
     * ja lisaa sen lausekkeeseen.
     * 
     * @throws IllegalStateException
     * @throws IllegalArgumentException 
     */
    private void kasitteleLuku() 
            throws IllegalStateException, IllegalArgumentException {
        LuvunKasittelija kasittelija = new LuvunKasittelija(syote, paikka);
        lauseke.lisaaArvollinen(kasittelija.lueLuku());
            
        paikka = kasittelija.getPaikka();
    }
    
    /**
     * Metodin kasitteleSeuraava apumetodi. Lukee laskutoimituksen
     * kutsuhetken paikasta ja lisaa sen lausekkeeseen.
     * 
     * @throws IllegalStateException 
     */
    private void kasitteleLaskutoimitus() throws IllegalStateException {
        LaskutoimituksenKasittelija kasittelija = new LaskutoimituksenKasittelija(
                kirjasto, syote, lauseke, paikka);            
        kasittelija.lueLaskutoimitus();
            
        paikka = kasittelija.getPaikka();
    }
    
    /**
     * Metodin kasitteleSeuraava apumetodi. Lukee funktion
     * kutsuhetken paikasta ja lisaa sen lausekkeeseen.
     * 
     * @throws IllegalStateException 
     */
    private void kasitteleFunktio() throws IllegalStateException {
        FunktionKasittelija kasittelija = new FunktionKasittelija(
                kirjasto, syote, lauseke, paikka);            
        kasittelija.lueFunktio();
            
        paikka = kasittelija.getPaikka();
    }
    
    /**
     * Palauttaa true, jos tamanhetkinen paikka vastaa jotain syotteen
     * merkkia.
     * 
     * @return 
     */
    private boolean paikkaSisaltyySyotteeseen() {
        return paikka >= 0 && paikka < syote.length();
    }
    
    public Lauseke getLauseke() {
        return lauseke;
    }
    
    /**
     * Palauttaa lausekkeen arvon. Metodia kasitteleLauseke tulee olla
     * kutsuttu ennen kutsua.
     * 
     * @return Lausekkeen arvo.
     */
    public double arvo() {
        return lauseke.arvo();
    }

}
