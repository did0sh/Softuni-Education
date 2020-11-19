package p04_MordorsCrueltyPlan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] allFoods = reader.readLine().split("\\s+");

        Gandalf gandalf = new Gandalf();

        for (String foodType : allFoods) {
            gandalf.setPointsOfHappiness(foodType);
        }

        System.out.print(gandalf);
    }
}
