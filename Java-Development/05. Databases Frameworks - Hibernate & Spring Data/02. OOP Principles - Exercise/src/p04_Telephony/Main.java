package p04_Telephony;

import p04_Telephony.entities.Smartphone;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> numbersToCall = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());
        List<String> sitesToBrowse = Arrays.stream(scan.nextLine().split(" ")).collect(Collectors.toList());

        Smartphone smartphone = new Smartphone();

        numbersToCall.forEach(number -> System.out.println(smartphone.call(number)));
        sitesToBrowse.forEach(site -> System.out.println(smartphone.browse(site)));
    }
}
