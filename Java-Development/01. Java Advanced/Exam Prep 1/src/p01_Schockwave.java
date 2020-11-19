import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Schockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsColumns = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(rowsColumns[0]);
        int cols = Integer.parseInt(rowsColumns[1]);
        int[][] matrix = new int[rows][cols];

        String input = reader.readLine();
        while (!"here we go".equalsIgnoreCase(input)){
            String[] tokens = input.split("\\s+");
            int x1 = Integer.parseInt(tokens[0]);
            int y1 = Integer.parseInt(tokens[1]);
            int x2 = Integer.parseInt(tokens[2]);
            int y2 = Integer.parseInt(tokens[3]);

            for (int i = x1; i <= x2 ; i++) {
                for (int j = y1; j <= y2 ; j++) {
                    matrix[i][j]++;
                }
            }
            input = reader.readLine();
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }
}
