package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;

/**
 * Tarjoaa toiminnallisuuden laskutoimituksen lukemiseksi String 
 * tyyppisesta syotteesta ja laskutoimituksen lisaamiseksi lausekkeeseen.
 * Jokaista luettavaa laskutoimitusta kohden tulee luoda uusi
 * LaskutoimituksenKasittelija.
 */
public class LaskutoimituksenKasittelija {
    
    /**
     * ToimintoKirjasto, josta laskutoimitus haetaan.
     */
    private ToimintoKirjasto kirjasto;
    
    /**
     * Lauseke, johon laskutoimitus lisataan.
     */
    private Lauseke lauseke;
    
    /**
     * Syote, josta laskutoimitus luetaan.
     */
    private String syote;
    
    /**
     * Muisti syotteen kohdalle, jossa LaskutoimituksenKasittelija on.
     */
    private int paikka;
    
    public LaskutoimituksenKasittelija(ToimintoKirjasto kirjasto, 
             String syote, Lauseke lauseke, int paikka) {
        this.kirjasto = kirjasto;
        this.syote = syote;
        this.lauseke = lauseke;
        this.paikka = paikka;
    }
    
    public LaskutoimituksenKasittelija(ToimintoKirjasto kirjasto) {
        this(kirjasto, "", new Lauseke(), 0);
    }
    
    /**
     * Lukee laskutoimituksen alkaen kutsuhetken paikasta ja lisaa
     * laskutoimituksen lausekkeeseen.
     * 
     * @throws IllegalStateException Kutsuhetken paikan tulee sisaltaa
     * laskutoimitus.
     */
    public void lueLaskutoimitus() throws IllegalStateException {
        
        if (!paikkaOsaTunnusta()) {
            throw new IllegalStateException();
        } 
        
        Laskutoimitus lisattava = kirjasto.haeLaskutoimitus(
                syote.substring(paikka, paikka + 1));
         
         lauseke.lisaaLaskutoimitus(lisattava);
         paikka++;
    }
    
    /**
     * Tarkistaa sisaltyyko paikka syotteeseen.
     * @return 
     */
    private boolean paikkaSisaltyySyotteeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa onko paikka osa tunnusta.
     * @return 
     */
    private boolean paikkaOsaTunnusta() {
        return paikkaSisaltyySyotteeseen() && paikkaSisaltaaSallitunMerkin();
    }
    
    /**
     * Tarkistaa sisaltaako paikka sallitun merkin.
     * @return 
     */
    private boolean paikkaSisaltaaSallitunMerkin() {
        
        if (syote.substring(paikka, paikka + 1).equals("-")) {
            return true;
        }
        
        return syote.substring(paikka, paikka + 1).matches("[+|*|/|']");
    }
    
    public void setPaikka(int paikka) {
        this.paikka = paikka;
    }
    
    public int getPaikka() {
        return paikka;
    }
    
    public void setSyote(String syote) {
        this.syote = syote;
    }
    
    public Lauseke getLauseke() {
        return lauseke;
    }
}
