package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;

public class LaskutoimituksenKasittelija {
    
    private ToimintoKirjasto kirjasto;
    private Lauseke lauseke;
    private String syote;
    private int paikka;
    
    public LaskutoimituksenKasittelija(ToimintoKirjasto kirjasto, 
             String syote, Lauseke lauseke, int paikka) {
        this.kirjasto = kirjasto;
        this.syote = syote;
        this.lauseke = lauseke;
        this.paikka = paikka;
    }
    
    public void lueLaskutoimitus() throws IllegalStateException {
        
        if (!merkkiOsaTunnusta()) {
            throw new IllegalStateException();
        } 
        
        Laskutoimitus lisattava = kirjasto.haeLaskutoimitus(
                syote.substring(paikka, paikka + 1));
         
         lauseke.lisaaLaskutoimitus(lisattava);
         paikka++;
    }
    
    private boolean paikkaSisaltyySyotteeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    
    private boolean merkkiOsaTunnusta() {
        if (!paikkaSisaltyySyotteeseen()) {
            return false;
        }
        
        if (paikkaSisaltaaSallitunMerkin()) {
            return true;
        }                
        
        return false;
    }
    
    private boolean paikkaSisaltaaSallitunMerkin() {
        
        if (syote.substring(paikka, paikka + 1)
                .matches("[+|*]")) {
            return true;
        }
        
        return false;
    }
    
    
    public int getPaikka() {
        return paikka;
    }
}
