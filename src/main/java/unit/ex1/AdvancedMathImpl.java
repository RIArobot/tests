package unit.ex1;

class AdvancedMathImpl implements AdvancedMath {
    @Override
    public double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    @Override
    public double squareRoot(double number) {
        return Math.sqrt(number);
    }
}
