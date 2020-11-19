import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsAndCols = reader.readLine().split(", ");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            String[] values = reader.readLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);
                sum += matrix[row][col];
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
