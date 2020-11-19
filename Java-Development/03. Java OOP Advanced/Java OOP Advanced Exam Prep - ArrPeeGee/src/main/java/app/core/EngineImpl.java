package app.core;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class EngineImpl implements Engine {
    private Reader reader;
    private Writer writer;
    private Battlefield battlefield;

    public EngineImpl(Reader reader, Writer writer, Battlefield battlefield) {
        this.reader = reader;
        this.writer = writer;
        this.battlefield = battlefield;
    }

    @Override
    public void run() throws IOException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        String input;
        while (!"Peace".equalsIgnoreCase(input = this.reader.readLine())){
            String[] commands = input.split("\\s+");
            switch (commands[0]){
                case "CreateParticipant":
                    this.battlefield.createParticipant(commands[1], commands[2]);
                    break;
                case "CreateAction":
                    String[] params = new String[commands.length - 2];
                    int index = 0;
                    for (int i = 2; i < commands.length ; i++) {
                        params[index] = commands[i];
                        index++;
                    }
                    this.battlefield.createAction(commands[1], params);
                    break;
                case "CreateSpecial":
                    this.battlefield.createSpecial(commands[1], commands[2]);
                    break;
                case "StatParticipants":
                    this.battlefield.reportParticipants();
                    break;
                case "StatActions":
                    this.battlefield.reportActions();
                    break;
            }
        }
    }
}
