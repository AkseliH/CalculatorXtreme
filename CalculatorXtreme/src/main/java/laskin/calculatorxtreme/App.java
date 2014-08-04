package laskin.calculatorxtreme;

import laskin.calculatorxtreme.sovelluslogiikka.*;

public class App {
    
    public static void main( String[] args ) {
        
        //System.out.println("Hello world!");
        Suoritusjono jono = new Suoritusjono();
        SuoritusjononKasittelija kasittelija = new SuoritusjononKasittelija(jono);
        
        kasittelija.lisaaJonoonArvollinen(new Luku(1));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(2));
        kasittelija.lisaaJonoonLaskutoimitus(new Kertolasku());
        kasittelija.lisaaJonoonArvollinen(new Luku(3));
        kasittelija.lisaaJonoonLaskutoimitus(new Kertolasku());
        kasittelija.lisaaJonoonArvollinen(new Luku(4));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(5));
        kasittelija.lisaaJonoonLaskutoimitus(new Kertolasku());
        kasittelija.lisaaJonoonArvollinen(new Luku(6));
        
        System.out.println(kasittelija.valmisSuoritusjono().arvo());
        
        
    }
}
