package p03_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        MyStack stack = new MyStack();

        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            List<String> info = Arrays.stream(input.split("[\\s+,]")).filter(x -> !x.isEmpty())
                    .collect(Collectors.toList());

            switch (info.get(0)){
                case "Push":
                    Integer[] integers = info.stream().skip(1).map(Integer::parseInt).toArray(Integer[]::new);
                    stack.push(integers);
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    }catch (NoSuchElementException nse){
                        System.out.println(nse.getMessage());
                        return;
                    }
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (Integer integer : stack) {
                sb.append(integer).append(System.lineSeparator());
            }
        }

        System.out.print(sb.toString());

    }
}
