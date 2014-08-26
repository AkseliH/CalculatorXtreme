package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void arvoOikeinArgumentinLisayksenJalkeen() {
        kosini.setArgumentti(new Luku(0));
        assertEquals(1, kosini.arvo(), 0.00001);
    }
}
