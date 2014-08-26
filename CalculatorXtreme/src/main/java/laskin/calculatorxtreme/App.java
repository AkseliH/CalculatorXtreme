package laskin.calculatorxtreme;


import java.util.Scanner;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.*;
import laskin.calculatorxtreme.kayttoliittyma.TekstiKayttoliittyma;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lohko;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import javax.swing.SwingUtilities;
import laskin.calculatorxtreme.kayttoliittyma.GraafinenKayttoliittyma;

public class App {
    
    public static void main( String[] args ) {                
        
        ToimintoKirjasto kirjasto = new ToimintoKirjasto();
//        
//        Scanner lukija = new Scanner(System.in);
//        
//        TekstiKayttoliittyma  kayttoliittyma 
//                = new TekstiKayttoliittyma(lukija, kirjasto);
//        
//        kayttoliittyma.kaynnista();
//        
        GraafinenKayttoliittyma kayttoliittyma = new GraafinenKayttoliittyma(kirjasto);
        SwingUtilities.invokeLater(kayttoliittyma);
    }
}
