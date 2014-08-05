package laskin.calculatorxtreme.sovelluslogiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuoritusjonoTest {
    
    Suoritusjono jono;
    
    public SuoritusjonoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jono = new Suoritusjono();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void jonoTyhjaLuonninJalkeen() {
        assertTrue(jono.onTyhja());
    }
    
    @Test
    public void arvoOikeinArvollisenLisayksenJalkeen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertEquals(1, jono.arvo(), 0.0001);
    }
    
    @Test
    public void arvoOikeinLaksutoimituksenLisayksenJalkeen() {
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.lisaaJonoonLaskutoimitus(new Plus());
        jono.lisaaSeuraavaArvollinen(new Luku(1));
        jono.paataJono();
        
        assertEquals(2, jono.arvo(), 0.0001);
    }

    
}
