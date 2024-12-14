/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 * @file RubricaControllerTest.java
 * @brief test per rubricacontroller
 * @package it.unisa.se.project.controllers
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
 * @brief classe RubricaControllerTest per testare rubrica
 * @test RubricaControllerTest
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
     * @test testInitialize di class RubricaController.
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
     * @test testHandleAggiungiContatto metodo di class RubricaController.
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
     * @test testHandleModificaContatto di class RubricaController.
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
     * @test testHandleRimuoviContatto di class RubricaController.
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
     * @test testHandleRicerca metodo di class RubricaController.
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
     * @test testHandleSalvataggio metodo di class RubricaController.
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
     * @test testHandleCaricamento metodo di class RubricaController.
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
