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
public class NumeroTelTest {
    private String numero;
    private NumeroTel num;
    
    public NumeroTelTest() {
    }
    
    @BeforeEach
    public void setUp() {
        numero="383383838";
        num=new NumeroTel(numero);
    }

    /**
    * Test of Costruttore method, of class Email.
    */
    void testCostruttore() {
        this.setUp();
        assertNotNull(num);
    }

    /**
     * Test of toString method, of class Email.
     */
    @Test
    public void testToString() {
        this.setUp();
        assertEquals(numero, num.toString());
    }
    
}
