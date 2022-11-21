/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Carlo
 */
public class ChickenTest {
    
    public ChickenTest() {
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
     * Test of setPosX method, of class Chicken.
     */
    @Test
    public void testSetPosX() {
        System.out.println("setPosX");
        int newPos = 0;
        Chicken instance = new Chicken();
        instance.setPosX(newPos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosY method, of class Chicken.
     */
    @Test
    public void testSetPosY() {
        System.out.println("setPosY");
        int newPos = 0;
        Chicken instance = new Chicken();
        instance.setPosY(newPos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosX method, of class Chicken.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        Chicken instance = new Chicken();
        int expResult = 0;
        int result = instance.getPosX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosY method, of class Chicken.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        Chicken instance = new Chicken();
        int expResult = 0;
        int result = instance.getPosY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirX method, of class Chicken.
     */
    @Test
    public void testSetDirX() {
        System.out.println("setDirX");
        int newDir = 0;
        Chicken instance = new Chicken();
        instance.setDirX(newDir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDirY method, of class Chicken.
     */
    @Test
    public void testSetDirY() {
        System.out.println("setDirY");
        int newDir = 0;
        Chicken instance = new Chicken();
        instance.setDirY(newDir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirX method, of class Chicken.
     */
    @Test
    public void testGetDirX() {
        System.out.println("getDirX");
        Chicken instance = new Chicken();
        int expResult = 0;
        int result = instance.getDirX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirY method, of class Chicken.
     */
    @Test
    public void testGetDirY() {
        System.out.println("getDirY");
        Chicken instance = new Chicken();
        int expResult = 0;
        int result = instance.getDirY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
