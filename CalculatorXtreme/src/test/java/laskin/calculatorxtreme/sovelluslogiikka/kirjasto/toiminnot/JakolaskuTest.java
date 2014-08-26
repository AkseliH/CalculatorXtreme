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
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunArvoaKysytaanEnnenLaskettavia() {
        virhe.expect(IllegalStateException.class);
        
        jakolasku.arvo();
    }
    
    @Test
    public void illegalStateExceptionKunJakajaNollaJaKysytaanArvoa() {
        virhe.expect(IllegalStateException.class);
        
        jakolasku.setEtujasen(new Luku(1));
        jakolasku.setTakajasen(new Luku(0));
        jakolasku.arvo();
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
