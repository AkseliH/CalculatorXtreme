package laskin.calculatorxtreme.sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LukuTest {
    
    Luku luku;
    
    public LukuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        luku = new Luku(-7);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstruktoriAsettaaArvonOikein() {
        assertEquals(-7, luku.arvo(), 0.00001);
    }
}
