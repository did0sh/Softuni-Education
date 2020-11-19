import java.util.Scanner;

public class Problem12_CurrencyConverter{

  public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        double constantUSD = 1.79549;
        double constantEUR = 1.95583;
        double constantGBP = 2.53405;
        double input = Double.parseDouble(scan.nextLine());

        String firstCurrency = scan.nextLine();
        String secondCurrency = scan.nextLine();


        switch (firstCurrency){
            case "USD": input *= constantUSD; break;
            case "EUR": input *= constantEUR; break;
            case "GBP": input *= constantGBP; break;
            default: break;
        }

        switch (secondCurrency){
            case "USD": input /= constantUSD; break;
            case "EUR": input /= constantEUR; break;
            case "GBP": input /= constantGBP; break;
            default: break;
        }
      System.out.printf("%.2f %s", input, secondCurrency);

    }
}