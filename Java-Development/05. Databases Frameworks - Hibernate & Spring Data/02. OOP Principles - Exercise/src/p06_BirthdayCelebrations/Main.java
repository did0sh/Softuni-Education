package p06_BirthdayCelebrations;

import p06_BirthdayCelebrations.entities.Citizen;
import p06_BirthdayCelebrations.entities.Pet;
import p06_BirthdayCelebrations.entities.Robot;
import p06_BirthdayCelebrations.interfaces.Birthable;
import p06_BirthdayCelebrations.interfaces.Identifiable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Birthable> birthables = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        String input;
        while (!"end".equalsIgnoreCase(input = scan.nextLine())){
            String[] cmdArgs = input.split("\\s+");
            switch (cmdArgs.length){
                case 5:
                    String name = cmdArgs[1];
                    int age = Integer.parseInt(cmdArgs[2]);
                    String id = cmdArgs[3];
                    String birthdate = cmdArgs[4];
                    Birthable citizen = new Citizen(name,age,id, birthdate);
                    birthables.add(citizen);
                    break;
                case 3:
                    if (cmdArgs[0].equalsIgnoreCase("pet")){
                        String petName = cmdArgs[1];
                        String petBirthdate = cmdArgs[2];
                        Birthable pet = new Pet(petName,petBirthdate);
                        birthables.add(pet);
                        break;
                    }
            }
        }

        input = scan.nextLine();
        String finalInput = input;

        birthables.stream().filter(model -> model.getBirthdate().endsWith(finalInput))
                .forEach(m -> System.out.println(m.getBirthdate()));
    }
}
