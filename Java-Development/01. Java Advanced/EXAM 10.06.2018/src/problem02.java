import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;

public class problem02 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowsAndColumns = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[rowsAndColumns][rowsAndColumns];

        int rowStartSnake = -1;
        int colStartSnake = -1;
        int snakeLength = 1;

        String[] commands = reader.readLine().split(", ");
        for (int i = 0; i < rowsAndColumns; i++) {
            String[] values = reader.readLine().split("\\s+");
            for (int j = 0; j < rowsAndColumns; j++) {
                if (values[j].equals("s")){
                    colStartSnake = j;
                    rowStartSnake = i;
                }
                matrix[i][j] = values[j];
            }
        }

        for (String command : commands) {
            switch (command){
                case "up":
                    if (rowStartSnake == 0){
                        rowStartSnake = matrix.length - 1;
                    } else {
                        rowStartSnake = rowStartSnake - 1;
                    }

                    if (matrix[rowStartSnake][colStartSnake].equals("f")){
                        snakeLength++;
                        matrix[rowStartSnake][colStartSnake] = ")";
                        boolean noleftFood = countFoodLeft(matrix);
                        if (noleftFood){
                            System.out.printf("You win! Final snake length is %d", snakeLength);
                            return;
                        }
                    } else if (matrix[rowStartSnake][colStartSnake].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;

                case "down":
                    if (rowStartSnake == matrix.length - 1){
                        rowStartSnake = 0;
                    } else {
                        rowStartSnake = rowStartSnake + 1;
                    }

                    if (matrix[rowStartSnake][colStartSnake].equals("f")){
                        snakeLength++;
                        matrix[rowStartSnake][colStartSnake] = ")";
                        boolean noleftFood = countFoodLeft(matrix);
                        if (noleftFood){
                            System.out.printf("You win! Final snake length is %d", snakeLength);
                            return;
                        }
                    } else if (matrix[rowStartSnake][colStartSnake].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;

                case "right":
                    if (colStartSnake == matrix.length - 1){
                        colStartSnake = 0;
                    } else {
                        colStartSnake = colStartSnake + 1;
                    }

                    if (matrix[rowStartSnake][colStartSnake].equals("f")){
                        snakeLength++;
                        matrix[rowStartSnake][colStartSnake] = ")";
                        boolean  noleftFood = countFoodLeft(matrix);
                        if (noleftFood){
                            System.out.printf("You win! Final snake length is %d", snakeLength);
                            return;
                        }
                    } else if (matrix[rowStartSnake][colStartSnake].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;

                case "left":
                    if (colStartSnake == 0){
                        colStartSnake = matrix.length - 1;
                    } else {
                        colStartSnake = colStartSnake - 1;
                    }

                    if (matrix[rowStartSnake][colStartSnake].equals("f")){
                        snakeLength++;
                        matrix[rowStartSnake][colStartSnake] = ")";
                        boolean  noleftFood = countFoodLeft(matrix);
                        if (noleftFood){
                            System.out.printf("You win! Final snake length is %d", snakeLength);
                            return;
                        }
                    } else if (matrix[rowStartSnake][colStartSnake].equals("e")){
                        System.out.println("You lose! Killed by an enemy!");
                        return;
                    }
                    break;
            }
        }

    }

    private static boolean countFoodLeft(String[][] matrix) {
        int countFoodLeft = 0;
        for (String[] strings : matrix) {
            for (String string : strings) {
                if (string.equals("f")){
                    countFoodLeft++;
                }
            }
        }

        if (countFoodLeft == 0){
            return true;
        }
        return false;
    }
}
