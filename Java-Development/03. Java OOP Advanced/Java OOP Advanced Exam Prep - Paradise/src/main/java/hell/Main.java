package hell;

import hell.core.Engine;
import hell.core.EngineImpl;
import hell.io.ConsoleInputReader;
import hell.io.ConsoleOutputWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
        ConsoleOutputWriter writer = new ConsoleOutputWriter();
        ConsoleInputReader reader = new ConsoleInputReader();
        Engine engine = new EngineImpl(reader, writer);
        engine.run();
    }
}