import java.util.Scanner;

public class p09_ByteParty {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            int bit = Integer.parseInt(scan.nextLine());
            numbers[i] = bit;
        }

        String input = scan.nextLine();
        while (true){
            if (input.equals("party over")){
                for (Integer num: numbers ) {
                    System.out.println(num);
                }
                return;
            }
            String[] tokens = input.split("\\s+");
            int command = Integer.parseInt(tokens[0]);
            int position = Integer.parseInt(tokens[1]);

            if (command == -1){
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] ^ (1 << position);
                }
            } else if (command == 0){
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] & ~(1 << position);
                }
            } else if (command == 1){
                for (int i = 0; i < numbers.length; i++) {
                    numbers[i] = numbers[i] | (1 << position);
                }
            }
            input = scan.nextLine();
        }
    }
}
