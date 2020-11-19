import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01_FillTheMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[n][n];


        if (type.equals("A")) {
            matrix = fillMatrixTypeA(matrix);
        } else if (type.equals("B")) {
           matrix = fillMatrixTypeB(matrix);
        }

        printMatrix(matrix);
    }

    private static int[][] fillMatrixTypeA(int[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                count++;
                matrix[col][row] = count;
            }
        }
        return matrix;
    }

    private static int[][] fillMatrixTypeB(int[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (row % 2 == 0) {
                for (int col = 0; col < matrix.length; col++) {
                    count++;
                    matrix[col][row] = count;
                }
            } else {
                for (int col = matrix.length - 1; col >= 0 ; col--) {
                    count++;
                    matrix[col][row] = count;
                }

            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] line : matrix) {
            for (int number : line) {
                System.out.printf("%d ", number);
            }
            System.out.println();
        }
    }
}
