package P01_ExtendedArrayList;

public class Main {
    public static void main(String[] args) {
        ExtendedArrayList<Integer> myList = new ExtendedArrayList<Integer>(){{
            add(1);
            add(10);
            add(15);
            add(4);
        }};

        System.out.println(myList.min());
        System.out.println(myList.max());
    }
}
