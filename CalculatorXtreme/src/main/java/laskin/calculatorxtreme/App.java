package laskin.calculatorxtreme;


import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.*;
import javax.swing.SwingUtilities;
import laskin.calculatorxtreme.kayttoliittyma.GraafinenKayttoliittyma;

public class App {
    
    public static void main( String[] args ) {                
        
        ToimintoKirjasto kirjasto = new ToimintoKirjasto();
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(kirjasto);
        
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
