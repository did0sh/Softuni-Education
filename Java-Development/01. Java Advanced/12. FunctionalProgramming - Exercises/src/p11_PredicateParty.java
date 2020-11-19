import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class p11_PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> people = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());

        String input = reader.readLine();
        while (!"party!".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            if (command.equalsIgnoreCase("double")) {
                String type = tokens[1];
                if (type.equalsIgnoreCase("length")) {
                    int length = Integer.parseInt(tokens[2]);
                    Predicate<String> testFunc = person -> {
                        if (person.length() == length) {
                            return true;
                        }
                        return false;
                    };
                    for (int i = 0; i < people.size(); i++) {
                        if (testFunc.test(people.get(i))) {
                            people.add(i, people.get(i));
                            i++;
                        }
                    }
                } else if (type.equalsIgnoreCase("endswith")) {
                    String endString = tokens[2];
                    Predicate<String> testFunc = person -> {
                        if (person.endsWith(endString)) {
                            return true;
                        }
                        return false;
                    };
                    for (int i = 0; i < people.size(); i++) {
                        if (testFunc.test(people.get(i))) {
                            people.add(i, people.get(i));
                            i++;
                        }
                    }
                } else if (type.equalsIgnoreCase("startswith")) {
                    String startString = tokens[2];
                    Predicate<String> testFunc = person -> {
                        if (person.startsWith(startString)) {
                            return true;
                        }
                        return false;
                    };
                    for (int i = 0; i < people.size(); i++) {
                        if (testFunc.test(people.get(i))) {
                            people.add(i, people.get(i));
                            i++;
                        }
                    }
                }
            } else if (command.equalsIgnoreCase("remove")){
                String type = tokens[1];
                if (type.equalsIgnoreCase("length")) {
                    int length = Integer.parseInt(tokens[2]);
                    Predicate<String> testFunc = person -> {
                        if (person.length() == length) {
                            return true;
                        }
                        return false;
                    };
                    for (int i = 0; i < people.size(); i++) {
                        if (testFunc.test(people.get(i))) {
                            people.remove(i);
                            i--;
                        }
                    }
                } else if (type.equalsIgnoreCase("endswith")) {
                    String endString = tokens[2];
                    Predicate<String> testFunc = person -> {
                        if (person.endsWith(endString)) {
                            return true;
                        }
                        return false;
                    };
                    for (int i = 0; i < people.size(); i++) {
                        if (testFunc.test(people.get(i))) {
                            people.remove(i);
                            i--;
                        }
                    }
                } else if (type.equalsIgnoreCase("startswith")) {
                    String startString = tokens[2];
                    Predicate<String> testFunc = person -> {
                        if (person.startsWith(startString)) {
                            return true;
                        }
                        return false;
                    };
                    for (int i = 0; i < people.size(); i++) {
                        if (testFunc.test(people.get(i))) {
                            people.remove(i);
                            i--;
                        }
                    }
                }
            }
            input = reader.readLine();
        }

        if (people.isEmpty()){
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", String.join(", ", people));
        }
    }
}
