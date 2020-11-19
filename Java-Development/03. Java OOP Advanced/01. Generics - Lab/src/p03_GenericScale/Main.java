package p03_GenericScale;

public class Main {
    public static void main(String[] args) {
        Scale<String> stringScale = new Scale<>("a", "b");
        System.out.println(stringScale.getHeavier());

        Scale<Integer> integerScale = new Scale<>(1, 2);
        System.out.println(integerScale.getHeavier());

        Scale<Integer> integerScale2 = new Scale<>(2, 2);
        System.out.println(integerScale2.getHeavier());


    }
}
