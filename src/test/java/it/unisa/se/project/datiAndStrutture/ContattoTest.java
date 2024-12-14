/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.se.project.datiAndStrutture;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

public class ContattoTest {

    private Contatto contatto1;
    private Contatto contatto2;
    private Contatto contatto3;
    private NumeroTel num1;
    private NumeroTel num2;
    private NumeroTel num3;
    private Email email1;
    private Email email2;
    private Email email3;
    
    public ContattoTest(){
        
    }

    @BeforeEach
    public void setUp() {
        // Inizializza oggetti per il test
        num1 = new NumeroTel("123456789");
        num2 = new NumeroTel("987654321");
        num3 = new NumeroTel("555555555");
        email1 = new Email("email1@example.com");
        email2 = new Email("email2@example.com");
        email3 = new Email("email3@example.com");

        // Crea contatti
        contatto1 = new Contatto("Mario", "Rossi", num1, num2, num3, email1, email2, email3);
        contatto2 = new Contatto("Giuseppe", "Verdi", num1, num2, num3, email1, email2, email3);
        contatto3 = new Contatto("Mario", "Rossi", num1, num2, num3, email1, email2, email3);
    }
    
    @Test
    public void testCostruttore() {
        assertNotNull(contatto1);
        assertEquals("Mario", contatto1.getNome());
        assertEquals("Rossi", contatto1.getCognome());
        assertEquals(3, contatto1.getNumeriTel().size());
        assertEquals(3, contatto1.getIndirizziEmail().size());
    }

    @Test
    public void testSetNome() {
        this.setUp();
        contatto3.setNome("Luca");
        assertEquals("Luca", contatto3.getNome());
    }

    @Test
    public void testSetCognome() {
        this.setUp();
        contatto3.setCognome("Bianchi");
        assertEquals("Bianchi", contatto3.getCognome());
    }

    @Test
    public void testGetNumeriTel() {
        this.setUp();
        ArrayList<NumeroTel> numeri = contatto1.getNumeriTel();
        assertEquals(3, numeri.size());
        assertTrue(numeri.contains(num1));
    }

    @Test
    public void testGetIndirizziEmail() {
        this.setUp();
        ArrayList<Email> emails = contatto1.getIndirizziEmail();
        assertEquals(3, emails.size());
        assertTrue(emails.contains(email1));
    }

    @Test
    public void testToString() {
        this.setUp();
        String expected = "Nome: Mario\nCognome: Rossi\nNumeri di telefono: [123456789, 987654321, 555555555]\nIndirizzi e-mail: [email1@example.com, email2@example.com, email3@example.com]";
        assertEquals(expected, contatto1.toString());
    }

    @Test
    public void testCompareToSameNameAndSurname() {
        this.setUp();
        // Contatto con lo stesso nome e cognome
        int result = contatto1.compareTo(contatto3);
        assertEquals(0, result);
    }

    @Test
    public void testCompareToDifferentCognome() {
        this.setUp();
        // Contatto con un cognome diverso
        int result = contatto1.compareTo(contatto2);
        assertTrue(result < 0); // "Verdi" viene dopo "Rossi" in ordine alfabetico
    }

    @Test
    public void testCompareToDifferentNome() {
        this.setUp();
        // Contatto con lo stesso cognome ma nome diverso
        contatto2.setCognome("Rossi");
        contatto2.setNome("Giuseppe");
        int result = contatto1.compareTo(contatto2);
        assertTrue(result > 0); // "Giuseppe" viene prima di "Mario" in ordine alfabetico
    }
}