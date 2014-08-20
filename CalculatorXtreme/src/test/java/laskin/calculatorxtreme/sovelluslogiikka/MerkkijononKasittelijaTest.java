package laskin.calculatorxtreme.sovelluslogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MerkkijononKasittelijaTest {
    
    MerkkijononKasittelija kasittelija;
    
    public MerkkijononKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ToimintoKirjasto kirjasto = new ToimintoKirjasto();
        
        kasittelija = new MerkkijononKasittelija(kirjasto);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void yksinkertaisenLausekkeenArvoOikein() {
        kasittelija.setSyote("1+2");
        kasittelija.kasitteleLauseke();
        assertEquals(3, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikein() {
        kasittelija.setSyote("1+2*3+5");
        kasittelija.kasitteleLauseke();
        assertEquals(12, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void desimaaliluvutOikein() {
        kasittelija.setSyote("12.5+2.00*3.5+7.25");
        kasittelija.kasitteleLauseke();
        assertEquals(26.75, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void sulutOikein() {
        kasittelija.setSyote("2*(5+3)*(2+1)");
        kasittelija.kasitteleLauseke();
        assertEquals(48, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void negatiivisetLuvutOikein() {
        kasittelija.setSyote("-5+(-2+3)*(-2)");
        kasittelija.kasitteleLauseke();
        assertEquals(-7, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void negatiivisetJaMiinuksetYhdessaOikein() {
        kasittelija.setSyote("-5-3-6-(-2)");
        kasittelija.kasitteleLauseke();
        assertEquals(-12, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void funktiotOikein() {
        kasittelija.setSyote("sin(-2+2)*3+sin(sin(0))");
        kasittelija.kasitteleLauseke();
        assertEquals(0, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void monimutkainenLausekeOikein() {
        kasittelija.setSyote("sin(-2+2)*3+((3+2)/5+7)*2");
        kasittelija.kasitteleLauseke();
        assertEquals(16, kasittelija.getLauseke().arvo(), 0.00001);
    }

}
