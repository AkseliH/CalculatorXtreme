package laskin.calculatorxtreme.sovelluslogiikka;

public class SuoritusjononKasittelija {
    
    private Suoritusjono jono;
    
    public SuoritusjononKasittelija(Suoritusjono jono) {
        this.jono = jono;
    }
    
    public void lisaaJonoonLaskutoimitus(Laskutoimitus lisattava) throws IllegalArgumentException, IllegalStateException {
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
    
    public Suoritusjono valmisSuoritusjono() throws IllegalStateException {
        jono.paataJono();
        return jono;
    }
}
