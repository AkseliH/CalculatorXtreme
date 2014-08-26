package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Vastaa lauseketta, joka koostuu laskutoimituksista ja arvollisista.
 * Laskutoimitukset ja arvolliset syotetaan luonnollisessa jarjestyksessa.
 * Rakentaa suoritettavan rakenteen, jossa laskujarjestys maaraytyy oikein
 * laskutoimitusten prioriteetin perusteella. Arvoksi maaraytyy lausekkeen
 * oikea arvo.
 */
public class Lohko implements Arvollinen {
    
    /**
     * Avoinna olevat prioriteetti tasot.
     */
    private List<Suoritusjono> suoritustasot;
    
    /**
     * Muistipaikka seuraavana asetettavalle arvolliselle.
     */
    private Arvollinen seuraavaArvollinen;
    
    public Lohko() {
        this.suoritustasot = new ArrayList<Suoritusjono>();
        suoritustasot.add(new Suoritusjono());
    }
    
    /**
     * Lisaa lohkoon laskutoimituksen huolehtien, etta suoritusrakennetta
     * kutsuttaessa laskujarjestys maaraytyy oikein laskutoimitusten
     * prioriteettien perusteella.
     * 
     * @param lisattava Lisattava laskutoimitus.
     * @throws IllegalArgumentException Lisattava ei saa olla null.
     * @throws IllegalStateException Lohkon muisti ei saa olla tyhja.
     */
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) 
            throws IllegalArgumentException, IllegalStateException {
       if (lisattava == null) {
           throw new IllegalArgumentException();
       }
       
       if (seuraavaArvollinen == null) {
           throw new IllegalStateException();
       }
      
       if (lisattava.getPrioriteetti() > suoritustasot.size()) {                      
           lisaaSuurempiPrioriteetti(lisattava);
       } else  if (lisattava.getPrioriteetti() < suoritustasot.size()){
           lisaaPienempiPrioriteetti(lisattava);
       } else {
           lisaaSamaPrioriteetti(lisattava);
       }
    }
    
    /**
     * Metodin lisaaSuurempiPrioriteetti apumetodi. Avaa uusia 
     * suoritustasoja kunnes suoritustasoja on yhta monta kuin
     * parametrina annettu prioriteetti.
     * 
     * @param prioriteetti Taso, jolle noustaan.
     */
    private void siirryKorkeammalleSuoritustasolle(int prioriteetti) {
        while (suoritustasot.size() < prioriteetti) {
            Suoritusjono uusitaso = new Suoritusjono();
            nykyinenJono().lisaaSeuraavaArvollinen(uusitaso);
            suoritustasot.add(uusitaso);
        }
    }
    
    /**
     * Metodin lisaaPienempiPrioriteetti apumetodi. Sulkee suoritustasoja 
     * kunnes suoritustasoja on yhta monta kuin parametrina annettu prioriteetti.
     * 
     * @param prioriteetti Taso, jolle lasketaan.
     */
    private void siirryAlemmalleSuoritustasolle(int prioriteetti) {
        asetaJonoonArvollinen();
        while (suoritustasot.size() > prioriteetti) {            
            nykyinenJono().paataJono();
            suoritustasot.remove(suoritustasot.size() - 1);
        }
    }
    
    /**
     * Metodin lisaaJonoonLaskutoimitus apumetodi. Lisaa 
     * suoritusrakenteeseen laskutoimituksen, jonka prioriteetti
     * on suurempi kuin lohkon nykyinen suoritustaso.
     * 
     * @param lisattava Lisattava laskutoimitus.
     */
    private void lisaaSuurempiPrioriteetti(Laskutoimitus lisattava) {
        siirryKorkeammalleSuoritustasolle(lisattava.getPrioriteetti());
        asetaJonoonArvollinen();
        nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
    }
    
    /**
     * Metodin lisaaJonoonLaskutoimitus apumetodi. Lisaa 
     * suoritusrakenteeseen laskutoimituksen, jonka prioriteetti
     * on pienempi kuin lohkon nykyinen suoritustaso.
     * 
     * @param lisattava Lisattava laskutoimitus.
     */
    private void lisaaPienempiPrioriteetti(Laskutoimitus lisattava) {
        siirryAlemmalleSuoritustasolle(lisattava.getPrioriteetti());
        nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
    }
    
    /**
     * Metodin lisaaJonoonLaskutoimitus apumetodi. Lisaa 
     * suoritusrakenteeseen laskutoimituksen, jonka prioriteetti
     * on sama kuin lohkon nykyinen suoritustaso.
     * 
     * @param lisattava 
     */
    private void lisaaSamaPrioriteetti(Laskutoimitus lisattava) {
        asetaJonoonArvollinen();
        nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
    }
    
    /**
     * Palauttaa suoritustason, jota kasitellaan kutsuhetkella.
     * 
     * @return Kutsuhetkella muokattava suoritusjono.
     */
    private Suoritusjono nykyinenJono() {        
        return suoritustasot.get(suoritustasot.size() - 1);
    }
       
    /**
     * Lisaa lohkon muistiin arvollisen.
     * 
     * @param lisattava Lisattava arvollinen.
     * @throws IllegalArgumentException Lisattava ei saa olla null.
     * @throws IllegalStateException Muistin tulee olla tyhja ennen lisaysta.
     */
    public void lisaaJonoonArvollinen(Arvollinen lisattava) 
            throws IllegalArgumentException, IllegalStateException {
        if (lisattava == null) {
            throw new IllegalArgumentException();
        }
        
        if (seuraavaArvollinen != null) {
            throw new IllegalStateException();
        }
        
        this.seuraavaArvollinen = lisattava;
    }
    
    /**
     * Asettaa arvollisen lohkon muistista talla hetkella muokattavan
     * suoritustason muistiin.
     * 
     * @throws IllegalStateException Lohkon muisti ei saa olla tyhja.
     */
    private void asetaJonoonArvollinen() throws IllegalStateException {
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        nykyinenJono().lisaaSeuraavaArvollinen(seuraavaArvollinen);
        this.seuraavaArvollinen = null;
    }
    
    /**
     * Asettaa arvollisen lohkon muistista nykyselle suoritustasolle ja
     * paattaa jokaisen suoritustason. Kutsun jalkeen lohkon metodia arvo
     * voidaan kutsua. Kutsun jalkeen lohkon tilaa muuttavia metodeja ei tule
     * kutsua.
     * 
     * @throws IllegalStateException Muisti ei saa olla tyhja.
     */
    public void paataLohko() throws IllegalStateException {
        asetaJonoonArvollinen();
        
        for (Suoritusjono taso : suoritustasot) {
            taso.paataJono();
        }
    }

    /**
     * Palauttaa syotetyn lausekkeen arvon laskettaessa laskutoimitukset 
     * laskujarjestyksen mukaisesti.
     * 
     * @return Syotetyn lausekkeen arvo.
     * @throws IllegalStateException 
     */
    @Override
    public double arvo() throws IllegalStateException {
        return suoritustasot.get(0).arvo();
    }
    
    /**
     * Palauttaa tiedon siita, etta lohko ei sisalla laskutoimituksia
     * tai arvollista.
     * 
     * @return 
     */
    public boolean onTyhja() {
        return suoritustasot.get(0).onTyhja() && seuraavaArvollinen == null;
    }

}
