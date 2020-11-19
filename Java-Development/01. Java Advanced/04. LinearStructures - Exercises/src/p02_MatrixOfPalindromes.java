import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p02_MatrixOfPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];

        matrix = fillMatrix(matrix);
        printMatrix(matrix);

    }
    private static String[][] fillMatrix(String[][] matrix){
        int startLetterAsciiCode = 97;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.setLength(0);
                sb.append((char)(startLetterAsciiCode + i));
                sb.append((char)(startLetterAsciiCode + i + j));
                sb.append((char)(startLetterAsciiCode+i));
                matrix[i][j] = sb.toString();
            }
        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix){
        for (String[] line:matrix) {
            for (String palindrome:line) {
                System.out.printf("%s ", palindrome);
            }
            System.out.println();
        }
    }
}
