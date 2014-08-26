package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Sinifunktio;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Jakolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Kertolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Plus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LausekeTest {
    
    Lauseke lauseke;
    
    public LausekeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lauseke = new Lauseke();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void arvoOikeinLuvunLisayksenJalkeen() {
        lauseke.lisaaArvollinen(new Luku(78));
        lauseke.suljeLohko();
        
        assertEquals(78, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinYhdellaLaskutoimituksella() {
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(-1));
        lauseke.suljeLohko();
        
        assertEquals(4, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikeinIlmanLohkoja() {
        lauseke.lisaaArvollinen(new Luku(1));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(2));
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(3));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(4));
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.suljeLohko();
        
        assertEquals(27, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void alussaTyhja() {
        assertTrue(lauseke.eiAvoimiaLohkoja());
    }
    
    @Test
    public void eiTyhjaLohkonAvaamisenJalkeen() {
        lauseke.avaaUusiLohko();
        assertFalse(lauseke.eiAvoimiaLohkoja());
    }
    
    @Test
    public void arvoKunPaalohkoSisaltaaLaskutoimituksenSisaltavanLohkon() {
        lauseke.avaaUusiLohko();
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(-1));
        lauseke.suljeLohko();
        lauseke.suljeLohko();
        
        assertEquals(4, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikeaLohkonSisaltavassaLausekkeessa() {
        lauseke.avaaUusiLohko();
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(-1));
        lauseke.suljeLohko();
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(3));
        lauseke.suljeLohko();
        
        assertEquals(12, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikeaUseammallaSisakkaisellaLohkolla() {
        lauseke.avaaUusiLohko();
        lauseke.avaaUusiLohko();
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(-1));
        lauseke.suljeLohko();
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(3));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(2));
        lauseke.suljeLohko();
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.suljeLohko();
        
        assertEquals(70, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void laskujarjestysOikeaKunKaksiLohkoaSamallaTasolla() {
        lauseke.avaaUusiLohko();
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(-1));
        lauseke.suljeLohko();
        lauseke.lisaaLaskutoimitus(new Kertolasku());
        lauseke.avaaUusiLohko();
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(-1));
        lauseke.suljeLohko();
        lauseke.suljeLohko();
        
        assertEquals(16, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinPelkallaFunktiolla() {
        lauseke.lisaaFunktioJaAvaaLohko(new Sinifunktio());
        lauseke.lisaaArvollinen(new Luku(Math.PI));
        lauseke.suljeLohko();
        lauseke.suljeLohko();
        
        assertEquals(0, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunFunktioLausekkeenSisalla() {
        lauseke.lisaaArvollinen(new Luku(-7));
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaFunktioJaAvaaLohko(new Sinifunktio());
        lauseke.lisaaArvollinen(new Luku(Math.PI/2));
        lauseke.suljeLohko();
        lauseke.lisaaLaskutoimitus(new Plus());
        lauseke.lisaaArvollinen(new Luku(5));
        lauseke.suljeLohko();
        
        assertEquals(-1, lauseke.arvo(), 0.00001);
    }
    
    @Test
    public void arvoOikeinKunFuntionSisallaLaskutoimitus() {
        lauseke.lisaaFunktioJaAvaaLohko(new Sinifunktio());
        lauseke.lisaaArvollinen(new Luku(Math.PI));
        lauseke.lisaaLaskutoimitus(new Jakolasku());
        lauseke.lisaaArvollinen(new Luku(2));
        lauseke.suljeLohko();
        lauseke.suljeLohko();
        
        assertEquals(1, lauseke.arvo(), 0.00001);
    }
    
}
