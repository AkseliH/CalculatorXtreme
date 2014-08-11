package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.Kertolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.Plus;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.SuoritusjononKasittelija;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuoritusjononKasittelijaTest {
    
    SuoritusjononKasittelija kasittelija;
    
    public SuoritusjononKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kasittelija = new SuoritusjononKasittelija();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arvoOikeinPelkallaLuvulla() {
        kasittelija.lisaaJonoonArvollinen(new Luku(2));
        
        assertEquals(2, kasittelija.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinYhdellaLaskutoimituksella() {
        kasittelija.lisaaJonoonArvollinen(new Luku(2));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(-2));
        kasittelija.paataJono();
        
        assertEquals(0, kasittelija.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysViimeisestaEnsimmaiseen() {
        kasittelija.lisaaJonoonArvollinen(new Luku(2));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(-2));
        kasittelija.lisaaJonoonLaskutoimitus(new Kertolasku());
        kasittelija.lisaaJonoonArvollinen(new Luku(5));
        kasittelija.paataJono();
        
        assertEquals(-8, kasittelija.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysEnsimmaisestaViimeiseen() {
        kasittelija.lisaaJonoonArvollinen(new Luku(2));
        kasittelija.lisaaJonoonLaskutoimitus(new Kertolasku());
        kasittelija.lisaaJonoonArvollinen(new Luku(-2));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(5));
        kasittelija.paataJono();
        
        assertEquals(1, kasittelija.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysVaihteleva() {
        kasittelija.lisaaJonoonArvollinen(new Luku(2));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(-2));
        kasittelija.lisaaJonoonLaskutoimitus(new Kertolasku());
        kasittelija.lisaaJonoonArvollinen(new Luku(5));
        kasittelija.lisaaJonoonLaskutoimitus(new Plus());
        kasittelija.lisaaJonoonArvollinen(new Luku(3));
        kasittelija.paataJono();
        
        assertEquals(-5, kasittelija.arvo(), 0.00001);
    }
}
