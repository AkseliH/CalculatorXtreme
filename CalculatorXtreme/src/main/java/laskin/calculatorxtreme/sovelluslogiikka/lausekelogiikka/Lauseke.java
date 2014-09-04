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
    
    /**
     * Lausekkeen uloin lohko.
     */
    private Lohko paalohko;
    
    /**
     * Lausekkeen lisalohkot eli "sulut".
     */
    private List<Lohko> lohkot;
    
    public Lauseke() {
        this.paalohko = new Lohko();
        this.lohkot = new ArrayList<Lohko>();
    }
    
    /**
     * Palauttaa true, jos lausekkeessa ei ole paalohkon lisaksi muita
     * avoimia lhkoja.
     * 
     * @return 
     */
    public boolean eiAvoimiaLohkoja() {
        return lohkot.isEmpty();
    }
    
    /**
     * Avaa uuden lohkon, lisaa linkin vanhaan lohkoon ja siirtaa kasittelyn
     * uuteen lohkoon.
     */
    public void avaaUusiLohko() {
        Lohko uusiLohko = new Lohko();
        this.nykyinenLohko().lisaaJonoonArvollinen(uusiLohko);
        
        lohkot.add(uusiLohko);
    }
    
    /**
     * Palauttaa kutsuhetkella kasiteltavan lohkon.
     * @return Nykyinen lohko.
     */
    public Lohko nykyinenLohko() {
        if (this.eiAvoimiaLohkoja()) {
            return paalohko;
        }
        
        return lohkot.get(lohkot.size() - 1);
    }
    
    /**
     * Lisaa suoritusrakenteeseen funktion, avaa funktiolle lohkon ja
     * siirtaa kasittelyn uuteen lohkoon.
     * 
     * @param funktio Lisattava funktio.
     * @throws IllegalArgumentException Lisattava ei saa olla null.
     */
    public void lisaaFunktioJaAvaaLohko(Funktio funktio) throws IllegalArgumentException {
        Lohko uusiLohko = new Lohko();
        funktio.setArgumentti(uusiLohko);
        this.nykyinenLohko().lisaaJonoonArvollinen(funktio);
        
        lohkot.add(uusiLohko);
        
    }
    
    /**
     * Lisaa nykyiseen lohkoon arvollisen.
     * 
     * @param arvollinen Lisattava arvollinen.
     */
    public void lisaaArvollinen(Arvollinen arvollinen) {
        this.nykyinenLohko().lisaaJonoonArvollinen(arvollinen);
    }
    
    /**
     * Lisaa nykyiseen lohkoon laskutoimituksen.
     * 
     * @param laskutoimitus Lisattava laskutoimitus.
     */
    public void lisaaLaskutoimitus(Laskutoimitus laskutoimitus) {
        this.nykyinenLohko().lisaaJonoonLaskutoimitus(laskutoimitus);
    }
    
    /**
     * Paattaa nykyisen lohkon, jolloin kasittely siirtyy edelliseen
     * lohkoon. Kun paalohko on suljettu, lausekkeen tilaa muuttavia metodeja
     * ei tule enaa kutsua.
     * 
     * @throws IllegalStateException Nykyisen lohkon tulee olla oikeassa tilassa.
     */
    public void suljeLohko() throws IllegalStateException {
        this.nykyinenLohko().paataLohko();
        
        if (!this.eiAvoimiaLohkoja()) {
            lohkot.remove(lohkot.size() - 1);
        }
        
    }

    /**
     * Palauttaa syotetyn lausekkeen arvon laskien lohkot sisimmasta
     * uloimpaan ja huomioiden lohkojen sisalla oikean laskujarjestyksen.
     * Ennen kutsua lausekkeen kaikki lohkot tulee olla suljettu.
     * 
     * @return Syotetyn lausekkeen arvo.
     * @throws IllegalStateException 
     */
    @Override
    public double arvo() throws IllegalStateException {
        return paalohko.arvo();
    }
 
}
