package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PlusTest {
    
    Plus plus;
    
    public PlusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        plus = new Plus();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void laskettavatAsetettuAsettamisenJalkeen() {
        plus.setEtujasen(new Luku(1));
        plus.setTakajasen(new Luku(2));
        
        assertTrue(plus.laskettavatAsetettu());
    }

    @Test
    public void arvoOikeinArvollistenLisayksenJalkeen() {
        plus.setEtujasen(new Luku(1));
        plus.setTakajasen(new Luku(2));
        
        assertEquals(3, plus.arvo(), 0.00001);
    }
}
