package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FunktioTehdasTest {
    
    FunktioTehdas tehdas;
    
    public FunktioTehdasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tehdas = new FunktioTehdas();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void olemattomallaPalauttaaNull() {
        assertTrue(tehdas.hae("hahahaa") == null);
    }
    
    @Test
    public void palauttaaSinin() {
        assertFalse(tehdas.hae("sin") == null);
    }
    
    @Test
    public void palauttaaKosinin() {
        assertFalse(tehdas.hae("cos") == null);
    }
}
