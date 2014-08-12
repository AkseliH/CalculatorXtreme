package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;

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
    
    private void kasitteleSeuraava() 
            throws IllegalStateException, IllegalArgumentException {
        if (syote.substring(paikka, paikka + 1).matches("[0-9]")) {
            LuvunKasittelija kasittelija = new LuvunKasittelija(syote, paikka);
            lauseke.lisaaArvollinen(kasittelija.lueLuku());
            
            paikka = kasittelija.getPaikka();
            
        } else if (syote.substring(paikka, paikka + 1).matches("[+|*]")){
            LaskutoimituksenKasittelija kasittelija = new LaskutoimituksenKasittelija(
                    kirjasto, syote, lauseke, paikka);            
            kasittelija.lueLaskutoimitus();
            
            paikka = kasittelija.getPaikka();
            
        } else if (syote.substring(paikka, paikka + 1).matches("[a-z]")) {
            FunktionKasittelija kasittelija = new FunktionKasittelija(
                    kirjasto, syote, lauseke, paikka);            
            kasittelija.lueFunktio();
            
            paikka = kasittelija.getPaikka();
            
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
    
    public void kasitteleLauseke() {
        while (paikkaSisaltyySyotteeseen()) {
            kasitteleSeuraava();
        }
        
        lauseke.suljeLohko();
    }
    
    public Lauseke getLauseke() {
        return lauseke;
    }
    
    private boolean paikkaSisaltyySyotteeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    

}
