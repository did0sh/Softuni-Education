import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class p06_StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Pattern pattern = Pattern.compile("\\((\\d+)\\)");
        Matcher matcher = pattern.matcher(input);
        List<String> allInputs = new ArrayList<>();

        int degrees = 0;
        while (matcher.find()) {
            degrees = Integer.parseInt(matcher.group(1));
        }
        int rotationsCount = (degrees / 90) % 4;

        int countRows = 0;
        input = reader.readLine();

        while (!input.equals("END")) {
            countRows++;
            allInputs.add(input);
            input = reader.readLine();
        }

        int biggestLength = findBiggestString(allInputs); // use as columns
        char[][] matrix = new char[countRows][biggestLength];
        matrix = fillMatrix(matrix, allInputs); // fill the matrix
        printRotatedMatrix(matrix, rotationsCount, biggestLength, countRows); //print the matrix
    }

    private static char[][] fillMatrix(char[][] matrix, List<String> allInputs) {
        for (int row = 0; row < matrix.length; row++) {
            char[] charArray = allInputs.get(row).toCharArray();
            for (int col = 0; col < charArray.length; col++) {
                matrix[row][col] = charArray[col];
            }
        }
        return matrix;
    }

    private static int findBiggestString(List<String> allInputs) {
        int biggestString = allInputs.get(0).length();
        for (String input : allInputs) {
            if (input.length() > biggestString) {
                biggestString = input.length();
            }
        }
        return biggestString;
    }

    private static void printRotatedMatrix(char[][] matrix, int rotationsCount, int biggestLength, int countRows) {
        switch (rotationsCount) {
            case 0:                                // 0*, 360*, 720* ...
                for (char[] line : matrix) {
                    for (char ch : line) {
                        System.out.printf("%s", ch);
                    }
                    System.out.println();
                }
                break;
            case 1:                                // 90*, 450*, 810* ...
                for (int row = 0; row < biggestLength; row++) {
                    for (int col = countRows - 1; col >= 0; col--) {
                        if (matrix[col][row] == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.printf("%s", matrix[col][row]);
                        }
                    }
                    System.out.println();
                }
                break;
            case 2:                                        // 180*, 540*, 900*, ...
                for (int i = countRows - 1; i >= 0; i--) {
                    for (int j = biggestLength - 1; j >= 0; j--) {
                        if (matrix[i][j] == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.printf("%s", matrix[i][j]);
                        }
                    }
                    System.out.println();
                }
                break;
            case 3:                                         // 270*, 630*, 990* ...
                for (int i = biggestLength - 1; i >= 0; i--) {
                    for (int j = 0; j < countRows; j++) {
                        if (matrix[j][i] == 0) {
                            System.out.print(" ");
                        } else {
                            System.out.printf("%s", matrix[j][i]);
                        }
                    }
                    System.out.println();
                }
        }
    }
}
