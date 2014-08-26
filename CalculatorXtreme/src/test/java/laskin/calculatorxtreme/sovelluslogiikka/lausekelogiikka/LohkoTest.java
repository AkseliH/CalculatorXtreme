package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Kertolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Plus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Miinus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Jakolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Potenssi;
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
        lohko.paataLohko();
        
        assertEquals(2, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinYhdellaLaskutoimituksella() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.paataLohko();
        
        assertEquals(0, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysViimeisestaEnsimmaiseen() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataLohko();
        
        assertEquals(-8, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysEnsimmaisestaViimeiseen() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataLohko();
        
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
        lohko.paataLohko();
        
        assertEquals(-5, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikeinPerakkaisillaMiinusLaskuilla() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Miinus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Miinus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.paataLohko();
        
        assertEquals(2, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void useampiTasoinenLaskujarjestysOikein() {
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Potenssi());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataLohko();
        
        assertEquals(34, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void monimutkainenLaskujarjestysOikein() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Potenssi());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaJonoonLaskutoimitus(new Miinus());
        lohko.lisaaJonoonArvollinen(new Luku(6));
        lohko.lisaaJonoonLaskutoimitus(new Jakolasku());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.lisaaJonoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaJonoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.paataLohko();
        
        assertEquals(-0.75, lohko.arvo(), 0.00001);
    }
    
    
}
