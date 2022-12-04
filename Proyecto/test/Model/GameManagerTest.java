package Model;

import java.awt.event.ActionListener;
import javax.swing.Timer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameManagerTest {
    
    public GameManagerTest() {
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
     * Test of newGame method, of class GameManager.
     */
    @Test
    public void testNewGame() {
        System.out.println("newGame");
        GameManager instance = new GameManager();
        instance.newGame();
        System.out.println("Lives: " + instance.getLives() + ", Score: " + instance.getScore());
    }

    /**
     * Test of initNewLevel method, of class GameManager.
     */
    @Test
    public void testInitNewLevel() {
        System.out.println("initNewLevel");
        GameManager instance = new GameManager();
        instance.initNewLevel();
        short[] screenData = instance.getScreenData();
        assertEquals(screenData.length, 38);
    }

    /**
     * Test of update method, of class GameManager.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        GameManager instance = new GameManager();
        instance.update();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetPlayerDirPos method, of class GameManager.
     */
    @Test
    public void testResetPlayerDirPos() {
        System.out.println("resetPlayerDirPos");
        GameManager instance = new GameManager();
        instance.resetPlayerDirPos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLives method, of class GameManager.
     */
    @Test
    public void testSetLives() {
        System.out.println("setLives");
        int amount = 0;
        GameManager instance = new GameManager();
        instance.setLives(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of decrementLives method, of class GameManager.
     */
    @Test
    public void testDecrementLives() {
        System.out.println("decrementLives");
        GameManager instance = new GameManager();
        instance.decrementLives();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLives method, of class GameManager.
     */
    @Test
    public void testGetLives() {
        System.out.println("getLives");
        GameManager instance = new GameManager();
        int expResult = 0;
        int result = instance.getLives();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setScore method, of class GameManager.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int amount = 0;
        GameManager instance = new GameManager();
        instance.setScore(amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incrementScore method, of class GameManager.
     */
    @Test
    public void testIncrementScore() {
        System.out.println("incrementScore");
        int increment = 0;
        GameManager instance = new GameManager();
        instance.incrementScore(increment);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScore method, of class GameManager.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        GameManager instance = new GameManager();
        int expResult = 0;
        int result = instance.getScore();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCatched method, of class GameManager.
     */
    @Test
    public void testIsCatched() {
        System.out.println("isCatched");
        GameManager instance = new GameManager();
        boolean expResult = false;
        boolean result = instance.isCatched();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTimer method, of class GameManager.
     */
    @Test
    public void testGetTimer() {
        System.out.println("getTimer");
        GameManager instance = new GameManager();
        Timer expResult = null;
        Timer result = instance.getTimer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getScreenData method, of class GameManager.
     */
    @Test
    public void testGetScreenData() {
        System.out.println("getScreenData");
        GameManager instance = new GameManager();
        short[] expResult = null;
        short[] result = instance.getScreenData();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCtrlDirX method, of class GameManager.
     */
    @Test
    public void testSetCtrlDirX() {
        System.out.println("setCtrlDirX");
        int newDir = 0;
        GameManager instance = new GameManager();
        instance.setCtrlDirX(newDir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCtrlDirX method, of class GameManager.
     */
    @Test
    public void testGetCtrlDirX() {
        System.out.println("getCtrlDirX");
        GameManager instance = new GameManager();
        int expResult = 0;
        int result = instance.getCtrlDirX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCtrlDirY method, of class GameManager.
     */
    @Test
    public void testSetCtrlDirY() {
        System.out.println("setCtrlDirY");
        int newDir = 0;
        GameManager instance = new GameManager();
        instance.setCtrlDirY(newDir);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCtrlDirY method, of class GameManager.
     */
    @Test
    public void testGetCtrlDirY() {
        System.out.println("getCtrlDirY");
        GameManager instance = new GameManager();
        int expResult = 0;
        int result = instance.getCtrlDirY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChickenPosX method, of class GameManager.
     */
    @Test
    public void testGetChickenPosX() {
        System.out.println("getChickenPosX");
        GameManager instance = new GameManager();
        int expResult = 0;
        int result = instance.getChickenPosX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChickenPosY method, of class GameManager.
     */
    @Test
    public void testGetChickenPosY() {
        System.out.println("getChickenPosY");
        GameManager instance = new GameManager();
        int expResult = 0;
        int result = instance.getChickenPosY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
