package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;


import java.util.ArrayList;
import java.util.List;

public class Lohkopino implements Arvollinen {
    
    private SuoritusjononKasittelija paalohko;
    private List<SuoritusjononKasittelija> lohkot;
    
    public Lohkopino() {
        this.paalohko = new SuoritusjononKasittelija();
        this.lohkot = new ArrayList<SuoritusjononKasittelija>();
    }
    
    public boolean onTyhja() {
        return lohkot.isEmpty();
    }
    
    public void avaaUusiLohko() {
        SuoritusjononKasittelija uusiLohko = new SuoritusjononKasittelija();
        this.nykyinenLohko().lisaaJonoonArvollinen(uusiLohko);
        
        lohkot.add(uusiLohko);
    }
    
    public SuoritusjononKasittelija nykyinenLohko() {
        if (this.onTyhja()) {
            return paalohko;
        }
        
        return lohkot.get(lohkot.size() - 1);
    }
    
    
    
    public void lisaaFunktioJaAvaaLohko(Funktio funktio) throws IllegalArgumentException {
        this.nykyinenLohko().lisaaJonoonArvollinen(funktio);
        SuoritusjononKasittelija uusiLohko = new SuoritusjononKasittelija();
        funktio.setArgumentti(uusiLohko);
        
        lohkot.add(uusiLohko);
        
    }
    
    public void lisaaArvollinen(Arvollinen arvollinen) {
        this.nykyinenLohko().lisaaJonoonArvollinen(arvollinen);
    }
    
    public void lisaaLaskutoimitus(Laskutoimitus laskutoimitus) {
        this.nykyinenLohko().lisaaJonoonLaskutoimitus(laskutoimitus);
    }
    
    public void suljeLohko() throws IllegalStateException {
        this.nykyinenLohko().paataJono();
        
        if (!this.onTyhja()) {
            lohkot.remove(lohkot.size() - 1);
        }
        
    }

    @Override
    public double arvo() throws IllegalStateException {
        return paalohko.arvo();
    }
    
    
    
    
    
    
}
