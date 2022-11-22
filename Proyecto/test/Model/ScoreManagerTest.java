package Model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ScoreManagerTest {
    
    public ScoreManagerTest() {
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
     * Test of getScores method, of class ScoreManager.
     */
    @Test
    public void testGetScores() {
        System.out.println("getScores");
        ScoreManager instance = new ScoreManager();
        String[][] expResult = new String[5][2];
        expResult[0][0] = "CHA";
        expResult[0][1] = "2300";
        expResult[1][0] = "ALE";
        expResult[1][1] = "2000";
        expResult[2][0] = "PRT";
        expResult[2][1] = "1500";
        expResult[3][0] = "ELO";
        expResult[3][1] = "1000";
        expResult[4][0] = "GRA";
        expResult[4][1] = "500";
        String[][] result = instance.getScores();
        assertArrayEquals(expResult, result);
    }
    
}
