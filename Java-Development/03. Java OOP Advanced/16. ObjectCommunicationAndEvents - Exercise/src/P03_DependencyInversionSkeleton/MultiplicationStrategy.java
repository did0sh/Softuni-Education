package P03_DependencyInversionSkeleton;

public class MultiplicationStrategy implements Calculatable {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }
}
