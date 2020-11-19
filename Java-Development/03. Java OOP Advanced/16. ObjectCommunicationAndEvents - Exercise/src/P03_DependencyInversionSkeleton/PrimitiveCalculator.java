package P03_DependencyInversionSkeleton;


public class PrimitiveCalculator {

    private boolean isAddition;
    private boolean isSubtraction;
    private boolean isMultiplication;
    private boolean isDivision;

    private AdditionStrategy additionStrategy;
    private SubtractionStrategy subtractionStrategy;
    private MultiplicationStrategy multiplicationStrategy;
    private DivisionStrategy divisionStrategy;

    public PrimitiveCalculator(){
        this.additionStrategy = new AdditionStrategy();
        this.subtractionStrategy = new SubtractionStrategy();
        this.multiplicationStrategy = new MultiplicationStrategy();
        this.divisionStrategy = new DivisionStrategy();

        this.isAddition = true;
        this.isDivision = false;
        this.isMultiplication = false;
        this.isSubtraction = false;
    }

    public void changeStrategy(char operator){
        switch (operator){
            case '+':
                this.isAddition = true;
                this.isSubtraction = false;
                this.isMultiplication = false;
                this.isDivision = false;
                break;
            case '-':
                this.isAddition = false;
                this.isSubtraction = true;
                this.isMultiplication = false;
                this.isDivision = false;
                break;
            case '*':
                this.isAddition = false;
                this.isSubtraction = false;
                this.isMultiplication = true;
                this.isDivision = false;
                break;
            case '/':
                this.isAddition = false;
                this.isSubtraction = false;
                this.isMultiplication = false;
                this.isDivision = true;
                break;
        }
    }

    public int performCalculation(int firstOperand,int secondOperand){
        if(this.isAddition){
            return additionStrategy.calculate(firstOperand,secondOperand);
        } else if (this.isSubtraction){
            return subtractionStrategy.calculate(firstOperand,secondOperand);
        } else if (this.isMultiplication){
            return multiplicationStrategy.calculate(firstOperand, secondOperand);
        } else if (this.isDivision){
            return divisionStrategy.calculate(firstOperand, secondOperand);
        }
        return 0;
    }
}
