package p01_EventImplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        Dispatcher dispatcher = new Dispatcher("Dido");


        while (!"end".equalsIgnoreCase(input = reader.readLine())){
            NameChange nameChange = new NameChange(input);
            NameChangeListener handler = new Handler(nameChange);
            dispatcher.addNameChangeListener(handler);
        }

        dispatcher.fireNameChangeListener();
    }
}
