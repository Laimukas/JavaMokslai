package math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    @Test
    void testAdd_validTwoNumbers_validNumber(){
       int suma = Calculator.add(5,5);
        assertEquals(10,suma);
    }
    @Test
    void testMinus_integerNumbers_substrictionResult(){
        int skirtumas = Calculator.minus(20,4);
        assertEquals(16,skirtumas);
    }
    @Test
    void testDivision_numberZero_arithmeticException(){
        ArithmeticException arithmeticException =
        assertThrows(ArithmeticException.class,()->Calculator.division(10,0));

        assertEquals("/ by zero", arithmeticException.getMessage());
    }
    @Test
    void testDivision_validNumbers_validDivision(){
        assertEquals(2, Calculator.division(10,5));
    }
    @Test
    void testMultiple_validNumbers_validResult(){
        assertEquals(10, Calculator.multiple(2,5));
    }
}
