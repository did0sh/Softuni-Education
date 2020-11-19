package p05_BorderControl;

import p05_BorderControl.entities.Citizen;
import p05_BorderControl.entities.Robot;
import p05_BorderControl.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Identifiable> models = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        String input;
        while (!"end".equalsIgnoreCase(input = scan.nextLine())){
            String[] cmdArgs = input.split("\\s+");
            switch (cmdArgs.length){
                case 3:
                    String name = cmdArgs[0];
                    int age = Integer.parseInt(cmdArgs[1]);
                    String id = cmdArgs[2];
                    Identifiable citizen = new Citizen(name,age,id);
                    models.add(citizen);
                    break;
                case 2:
                    String robotName = cmdArgs[0];
                    String robotId = cmdArgs[1];
                    Identifiable robot = new Robot(robotName,robotId);
                    models.add(robot);
                    break;
            }
        }

        input = scan.nextLine();
        String finalInput = input;

        models.stream().filter(model -> model.getId().endsWith(finalInput))
                .forEach(m -> System.out.println(m.getId()));
    }
}
