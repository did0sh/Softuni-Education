package P03_DependencyInversionSkeleton;

public class SubtractionStrategy implements Calculatable {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }
}
