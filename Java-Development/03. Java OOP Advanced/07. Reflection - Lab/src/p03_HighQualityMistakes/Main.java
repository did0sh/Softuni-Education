package p03_HighQualityMistakes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){

        Set<Method> notPublicGetters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Method> notPrivateSetters = new TreeSet<>(Comparator.comparing(Method::getName));
        Set<Field> notPrivateFields = new TreeSet<>(Comparator.comparing(Field::getName));

        notPublicGetters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("get")
                        && method.getParameterTypes().length == 0
                        && !Modifier.isPublic(method.getModifiers()))
                .collect(Collectors.toList()));

        notPrivateSetters.addAll(Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(method -> method.getName().startsWith("set")
                        && method.getParameterTypes().length == 1
                        && method.getReturnType().equals(void.class)
                        && !Modifier.isPrivate(method.getModifiers()))
                .collect(Collectors.toList()));

        notPrivateFields.addAll(Arrays.stream(Reflection.class.getDeclaredFields())
                .filter(field -> !Modifier.isPrivate(field.getModifiers()))
                .collect(Collectors.toList()));

        for (Field notPrivateField : notPrivateFields) {
            System.out.printf("%s must be private!%n", notPrivateField.getName());
        }

        for (Method notPublicGetter : notPublicGetters) {
            System.out.printf("%s have to be public!%n", notPublicGetter.getName());
        }

        for (Method notPrivateSetter : notPrivateSetters) {
            System.out.printf("%s have to be private!%n", notPrivateSetter.getName());
        }
    }
}
