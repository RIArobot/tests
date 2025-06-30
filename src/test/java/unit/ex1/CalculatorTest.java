package unit.ex1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CalculatorTest {
    private Calculator calculator;
    private AdvancedMath advancedMathMock;

    @BeforeEach
    void setUp() {
        advancedMathMock = mock(AdvancedMath.class);
        calculator = new Calculator(advancedMathMock);
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 5",
            "0, 0, 0",
            "-1, 1, 0",
            "2.5, 3.5, 6.0"
    })
    void testAdd(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), 0.0001);
    }

    @Test
    void testDivideByZero() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void testPowerDelegatesToAdvancedMath() {
        when(advancedMathMock.power(2, 3)).thenReturn(8.0);
        assertEquals(8.0, calculator.power(2, 3), 0.0001);
        verify(advancedMathMock).power(2, 3);
    }
}
