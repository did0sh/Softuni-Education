import java.text.DecimalFormat;
import java.util.Scanner;

public class Pipes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int V = Integer.parseInt(scan.nextLine());
        int P1 = Integer.parseInt(scan.nextLine());
        int P2 = Integer.parseInt(scan.nextLine());
        double H = Double.parseDouble(scan.nextLine());

        double firstPipe = P1 * H;
        double secondPipe = P2 * H;
        double sumPipes = firstPipe + secondPipe;

        DecimalFormat df = new DecimalFormat("0.##");

        if (sumPipes <= V){
            double procentFull = (sumPipes*100)/V;
            double prinosFirstPipe = (firstPipe*100)/sumPipes;
            double prinosSecondPipe = (secondPipe*100)/sumPipes;
            System.out.printf("The pool is %d%% full. Pipe 1: %d%%. Pipe 2: %d%%.", (int)procentFull, (int)prinosFirstPipe, (int)prinosSecondPipe);
        } else {
            System.out.println("For " + df.format(H) + " hours the pool overflows with " + df.format(sumPipes-V) + " liters.");
        }


    }
}
