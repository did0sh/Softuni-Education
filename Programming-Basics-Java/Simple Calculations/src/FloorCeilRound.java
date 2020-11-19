import java.text.DecimalFormat;

public class FloorCeilRound {

        public static void main(String[] args) {
            double d = 2.75439;

            double floor = Math.floor(d);
            System.out.println("Floor: " + floor);
            double ceil = Math.ceil(d);
            System.out.println("Ceil: " + ceil);

            double round = Math.round(d);
            System.out.println("Round: " + round);

            System.out.print("Printf:");
            System.out.printf("%.0f\n", d);
            System.out.println(d);

            DecimalFormat decimalFormat = new DecimalFormat("#");
            System.out.println("DecimalFormat: " + decimalFormat.format(d));

            int b = (int) d;
            System.out.println("Cast: " + b);

        }

    }


