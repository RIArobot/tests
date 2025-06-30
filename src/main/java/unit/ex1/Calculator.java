package unit.ex1;


public class Calculator {
    private final AdvancedMath advancedMath;

    public Calculator(AdvancedMath advancedMath) {
        this.advancedMath = advancedMath;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero");
        }
        return a / b;
    }

    public double power(double base, double exponent) {
        return advancedMath.power(base, exponent);
    }

    public double squareRoot(double number) {
        return advancedMath.squareRoot(number);
    }
}
