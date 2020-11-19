import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class problem01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        Pattern namePattern = Pattern.compile("[A-Z][a-z]+ [A-Z][a-z]+");

        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            stack.push(reader.readLine());
        }
        for (int i = 0; i < m; i++) {
            String input = reader.readLine();
            Matcher matcher = namePattern.matcher(input);
            if (matcher.matches()){
                queue.offer(input);
            }
        }


        StringBuilder sb = new StringBuilder();
        boolean stackEmpty = false;
        while (true){
            if (queue.size() == 1){
                sb.append(String.format("%s gets the job!", queue.peek())).append(System.lineSeparator());
                break;
            }
            if (stack.isEmpty()){
                stackEmpty = true;
                break;
            }
            String problem = stack.pop();

            String candidate = queue.getFirst();
            char[] problemChars = problem.toCharArray();
            char[] candidateChars = candidate.toCharArray();

            int sumProblemChars = 0;
            int sumCandidateChars = 0;

            for (int i = 0; i < problemChars.length; i++) {
                sumProblemChars += problemChars[i];
            }
            for (int i = 0; i < candidateChars.length; i++) {
                sumCandidateChars += candidateChars[i];
            }

            if (sumCandidateChars > sumProblemChars){
                sb.append(String.format("%s solved %s.", candidate, problem)).append(System.lineSeparator());
                queue.addLast(candidate);
                queue.removeFirst();
            } else {
                sb.append(String.format("%s failed %s.", candidate, problem)).append(System.lineSeparator());
                stack.addLast(problem);
                queue.removeFirst();
            }

        }

        if (stackEmpty){
            System.out.print(sb.toString());
            System.out.println(String.join(", ", queue));
        } else {
            System.out.print(sb.toString());
        }


    }
}
