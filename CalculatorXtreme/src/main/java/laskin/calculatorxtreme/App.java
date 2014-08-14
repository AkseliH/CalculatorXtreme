package laskin.calculatorxtreme;


import java.util.Scanner;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.*;
import laskin.calculatorxtreme.kayttoliittyma.TekstiKayttoliittyma;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;

public class App {
    
    public static void main( String[] args ) {
        
        //Perakkaisten jako- ja vahennyslaskujen laskujarjestys vaara.
        
        ToimintoKirjasto kirjasto = new ToimintoKirjasto();
        kirjasto.lisaaLaskutoimituksetJaFunktiot();
        
        Scanner lukija = new Scanner(System.in);
        
        TekstiKayttoliittyma  kayttoliittyma 
                = new TekstiKayttoliittyma(lukija, kirjasto);
        
        kayttoliittyma.kaynnista();

    }
}
