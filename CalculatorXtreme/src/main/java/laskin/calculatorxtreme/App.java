package laskin.calculatorxtreme;


import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.*;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.*;
import laskin.calculatorxtreme.sovelluslogiikka.MerkkijononKasittelija;

public class App {
    
    public static void main( String[] args ) {
        
        ToimintoKirjasto kirjasto = new ToimintoKirjasto();
        kirjasto.lisaaLaskutoimituksetJaFunktiot();
        MerkkijononKasittelija kasittelija = new MerkkijononKasittelija(
                "((12.5+3)*6.5+2)*2*3+sin(5)", kirjasto);
        
        kasittelija.kasitteleLauseke();
        System.out.println(kasittelija.getLauseke().arvo());
        
        MerkkijononKasittelija kasittelija2 = new MerkkijononKasittelija(
                "3", kirjasto);
        
        kasittelija2.kasitteleLauseke();
        System.out.println(kasittelija2.getLauseke().arvo());
        
        
        
    }
}
