
package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Arvollinen;

/**
 * Tarjoaa toiminnallisuuden luvun luomiseksi String tyyppisesta 
 * syotteesta.
 */
public class LuvunKasittelija {
    
    private String syote;
    private int paikka;
    private boolean desimaalipisteLoydetty;
    
    public LuvunKasittelija(String lauseke, int aloitusPaikka) {
        this.syote = lauseke;
        this.paikka = aloitusPaikka;
        this.desimaalipisteLoydetty = false;
    }
    
    public LuvunKasittelija() {
        this(null, 0);
    }
    
    public void setSyote(String syote) {
        this.syote = syote;
    }
    
    public void setPaikka(int paikka) {
        this.paikka = paikka;
    }
    
    /**
     * Lukee syotteesta yhden yhtenaisen luvun lukien kutsuhetken 
     * paikasta ja luo tata arvoa vastaavan luvun, joka palautetaan
     * arvollisena.
     * 
     * @return Syotteen luku.
     * @throws IllegalStateException Syotteen kohdan tulee sisaltaa luku.
     * @throws IllegalArgumentException 
     */
    public Arvollinen lueLuku() 
            throws IllegalStateException, IllegalArgumentException {
        
        int aloituspaikka = paikka;
        
        if (!lukeminenVoidaanAloittaa()) {
            throw new IllegalStateException();
        }
        
        siirryLuvunLoppuun();
        
        Arvollinen luku = new Luku(Double.parseDouble(
                syote.substring(aloituspaikka, paikka)));
        
        return luku;
    
    }
    
    /**
     * Testaa, etta aloituspaikka aloittaa luvun.
     * 
     * @return 
     */
    private boolean lukeminenVoidaanAloittaa() {
        if (syote == null) {
            return false;
        }
        
        if (!paikkaSisaltyySyotteeseen()) {
            return false;
        }
        
        if (paikkaSisaltaaNumeron() || paikkaSisaltaaDesimaalipisteen()) {
            return true;
        }
        
        return false;
    }
    
    private void siirryLuvunLoppuun() {
         while (true) {
            
            if (!merkkiOsaLukua()) {
                break;
            }
            
            paikka++;
        }
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
