/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import model.LabyrinthGenerator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LabyrinthGeneratorTest {
    
    public LabyrinthGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNewLabyrinth method, of class LabyrinthGenerator.
     */
    @Test
    public void testGetNewLabyrinth() {
        System.out.println("getNewLabyrinth");
        LabyrinthGenerator instance = new LabyrinthGenerator();
        short[] expResult = null;
        short[] result = instance.getNewLabyrinth();
        assertEquals(expResult.length, result.length);
    }
    
}
