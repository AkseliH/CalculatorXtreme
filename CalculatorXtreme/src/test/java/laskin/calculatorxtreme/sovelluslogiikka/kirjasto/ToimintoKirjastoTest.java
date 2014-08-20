package laskin.calculatorxtreme.sovelluslogiikka.kirjasto;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Laskutoimitus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ToimintoKirjastoTest {
    
    ToimintoKirjasto kirjasto;
    
    public ToimintoKirjastoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kirjasto = new ToimintoKirjasto();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void olemattomallaLaskutoimituksellaHakuPalauttaaNull() {
        assertTrue(kirjasto.haeLaskutoimitus("olematon") == null);
    }
    
    @Test
    public void oikeallaLaskutoimituksellaHakuEiPalautaNull() {
        assertFalse(kirjasto.haeLaskutoimitus("+") == null);
    }

    @Test
    public void olemattomallaFunktiollaHakuPalauttaaNull() {
        assertTrue(kirjasto.haeFunktio("olematon") == null);
    }
    
    @Test
    public void oikeallaFunktiollaHakuEiPalautaNull() {
        assertFalse(kirjasto.haeFunktio("sin") == null);
    }
}
