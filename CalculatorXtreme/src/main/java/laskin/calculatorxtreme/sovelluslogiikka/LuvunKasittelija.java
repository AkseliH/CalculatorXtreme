
package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Arvollinen;

public class LuvunKasittelija {
    
    private String lauseke;
    private int paikka;
    private boolean desimaalipisteLoydetty;
    
    public LuvunKasittelija(String lauseke, int aloitusPaikka) {
        this.lauseke = lauseke;
        this.paikka = aloitusPaikka;
        this.desimaalipisteLoydetty = false;
    }
    
    public Arvollinen lueLuku() throws IllegalStateException {
        
        int aloituspaikka = paikka;
        
        if (lauseke == null || !paikkaSisaltyyLausekkeeseen()
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
                lauseke.substring(aloituspaikka, paikka)));
        
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
        if (!paikkaSisaltyyLausekkeeseen()) {
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
        return lauseke.substring(paikka, paikka + 1).matches("[0-9]");        
    }
    
    private boolean paikkaSisaltaaDesimaalipisteen() {
        return lauseke.substring(paikka, paikka + 1).equals(".");
    }
    
    private boolean paikkaSisaltyyLausekkeeseen() {
        if (paikka >= 0 && paikka < lauseke.length()) {
            return true;
        }
        
        return false;
    }
    
    public int getPaikka() {
        return paikka;
    }
}
