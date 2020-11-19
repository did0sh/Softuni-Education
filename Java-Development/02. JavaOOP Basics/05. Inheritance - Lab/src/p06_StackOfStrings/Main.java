package p06_StackOfStrings;

public class Main {
    public static void main(String[] args) {
        StackOfStrings stack = new StackOfStrings();

        stack.push("asdddd");
        stack.push("asfopd");
        stack.push("PESHOS");
        stack.push("KOSADKO");

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());

    }
}
