package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import java.util.HashMap;
import java.util.Map;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;


public class ToimintoKirjasto {
    
    private Map<String,LaskutoimitusTehdas> laskutoimitukset;
    
    
    public ToimintoKirjasto() {
        this.laskutoimitukset = new HashMap<String,LaskutoimitusTehdas>();
    }
    
    public void lisaaLaskutoimitusKirjastoon(LaskutoimitusTehdas laskutoimitus) {        
        laskutoimitukset.put(laskutoimitus.getTunnus(), laskutoimitus);        
    }
    
    public void lisaaLaskutoimitukset() {
        this.lisaaLaskutoimitusKirjastoon(new PlusTehdas());
        this.lisaaLaskutoimitusKirjastoon(new KertolaskuTehdas());
    }
    
    public Laskutoimitus haeLaskutoimitus(String tunnus) {
        if (laskutoimitukset.containsKey(tunnus)) {
            return laskutoimitukset.get(tunnus).luo();
        }
        
        return null;
    }
}
