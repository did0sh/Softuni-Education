import com.sun.org.apache.xml.internal.serialize.LineSeparator;
import org.omg.CORBA.Environment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p09_MaximumElement {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());
        ArrayDeque<Long> stack = new ArrayDeque<>();
        ArrayDeque<Long> maxStack = new ArrayDeque<>();
        long maxNum = Long.MIN_VALUE;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String[] components = reader.readLine().split(" ");
            String command = components[0];

            switch (command){
                case "1":
                    long numberToPush = Long.parseLong(components[1]);
                    stack.push(numberToPush);
                    if (maxStack.size() == 0){
                        maxStack.push(numberToPush);
                    } else {
                        if (maxStack.peek() < numberToPush){
                            maxStack.push(numberToPush);
                        }
                    }
                    break;
                case "2":
                    if (stack.peek() == maxStack.peek() && maxStack.size() > 0){
                        maxStack.pop();
                    }
                    stack.pop();
                    break;
                case "3":
                    sb.append(maxStack.peek() + System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb.toString());
    }
}
