package Calculator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void testEval_5_plus_322() {
        // Проверяемый метод
        assertEquals(327, Calculator.eval("5+322"),0);
    }

    @Test
    public void testEval_21_divide_42() {
        // Проверяемый метод
        assertEquals(0.5, Calculator.eval("21/42"),0);
    }

    @Test
    public void testEval_21_multiply_0() {
        // Проверяемый метод
        assertEquals(0, Calculator.eval("21*0"),0);
    }

    @Test
    public void testEval_5_multiply_5_minus_41() {
                // Проверяемый метод
        assertEquals(-16, Calculator.eval("5*5-41"),0);
    }

    @Test
    public void testEval_5_mult_opBr_5_minus_41_clBr_div_opBr_90_div_2_clBr() {
        // Проверяемый метод
        assertEquals(-4, Calculator.eval("5*(5-41)/(90/2)"),0);
    }
}
