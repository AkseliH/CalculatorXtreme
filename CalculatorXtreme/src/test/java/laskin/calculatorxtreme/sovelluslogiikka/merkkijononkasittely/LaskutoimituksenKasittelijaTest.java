package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaskutoimituksenKasittelijaTest {
    
    ToimintoKirjasto kirjasto;
    LaskutoimituksenKasittelija kasittelija;
    
    public LaskutoimituksenKasittelijaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kasittelija = new LaskutoimituksenKasittelija(kirjasto);
    }
    
    @After
    public void tearDown() {
    }

    
}
