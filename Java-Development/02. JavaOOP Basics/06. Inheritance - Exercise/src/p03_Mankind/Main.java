package p03_Mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLineInfo = reader.readLine().split("\\s+");
        String firstNameStudent = firstLineInfo[0];
        String lastNameStudent = firstLineInfo[1];
        String facNumber = firstLineInfo[2];

        Student student = null;
        try {
            student = new Student(firstNameStudent,lastNameStudent,facNumber);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        String[] secondLineInfo = reader.readLine().split("\\s+");
        String firstNameWorker = secondLineInfo[0];
        String lastNameWorker = secondLineInfo[1];
        double salary = Double.parseDouble(secondLineInfo[2]);
        int workHours = Integer.parseInt(secondLineInfo[3]);

        Worker worker = null;
        try {
            worker = new Worker(firstNameWorker,lastNameWorker,salary,workHours);
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
            return;
        }

        System.out.print(student);
        System.out.print(worker);

    }
}
