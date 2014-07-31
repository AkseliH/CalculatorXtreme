package laskin.calculatorxtreme;

import laskin.calculatorxtreme.sovelluslogiikka.LuvunKasittelija;

public class App {
    
    public static void main( String[] args ) {
        
        LuvunKasittelija luvunKasittelija = new LuvunKasittelija("xg12.3..5jkl",5);
        
        double luku = luvunKasittelija.lueLuku();
        System.out.println(luku);
        System.out.println(luku + 1);
    }
}
