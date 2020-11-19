package p01_OverloadMethod;

public class MathOperation {
    public int add(int firstInteger, int secondInteger){
        return firstInteger + secondInteger;
    }

    public int add(int firstInteger, int secondInteger, int thirdInteger){
        return firstInteger + secondInteger + thirdInteger;
    }

    public int add(int firstInteger, int secondInteger, int thirdInteger, int fourthInteger){
        return firstInteger + secondInteger + thirdInteger + fourthInteger;
    }

}
