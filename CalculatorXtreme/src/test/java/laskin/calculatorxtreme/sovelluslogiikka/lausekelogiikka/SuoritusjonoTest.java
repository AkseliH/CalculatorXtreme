package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Kertolasku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Plus;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot.Potenssi;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class SuoritusjonoTest {
    
    Suoritusjono jono;
    
    public SuoritusjonoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jono = new Suoritusjono();
    }
    
    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionTyhjanJononArvolla() {
        virhe.expect(IllegalStateException.class);
        
        jono.arvo();
    }
    
    @Test
    public void illegalStateExceptionKunYritetaanLisataKaksiArvollista() {
        virhe.expect(IllegalStateException.class);
        
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaSeuraavaArvollinen(new Luku(2));
    }
    
    @Test
    public void illegalStateExceptionKunLoppuuLaskutoimitukseen() {
        virhe.expect(IllegalStateException.class);
        
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.paataJono();
    }
    
    @Test
    public void illegalArgumentExceptionKunLisattavaArvollinenNull() {
        virhe.expect(IllegalArgumentException.class);
        
        jono.lisaaSeuraavaArvollinen(null);
    }
    
    @Test
    public void illegalArgumentExceptionKunLisattavaLaskuNull() {
        virhe.expect(IllegalArgumentException.class);
        
        jono.lisaaJonoonLaskutoimitus(null);
    }
    
    @Test
    public void jonoTyhjaLuonninJalkeen() {
        assertTrue(jono.eiSisallaLaskutoimituksia());
    }
    
    @Test
    public void jononArvoOikeinPelkallaArvollisella() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        assertEquals(1, jono.arvo(), 0.00001);
    }
    
    @Test
    public void jonoEiTyhjaLaskutoimituksenLisayksenJalkeen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());
        
        assertFalse(jono.eiSisallaLaskutoimituksia());
    }
    
    @Test
    public void asetaEnsimmainenAsettaaViimeisen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.asetaEnsimmainen(new Plus());
        
        assertFalse(jono.getViimeinen() == null);
    }
    
    @Test
    public void lisaaLaskutoimitusLisaaEnsimmaisenLaskutoimituksen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());   
        assertFalse(jono.eiSisallaLaskutoimituksia());
    }
    
    @Test
    public void arvoOikeinPaattamisenJalkeenPelkallaArvollisella() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertEquals(1, jono.arvo(), 0.00001);
    }
    
    @Test
    public void lisaaSeuraavaArvollinenLisaaUudenArvollisen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(2));
        
        assertEquals(2, jono.getSeuraavaArvollinen().arvo(), 0.00001);
    }
        
    
    @Test
    public void paataAsettaaSeuraavanArvollisenViimeiselle() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertFalse(jono.getViimeinen().getTakajasen() == null);
    }
    
    @Test
    public void arvoOikeinLaskutoimituksenJaLuvunLisayksenJaPaattamisenJalkeen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertEquals(2, jono.arvo(), 0.0001);
    }
    
    @Test
    public void laskeeLaskutoimituksetEnsimmaisestaViimeiseen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Potenssi());
        jono.lisaaSeuraavaArvollinen(new Luku(-4));
        jono.lisaaJonoonLaskutoimitus(new Kertolasku());
        jono.lisaaSeuraavaArvollinen(new Luku(5));
        jono.paataJono();
        
        assertEquals(5, jono.arvo(), 0.00001);
    }

    
}
