package p10p11p12p13p14_InfernoInfinity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommandManager manager = new CommandManager();

        String input;
        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split(";");
            switch (info[0]){
                case "Create":
                    manager.create(info[1], info[2]);
                    break;
                case "Add":
                    manager.add(info[1], Integer.parseInt(info[2]), info[3]);
                    break;
                case "Remove":
                    manager.removeGem(info[1], Integer.parseInt(info[2]));
                    break;
                case "Print":
                    manager.print(info[1]);
                    break;
                case "Compare":
                    manager.compare(info[1], info[2]);
                    break;
                default:
                    executeAnnotations(info);
            }
        }
    }

    private static void executeAnnotations(String[] info) {
        CustomClassAnnotation annotation = Weapon.class.getAnnotation(CustomClassAnnotation.class);

        switch (info[0]){
            case "Author":
                System.out.printf("Author: %s%n", annotation.author());
                break;
            case "Revision":
                System.out.printf("Revision: %d%n", annotation.revision());
                break;
            case "Description":
                System.out.printf("Class description: %s%n", annotation.description());
                break;
            case "Reviewers":
                System.out.printf("Reviewers: %s%n", String.join(", ", annotation.reviewers()));
                break;
        }
    }
}
