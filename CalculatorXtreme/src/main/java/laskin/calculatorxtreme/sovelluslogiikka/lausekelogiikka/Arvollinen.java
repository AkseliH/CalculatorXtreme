package laskin.calculatorxtreme.sovelluslogiikka.lausekelogiikka;

/**
 * Rajapinta, joka tarjoaa mahdollisuuden kysya double tyyppista arvoa.
 */
public interface Arvollinen {
    double arvo() throws IllegalStateException;
}
