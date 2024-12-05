/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.jeu_dames;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author augustoarrojo
 */
public class JoueurTest {

    private Joueur joueur;
    private TableauDeJeu mockTableau;

    public JoueurTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        TableauDeJeu mockTableau = new TableauDeJeu();  // Assuming a constructor that works without arguments or mock it
        this.joueur = new Joueur("Player 1", true, mockTableau);  // Initialize the Joueur object with proper arguments
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getNom method, of class Joueur.
     */
    @Test
    public void testGetNom() {
        assertEquals("Player 1", joueur.getNom());  // Test the name getter
    }

    /**
     * Test of isCouleur method, of class Joueur.
     */
    @Test
    public void testIsCouleur() {
        assertTrue(joueur.isCouleur(), "Le couleur du joueur doit être noir");  // True represents black player (assuming)
    }

    /**
     * Test of getPartie method, of class Joueur.
     */
    @Test
    public void testGetPartie() {
        assertNotNull(joueur.getPartie());  // Ensure that the game board is not null
        assertTrue(joueur.getPartie() instanceof TableauDeJeu);  // Ensure it's an instance of TableauDeJeu
    }

    /**
     * Test of tourDeJeu method, of class Joueur.
     */
    @Test
    public void testTourDeJeu() {
        System.out.println("tourDeJeu");
        Joueur instance = new Joueur("Player 1", true, new TableauDeJeu());
        instance.tourDeJeu();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirPosX method, of class Joueur.
     */
    @Test
    public void testConvertirPosX() {
        assertEquals(0, joueur.convertirPosX('A')); // Example test case
    }

    /**
     * Test of getCordonneesValides method, of class Joueur.
     */
    @Test
    public void testGetCordonneesValides_ValidInputs() {
        // Simulate valid user input: Column 'B' and Row '2'
        String simulatedInput = "B\n2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Joueur joueur = new Joueur("Player", true, new TableauDeJeu());  // Assuming the constructor works

        // Calling the method
        int[] result = joueur.getCordonneesValides();

        // Assert the result
        assertEquals(1, result[0]);  // Column 'B' should be converted to 1
        assertEquals(2, result[1]);  // Row '2' should be 2
    }

    @Test
    public void testGetCordonneesValides_InvalidColumn() {
        // Simulate invalid column 'Z' followed by a valid column 'C'
        String simulatedInput = "Z\nC\n2\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Joueur joueur = new Joueur("Player", true, new TableauDeJeu());

        // Calling the method
        int[] result = joueur.getCordonneesValides();

        // Assert the result
        assertEquals(2, result[0]);  // Column 'C' should be converted to 2
        assertEquals(2, result[1]);  // Row '2' should be 2
    }

    @Test
    public void testGetCordonneesValides_InvalidRow() {
        // Simulate valid column 'A' and invalid row '11', followed by a valid row '5'
        String simulatedInput = "A\n11\n5\n";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        Joueur joueur = new Joueur("Player", true, new TableauDeJeu());

        // Calling the method
        int[] result = joueur.getCordonneesValides();

        // Assert the result
        assertEquals(0, result[0]);  // Column 'A' should be converted to 0
        assertEquals(5, result[1]);  // Row '5' should be 5
    }

    /**
     * Test of estCoordonneeVide method, of class Joueur.
     */
    @Test
    public void testEstCoordonneeVide() {
        // Set up some mock peons
        ArrayList<Peon> mesPeons = new ArrayList<>();
        ArrayList<Peon> adversairesPeons = new ArrayList<>();
        Peon peon1 = new Peon(0, 0, true, mockTableau); // Assuming a constructor that sets the position
        Peon peon2 = new Peon(1, 1, false, mockTableau);
        mesPeons.add(peon1);
        adversairesPeons.add(peon2);

        //Test the method
        boolean result = joueur.estCoordonneeVide(0, 0, mesPeons, adversairesPeons);
        assertFalse(result); // It should return false since (0,0) is occupied by one of the player's peons
    }
}
