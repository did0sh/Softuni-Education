package pr02PrivateClassFiddling;

import pr02PrivateClassFiddling.com.BlackBoxInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchFieldException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;

        Constructor[] constructors = BlackBoxInt.class.getDeclaredConstructors();
        BlackBoxInt blackBoxInt = null;
        for (Constructor constructor : constructors) {
            if (constructor.getParameterCount() == 1 && int.class.equals(constructor.getParameterTypes()[0])){
                constructor.setAccessible(true);
                blackBoxInt = (BlackBoxInt) constructor.newInstance(0);
                break;
            }
        }

        while (!"end".equalsIgnoreCase(inputLine = reader.readLine())) {
            String[] info = inputLine.split("_");
            printValue(info, blackBoxInt);
        }
    }

    private static void printValue(String[] info, BlackBoxInt blackBoxInt) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException, NoSuchFieldException {

        String command = info[0];
        int value = Integer.parseInt(info[1]);

        Method[] declaredMethod = BlackBoxInt.class.getDeclaredMethods();
        for (Method method : declaredMethod) {
            if (method.getName().equals(command)){
                method.setAccessible(true);
                method.invoke(blackBoxInt, value);
                break;
            }
        }

        Field[] fields = blackBoxInt.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("innerValue")){
                field.setAccessible(true);
                System.out.println(field.get(blackBoxInt));
                break;
            }
        }
    }
}
