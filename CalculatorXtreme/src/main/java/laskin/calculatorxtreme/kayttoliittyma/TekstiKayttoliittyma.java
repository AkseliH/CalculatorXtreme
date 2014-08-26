package laskin.calculatorxtreme.kayttoliittyma;

import java.util.Scanner;
import laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely.MerkkijononKasittelija;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;

public class TekstiKayttoliittyma {
    
    private Scanner lukija;
    private ToimintoKirjasto kirjasto;
    
    public TekstiKayttoliittyma(Scanner lukija, ToimintoKirjasto kirjasto) {
        this.lukija = lukija;
        this.kirjasto = kirjasto;
    }
    
    public void kaynnista() {
        
        while (true) {
            System.out.print("Anna lauseke (tyhja lopettaa): ");
            String syote = lukija.nextLine();
            
            if (syote.equals("")) {
                break;
            }
            
            try {
                MerkkijononKasittelija kasittelija 
                        = new MerkkijononKasittelija(syote, kirjasto);
                
                kasittelija.kasitteleLauseke();
                System.out.print("Lausekkeen arvo: ");
                System.out.println(kasittelija.getLauseke().arvo());
            } catch (Exception e) {
                System.out.println("Virheellinen lauseke.");
            }
        }
    }
    
    private void tulostaLausekkeenArvo(String syote) {
        MerkkijononKasittelija kasittelija 
               = new MerkkijononKasittelija(syote, kirjasto);
                
        kasittelija.kasitteleLauseke();
        System.out.print("Lausekkeen arvo: ");
        System.out.println(kasittelija.getLauseke().arvo());
    }
}
