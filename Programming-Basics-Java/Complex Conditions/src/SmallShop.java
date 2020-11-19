import java.util.Scanner;

public class SmallShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String product = scan.nextLine().toLowerCase();
        String town = scan.nextLine().toLowerCase();

        double quantity = Double.parseDouble(scan.nextLine());
        double price = 0.0;

        if (town.equals("sofia")){
            if (product.equals("coffee")){
                price = 0.5;
            } else if (product.equals("water")){
                price = 0.8;
            } else if (product.equals("beer")){
                price = 1.2;
            } else if (product.equals("sweets")){
                price = 1.45;
            } else if (product.equals("peanuts")){
                price = 1.6;
            }
        }

        if (town.equals("plovdiv")){
            if (product.equals("coffee")){
                price = 0.4;
            } else if (product.equals("water")){
                price = 0.7;
            } else if (product.equals("beer")){
                price = 1.15;
            } else if (product.equals("sweets")){
                price = 1.3;
            } else if (product.equals("peanuts")){
                price = 1.5;
            }
        }

        if (town.equals("varna")){
            if (product.equals("coffee")){
                price = 0.45;
            } else if (product.equals("water")){
                price = 0.7;
            } else if (product.equals("beer")){
                price = 1.1;
            } else if (product.equals("sweets")){
                price = 1.35;
            } else if (product.equals("peanuts")){
                price = 1.55;
            }
        }
        System.out.println(price*quantity);
    }
}
