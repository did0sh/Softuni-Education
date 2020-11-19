import java.util.Scanner;

public class RepairingTheTiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());
        double width = Double.parseDouble(scan.nextLine());
        double length = Double.parseDouble(scan.nextLine());
        int mPeika = Integer.parseInt(scan.nextLine());
        int oPeika = Integer.parseInt(scan.nextLine());

        int wholeVolume = N * N;
        int peikaVolume = mPeika * oPeika;
        int volumeLeft = wholeVolume - peikaVolume;
        double tilesVolume = width * length;
        double tilesNeeded = volumeLeft / tilesVolume;
        double timeNeeded =  tilesNeeded * 0.2;

        System.out.printf("%.2f%n",tilesNeeded);
        System.out.printf("%.2f",timeNeeded);


    }
}
