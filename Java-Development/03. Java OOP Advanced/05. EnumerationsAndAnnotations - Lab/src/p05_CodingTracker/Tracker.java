package p05_CodingTracker;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Tracker {


    @Author(name = "Dido")
    public static void printMethodsByAuthor(Class<?> cl){
        Map<String, List<String>> annotations = new LinkedHashMap<>();
        Class<?> trackerClass = Tracker.class;
        Method[] methods = trackerClass.getDeclaredMethods();

        for (Method method : methods) {
            Author annotation = method.getAnnotation(Author.class);
            if (annotation != null){
                annotations.putIfAbsent(annotation.name(), new ArrayList<>());
                annotations.get(annotation.name()).add(method.getName());
            }
        }

        for (String author : annotations.keySet()) {
            System.out.println(String.format("%s: %s", author, String.join(", ", annotations.get(author))));
        }

    }

    @Author(name = "Dido")
    public static void main(String[] args) {
        Tracker.printMethodsByAuthor(Tracker.class);
    }
}
