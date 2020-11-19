import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;

public class p02_CrossFire {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] rowsColumns = reader.readLine().split("\\s+");
        int rows = Integer.parseInt(rowsColumns[0]);
        int cols = Integer.parseInt(rowsColumns[1]);
        int[][] matrix = new int[rows][cols];
        List<ArrayList<Integer>> items = new ArrayList<>();

        int count = 0;
        for (int i = 0; i < rows; i++) {
           items.add(new ArrayList<>());
            for (int j = 0; j < cols; j++) {
                count++;
                items.get(i).add(count);
            }
        }


        String input = reader.readLine();
        while (!"nuke it from orbit".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            int currRow = Integer.parseInt(tokens[0]);
            int currCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);


            for (int i = currRow - radius; i <= currRow + radius ; i++) {
                if (isInMatrix(i, currCol, items)){
                    items.get(i).set(currCol, -1);
                }
            }

            for (int i = currCol - radius; i <= currCol + radius ; i++) {
                if (isInMatrix(currRow, i, items)){
                    items.get(currRow).set(i, -1);
                }
            }

            for (int row = 0; row < items.size(); row++) {
                items.get(row).removeAll(Arrays.asList((new Integer[] {-1})));
            }
            items.removeAll(Arrays.asList(new ArrayList<Integer>()));

            input = reader.readLine();
        }


        for (ArrayList<Integer> item : items) {
            for (Integer integer : item) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
        }
    }

    private static boolean isInMatrix(int currRow, int currCol, List<ArrayList<Integer>> items) {
        return currRow >=0 && currRow < items.size() && currCol >=0 && currCol < items.get(currRow).size();
    }

}
