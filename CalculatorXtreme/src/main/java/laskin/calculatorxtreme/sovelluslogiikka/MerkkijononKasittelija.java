package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lohkopino;

public class MerkkijononKasittelija {
    
    private String syote;
    private ToimintoKirjasto kirjasto;
    private Lohkopino lauseke;
    private int paikka;
    
    public MerkkijononKasittelija(String syote, ToimintoKirjasto kirjasto) {
        this.lauseke = new Lohkopino();
        this.syote = syote;
        this.kirjasto = kirjasto;
        this.paikka = 0;
    }
    
    private void kasitteleSeuraava() {
        if (syote.substring(paikka, paikka + 1).matches("[0-9]")) {
            LuvunKasittelija kasittelija = new LuvunKasittelija(syote, paikka);
            lauseke.lisaaArvollinen(kasittelija.lueLuku());
            
            paikka = kasittelija.getPaikka();
            
        } else {
            ToiminnonKasittelija kasittelija = new ToiminnonKasittelija(
                    kirjasto, syote, lauseke, paikka);            
            kasittelija.lueToiminto();
            
            paikka = kasittelija.getPaikka();
        }
    }
    
    public void kasitteleLauseke() {
        while (paikkaSisaltyyLausekkeeseen()) {
            kasitteleSeuraava();
        }
        
        lauseke.suljeLohko();
    }
    
    public Lohkopino getLauseke() {
        return lauseke;
    }
    
    private boolean paikkaSisaltyyLausekkeeseen() {
        if (paikka >= 0 && paikka < syote.length()) {
            return true;
        }
        
        return false;
    }
    

}
