package p07_ManKind;

import p07_ManKind.models.Student;
import p07_ManKind.models.Worker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try  {
            String[] tokens = scanner.nextLine().split("\\s+");
            Student student = new Student(tokens[0], tokens[1], tokens[2]);


            tokens = scanner.nextLine().split("\\s+");
            Worker worker = new Worker(tokens[0], tokens[1],
                    Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
    }
}
