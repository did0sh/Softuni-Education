package p09_LinkedListTraversial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CustomLinkedList<Integer> linkedList = new CustomLinkedList<>();

        int lines = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lines; i++) {
            String[] info = reader.readLine().split("\\s+");
            String command = info[0];
            switch (command){
                case "Add":
                    linkedList.add(Integer.parseInt(info[1]));
                    break;
                case "Remove":
                    linkedList.remove(Integer.parseInt(info[1]));
                    break;
            }
        }

        System.out.println(linkedList.getSize());
        StringBuilder sb = new StringBuilder();
        for (Integer integer : linkedList) {
            sb.append(String.format("%d ", integer));
        }
        System.out.println(sb.toString().trim());
    }
}
