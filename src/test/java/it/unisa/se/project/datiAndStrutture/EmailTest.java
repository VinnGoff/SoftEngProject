/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.se.project.datiAndStrutture;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author vgoff
 */
public class EmailTest {
    private String indirizzo;
    private Email mail;
    
    public EmailTest() {
    }
    
    @BeforeEach
    public void setUp() {
        indirizzo="v.goffredo@studenti.unisa.it";
        mail=new Email(indirizzo);
    }
    
    /**
     * Test of Costruttore method, of class Email.
     */
    void testCostruttore() {
        this.setUp();
        assertNotNull(mail);
    }

    /**
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        this.setUp();
        assertEquals(indirizzo, mail.toString());
    }
    
}
