/**
 * Created by user on 3.10.2017 г..
 */
public class p01_BlankReceipt {
    public static void main(String[] args) {
        printReceipt();
    }

    static void printReceiptHeader() {
        System.out.println("CASH RECEIPT");
        System.out.println("------------------------------");
    }

    static void printReceiptBody() {
        System.out.println("Charged to____________________");
        System.out.println("Received by___________________");
    }

    static void printReceiptFooter(){
        System.out.println("------------------------------");
        System.out.println("© SoftUni");
    }

    static void printReceipt(){
        printReceiptHeader();
        printReceiptBody();
        printReceiptFooter();
    }
}
