package p05_RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList randomArrayList = new RandomArrayList();
        randomArrayList.add(12);
        randomArrayList.add(52);
        randomArrayList.add(105);
        randomArrayList.add(44);

        System.out.println(randomArrayList.getRandomElement());
    }
}
