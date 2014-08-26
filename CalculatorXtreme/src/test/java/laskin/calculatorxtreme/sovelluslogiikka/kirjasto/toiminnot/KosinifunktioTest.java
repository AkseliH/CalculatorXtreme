package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class KosinifunktioTest {
    
    Kosinifunktio kosini;
    
    public KosinifunktioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kosini = new Kosinifunktio();
    }
    
    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunArvoaKutsutaanEnnenArgumenttia() {
        virhe.expect(IllegalStateException.class);
        
        kosini.arvo();
    }

    @Test
    public void arvoOikeinArgumentinLisayksenJalkeen() {
        kosini.setArgumentti(new Luku(0));
        assertEquals(1, kosini.arvo(), 0.00001);
    }
}
