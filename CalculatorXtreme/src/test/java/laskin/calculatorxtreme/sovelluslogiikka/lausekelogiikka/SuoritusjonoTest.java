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
        jono = new Suoritusjono(new Luku(1));
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void jonoTyhjaLuonninJalkeen() {
        assertTrue(jono.eiSisallaLaskutoimituksia());
    }
    
    
    @Test
    public void konstruktoriAsettaaArvollisen() {       
        assertEquals(1, jono.getSeuraavaArvollinen().arvo(), 0.00001);
    }
    
    @Test
    public void jononArvoOikeinPelkallaArvollisella() {
        assertEquals(1, jono.arvo(), 0.00001);
    }
    
    @Test
    public void jonoEiTyhjaLaskutoimituksenLisayksenJalkeen() {
        jono.lisaaJonoonLaskutoimitus(new Plus());
        
       assertFalse(jono.eiSisallaLaskutoimituksia());
    }
    
    @Test
    public void asetaEnsimmainenAsettaaViimeisen() {
        jono.asetaEnsimmainen(new Plus());
        
        assertFalse(jono.getViimeinen() == null);
    }
    
    @Test
    public void lisaaLaskutoimitusLisaaEnsimmaisenLaskutoimituksen() {
        jono.lisaaJonoonLaskutoimitus(new Plus());   
        assertFalse(jono.eiSisallaLaskutoimituksia());
    }
    
    @Test
    public void arvoOikeinPaattamisenJalkeenPelkallaArvollisella() {
        jono.paataJono();
        
        assertEquals(1, jono.arvo(), 0.00001);
    }
    
    @Test
    public void lisaaSeuraavaArvollinenLisaaUudenArvollisen() {
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(2));
        
        assertEquals(2, jono.getSeuraavaArvollinen().arvo(), 0.00001);
    }
        
    
    @Test
    public void paataAsettaaSeuraavanArvollisenViimeiselle() {
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertFalse(jono.getViimeinen().getTakajasen() == null);
    }
    
    @Test
    public void arvoOikeinLaskutoimituksenJaLuvunLisayksenJaPaattamisenJalkeen() {
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertEquals(2, jono.arvo(), 0.0001);
    }
    
    @Test
    public void laskeeLaskutoimituksetEnsimmaisestaViimeiseen() {
        jono.lisaaJonoonLaskutoimitus(new Potenssi());
        jono.lisaaSeuraavaArvollinen(new Luku(-4));
        jono.lisaaJonoonLaskutoimitus(new Kertolasku());
        jono.lisaaSeuraavaArvollinen(new Luku(5));
        jono.paataJono();
        
        assertEquals(5, jono.arvo(), 0.00001);
    }

    
}
