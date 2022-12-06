/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import model.Fox;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FoxTest {
    
    public FoxTest() {
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
     * Test of resetCellPos method, of class Fox.
     */
    @Test
    public void testResetCellPos() {
        System.out.println("resetCellPos");
        Fox instance = new Fox(1, 1, 16);
        instance.resetCellPos(16);
        assertEquals(16, instance.getCellPosX());
    }

    /**
     * Test of resetDir method, of class Fox.
     */
    @Test
    public void testResetDir() {
        System.out.println("resetDir");
        Fox instance = new Fox(1, 1, 16);
        instance.resetDir();
        assertEquals(0, instance.getDirX());
    }
}
