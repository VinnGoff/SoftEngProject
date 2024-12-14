package it.unisa.se.project.datiAndStrutture;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmailTest {

    @Test
    void testCostruttore() {
        String indirizzo = "example@example.com";
        Email email = new Email(indirizzo);
        assertNotNull(email, "L'oggetto Email dovrebbe essere creato correttamente");
        assertEquals(indirizzo, email.toString(), "L'indirizzo memorizzato dovrebbe essere uguale a quello passato al costruttore");
    }

    @Test
    void testToString() {
        String indirizzo = "user@domain.com";
        Email email = new Email(indirizzo);
        assertEquals(indirizzo, email.toString(), "Il metodo toString dovrebbe restituire l'indirizzo originale");
    }
}
