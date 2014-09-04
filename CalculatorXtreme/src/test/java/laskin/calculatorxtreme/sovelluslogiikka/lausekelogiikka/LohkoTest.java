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
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalArgumentExceptionKunLisattavaArvollinenNull() {
        virhe.expect(IllegalArgumentException.class);
        
        lohko.lisaaJonoonArvollinen(null);
    }
    
    @Test
    public void illegalArgumentExceptionKunLisattavaLaskutoimitusNull() {
        virhe.expect(IllegalArgumentException.class);
        
        lohko.lisaaLohkoonLaskutoimitus(null);
    }
    
    @Test
    public void illegalStateExceptionKunKaksiArvollistaPerattain() {
        virhe.expect(IllegalStateException.class);
        
        lohko.lisaaJonoonArvollinen(new Luku(1));
        lohko.lisaaJonoonArvollinen(new Luku(-1));
    }
    
    @Test
    public void illegalStateExceptionKunPaatetaanTyhjaLohko() {
        virhe.expect(IllegalStateException.class);
        
        lohko.paataLohko();
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
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.paataLohko();
        
        assertEquals(0, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysViimeisestaEnsimmaiseen() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaLohkoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataLohko();
        
        assertEquals(-8, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysEnsimmaisestaViimeiseen() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataLohko();
        
        assertEquals(1, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunOikeaLaskujarjestysVaihteleva() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaLohkoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.paataLohko();
        
        assertEquals(-5, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikeinPerakkaisillaMiinusLaskuilla() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Miinus());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaLohkoonLaskutoimitus(new Miinus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.paataLohko();
        
        assertEquals(2, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void useampiTasoinenLaskujarjestysOikein() {
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Potenssi());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.lisaaLohkoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.paataLohko();
        
        assertEquals(34, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void monimutkainenLaskujarjestysOikein() {
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Potenssi());
        lohko.lisaaJonoonArvollinen(new Luku(-2));
        lohko.lisaaLohkoonLaskutoimitus(new Miinus());
        lohko.lisaaJonoonArvollinen(new Luku(6));
        lohko.lisaaLohkoonLaskutoimitus(new Jakolasku());
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(3));
        lohko.paataLohko();
        
        assertEquals(-11.75, lohko.arvo(), 0.00001);
    }
    
    @Test
    public void prioritettiOikein() {
        lohko.lisaaJonoonArvollinen(new Luku(5));
        lohko.lisaaLohkoonLaskutoimitus(new Plus());
        lohko.lisaaJonoonArvollinen(new Luku(2));
        lohko.lisaaLohkoonLaskutoimitus(new Kertolasku());
        lohko.lisaaJonoonArvollinen(new Luku(4));
        
        assertEquals(2, lohko.nykyinenPrioriteetti());
    }
    
}
