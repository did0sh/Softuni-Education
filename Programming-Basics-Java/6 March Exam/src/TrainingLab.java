import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());

        double widthInCentimeters = width * 100;
        double heightInCentimeters = height * 100;

        double heightSpaceLeft = heightInCentimeters - 100;

        double buros = heightSpaceLeft / 70;
        double rows = widthInCentimeters / 120;

        int sum = (int) buros * (int) rows - 3;

        System.out.println(sum);
    }
}
