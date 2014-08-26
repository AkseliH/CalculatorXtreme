package laskin.calculatorxtreme.sovelluslogiikka.kirjasto.toiminnot;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class JakolaskuTest {
    
    Jakolasku jakolasku;
    
    public JakolaskuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jakolasku = new Jakolasku();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void prioriteettiOikea() {
        assertEquals(2, jakolasku.getPrioriteetti());
    }

    @Test
    public void arvoOikeinArvollistenLisayksenJalkeen() {
        jakolasku.setEtujasen(new Luku(7));
        jakolasku.setTakajasen(new Luku(2));
        assertEquals(3.5, jakolasku.arvo(), 0.00001);
    }
}
