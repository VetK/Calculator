import org.junit.Test;
import sample.Calculator;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void calculate() {
        //Arrange
        String value = "5+3";
        String value2 = "5+3*2";
        String value3 = "(45+6)/3";

        //Act
        Calculator calc = new Calculator();
        double actual = calc.calculate(value);
        double actual2 = calc.calculate(value2);
        double actual3 = calc.calculate(value3);

        double expected = 8;
        double expected2 = 11;
        double expected3 = 17;

        //Assert
        assertEquals(expected, actual);
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }
}