/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package rpncalculator;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Rendszergazda
 */
public class RPNCalculatorTest {
    
    public RPNCalculatorTest() {
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
     * Test of calculate method, of class RPNCalculator.
     */
    @Test
    public void testCalculate() throws Exception {
        RPNCalculator instance = new RPNCalculator();
        Double result = null;
        result = instance.calculate("0");
        assertEquals(new Double(0), result);
        
        result = instance.calculate("0.0");
        assertEquals(new Double(0), result);
        
        result = instance.calculate("10 10 -");
        assertEquals(new Double(0), result);
        
        result = instance.calculate("10 10.0 -");
        assertEquals(new Double(0), result);
        
        result = instance.calculate("10 10 +");
        assertEquals(new Double(20), result);
        
        result = instance.calculate("19 2.14 + 4.5 2 4.3 / - *");
        assertEquals(new Double(85.29744186046511), result);
    }

    /**
     * Test of isNumber method, of class RPNCalculator.
     */
    @Test
    public void testIsNumber() {
        assertEquals(true, RPNCalculator.isNumber("0"));
        assertEquals(true, RPNCalculator.isNumber("1"));
        assertEquals(true, RPNCalculator.isNumber("10"));
        assertEquals(true, RPNCalculator.isNumber("22"));

        //assertEquals(true, RPNCalculator.isNumber("55.32"));
        //assertEquals(true, RPNCalculator.isNumber("3.14"));
        
        assertEquals(false, RPNCalculator.isNumber(""));
        assertEquals(false, RPNCalculator.isNumber("alma"));
        assertEquals(false, RPNCalculator.isNumber("0X12"));
        assertEquals(false, RPNCalculator.isNumber("0xFFFFFF"));
    }

    /**
     * Test of isOperation method, of class RPNCalculator.
     */
    @Test
    public void testIsOperation() {
        assertEquals(true, RPNCalculator.isOperation("+"));
        assertEquals(true, RPNCalculator.isOperation("-"));
        assertEquals(true, RPNCalculator.isOperation("*"));
        assertEquals(true, RPNCalculator.isOperation("/"));
        
        assertEquals(false, RPNCalculator.isOperation(""));
        assertEquals(false, RPNCalculator.isOperation("xyz"));
        assertEquals(false, RPNCalculator.isOperation("$$$"));
        assertEquals(false, RPNCalculator.isOperation("#"));
    }

}
