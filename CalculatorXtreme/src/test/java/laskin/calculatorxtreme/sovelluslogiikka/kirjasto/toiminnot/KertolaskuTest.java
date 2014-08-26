package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KertolaskuTest {
    
    Kertolasku kertolasku;
    
    public KertolaskuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kertolasku = new Kertolasku();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void prioriteettiOikea() {
        assertEquals(2, kertolasku.getPrioriteetti());
    }

    @Test
    public void arvoOikeinArvollistenLisayksenJalkeen() {
        kertolasku.setEtujasen(new Luku(6));
        kertolasku.setTakajasen(new Luku(0.2));
        assertEquals(1.2, kertolasku.arvo(), 0.00001);
    }
}
