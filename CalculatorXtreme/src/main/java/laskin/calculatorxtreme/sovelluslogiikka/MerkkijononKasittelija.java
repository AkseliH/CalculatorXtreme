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
    
    public MerkkijononKasittelija(ToimintoKirjasto kirjasto) {
        this(null, kirjasto);
    }
    
    public void setSyote(String syote) {
        this.syote = syote;
    }
    
    private void kasitteleSeuraava() 
            throws IllegalStateException, IllegalArgumentException {
        if (seuraavanaLuku()) {
            kasitteleLuku();            
        } else if (seuraavanaLaskutoimitus()){
            kasitteleLaskutoimitus();            
        } else if (seuraavanaFunktio()) {
            kasitteleFunktio();            
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
    
    private boolean seuraavanaLuku() {
        if (syote.substring(paikka, paikka + 1).matches("[0-9|.]")) {
            return true;
        }
        
        if (syote.substring(paikka, paikka + 1).equals("-") 
                && lauseke.nykyinenLohko().onTyhja()) {
            return true;
        }
        
        return false;
    }
    
    private boolean seuraavanaLaskutoimitus() {
        return syote.substring(paikka, paikka + 1).matches("[+|*|/]");
    }
    
    private boolean seuraavanaFunktio() {
        return syote.substring(paikka, paikka + 1).matches("[a-z]");
    }
    
    public void kasitteleLauseke() 
            throws IllegalStateException, IllegalArgumentException {
        while (paikkaSisaltyySyotteeseen()) {
            kasitteleSeuraava();
        }
        
        lauseke.suljeLohko();
    }
    
    private void kasitteleLuku() 
            throws IllegalStateException, IllegalArgumentException {
        LuvunKasittelija kasittelija = new LuvunKasittelija(syote, paikka);
        lauseke.lisaaArvollinen(kasittelija.lueLuku());
            
        paikka = kasittelija.getPaikka();
    }
    
    private void kasitteleLaskutoimitus() throws IllegalStateException {
        LaskutoimituksenKasittelija kasittelija = new LaskutoimituksenKasittelija(
                kirjasto, syote, lauseke, paikka);            
        kasittelija.lueLaskutoimitus();
            
        paikka = kasittelija.getPaikka();
    }
    
    private void kasitteleFunktio() throws IllegalStateException {
        FunktionKasittelija kasittelija = new FunktionKasittelija(
                kirjasto, syote, lauseke, paikka);            
        kasittelija.lueFunktio();
            
        paikka = kasittelija.getPaikka();
    }
    
    private boolean paikkaSisaltyySyotteeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    
    public Lauseke getLauseke() {
        return lauseke;
    }

}
