
package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Arvollinen;

public class LuvunKasittelija {
    
    private String syote;
    private int paikka;
    private boolean desimaalipisteLoydetty;
    
    public LuvunKasittelija(String lauseke, int aloitusPaikka) {
        this.syote = lauseke;
        this.paikka = aloitusPaikka;
        this.desimaalipisteLoydetty = false;
    }
    
    public Arvollinen lueLuku() 
            throws IllegalStateException, IllegalArgumentException {
        
        int aloituspaikka = paikka;
        
        if (syote == null || !paikkaSisaltyySyotteeseen()
                || !paikkaSisaltaaNumeron()) {
            throw new IllegalStateException();
        }
        
        while (true) {
            
            if (!merkkiOsaLukua()) {
                break;
            }
            
            paikka++;
        }
        
        Arvollinen luku = new Luku(Double.parseDouble(
                syote.substring(aloituspaikka, paikka)));
        
        return luku;
    
    }
    
    private boolean kasitteleDesimaalipiste() {        
        if (!desimaalipisteLoydetty) {
            desimaalipisteLoydetty = true;
            return true;
        }
        
        return false;
    }
    
    private boolean merkkiOsaLukua() {
        if (!paikkaSisaltyySyotteeseen()) {
            return false;
        }
        
        if (paikkaSisaltaaNumeron()) {
            return true;
        }
        
        if (paikkaSisaltaaDesimaalipisteen()) {
            return kasitteleDesimaalipiste();
        }
        
        return false;
    }
    
    private boolean paikkaSisaltaaNumeron() {                
        return syote.substring(paikka, paikka + 1).matches("[0-9]");        
    }
    
    private boolean paikkaSisaltaaDesimaalipisteen() {
        return syote.substring(paikka, paikka + 1).equals(".");
    }
    
    private boolean paikkaSisaltyySyotteeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    
    public int getPaikka() {
        return paikka;
    }
}
