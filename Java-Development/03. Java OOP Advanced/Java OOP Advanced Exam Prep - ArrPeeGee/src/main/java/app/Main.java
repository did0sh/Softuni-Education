package app;

import app.contracts.*;
import app.core.BattlefieldImplementation;
import app.core.EngineImpl;
import app.factory.ActionFactoryImpl;
import app.factory.TargetableFactoryImpl;
import app.io.ConsoleReader;
import app.io.ConsoleWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();

        TargetableFactory targetableFactory = new TargetableFactoryImpl();
        ActionFactory actionFactory = new ActionFactoryImpl();

        Battlefield battleField = new BattlefieldImplementation(writer, targetableFactory, actionFactory);
        Engine engine = new EngineImpl(reader, writer, battleField);

        engine.run();
    }
}
