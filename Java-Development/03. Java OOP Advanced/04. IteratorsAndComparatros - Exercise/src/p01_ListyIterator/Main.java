package p01_ListyIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        ListyIterator listyIterator = null;
        List<String> itemsToAdd = new ArrayList<>();

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            String[] info = input.split("\\s+");
            switch (info[0]){
                case "Create":
                    for (int i = 1; i < info.length ; i++) {
                        itemsToAdd.add(info[i]);
                    }
                    listyIterator = new ListyIterator(itemsToAdd);
                    break;
                case "Move":
                    if (listyIterator != null){
                        System.out.println(listyIterator.move());
                    }
                    break;
                case "HasNext":
                    if (listyIterator != null){
                        System.out.println(listyIterator.hasNext());
                    }
                    break;
                case "Print":
                    if (listyIterator != null){
                        try {
                            listyIterator.print();
                        }catch (IllegalStateException ise){
                            System.out.println(ise.getMessage());
                        }
                    }
                    break;
            }
        }
    }
}
