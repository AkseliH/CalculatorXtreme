package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import java.util.HashMap;
import java.util.Map;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Funktio;


public class ToimintoKirjasto {
    
    private Map<String,LaskutoimitusTehdas> laskutoimitukset;
    private Map<String,FunktioTehdas> funktiot;
    
    
    public ToimintoKirjasto() {
        this.laskutoimitukset = new HashMap<String,LaskutoimitusTehdas>();
        this.funktiot = new HashMap<String,FunktioTehdas>();
    }
    
    public void lisaaLaskutoimitusKirjastoon(LaskutoimitusTehdas laskutoimitus) {        
        laskutoimitukset.put(laskutoimitus.getTunnus(), laskutoimitus);        
    }
    
    public void lisaaFunktioKirjastoon(FunktioTehdas funktio) {
        funktiot.put(funktio.getTunnus(), funktio);
    }
    
    public void lisaaLaskutoimituksetJaFunktiot() {
        this.lisaaLaskutoimitusKirjastoon(new PlusTehdas());
        this.lisaaLaskutoimitusKirjastoon(new KertolaskuTehdas());
        this.lisaaLaskutoimitusKirjastoon(new JakolaskuTehdas());
        this.lisaaLaskutoimitusKirjastoon(new MiinusTehdas());
        
        this.lisaaFunktioKirjastoon(new SinifunktioTehdas());
    }
    
    public Laskutoimitus haeLaskutoimitus(String tunnus) {
        if (laskutoimitukset.containsKey(tunnus)) {
            return laskutoimitukset.get(tunnus).luo();
        }
        
        return null;
    }
    
    public Funktio haeFunktio(String tunnus) {
        if (funktiot.containsKey(tunnus)) {
            return funktiot.get(tunnus).luo();
        }
        
        return null;
    }
}
