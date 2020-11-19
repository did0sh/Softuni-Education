import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scan.nextLine());

        double averageSum = 0.0;
        int topStudents = 0;
        int studentsBetween4And5 = 0;
        int studentsBetween3And4 = 0;
        int failStudents = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            double note = Double.parseDouble(scan.nextLine());

            averageSum += note;

            if (note < 3){
                failStudents++;
            } else if (note >= 3 && note <= 3.99){
                studentsBetween3And4++;
            } else  if (note >=4 && note <= 4.99){
                studentsBetween4And5++;
            } else if (note >= 5){
                topStudents++;
            }
        }

        double percentTopStudents = (topStudents*100)/(double) numberOfStudents;
        double percentStudentsBetween3And4 = (studentsBetween3And4*100)/(double) numberOfStudents;
        double percentStudentsBetween4And5 = (studentsBetween4And5*100)/(double) numberOfStudents;
        double percentFailStudents = (failStudents*100)/(double) numberOfStudents;

        double average = (double)averageSum /numberOfStudents;

        System.out.printf("Top students: %.2f%%%n", percentTopStudents);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", percentStudentsBetween4And5);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", percentStudentsBetween3And4);
        System.out.printf("Fail: %.2f%%%n", percentFailStudents);
        System.out.printf("Average: %.2f%n", average);

    }
}
