import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class p14_SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opertaionsCount = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder printChar = new StringBuilder();

        ArrayDeque<String> operations = new ArrayDeque<>();
        ArrayDeque<Integer> appendedItemslengths = new ArrayDeque<>();
        ArrayDeque<String> erasedParts = new ArrayDeque<>();

        int appendItemLength = 0;
        String erasedPart = null;

        for (int i = 0; i < opertaionsCount; i++) {
            String[] commands = reader.readLine().split("\\s+");
            switch (commands[0]){
                case "1":
                    appendItemLength = commands[1].length();
                    appendedItemslengths.push(appendItemLength);
                    sb.append(commands[1]);
                    operations.push(commands[0]);
                    break;
                case "2":
                    erasedPart = sb.substring(sb.length() - Integer.parseInt(commands[1]));
                    erasedParts.push(erasedPart);
                    sb.setLength(sb.length() - Integer.parseInt(commands[1]));
                    operations.push(commands[0]);
                    break;
                case "3":
                    printChar.append(sb.charAt(Integer.parseInt(commands[1])-1) + System.lineSeparator());
                    operations.push(commands[0]);
                    break;
                case "4":
                    while (true){
                        if (operations.isEmpty()){
                            break;
                        }
                        String previousOperation = operations.pop();
                        if (previousOperation.equals("1")){
                            sb.setLength(sb.length() - appendedItemslengths.pop());// erase
                            break;
                        } else if (previousOperation.equals("2")){
                            sb.append(erasedParts.pop());  // append
                            break;
                        }
                    }
                    break;
            }
        }
        System.out.println(printChar.toString());
    }
}
