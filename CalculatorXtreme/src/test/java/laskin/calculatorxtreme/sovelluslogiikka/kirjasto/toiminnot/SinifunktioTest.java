package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SinifunktioTest {
    
    Sinifunktio sin;
    
    public SinifunktioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        sin = new Sinifunktio();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void argumenttiAsetettuAsettamisenJalkeen() {
        sin.setArgumentti(new Luku(1));
        
        assertTrue(sin.argumenttiAsetettu());
    }
    
    @Test
    public void arvoOikeinArgumentinLisayksenJalkeen() {
        sin.setArgumentti(new Luku(Math.PI/2));
        
        assertEquals(1, sin.arvo(), 0.00001);
    }
}
