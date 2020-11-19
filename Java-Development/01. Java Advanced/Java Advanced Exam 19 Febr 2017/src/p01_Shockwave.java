import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_Shockwave {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsAndCols = reader.readLine().split(" ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);
        int[][] matrix = new int[rows][cols];

        String input = reader.readLine();
        while (!"Here We Go".equals(input)){
            String[] arguments = input.split(" ");
            int startRow = Integer.parseInt(arguments[0]);
            int startCol = Integer.parseInt(arguments[1]);
            int endRow = Integer.parseInt(arguments[2]);
            int endCol = Integer.parseInt(arguments[3]);

            for (int i = startRow; i <= endRow ; i++) {
                for (int j = startCol; j <= endCol ; j++) {
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
