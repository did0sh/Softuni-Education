import java.util.Scanner;
public class PointInFigure {

        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int h = Integer.parseInt(scan.nextLine());
            int x = Integer.parseInt(scan.nextLine());
            int y = Integer.parseInt(scan.nextLine());

            if ((x>0 && x<h && y>0 && y<h) || (x>h && x<2*h && y>0 && y<4*h) || (x>2*h && x<3*h && y>0 && y<h) || (x>=h && x<=2*h && y>0 && y<h)) {
                System.out.println("inside");
            } else if ((x>=0 && x<=3*h && y==0) || (x==0 && y>=0 && y<=h) || (x>=0 && x<=h && y==h)
                    || (x==h && y>=h && y<=4*h) || (x>=h && x<=2*h && y==4*h) || (x==2*h && y>=h && y<=4*h)
                    || (x>=2*h && x<=3*h & y==h) || (x==3*h && y>=0 && y<=h)) {
                System.out.println("border");
            } else {
                System.out.println("outside");
            }
        }
    }


