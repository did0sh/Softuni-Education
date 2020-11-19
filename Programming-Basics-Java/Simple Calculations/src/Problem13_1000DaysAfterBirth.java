import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Problem13_1000DaysAfterBirth {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(scan.nextLine(), formatter);
        date = date.plusDays(999);
        System.out.println(date.format(formatter));
    }
}
