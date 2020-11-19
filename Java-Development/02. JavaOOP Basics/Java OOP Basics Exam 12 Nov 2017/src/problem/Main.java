package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        HealthManager healthManager = new HealthManager();
        StringBuilder sb = new StringBuilder();

        while (!"beer is coming".equalsIgnoreCase(input = reader.readLine())) {
            String[] info = input.split("\\s+");
            String command = info[0];
            String name = info[1];

            String toAppend = null;
            switch (command.toLowerCase()) {
                case "createorganism":
                    sb.append(healthManager.createOrganism(name));
                    break;
                case "addcluster":
                    String id = info[2];
                    int rows = Integer.parseInt(info[3]);
                    int cols = Integer.parseInt(info[4]);
                    toAppend = healthManager.addCluster(name, id, rows, cols);
                    if (toAppend != null) {
                        sb.append(toAppend);
                    }
                    break;
                case "addcell":
                    String clusterId = info[2];
                    String cellType = info[3];
                    String cellId = info[4];
                    int health = Integer.parseInt(info[5]);
                    int posRow = Integer.parseInt(info[6]);
                    int posCol = Integer.parseInt(info[7]);
                    int additionalProp = Integer.parseInt(info[8]);
                    toAppend = healthManager.addCell(name, clusterId, cellType, cellId, health, posRow, posCol, additionalProp);
                    if (toAppend != null) {
                        sb.append(toAppend);
                    }
                    break;
                case "activatecluster":
                    toAppend = healthManager.activateCluster(name);
                    if (toAppend != null){
                        sb.append(toAppend);
                    }
                    break;
                case "checkcondition":
                    toAppend = healthManager.checkCondition(name);
                    if (toAppend != null) {
                        sb.append(toAppend);
                    }
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
