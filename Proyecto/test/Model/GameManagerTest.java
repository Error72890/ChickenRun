/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Model;

import model.GameManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
     * Test of initNewLevel method, of class GameManager.
     */
    @Test
    public void testInitNewLevel() {
        System.out.println("initNewLevel");
        GameManager instance = new GameManager(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        instance.initNewLevel();
        assertEquals(0, instance.getOFoxDirX());
    }
    
    @Test
    public void testResetPlayerDirPos() {
        System.out.println("resetPlayerDirPos");
        GameManager instance = new GameManager(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        instance.resetPlayerDirPos();
        assertEquals(9*16, instance.getChickenPosX());
    }
    
}
