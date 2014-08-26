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

public class MiinusTest {
    
    Miinus miinus;
    
    public MiinusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        miinus = new Miinus();
    }
    
    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunArvoaKysytaanEnnenLaskettavia() {
        virhe.expect(IllegalStateException.class);
        
        miinus.arvo();
    }
    
    @Test
    public void prioriteettiOikea() {
        assertEquals(1, miinus.getPrioriteetti());
    }

    @Test
    public void arvoOikeinArvollistenLisayksenJalkeen() {
        miinus.setEtujasen(new Luku(1));
        miinus.setTakajasen(new Luku(2));
        assertEquals(-1, miinus.arvo(), 0.00001);
    }
}
