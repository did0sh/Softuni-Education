public class p01 {
    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            System.out.printf("%s%n", repeatStr("*", 10));
        }
    }
    private static String repeatStr (String symbol, int count){
        String result = "";

        for (int i = 0; i < count ; i++) {
            result += symbol;
        }
        return result;
    }
}
