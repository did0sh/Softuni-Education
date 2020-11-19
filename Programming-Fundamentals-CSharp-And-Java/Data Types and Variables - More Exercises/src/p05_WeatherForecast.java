
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by user on 3.10.2017 г..
 */
public class p05_WeatherForecast {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);



       try{

           BigInteger number = new BigInteger(scan.nextLine());

           if (BigInteger.valueOf(Byte.MIN_VALUE).compareTo(number) <= 0 &&
                   BigInteger.valueOf(Byte.MAX_VALUE).compareTo(number) >= 0){

               System.out.println("Sunny");

           } else if (BigInteger.valueOf(Integer.MIN_VALUE).compareTo(number) <= 0 &&
                   BigInteger.valueOf(Integer.MAX_VALUE).compareTo(number) >= 0 ){

               System.out.println("Cloudy");

           } else if (BigInteger.valueOf(Long.MIN_VALUE).compareTo(number) <= 0 &&
                   BigInteger.valueOf(Long.MAX_VALUE).compareTo(number) >= 0 ){

               System.out.println("Windy");
           }
       } catch (Exception ex){
           System.out.println("Rainy");
       }



    }
}
