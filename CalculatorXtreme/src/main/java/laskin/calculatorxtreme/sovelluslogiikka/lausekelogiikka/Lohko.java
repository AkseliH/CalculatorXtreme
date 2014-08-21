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
    
    private List<Suoritusjono> suoritustasot;
    private Arvollinen seuraavaArvollinen;
    
    public Lohko() {
        this.suoritustasot = new ArrayList<Suoritusjono>();
        suoritustasot.add(new Suoritusjono());
    }
    
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) 
            throws IllegalArgumentException, IllegalStateException {
       if (lisattava == null || seuraavaArvollinen == null) {
           throw new IllegalArgumentException();
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
     * Avaa uusia suoritustasoja kunnes suoritustasoja on yhta monta kuin
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
     * Sulkee suoritustasoja kunnes uoritustasoja on yhta monta kuin
     * parametrina annettu prioriteetti.
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
     * Lisaa suoritusrakenteeseen laskutoimituksen, jonka prioriteetti
     * on suurempi kuin lohkon nykyinen suoritustaso.
     * 
     * @param lisattava Lisattava laskutoimitus.
     */
    private void lisaaSuurempiPrioriteetti(Laskutoimitus lisattava) {
        siirryKorkeammalleSuoritustasolle(lisattava.getPrioriteetti());
        asetaJonoonArvollinen();
        nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
    }
    
    private void lisaaPienempiPrioriteetti(Laskutoimitus lisattava) {
        siirryAlemmalleSuoritustasolle(lisattava.getPrioriteetti());
        nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
    }
    
    private void lisaaSamaPrioriteetti(Laskutoimitus lisattava) {
        asetaJonoonArvollinen();
        nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
    }
    
    private Suoritusjono nykyinenJono() {        
        return suoritustasot.get(suoritustasot.size() - 1);
    }
       
    
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
    
    public void asetaJonoonArvollinen() throws IllegalStateException {
        if (seuraavaArvollinen == null) {
            throw new IllegalStateException();
        }
        
        nykyinenJono().lisaaSeuraavaArvollinen(seuraavaArvollinen);
        this.seuraavaArvollinen = null;
    }
    
    public void paataLohko() throws IllegalStateException {
        asetaJonoonArvollinen();
        
        for (Suoritusjono taso : suoritustasot) {
            taso.paataJono();
        }
    }

    @Override
    public double arvo() throws IllegalStateException {
        return suoritustasot.get(0).arvo();
    }
    
    public boolean onTyhja() {
        return suoritustasot.get(0).onTyhja() && seuraavaArvollinen == null;
    }

}
