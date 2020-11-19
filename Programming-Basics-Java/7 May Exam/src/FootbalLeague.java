import java.util.Scanner;

public class FootbalLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double stadiumCapacity = Double.parseDouble(scan.nextLine());
        int fans = Integer.parseInt(scan.nextLine());
        double sumA = 0;
        double sumB = 0;
        double sumV = 0;
        double sumG = 0;


        for (int i = 0; i < fans ; i++) {
            String sector = scan.nextLine();

            if (sector.equals("A")){
                sumA += 1;
            } else if (sector.equals("B")){
                sumB += 1;
            } else if (sector.equals("V")){
                sumV += 1;
            } else if (sector.equals("G")){
                sumG += 1;
            }
        }

        double procentSectorA = (sumA*100)/fans;
        double procentSectorB = (sumB*100)/fans;
        double procentSectorV = (sumV*100)/fans;
        double procentSectorG = (sumG*100)/fans;
        double procentAllFans = (fans*100)/stadiumCapacity;

        System.out.printf("%.2f%%\n", procentSectorA);
        System.out.printf("%.2f%%\n", procentSectorB);
        System.out.printf("%.2f%%\n", procentSectorV);
        System.out.printf("%.2f%%\n", procentSectorG);
        System.out.printf("%.2f%%",  procentAllFans);

    }
}
