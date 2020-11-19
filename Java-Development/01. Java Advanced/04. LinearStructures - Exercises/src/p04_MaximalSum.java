import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_MaximalSum {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];

        matrix = fillMatrix(matrix, reader);

        int maxSum = Integer.MIN_VALUE;
        int startRow = 0;
        int startCol = 0;

        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        System.out.printf("Sum = %d%n", maxSum);
        for (int i = startRow; i < startRow + 3 ; i++) {
            for (int j = startCol; j < startCol + 3 ; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int[][] matrix, BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] values = reader.readLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);
            }
        }
        return matrix;
    }
}
