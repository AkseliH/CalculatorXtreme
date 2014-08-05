package laskin.calculatorxtreme;

import laskin.calculatorxtreme.sovelluslogiikka.*;

public class App {
    
    public static void main( String[] args ) {
        
        //System.out.println("Hello world!");
        

        //(1+2)*3+sin(PI/2)*4
                                
        Lohkopino lauseke = new Lohkopino();
        
        lauseke.avaaUusiLohko();
        lauseke.lisaaArvollinen(new Luku(1));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(2));
        lauseke.suljeLohko();
        
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(3));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaFunktioJaAvaaLohko(new Sinifunktio());
        lauseke.lisaaArvollinen(new Luku(Math.PI));
        lauseke.lisaaLaskutoimitus(new Jakolasku());
        lauseke.lisaaArvollinen(new Luku(2));
        lauseke.suljeLohko();
        
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(4));
        
        lauseke.suljeLohko();
        
        System.out.println(lauseke.arvo());
        
        
        
    }
}
