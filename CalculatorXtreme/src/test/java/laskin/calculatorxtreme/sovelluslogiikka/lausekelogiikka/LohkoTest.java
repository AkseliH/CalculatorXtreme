package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.Kertolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.Plus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.Miinus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.Jakolasku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LohkoTest {
    
    Lohko lohko;
    
    public LohkoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lohko = new Lohko();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arvoOikeinPelkallaLuvulla() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        
        assertEquals(2, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinYhdellaLaskutoimituksella() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.paataJono();
        
        assertEquals(0, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysViimeisestaEnsimmaiseen() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataJono();
        
        assertEquals(-8, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysEnsimmaisestaViimeiseen() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataJono();
        
        assertEquals(1, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysVaihteleva() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.paataJono();
        
        assertEquals(-5, lohko.arvo(), 0.00001);
    }
    
//    @Test
//    public void laskujarjestysOikeinPerakkaisillaMiinusLaskuilla() {
//        lohko.lisaaJonoonArvollinen(new Luku(2));
//        lohko.lisaaJonoonLaskutoimitus(new Miinus());
//        lohko.lisaaJonoonArvollinen(new Luku(-2));
//        lohko.lisaaJonoonLaskutoimitus(new Miinus());
//        lohko.lisaaJonoonArvollinen(new Luku(5));
//        lohko.lisaaJonoonLaskutoimitus(new Plus());
//        lohko.lisaaJonoonArvollinen(new Luku(3));
//        lohko.paataJono();
//        
//        assertEquals(2, lohko.arvo(), 0.00001);
//    }
    
    
}
