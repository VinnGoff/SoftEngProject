/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.se.project.datiAndStrutture;

import java.util.ArrayList;
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
public class ContattoTest {
    
    public ContattoTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNome method, of class Contatto.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCognome method, of class Contatto.
     */
    @Test
    public void testGetCognome() {
        System.out.println("getCognome");
        Contatto instance = null;
        String expResult = "";
        String result = instance.getCognome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class Contatto.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        Contatto instance = null;
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCognome method, of class Contatto.
     */
    @Test
    public void testSetCognome() {
        System.out.println("setCognome");
        String cognome = "";
        Contatto instance = null;
        instance.setCognome(cognome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiNumeroTel method, of class Contatto.
     */
    @Test
    public void testAggiungiNumeroTel() {
        System.out.println("aggiungiNumeroTel");
        NumeroTel numero = null;
        Contatto instance = null;
        instance.aggiungiNumeroTel(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of aggiungiEmail method, of class Contatto.
     */
    @Test
    public void testAggiungiEmail() {
        System.out.println("aggiungiEmail");
        Email email = null;
        Contatto instance = null;
        instance.aggiungiEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviNumeroTel method, of class Contatto.
     */
    @Test
    public void testRimuoviNumeroTel() {
        System.out.println("rimuoviNumeroTel");
        NumeroTel numero = null;
        Contatto instance = null;
        instance.rimuoviNumeroTel(numero);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviEmail method, of class Contatto.
     */
    @Test
    public void testRimuoviEmail() {
        System.out.println("rimuoviEmail");
        Email email = null;
        Contatto instance = null;
        instance.rimuoviEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNumeriTel method, of class Contatto.
     */
    @Test
    public void testGetNumeriTel() {
        System.out.println("getNumeriTel");
        Contatto instance = null;
        ArrayList<NumeroTel> expResult = null;
        ArrayList<NumeroTel> result = instance.getNumeriTel();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIndirizziEmail method, of class Contatto.
     */
    @Test
    public void testGetIndirizziEmail() {
        System.out.println("getIndirizziEmail");
        Contatto instance = null;
        ArrayList<Email> expResult = null;
        ArrayList<Email> result = instance.getIndirizziEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Contatto.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Contatto instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of compareTo method, of class Contatto.
     */
    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Contatto c = null;
        Contatto instance = null;
        int expResult = 0;
        int result = instance.compareTo(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
