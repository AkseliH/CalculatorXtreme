package laskin.calculatorxtreme.sovelluslogiikka;

import java.util.ArrayList;
import java.util.List;

public class Lohkopino implements Arvollinen {
    
    private Suoritusjono paalohko;
    private List<Suoritusjono> lohkot;
    private SuoritusjononKasittelija kasittelija;
    
    public Lohkopino() {
        this.paalohko = new Suoritusjono();
        this.lohkot = new ArrayList<Suoritusjono>();
        this.kasittelija = new SuoritusjononKasittelija(paalohko);
    }
    
    public boolean onTyhja() {
        return lohkot.isEmpty();
    }
    
    public void avaaUusiLohko() {
        Suoritusjono uusiLohko = new Suoritusjono();
        
        kasittelija.lisaaJonoonArvollinen(uusiLohko);
        
        lohkot.add(uusiLohko);
        kasittelija.setJono(uusiLohko);
    }
    
    public Suoritusjono nykyinenLohko() {
        if (this.onTyhja()) {
            return paalohko;
        }
        
        return lohkot.get(lohkot.size() - 1);
    }
    
    
    
    public void lisaaFunktioJaAvaaLohko(Funktio funktio) {
        kasittelija.lisaaJonoonArvollinen(funktio);
        Suoritusjono uusiLohko = new Suoritusjono();
        funktio.setArgumentti(uusiLohko);
        
        lohkot.add(uusiLohko);
        kasittelija.setJono(uusiLohko);
        
    }
    
    public void lisaaArvollinen(Arvollinen arvollinen) {
        kasittelija.lisaaJonoonArvollinen(arvollinen);
    }
    
    public void lisaaLaskutoimitus(Laskutoimitus laskutoimitus) {
        kasittelija.lisaaJonoonLaskutoimitus(laskutoimitus);
    }
    
    public void suljeLohko() {
        kasittelija.paataJono();
        
        if (!lohkot.isEmpty()) {
            lohkot.remove(lohkot.size() - 1);
            kasittelija.setJono(this.nykyinenLohko());
        }
        
    }

    @Override
    public double arvo() throws IllegalStateException {
        return paalohko.arvo();
    }
    
    
    
    
    
    
}
