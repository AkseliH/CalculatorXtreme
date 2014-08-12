package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;

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
    
    public void lueFunktio() throws IllegalStateException {
        
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
        
        Funktio lisattava = kirjasto.haeFunktio(
                syote.substring(aloituspaikka, paikka));
        
        if (lisattava == null || !funktiotaSeuraaSulku()) {
            throw new IllegalStateException();
        }
        
        lauseke.lisaaFunktioJaAvaaLohko(lisattava);
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
    
    private boolean funktiotaSeuraaSulku() {
        if (syote.substring(paikka, paikka + 1).equals("(")) {
            paikka++;
            return true;
        }
        
        return false;
    }
    
    private boolean paikkaSisaltyySyotteeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    
    private boolean paikkaSisaltaaSallitunMerkin() {
        if (syote.substring(paikka, paikka + 1).toLowerCase().matches("[a-z]")) {
            return true;
        }
        
        return false;
    }
    
    public int getPaikka() {
        return paikka;
    }
}
