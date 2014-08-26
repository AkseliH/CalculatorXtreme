package laskin.calculatorxtreme.sovelluslogiikka.merkkijononkasittely;

import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Luku;
import laskin.calculatorxtreme.sovelluslogiikka.kirjasto.ToimintoKirjasto;
import laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka.Lauseke;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

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
        kirjasto = new ToimintoKirjasto();
        kasittelija = new LaskutoimituksenKasittelija(kirjasto);
    }
    
    @After
    public void tearDown() {
    }
    
    @Rule
    public ExpectedException virhe = ExpectedException.none();
    
    @Test
    public void illegalStateExceptionKunAloituspaikkaUlkopuolella() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("1+2");
        kasittelija.setPaikka(10);
        kasittelija.lueLaskutoimitus();
    }
    
    @Test
    public void illegalStateExceptionKunAloitusPaikallaEiLaskutoimitusta() {
        virhe.expect(IllegalStateException.class);
        
        kasittelija.setSyote("12");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
    }
    
    @Test
    public void paikkaOikeinLukemisenJalkeen() {
        Lauseke lauseke = kasittelija.getLauseke();
        lauseke.lisaaArvollinen(new Luku(1));
        
        kasittelija.setSyote("1*3");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
        
        assertEquals(2, kasittelija.getPaikka());
    }

    @Test
    public void lukeePlussanOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        
        lauseke.lisaaArvollinen(new Luku(1));
        kasittelija.setSyote("1+2");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
        lauseke.lisaaArvollinen(new Luku(2));
        lauseke.suljeLohko();
        
        assertEquals(3, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeMiinuksenOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        
        lauseke.lisaaArvollinen(new Luku(5));
        kasittelija.setSyote("5-7");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
        lauseke.lisaaArvollinen(new Luku(7));
        lauseke.suljeLohko();
        
        assertEquals(-2, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeKertolaskunOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        
        lauseke.lisaaArvollinen(new Luku(2));
        kasittelija.setSyote("2*0.5");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
        lauseke.lisaaArvollinen(new Luku(0.5));
        lauseke.suljeLohko();
        
        assertEquals(1, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void lukeeJakolaskunOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        
        lauseke.lisaaArvollinen(new Luku(2));
        kasittelija.setSyote("2/4");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
        lauseke.lisaaArvollinen(new Luku(4));
        lauseke.suljeLohko();
        
        assertEquals(0.5, kasittelija.getLauseke().arvo(), 0.00001);
    }
    
    @Test
    public void lukeePotenssinOikein() {
        Lauseke lauseke = kasittelija.getLauseke();
        
        lauseke.lisaaArvollinen(new Luku(2));
        kasittelija.setSyote("2'3");
        kasittelija.setPaikka(1);
        kasittelija.lueLaskutoimitus();
        lauseke.lisaaArvollinen(new Luku(3));
        lauseke.suljeLohko();
        
        assertEquals(8, kasittelija.getLauseke().arvo(), 0.00001);
    }
}
