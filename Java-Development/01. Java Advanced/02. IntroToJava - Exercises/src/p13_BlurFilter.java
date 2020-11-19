import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class p13_BlurFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int blurAmount = Integer.parseInt(reader.readLine());
        String[] rowsAndColumns = reader.readLine().split(" ");
        int rows = Integer.parseInt(rowsAndColumns[0]);
        int cols = Integer.parseInt(rowsAndColumns[1]);
        long[][] matrix = new long[rows][cols];

        matrix = getMatrix(rows, cols, reader);

        String[] coordinates = reader.readLine().split(" ");
        int x = Integer.parseInt(coordinates[0]);
        int y = Integer.parseInt(coordinates[1]);

        printBlurredPhoto(matrix, x, y, rows, cols, blurAmount);
    }

    private static long[][] getMatrix(int rows, int cols, BufferedReader reader) throws IOException {
        long[][] matrix = new long[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] items = reader.readLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(items[j]);
            }
        }
        return matrix;
    }

    private static void printBlurredPhoto(long[][] matrix, int x, int y, int rows, int cols, int blurAmount){
        int left = Math.max(y - 1, 0);
        int right = Math.min(y + 1, cols);
        int top = Math.max(x - 1, 0);
        int bottom = Math.min(x + 1, rows);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (top <= r && r <= bottom && left <= c && c <= right) {
                    System.out.printf("%s ", matrix[r][c] + blurAmount);
                } else {
                    System.out.printf("%s ", matrix[r][c]);
                }
            }

            System.out.println();
        }
    }
}
