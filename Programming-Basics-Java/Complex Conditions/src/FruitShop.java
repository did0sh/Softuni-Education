import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fruit = scan.nextLine().toLowerCase();
        String day = scan.nextLine().toLowerCase();
        double quantity = Double.parseDouble(scan.nextLine());
        double price = -1;


        boolean isWorkDay = day.equals("monday")
                || day.equals("tuesday")
                || day.equals("wednesday")
                || day.equals("thursday")
                || day.equals("friday");

        boolean isHoliday = day.equals("saturday") || day.equals("sunday");

        boolean isValidFruit = fruit.equals("banana")
                || fruit.equals("apple")
                || fruit.equals("orange")
                || fruit.equals("grapefruit")
                || fruit.equals("kiwi")
                || fruit.equals("pineapple")
                || fruit.equals("grapes");

        boolean isValidDay = isWorkDay || isHoliday;

        if (isValidDay && isValidFruit) {
            if (isWorkDay) {
                switch (fruit) {
                    case "banana":
                        price = 2.5;
                        break;
                    case "apple":
                        price = 1.2;
                        break;
                    case "orange":
                        price = 0.85;
                        break;
                    case "grapefruit":
                        price = 1.45;
                        break;
                    case "kiwi":
                        price = 2.7;
                        break;
                    case "pineapple":
                        price = 5.5;
                        break;
                    case "grapes":
                        price = 3.85;
                        break;
                }
            } else {
                if (isHoliday) {
                    switch (fruit) {
                        case "banana":
                        price = 2.7;
                        break;
                            case "apple":
                                price = 1.25;
                                break;
                            case "orange":
                                price = 0.90;
                                break;
                            case "grapefruit":
                                price = 1.60;
                                break;
                            case "kiwi":
                                price = 3;
                                break;
                            case "pineapple":
                                price = 5.6;
                                break;
                            case "grapes":
                                price = 4.2;
                                break;
                        }
                    }
                }
            }

        double result = quantity * price;
        if (price == -1) {
            System.out.println("error");
        } else {
            System.out.printf("%.2f", result);
        }

    }
}




