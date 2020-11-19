package p01_Reflection;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<Reflection> reflectionClass = Reflection.class;
        System.out.println(reflectionClass);
        System.out.println(reflectionClass.getSuperclass());

        for (Class<?> anInterface : reflectionClass.getInterfaces()) {
            System.out.println(anInterface);
        }

        Reflection refl = Reflection.class.getDeclaredConstructor().newInstance();
        System.out.println(refl);
    }
}
