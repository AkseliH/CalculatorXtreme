package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

/**
 * Tarjoaa toiminnallisuuden funktion lukemiseksi String 
 * tyyppisesta syotteesta ja funktion lisaamiseksi lausekkeeseen.
 * Jokaista luettavaa funktiota kohti tulee luoda uusi FunktionKasittelija.
 */
public class FunktionKasittelija {
    
    private ToimintoKirjasto kirjasto;
    private Lauseke lauseke;
    private String syote;
    private int paikka;
    
    public FunktionKasittelija(ToimintoKirjasto kirjasto, String syote, 
            Lauseke lauseke, int paikka) {
        this.kirjasto = kirjasto;
        this.syote = syote;
        this.lauseke = lauseke;
        this.paikka = paikka;
    }
    
    public FunktionKasittelija(ToimintoKirjasto kirjasto) {
        this(kirjasto, "", new Lauseke(), 0);
    }
    
    /**
     * Lukee syotteesta yhden kokonaisen tekstielementin alkaen 
     * kutsuhetken paikasta ja lisaa lausekkeeseen vastaavan funktion.
     * 
     * @throws IllegalStateException Kutsuhetken paikalla tulee olla
     * tuettu funktio ja funktiota tulee seurata sulku.
     */
    public void lueFunktio() throws IllegalStateException {
        
        if (!merkkiOsaTunnusta()) {
            throw new IllegalStateException();
        }
        
        int aloituspaikka = paikka;        
        siirryTunnuksenLoppuun();
        
        Funktio lisattava = kirjasto.haeFunktio(
                syote.substring(aloituspaikka, paikka));
        
        if (lisattava == null || !funktiotaSeuraaSulku()) {
            throw new IllegalStateException();
        }
        
        lauseke.lisaaFunktioJaAvaaLohko(lisattava);
    }
    
    /**
     * Siirtyy yhtenaisen tekstielementin jalkeiseen paikkaan.
     */
    private void siirryTunnuksenLoppuun() {
        while (true) {
            
            if (!merkkiOsaTunnusta()) {
                break;
            }
            
            paikka++;
        }
    }
    
    /**
     * Tarkistaa sisaltyyko paikka tekstielementtiin.
     * @return 
     */
    private boolean merkkiOsaTunnusta() {
        return paikkaSisaltyySyotteeseen() && paikkaSisaltaaSallitunMerkin();
    }
    
    /**
     * Tarkistaa onko paikalla sulku ja siirtyy sulun jalkeiseen paikkaan.
     * @return 
     */
    private boolean funktiotaSeuraaSulku() {
        if (syote.substring(paikka, paikka + 1).equals("(")) {
            paikka++;
            return true;
        }
        
        return false;
    }
    
    
    /**
     * Tarkistaa sisaltyyko paikka syotteeseen.
     * @return 
     */
    private boolean paikkaSisaltyySyotteeseen() {
        return (paikka >= 0 && paikka < syote.length()) ;
    }
    
    /**
     * Tarkistaa sisaltaako paikka sallitun merkin.
     * @return 
     */
    private boolean paikkaSisaltaaSallitunMerkin() {
        return syote.substring(paikka, paikka + 1).matches("[a-z]");
    }
    
    public int getPaikka() {
        return paikka;
    }
    
    public void setPaikka(int paikka) {
        this.paikka = paikka;
    }
    
    public Lauseke getLauseke() {
        return lauseke;
    }
    
    public void setSyote(String syote) {
        this.syote = syote;
    }
}
