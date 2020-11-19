import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p04_MaximumSumOf2x2Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arguments = reader.readLine().split(", ");
        int rows = Integer.parseInt(arguments[0]);
        int cols = Integer.parseInt(arguments[1]);

        int[][] matrix = new int[rows][cols];
        matrix = fillMatrix(matrix, rows, cols, reader);

        int bestSum = Integer.MIN_VALUE;
        int startRow = 0;;
        int startCol = 0;

        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row+1][col] + matrix[row][col+1] + matrix[row+1][col+1];
                if (sum > bestSum){
                    bestSum = sum;
                    startRow = row;
                    startCol = col;
                }
            }
        }

        printMaxSum(startRow, startCol, matrix);
    }

    private static int[][] fillMatrix(int[][] matrix, int rows, int cols, BufferedReader reader) throws IOException {
        for (int row = 0; row < matrix.length; row++) {
            String[] values = reader.readLine().split(", ");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = Integer.parseInt(values[col]);
            }
        }

        return matrix;
    }

    private static void printMaxSum(int startRow, int startCol, int[][] matrix){
        int totalSum = 0;
        for (int i = startRow; i < startRow + 2 ; i++) {
            for (int j = startCol; j < startCol + 2 ; j++) {
                totalSum += matrix[i][j];
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }

        System.out.println(totalSum);
    }
}
