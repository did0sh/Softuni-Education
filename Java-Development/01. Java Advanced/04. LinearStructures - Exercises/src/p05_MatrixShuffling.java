import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p05_MatrixShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arguments = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(arguments[0]);
        int cols = Integer.parseInt(arguments[1]);
        int[][] matrix = new int[rows][cols];

        matrix = fillMatrix(matrix,reader);

        String input = reader.readLine();
        while (!input.equals("END")){
            String[] components = input.split("\\s+");
            String swapCommand = components[0];

            if (!swapCommand.equals("swap") || components.length != 5){
                System.out.println("Invalid input!");
            } else {
                int row1 = Integer.parseInt(components[1]);
                int col1 = Integer.parseInt(components[2]);
                int row2 = Integer.parseInt(components[3]);
                int col2 = Integer.parseInt(components[4]);

                if (row1 < 0 || row1 > matrix.length-1 || row2 < 0 || row2 > matrix.length-1
                        || col1 < 0 || col1 > matrix[0].length-1 || col2 < 0 || col2 > matrix[0].length-1){
                    System.out.println("Invalid input!");
                } else {
                    matrix = swapNumbers(matrix, row1, col1, row2, col2);
                    printSwappedMatrix(matrix);
                }
            }
            input = reader.readLine();
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

    private static int[][] swapNumbers(int[][] matrix, int row1, int col1, int row2, int col2){
        int temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;

        return matrix;
    }

    private static void printSwappedMatrix(int[][] matrix){
        for (int[] line:matrix) {
            for (int number:line) {
                System.out.printf("%d ",number);
            }
            System.out.println();
        }
    }
}
