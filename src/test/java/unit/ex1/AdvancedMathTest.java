package unit.ex1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedMathTest {
    @ParameterizedTest
    @CsvSource({
            "2, 3, 8",
            "0, 0, 1",
            "1, 100, 1",
            "2.5, 3, 15.625"
    })
    void testPower(double a, double b, double c) {
        AdvancedMath math = new AdvancedMathImpl();
        assertEquals(c, math.power(a, b), 0.0001);
    }

    @Test
    void testSquareRoot() {
        AdvancedMath math = new AdvancedMathImpl();
        assertEquals(4.0, math.squareRoot(16), 0.0001);
    }

}