package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;


import java.util.ArrayList;
import java.util.List;

/**
 * Vastaa lauseketta, joka voi laskutoimitusten ja arvollisten lisaksi 
 * sisaltaa lohkoja ja funktioita. Lausekkeen elementit syotetaan 
 * luonnollisessa jarjestyksessa. Rakentaa suoritusrakenteen, jossa
 * suoritus etenee sisemmista lohkoista ulompiin ja lohkoissa laskujarjestyksen
 * mukaan. Arvoksi maaraytyy lausekkeen oikea arvo.
 */
public class Lauseke implements Arvollinen {
    
    private Lohko paalohko;
    private List<Lohko> lohkot;
    
    public Lauseke() {
        this.paalohko = new Lohko();
        this.lohkot = new ArrayList<Lohko>();
    }
    
    public boolean eiAvoimiaLohkoja() {
        return lohkot.isEmpty();
    }
    
    public void avaaUusiLohko() {
        Lohko uusiLohko = new Lohko();
        this.nykyinenLohko().lisaaJonoonArvollinen(uusiLohko);
        
        lohkot.add(uusiLohko);
    }
    
    public Lohko nykyinenLohko() {
        if (this.eiAvoimiaLohkoja()) {
            return paalohko;
        }
        
        return lohkot.get(lohkot.size() - 1);
    }
    
    
    
    public void lisaaFunktioJaAvaaLohko(Funktio funktio) throws IllegalArgumentException {
        Lohko uusiLohko = new Lohko();
        funktio.setArgumentti(uusiLohko);
        this.nykyinenLohko().lisaaJonoonArvollinen(funktio);
        
        lohkot.add(uusiLohko);
        
    }
    
    public void lisaaArvollinen(Arvollinen arvollinen) {
        this.nykyinenLohko().lisaaJonoonArvollinen(arvollinen);
    }
    
    public void lisaaLaskutoimitus(Laskutoimitus laskutoimitus) {
        this.nykyinenLohko().lisaaJonoonLaskutoimitus(laskutoimitus);
    }
    
    public void suljeLohko() throws IllegalStateException {
        this.nykyinenLohko().paataLohko();
        
        if (!this.eiAvoimiaLohkoja()) {
            lohkot.remove(lohkot.size() - 1);
        }
        
    }

    @Override
    public double arvo() throws IllegalStateException {
        return paalohko.arvo();
    }
 
}
