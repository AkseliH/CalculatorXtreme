package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

public class SuoritusjononKasittelija implements Arvollinen {
    
    private Suoritusjono jono;
    
    public SuoritusjononKasittelija(Suoritusjono jono) {
        this.jono = jono;
    }
    
    public SuoritusjononKasittelija() {
        this(new Suoritusjono());
    }
    
    public void setJono(Suoritusjono jono) {
        this.jono = jono;
    }
    
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) 
            throws IllegalArgumentException, IllegalStateException {
       if (lisattava == null) {
           throw new IllegalArgumentException();
       }
               
       if (lisattava.getPrioriteetti() < jono.nykyinenPrioriteetti()) {                      
           jono.paataJono();
           jono = new Suoritusjono(jono);
           jono.asetaEnsimmainen(lisattava);
       } else {
           jono.lisaaJonoonLaskutoimitus(lisattava);
       }
    }
    
    public void lisaaJonoonArvollinen(Arvollinen lisattava) throws IllegalArgumentException {
        jono.lisaaSeuraavaArvollinen(lisattava);
    }
    
    public void paataJono() throws IllegalStateException {
        jono.paataJono();
    }

    @Override
    public double arvo() throws IllegalStateException {
        if (jono == null) {
            throw new IllegalStateException();
        }
        return jono.arvo();
    }
    
    
}
