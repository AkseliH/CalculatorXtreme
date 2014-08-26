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
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunArvoaKysytaanEnnenLaskettavia() {
        virhe.expect(IllegalStateException.class);
        
        plus.arvo();
    }
    
    @Test
    public void laskettavatAsetettuAsettamisenJalkeen() {
        plus.setEtujasen(new Luku(1));
        plus.setTakajasen(new Luku(2));
        
        assertTrue(plus.laskettavatAsetettu());
    }

    @Test
    public void prioriteettiOikea() {
        assertEquals(1, plus.getPrioriteetti());
    }
    
    @Test
    public void arvoOikeinArvollistenLisayksenJalkeen() {
        plus.setEtujasen(new Luku(1));
        plus.setTakajasen(new Luku(2));
        
        assertEquals(3, plus.arvo(), 0.00001);
    }
}
