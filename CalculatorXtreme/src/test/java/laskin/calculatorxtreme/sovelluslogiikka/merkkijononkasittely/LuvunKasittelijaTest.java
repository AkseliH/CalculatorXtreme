package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunAloituspaikkaUlkopuolella() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("1");
        kasittelija.setPaikka(1);
        kasittelija.lueLuku();
    }
    
    @Test
    public void illegalStateExceptionKunAloitusPaikallaEiLukua() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("3+5");
        kasittelija.setPaikka(1);
        kasittelija.lueLuku();
    }
    
    @Test
    public void luvunLukemisenJalkeenOikeallaPaikalla() {
        kasittelija.setSyote("312.5ab");
        kasittelija.lueLuku();
        
        assertEquals(5, kasittelija.getPaikka());
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
}
