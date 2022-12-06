/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Util;

import util.CSVWriteReader;
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
public class CSVWriteReaderTest {
    
    public CSVWriteReaderTest() {
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
     * Test of readFrom method, of class CSVWriteReader.
     */
    @Test
    public void testReadFrom() {
        System.out.println("readFrom");
        String path = "test/Prueba.txt";
        CSVWriteReader instance = CSVWriteReader.getInstance();
        String[][] expResult = new String[2][2];
        expResult[0][0] = "a";
        expResult[0][1] = "1";
        expResult[1][0] = "b";
        expResult[1][1] = "2";
        String[][] result = instance.readFrom(path);
        String[][] recortedResult = new String[2][2];
        recortedResult[0][0] = result[0][0];
        recortedResult[0][1] = result[0][1];
        recortedResult[1][0] = result[1][0];
        recortedResult[1][1] = result[1][1];
        assertArrayEquals(expResult, recortedResult);
    }

    /**
     * Test of writeTo method, of class CSVWriteReader.
     */
    @Test
    public void testWriteTo() {
        System.out.println("writeTo");
        String path = "test/Prueba.txt";
        String[][] msg = new String[2][2];
        msg[0][0] = "a";
        msg[0][1] = "1";
        msg[1][0] = "b";
        msg[1][1] = "2";
        CSVWriteReader instance = CSVWriteReader.getInstance();
        instance.writeTo(path, msg);
    }
}
