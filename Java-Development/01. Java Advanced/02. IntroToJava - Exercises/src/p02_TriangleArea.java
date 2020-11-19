import java.util.Scanner;

public class p02_TriangleArea {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int Ax = scan.nextInt();
        int Ay = scan.nextInt();
        int Bx = scan.nextInt();
        int By = scan.nextInt();
        int Cx = scan.nextInt();
        int Cy = scan.nextInt();

        int area = (Ax*(By-Cy) + Bx*(Cy-Ay) + Cx*(Ay-By))/2;
        area = Math.abs(area);
        System.out.println(area);
    }
}
