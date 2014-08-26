package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskutoimitusTehdasTest {
    
    LaskutoimitusTehdas tehdas;
    
    public LaskutoimitusTehdasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tehdas = new LaskutoimitusTehdas();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void olemattomallaPalauttaaNull() {
        assertTrue(tehdas.hae("a") == null);
    }
    
    @Test
    public void palauttaaPlussan() {
        assertFalse(tehdas.hae("+") == null);
    }
    
    @Test
    public void palauttaaMiinuksen() {
        assertFalse(tehdas.hae("-") == null);
    }
    
    @Test
    public void palauttaaKertolaskun() {
        assertFalse(tehdas.hae("*") == null);
    }
    
    @Test
    public void palauttaaJakolaskun() {
        assertFalse(tehdas.hae("/") == null);
    }
    
    @Test
    public void palauttaaPotenssin() {
        assertFalse(tehdas.hae("'") == null);
    }
}
