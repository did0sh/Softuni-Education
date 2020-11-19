public class RectangleOf10x10Stars {
    public static void main(String[] args) {

        for (int i = 0; i < 10 ; i++) {
            System.out.println(repeatString("*", 10));
        }
    }

    private static String repeatString (String symbol , int count){
        String result = "";

        for (int j=0; j < count; j++){
            result += symbol;
        }
        return result;
    }
}
