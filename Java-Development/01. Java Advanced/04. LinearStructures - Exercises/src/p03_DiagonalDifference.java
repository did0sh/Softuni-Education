import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p03_DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] matrix = new int[n][n];

        matrix = fillMatrix(matrix, reader, n);
        int sumPrimaryDiagonal = sumPrimaryDiagonal(matrix);
        int sumSecondaryDiagonal = sumSecondaryDiagonal(matrix);
        int difference = Math.abs(sumPrimaryDiagonal - sumSecondaryDiagonal);
        System.out.println(difference);

    }
    private static int[][] fillMatrix(int[][] matrix, BufferedReader reader, int n) throws IOException {
        for (int row = 0; row < n; row++) {
            String[] input = reader.readLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = Integer.parseInt(input[col]);
            }
        }
        return matrix;
    }

    private static int sumPrimaryDiagonal(int[][] matrix){
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][row];
        }
        return sum;
    }

    private static int sumSecondaryDiagonal(int[][] matrix){
        int sum = 0;
        int lastNumberFromMatrix = matrix.length - 1;
        for (int row = 0; row < matrix.length; row++) {
            sum += matrix[row][lastNumberFromMatrix];
            lastNumberFromMatrix--;
        }
        return sum;
    }
}
