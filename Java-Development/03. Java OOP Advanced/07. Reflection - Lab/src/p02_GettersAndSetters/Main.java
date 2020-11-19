package p02_GettersAndSetters;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Set<Method> getters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> setters = new TreeSet<>(Comparator.comparing(Method::getName));

        getters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get")
                        && method.getParameterTypes().length == 0)
                .collect(Collectors.toList()));

        setters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set")
                        && method.getParameterTypes().length == 1
                        && method.getReturnType().equals(void.class))
                .collect(Collectors.toList()));

        for (Method getter : getters) {
            System.out.printf("%s will return %s%n", getter.getName(), getter.getReturnType());
        }

        for (Method setter : setters) {
            System.out.printf("%s and will set field of %s%n", setter.getName(), setter.getParameterTypes()[0]);
        }
    }
}
