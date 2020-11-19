package p09_CustomListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        CustomListImpl<String> list = new CustomListImpl<>();

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split("\\s+");

            switch (info[0]){
                case "Add":
                    list.add(info[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(info[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(info[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(info[1]), Integer.parseInt(info[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(info[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
                case "Print":
                    list.print();
                    break;
            }
        }
    }
}
