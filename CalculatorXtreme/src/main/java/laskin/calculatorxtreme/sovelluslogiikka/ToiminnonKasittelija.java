package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lohkopino;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;

public class ToiminnonKasittelija {
    
    private ToimintoKirjasto kirjasto;
    private Lohkopino lauseke;
    private String syote;
    private int paikka;
    
    public ToiminnonKasittelija(ToimintoKirjasto kirjasto, String syote, 
            Lohkopino lauseke, int paikka) {
        this.kirjasto = kirjasto;
        this.syote = syote;
        this.lauseke = lauseke;
        this.paikka = paikka;
    }
    
    public void lueToiminto() throws IllegalStateException {
        
        if (!merkkiOsaTunnusta()) {
            throw new IllegalStateException();
        }
        
        int aloituspaikka = paikka;
        
        while (true) {
            
            if (!merkkiOsaTunnusta()) {
                break;
            }
            
            paikka++;
        }
        
        Laskutoimitus lisattava = kirjasto.haeLaskutoimitus(
                syote.substring(aloituspaikka, paikka));
        
        if (lisattava == null) {
            throw new IllegalStateException();
        }
        
        lauseke.lisaaLaskutoimitus(lisattava);
    }
    
    private boolean merkkiOsaTunnusta() {
        if (!paikkaSisaltyyLausekkeeseen()) {
            return false;
        }
        
        if (paikkaSisaltaaSallitunMerkin()) {
            return true;
        }                
        
        return false;
    }
    
    private boolean paikkaSisaltyyLausekkeeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    
    private boolean paikkaSisaltaaSallitunMerkin() {
        if (syote.substring(paikka, paikka + 1).toLowerCase().matches("[a-z]")) {
            return true;
        }
        
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
