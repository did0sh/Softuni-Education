package p06_Animals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String type = reader.readLine();
            if (type.equalsIgnoreCase("beast!")){
                break;
            }
            String[] info = reader.readLine().split("\\s+");
            try {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String gender = info[2];
                Animal animal = null;
                switch (type.toLowerCase()){
                    case "cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "dog":
                        animal = new Dog(name,age,gender);
                        break;
                    case "frog":
                        animal = new Frog(name,age,gender);
                        break;
                    case "kitten":
                        animal = new Kitten(name,age,gender);
                        break;
                    case "tomcat":
                        animal = new Tomcat(name,age,gender);
                        break;
                        default:
                            throw new IllegalArgumentException("Invalid input!");
                }
                System.out.println(animal);
                System.out.println(animal.produceSound());
            } catch (IllegalArgumentException iae){
                System.out.println(iae.getMessage());
            }
        }
    }
}
