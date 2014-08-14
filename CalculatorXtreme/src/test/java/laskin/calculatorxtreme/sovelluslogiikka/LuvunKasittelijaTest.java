package laskin.calculatorxtreme.sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LuvunKasittelijaTest {
    
    LuvunKasittelija kasittelija;
    
    public LuvunKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {        
        kasittelija = new LuvunKasittelija();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void lukeeKokonaisluvunOikein() {
        kasittelija.setSyote("3");
        assertEquals(3, kasittelija.lueLuku().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeDesimaaliluvunOikein() {
        kasittelija.setSyote("106.745");
        assertEquals(106.745, kasittelija.lueLuku().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeLuvunOikeinKunPerassaTekstia() {
        kasittelija.setSyote("14.53abcd");
        assertEquals(14.53, kasittelija.lueLuku().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeLuvunOikeinTekstinSeasta() {
        kasittelija.setSyote("asd14.53abcd");
        kasittelija.setPaikka(3);
        assertEquals(14.53, kasittelija.lueLuku().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeNegatiivisenLuvunOikein() {
        kasittelija.setSyote("-16.567");
        assertEquals(-16.567, kasittelija.lueLuku().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeNegatiivisenLuvunOikeinTekstista() {
        kasittelija.setSyote("asdaf-88.45hgdflhg");
        kasittelija.setPaikka(5);
        assertEquals(-88.45, kasittelija.lueLuku().arvo(), 0.00001);
    }
    
    @Test
    public void miinusLuvunJalkeenEiVaikuta() {
        kasittelija.setSyote("-16.567-");
        assertEquals(-16.567, kasittelija.lueLuku().arvo(), 0.00001);
    }

}
