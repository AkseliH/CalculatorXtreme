package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class FunktionKasittelijaTest {
    
    ToimintoKirjasto kirjasto;
    FunktionKasittelija kasittelija;
    
    public FunktionKasittelijaTest() {
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
        kasittelija = new FunktionKasittelija(kirjasto);
    }
    
    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunAloituspaikkaUlkopuolella() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("sin(0)");
        kasittelija.setPaikka(6);
        kasittelija.lueFunktio();
    }
    
    @Test
    public void illegalStateExceptionKunAloitusPaikallaEiFunktiota() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("1234");
        kasittelija.setPaikka(1);
        kasittelija.lueFunktio();
    }
    
    @Test
    public void illegalStateExceptionKunOlematonFunktio() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("hahahaa(2)");
        kasittelija.lueFunktio();
    }
    
    @Test
    public void illegalStateExceptionKunFunktiotaEiSeuraaSulku() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("sin2");
        kasittelija.lueFunktio();
    }

    @Test
    public void paikkaOikeinLukemisenJalkeen() {
        kasittelija.setSyote("sin(0)");
        kasittelija.lueFunktio();
        
        assertEquals(4, kasittelija.getPaikka());
    }
    
    @Test
    public void lukeeSininOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        kasittelija.setSyote("sin(0)");
        kasittelija.lueFunktio();
        lauseke.lisaaArvollinen(new Luku(0));
        lauseke.suljeLohko();
        lauseke.suljeLohko();
        
        assertEquals(0, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeKosininOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        kasittelija.setSyote("cos(0)");
        kasittelija.lueFunktio();
        lauseke.lisaaArvollinen(new Luku(0));
        lauseke.suljeLohko();
        lauseke.suljeLohko();
        
        assertEquals(1, kasittelija.getLauseke().arvo(), 0.00001);
    }
}
