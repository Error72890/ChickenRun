package Model;

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
        short[] expResult = {
            1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,
            8,0,10,10,10,10,10,10,9,10,10,10,10,10,10,10,10,0,4,
            8,10,9,9,9,9,9,10,9,10,9,9,9,9,9,9,9,10,4,
            8,10,10,9,10,10,9,10,9,10,9,10,10,10,10,10,9,10,4,
            8,9,10,10,10,10,10,10,10,10,9,10,9,9,9,10,9,10,4,
            8,9,9,9,9,9,9,9,9,10,10,10,10,10,9,10,9,10,4,
            8,10,10,10,9,10,10,10,10,10,9,9,9,10,9,10,10,10,4,
            8,10,9,10,10,10,9,9,9,10,10,10,10,10,10,10,9,10,4,
            8,10,10,10,9,10,10,10,9,9,9,10,9,9,9,9,9,10,4,
            8,9,9,9,9,9,9,10,10,0,9,10,10,10,10,10,10,10,4,
            8,10,10,10,10,10,9,10,9,10,10,10,9,9,9,9,10,9,4,
            8,10,9,10,9,10,10,10,9,10,9,9,9,10,10,10,10,10,4,
            8,10,9,10,9,9,9,10,9,10,9,10,10,10,9,9,9,10,4,
            8,10,9,10,9,10,10,10,9,10,10,10,9,10,10,10,9,10,4,
            8,10,9,10,9,10,9,10,9,9,9,9,9,10,9,10,9,10,4,
            8,10,9,10,10,10,9,10,10,10,10,10,10,10,9,10,9,10,4,
            8,10,9,9,9,9,9,10,9,9,9,9,9,10,9,10,9,10,4,
            8,0,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,4,
            7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,5,
        };
        short[] result = instance.getNewLabyrinth();
        assertEquals(expResult.length, result.length);
    }

    /**
     * Test of getPrefabLabyrinth method, of class LabyrinthGenerator.
     */
    @Test
    public void testGetPrefabLabyrinth() {
        System.out.println("getPrefabLabyrinth");
        LabyrinthGenerator instance = new LabyrinthGenerator();
        short[] expResult = {
            1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3,
            8,0,10,10,10,10,10,10,9,10,10,10,10,10,10,10,10,0,4,
            8,10,9,9,9,9,9,10,9,10,9,9,9,9,9,9,9,10,4,
            8,10,10,9,10,10,9,10,9,10,9,10,10,10,10,10,9,10,4,
            8,9,10,10,10,10,10,10,10,10,9,10,9,9,9,10,9,10,4,
            8,9,9,9,9,9,9,9,9,10,10,10,10,10,9,10,9,10,4,
            8,10,10,10,9,10,10,10,10,10,9,9,9,10,9,10,10,10,4,
            8,10,9,10,10,10,9,9,9,10,10,10,10,10,10,10,9,10,4,
            8,10,10,10,9,10,10,10,9,9,9,10,9,9,9,9,9,10,4,
            8,9,9,9,9,9,9,10,10,0,9,10,10,10,10,10,10,10,4,
            8,10,10,10,10,10,9,10,9,10,10,10,9,9,9,9,10,9,4,
            8,10,9,10,9,10,10,10,9,10,9,9,9,10,10,10,10,10,4,
            8,10,9,10,9,9,9,10,9,10,9,10,10,10,9,9,9,10,4,
            8,10,9,10,9,10,10,10,9,10,10,10,9,10,10,10,9,10,4,
            8,10,9,10,9,10,9,10,9,9,9,9,9,10,9,10,9,10,4,
            8,10,9,10,10,10,9,10,10,10,10,10,10,10,9,10,9,10,4,
            8,10,9,9,9,9,9,10,9,9,9,9,9,10,9,10,9,10,4,
            8,0,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,0,4,
            7,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,6,5,
        };
        short[] result = instance.getPrefabLabyrinth();
        assertArrayEquals(expResult, result);
    }
    
}
