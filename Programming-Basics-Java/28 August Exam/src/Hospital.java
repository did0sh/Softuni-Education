import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = Integer.parseInt(scan.nextLine());
        int sumTreatedPatients = 0;
        int sumNonTreated = 0;
        int treated = 0;

        for (int i = 1; i <= count ; i++) {
            int patients = Integer.parseInt(scan.nextLine());

            if (i % 3 == 0) {

                if (sumNonTreated >= sumTreatedPatients) {
                    treated++;

                    if (patients >= 7) {

                        sumTreatedPatients += (7 + treated);
                        sumNonTreated += (patients - 7 - treated);

                    }else {
                        sumTreatedPatients += patients;
                        sumNonTreated += 0;
                    }
                } else {
                    if (patients >= 7) {
                        sumTreatedPatients += (7 + treated);
                        sumNonTreated += (patients - 7 - treated);
                    } else {
                        sumTreatedPatients += patients;
                        sumNonTreated += 0;                    }

                }
            } else {
                treated += 0;
                if (patients >= 7) {
                    sumTreatedPatients += (7 + treated);
                    sumNonTreated += (patients - 7 - treated);
                } else {
                    sumTreatedPatients += patients;
                    sumNonTreated += 0;
                }
            }
        }

        System.out.printf("Treated patients: %d.%n", sumTreatedPatients);
        System.out.printf("Untreated patients: %d.", sumNonTreated);
    }
}
