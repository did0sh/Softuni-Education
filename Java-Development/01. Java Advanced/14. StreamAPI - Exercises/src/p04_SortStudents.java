import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class p04_SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = new ArrayList<>();
        String name = reader.readLine();
        while (!"end".equalsIgnoreCase(name)){
            names.add(name);
            name = reader.readLine();
        }

        names.stream()
                .sorted((str1, str2) -> {
                    String firstNameString1 = str1.split("\\s+")[0];
                    String lastNameString1 = str1.split("\\s+")[1];

                    String firstNameString2 = str2.split("\\s+")[0];
                    String lastNameString2 = str2.split("\\s+")[1];

                    if (lastNameString1.compareTo(lastNameString2) == 0) {
                        return firstNameString2.compareTo(firstNameString1);
                    } else {
                        return lastNameString1.compareTo(lastNameString2);
                    }
                }).forEach(str -> System.out.printf("%s%n", str));
    }
}
