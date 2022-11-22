package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
        int newPos = 300;
        Chicken instance = new Chicken();
        instance.setPosX(newPos);
        assertEquals(300, instance.getPosX());
    }

    /**
     * Test of setPosY method, of class Chicken.
     */
    @Test
    public void testSetPosY() {
        System.out.println("setPosY");
        int newPos = 300;
        Chicken instance = new Chicken();
        instance.setPosY(newPos);
        assertEquals(300, instance.getPosY());
    }

    /**
     * Test of getPosX method, of class Chicken.
     */
    @Test
    public void testGetPosX() {
        System.out.println("getPosX");
        Chicken instance = new Chicken();
        instance.setPosX(300);
        int expResult = 300;
        int result = instance.getPosX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPosY method, of class Chicken.
     */
    @Test
    public void testGetPosY() {
        System.out.println("getPosY");
        Chicken instance = new Chicken();
        instance.setPosY(300);
        int expResult = 300;
        int result = instance.getPosY();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDirX method, of class Chicken.
     */
    @Test
    public void testSetDirX() {
        System.out.println("setDirX");
        int newDir = 1;
        Chicken instance = new Chicken();
        instance.setDirX(newDir);
        assertEquals(1, instance.getDirX());
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
        assertEquals(0, instance.getDirX());
    }

    /**
     * Test of getDirX method, of class Chicken.
     */
    @Test
    public void testGetDirX() {
        System.out.println("getDirX");
        Chicken instance = new Chicken();
        int expResult = 1;
        instance.setDirX(1);
        int result = instance.getDirX();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDirY method, of class Chicken.
     */
    @Test
    public void testGetDirY() {
        System.out.println("getDirY");
        Chicken instance = new Chicken();
        int expResult = 1;
        instance.setDirY(1);
        int result = instance.getDirY();
        assertEquals(expResult, result);
    }
    
}
