package P03_DependencyInversionSkeleton;

public class DivisionStrategy implements Calculatable {
    @Override
    public int calculate(int firstOperand, int secondOperand) {
        return firstOperand / secondOperand;
    }
}
