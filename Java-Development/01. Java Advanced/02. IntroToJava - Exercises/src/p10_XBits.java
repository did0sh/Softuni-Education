import java.util.Scanner;

public class p10_XBits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] binaryNumbers = new String[8];
        for (int i = 0; i < 8; i++) {
            int bit = Integer.parseInt(scan.nextLine());
            String binaryBit = String.format("%32s", Integer.toBinaryString(bit)).replace(' ', '0');
            binaryNumbers[i] = binaryBit;
        }

        int counter = 0;
        for (int row = 0; row < binaryNumbers.length - 2; row++) {
            for (int col = 0; col < binaryNumbers[row].length() - 2; col++) {
                String a =  "" + binaryNumbers[row].charAt(col) + binaryNumbers[row].charAt(col+1) + binaryNumbers[row].charAt(col+2);
                String b = "" + binaryNumbers[row+1].charAt(col) + binaryNumbers[row+1].charAt(col+1) + binaryNumbers[row+1].charAt(col+2);
                String c = "" + binaryNumbers[row+2].charAt(col) + binaryNumbers[row+2].charAt(col+1) + binaryNumbers[row+2].charAt(col+2);

                if (a.equals("101") && b.equals("010") && c.equals("101")){
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
