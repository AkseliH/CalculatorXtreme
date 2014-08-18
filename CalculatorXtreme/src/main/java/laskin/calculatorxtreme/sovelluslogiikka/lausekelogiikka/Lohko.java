package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import java.util.ArrayList;
import java.util.List;

public class Lohko implements Arvollinen {
    
    private Suoritusjono alintaso;
    private List<Suoritusjono> suoritustasot;
    private Arvollinen seuraavaArvollinen;
    
    public Lohko(Suoritusjono jono) {
        this.alintaso = jono;
        this.suoritustasot = new ArrayList<Suoritusjono>();
        this.seuraavaArvollinen = null;
    }
    
    public Lohko() {
        this(new Suoritusjono());
    }
    
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) 
            throws IllegalArgumentException, IllegalStateException {
       if (lisattava == null || seuraavaArvollinen == null) {
           throw new IllegalArgumentException();
       }
       
       if (nykyinenJono().eiSisallaLaskutoimituksia()) {
           asetaJonoonArvollinen();
           nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
           return;
       }
               
       if (lisattava.getPrioriteetti() > nykyinenJono().nykyinenPrioriteetti()) {                      
           Suoritusjono uusitaso = new Suoritusjono();           
           nykyinenJono().lisaaSeuraavaArvollinen(uusitaso);
           suoritustasot.add(uusitaso);
           asetaJonoonArvollinen();
           nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
           
       } else if (lisattava.getPrioriteetti() == nykyinenJono().nykyinenPrioriteetti()) {
           asetaJonoonArvollinen();
           nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
       
       } else {
           asetaJonoonArvollinen();
           while (nykyinenJono().nykyinenPrioriteetti() > lisattava.getPrioriteetti()
                   && !suoritustasot.isEmpty()) {
               
               paataNykyinen();
               suoritustasot.remove(suoritustasot.size() - 1);
           }
           nykyinenJono().lisaaJonoonLaskutoimitus(lisattava);
   
       }
    }
    
    private Suoritusjono nykyinenJono() {
        if (suoritustasot.isEmpty()) {
            return alintaso;
        }
        
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
        while (!suoritustasot.isEmpty()) {
            paataNykyinen();
            suoritustasot.remove(suoritustasot.size() - 1);
        }
        paataNykyinen();
        
    }
    
    public void paataNykyinen() {
        nykyinenJono().paataJono();
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (alintaso == null) {
            throw new IllegalStateException();
        }
        return alintaso.arvo();
    }
    
    public boolean onTyhja() {
        return alintaso.onTyhja() && seuraavaArvollinen == null;
    }

}
