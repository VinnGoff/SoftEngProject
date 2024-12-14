package it.unisa.se.project.datiAndStrutture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class NumeroTelTest {

    @Test
    void testCostruttore() {
        String numero = "+393401234567";
        NumeroTel numeroTel = new NumeroTel(numero);
        assertNotNull(numeroTel, "L'oggetto NumeroTel dovrebbe essere creato correttamente");
        assertEquals(numero, numeroTel.toString(), "Il numero memorizzato dovrebbe essere uguale a quello passato al costruttore");
    }

    @Test
    void testToString() {
        String numero = "3401234567";
        NumeroTel numeroTel = new NumeroTel(numero);
        assertEquals(numero, numeroTel.toString(), "Il metodo toString dovrebbe restituire il numero originale");
    }

}
