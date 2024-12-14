/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.se.project.datiAndStrutture;

import java.util.List;
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
public class RubricaTest {
    
    public RubricaTest() {
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
     * Test of aggiungiContatto method, of class Rubrica.
     */
    @Test
    public void testAggiungiContatto() {
        System.out.println("aggiungiContatto");
        Contatto contatto = null;
        Rubrica instance = new Rubrica();
        instance.aggiungiContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rimuoviContatto method, of class Rubrica.
     */
    @Test
    public void testRimuoviContatto() {
        System.out.println("rimuoviContatto");
        Contatto contatto = null;
        Rubrica instance = new Rubrica();
        instance.rimuoviContatto(contatto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cercaContatto method, of class Rubrica.
     */
    @Test
    public void testCercaContatto() {
        System.out.println("cercaContatto");
        String query = "";
        Rubrica instance = new Rubrica();
        List<Contatto> expResult = null;
        List<Contatto> result = instance.cercaContatto(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ordinaContatti method, of class Rubrica.
     */
    @Test
    public void testOrdinaContatti() {
        System.out.println("ordinaContatti");
        Rubrica instance = new Rubrica();
        List<Contatto> expResult = null;
        List<Contatto> result = instance.ordinaContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of salvaFile method, of class Rubrica.
     */
    @Test
    public void testSalvaFile() throws Exception {
        System.out.println("salvaFile");
        String percorso = "";
        Rubrica instance = new Rubrica();
        instance.salvaFile(percorso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caricaFile method, of class Rubrica.
     */
    @Test
    public void testCaricaFile() throws Exception {
        System.out.println("caricaFile");
        String percorso = "";
        Rubrica instance = new Rubrica();
        instance.caricaFile(percorso);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContatti method, of class Rubrica.
     */
    @Test
    public void testGetContatti() {
        System.out.println("getContatti");
        Rubrica instance = new Rubrica();
        List<Contatto> expResult = null;
        List<Contatto> result = instance.getContatti();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
