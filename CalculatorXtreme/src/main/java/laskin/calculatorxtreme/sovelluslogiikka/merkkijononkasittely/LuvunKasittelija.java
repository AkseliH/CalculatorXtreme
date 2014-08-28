
package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Arvollinen;

/**
 * Tarjoaa toiminnallisuuden luvun luomiseksi String tyyppisesta 
 * syotteesta. Jokaista luettavaa lukua kohden tulee luoda uusi
 * Luvunkasittelija.
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
    
    /**
     * Siirtyy luvun jalkeiseen paikkaan.
     */
    private void siirryLuvunLoppuun() {
         while (true) {
            
            if (!merkkiOsaLukua()) {
                break;
            }
            
            paikka++;
        }
    }
    
    /**
     * Tarkistaa onko desimaalipiste kohdattu ja jos ei kirjaa sen
     * kohdatuksi.
     * 
     * @return 
     */
    private boolean kasitteleDesimaalipiste() {        
        if (!desimaalipisteLoydetty) {
            desimaalipisteLoydetty = true;
            return true;
        }
        
        return false;
    }
    
    /**
     * Tarkistaa onko paikka osa lukua.
     * @return 
     */
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
    
    /**
     * Tarkistaa sisaltaako paikka numeron.
     * @return 
     */
    private boolean paikkaSisaltaaNumeron() {                
        return syote.substring(paikka, paikka + 1).matches("[0-9]");        
    }
    
    /**
     * Tarkistaa sisaltaako paikka desimaalipisteen.
     * @return 
     */
    private boolean paikkaSisaltaaDesimaalipisteen() {
        return syote.substring(paikka, paikka + 1).equals(".");
    }
    
    /**
     * Tarkistaa sisaltyyko paikka syotteeseen.
     * @return 
     */
    private boolean paikkaSisaltyySyotteeseen() {
        return paikka >= 0 && paikka < syote.length();
    }
    
    public int getPaikka() {
        return paikka;
    }
}
