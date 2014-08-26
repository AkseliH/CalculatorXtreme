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

public class PotenssiTest {
    
    Potenssi potenssi;
    
    public PotenssiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        potenssi = new Potenssi();
    }
    
    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunArvoaKysytaanEnnenLaskettavia() {
        virhe.expect(IllegalStateException.class);
        
        potenssi.arvo();
    }

    @Test
    public void prioriteettiOikea() {
        assertEquals(3, potenssi.getPrioriteetti());
    }

    @Test
    public void arvoOikeinArvollistenLisayksenJalkeen() {
        potenssi.setEtujasen(new Luku(3));
        potenssi.setTakajasen(new Luku(2));
        assertEquals(9, potenssi.arvo(), 0.00001);
    }
}
