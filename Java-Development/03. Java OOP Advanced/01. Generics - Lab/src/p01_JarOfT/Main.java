package p01_JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> pickles = new Jar<>();

        pickles.add("Pickle 1");
        pickles.add("Pickle 2");
        pickles.add("Pickle 3");

        System.out.println(pickles.remove());
    }
}
