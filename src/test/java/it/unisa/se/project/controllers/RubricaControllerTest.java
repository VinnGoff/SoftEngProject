/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.se.project.controllers;

import java.net.URL;
import java.util.ResourceBundle;
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
public class RubricaControllerTest {
    
    public RubricaControllerTest() {
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
     * Test of initialize method, of class RubricaController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        RubricaController instance = new RubricaController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleAggiungiContatto method, of class RubricaController.
     */
    @Test
    public void testHandleAggiungiContatto() {
        System.out.println("handleAggiungiContatto");
        RubricaController instance = new RubricaController();
        instance.handleAggiungiContatto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleModificaContatto method, of class RubricaController.
     */
    @Test
    public void testHandleModificaContatto() {
        System.out.println("handleModificaContatto");
        RubricaController instance = new RubricaController();
        instance.handleModificaContatto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleRimuoviContatto method, of class RubricaController.
     */
    @Test
    public void testHandleRimuoviContatto() {
        System.out.println("handleRimuoviContatto");
        RubricaController instance = new RubricaController();
        instance.handleRimuoviContatto();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleRicerca method, of class RubricaController.
     */
    @Test
    public void testHandleRicerca() {
        System.out.println("handleRicerca");
        RubricaController instance = new RubricaController();
        instance.handleRicerca();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleSalvataggio method, of class RubricaController.
     */
    @Test
    public void testHandleSalvataggio() {
        System.out.println("handleSalvataggio");
        RubricaController instance = new RubricaController();
        instance.handleSalvataggio();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleCaricamento method, of class RubricaController.
     */
    @Test
    public void testHandleCaricamento() {
        System.out.println("handleCaricamento");
        RubricaController instance = new RubricaController();
        instance.handleCaricamento();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
